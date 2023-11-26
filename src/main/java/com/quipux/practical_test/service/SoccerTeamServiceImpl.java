package com.quipux.practical_test.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quipux.practical_test.common.LogUtils;
import com.quipux.practical_test.common.ReportUtils;
import com.quipux.practical_test.dto.TeamBasicReportResponseDTO;
import com.quipux.practical_test.dto.TeamDetailedReportResponseDTO;
import com.quipux.practical_test.dto.TeamRequestDTO;
import com.quipux.practical_test.dto.TeamResponseDTO;
import com.quipux.practical_test.exception.InternalServerException;
import com.quipux.practical_test.model.Player;
import com.quipux.practical_test.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SoccerTeamServiceImpl implements SoccerTeamService {
    @Autowired
    private LogUtils logUtils;
    @Autowired
    private ReportUtils reportUtils;
    @Value("${json.file.path}")
    private String JSON_FILE_PATH;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ResponseEntity<TeamResponseDTO> addTeam(TeamRequestDTO requestDTO) throws Exception {
        TeamResponseDTO responseDTO;
        try {
            List<Team> teams = new ArrayList<>(getAllTeams());
            List<Player> startingPlayers = new ArrayList<>();
            List<Player> substitutePlayers = new ArrayList<>();
            requestDTO.getStartingPlayers().forEach(player -> {
                Player newPlayer = new Player(player.getName(), player.getPosition());
                startingPlayers.add(newPlayer);
            });
            requestDTO.getSubstitutePlayers().forEach(player -> {
                Player newPlayer = new Player(player.getName(), player.getPosition());
                substitutePlayers.add(newPlayer);
            });
            Team newTeam = new Team(requestDTO.getName(), requestDTO.getStadium(), requestDTO.getNumberOfTitles(), startingPlayers, substitutePlayers);
            teams.add(newTeam);
            saveTeams(teams);
            responseDTO = objectMapper.convertValue(newTeam, TeamResponseDTO.class);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (Exception e) {
            this.logUtils.catchThrowable(e);
            throw new InternalServerException(e.getMessage());
        }
    }

    private List<Team> getAllTeams() throws IOException {
        File file = new File(JSON_FILE_PATH);
        if (!file.exists()) {
            return List.of();
        }
        return List.of(objectMapper.readValue(file, Team[].class));
    }

    private void saveTeams(List<Team> teams) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(JSON_FILE_PATH), teams);
    }

    @Override
    public ResponseEntity<List<TeamBasicReportResponseDTO>> getBasicTeamReport() throws Exception {
        List<TeamBasicReportResponseDTO> responseDTO;
        try {
            List<Team> teams = new ArrayList<>(getAllTeams());
            responseDTO = reportUtils.getBasicReport(teams);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (Exception e) {
            this.logUtils.catchThrowable(e);
            throw new InternalServerException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<List<TeamDetailedReportResponseDTO>> getDetailedTeamReport() throws Exception {
        List<TeamDetailedReportResponseDTO> responseDTO;
        try {
            List<Team> teams = new ArrayList<>(getAllTeams());
            responseDTO = reportUtils.getDetailedReport(teams);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (Exception e) {
            this.logUtils.catchThrowable(e);
            throw new InternalServerException(e.getMessage());
        }
    }
}
