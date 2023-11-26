package com.quipux.practical_test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamDetailedReportResponseDTO {
    private String name;
    private List<PlayerDTO> startingPlayers;
    private List<PlayerDTO> substitutePlayers;
}
