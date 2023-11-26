package com.quipux.practical_test.service;

import com.quipux.practical_test.dto.HourInWordResponseDTO;
import org.springframework.http.ResponseEntity;

public interface HourInWordsService {
    ResponseEntity<HourInWordResponseDTO> getHourInWords(Integer hours, Integer minutes) throws Exception;
}
