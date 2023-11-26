package com.quipux.practical_test.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quipux.practical_test.dto.PlayerDTO;
import com.quipux.practical_test.dto.TeamBasicReportResponseDTO;
import com.quipux.practical_test.dto.TeamDetailedReportResponseDTO;
import com.quipux.practical_test.model.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReportUtils {
    private final ObjectMapper objectMapper = new ObjectMapper();
    public ReportUtils() {}

    public List<TeamBasicReportResponseDTO> getBasicReport(List<Team> teams) {
        List<TeamBasicReportResponseDTO> responseDTO = new ArrayList<>();
        teams.forEach(team -> responseDTO.add(convertToBasicReportDTO(team)));
        return responseDTO;
    }
    private TeamBasicReportResponseDTO convertToBasicReportDTO(Team team) {
        TeamBasicReportResponseDTO reportResponseDTO = new TeamBasicReportResponseDTO();
        reportResponseDTO.setName(team.getName());
        reportResponseDTO.setNumberOfTitles(team.getNumberOfTitles());
        reportResponseDTO.setTotalPlayers(team.getStartingPlayers().size() + team.getSubstitutePlayers().size());
        return reportResponseDTO;
    }

    public List<TeamDetailedReportResponseDTO> getDetailedReport(List<Team> teams) {
        List<TeamDetailedReportResponseDTO> responseDTO = new ArrayList<>();
        teams.forEach(team -> responseDTO.add(convertToDetailedReportDTO(team)));
        return responseDTO;
    }
    private TeamDetailedReportResponseDTO convertToDetailedReportDTO(Team team) {
        TeamDetailedReportResponseDTO reportResponseDTO = new TeamDetailedReportResponseDTO();
        reportResponseDTO.setName(team.getName());
        List<PlayerDTO> startingPlayers = new ArrayList<>();
        List<PlayerDTO> substitutePlayers = new ArrayList<>();
        team.getStartingPlayers().forEach(player -> startingPlayers.add(objectMapper.convertValue(player, PlayerDTO.class)));
        team.getSubstitutePlayers().forEach(player -> substitutePlayers.add(objectMapper.convertValue(player, PlayerDTO.class)));
        reportResponseDTO.setStartingPlayers(startingPlayers);
        reportResponseDTO.setSubstitutePlayers(substitutePlayers);
        return reportResponseDTO;
    }
}
