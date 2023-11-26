package com.quipux.practical_test.controller;

import com.quipux.practical_test.dto.HourInWordResponseDTO;
import com.quipux.practical_test.service.HourInWordsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hour-in-words")
public class HourInWordsController {
    @Autowired
    HourInWordsService hourInWordsService;

    @GetMapping("/get")
    public ResponseEntity<HourInWordResponseDTO> getHourInWords(@Valid @RequestParam Integer hours, @Valid @RequestParam Integer minutes) throws Exception {
        return hourInWordsService.getHourInWords(hours, minutes);
    }
}
