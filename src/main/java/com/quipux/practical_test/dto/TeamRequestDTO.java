package com.quipux.practical_test.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamRequestDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String stadium;
    @Min(value = 0)
    private int numberOfTitles;
    @Size(min = 0)
    @Valid
    private List<PlayerRequestDTO> startingPlayers;
    @Size(min = 0)
    @Valid
    private List<PlayerRequestDTO> substitutePlayers;
}
