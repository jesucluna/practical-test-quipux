package com.quipux.practical_test.service;

import com.quipux.practical_test.dto.TeamBasicReportResponseDTO;
import com.quipux.practical_test.dto.TeamDetailedReportResponseDTO;
import com.quipux.practical_test.dto.TeamRequestDTO;
import com.quipux.practical_test.dto.TeamResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SoccerTeamService {
    ResponseEntity<TeamResponseDTO> addTeam(TeamRequestDTO requestDTO) throws Exception;
    ResponseEntity<List<TeamBasicReportResponseDTO>> getBasicTeamReport() throws Exception;
    ResponseEntity<List<TeamDetailedReportResponseDTO>> getDetailedTeamReport() throws Exception;
}
