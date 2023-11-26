package com.quipux.practical_test.controller;

import com.quipux.practical_test.dto.TeamBasicReportResponseDTO;
import com.quipux.practical_test.dto.TeamDetailedReportResponseDTO;
import com.quipux.practical_test.dto.TeamRequestDTO;
import com.quipux.practical_test.dto.TeamResponseDTO;
import com.quipux.practical_test.service.SoccerTeamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/soccer-team")
public class SoccerTeamController {
    @Autowired
    SoccerTeamService soccerTeamService;

    @PostMapping("/add")
    public ResponseEntity<TeamResponseDTO> addTeam(@Valid @RequestBody TeamRequestDTO item) throws Exception {
        return soccerTeamService.addTeam(item);
    }

    @GetMapping("/basic-report")
    public ResponseEntity<List<TeamBasicReportResponseDTO>> getBasicTeamReport() throws Exception {
        return soccerTeamService.getBasicTeamReport();
    }

    @GetMapping("/detailed-report")
    public ResponseEntity<List<TeamDetailedReportResponseDTO>> getDetailedTeamReport() throws Exception {
        return soccerTeamService.getDetailedTeamReport();
    }
}
