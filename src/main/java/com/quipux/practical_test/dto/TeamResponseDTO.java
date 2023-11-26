package com.quipux.practical_test.dto;

import com.quipux.practical_test.model.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponseDTO {
    private String name;
    private String stadium;
    private int numberOfTitles;
    private List<PlayerDTO> startingPlayers;
    private List<PlayerDTO> substitutePlayers;
}
