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
public class TeamBasicReportResponseDTO {
    private String name;
    private int numberOfTitles;
    private int totalPlayers;
}
