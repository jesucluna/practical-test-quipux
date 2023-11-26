package com.quipux.practical_test.service;

import com.quipux.practical_test.dto.HourInWordResponseDTO;
import com.quipux.practical_test.dto.QuipuxNumberResponseDTO;
import org.springframework.http.ResponseEntity;

public interface QuipuxNumberService {
    ResponseEntity<QuipuxNumberResponseDTO> getQuipuxNumber(Integer number) throws Exception;
}
