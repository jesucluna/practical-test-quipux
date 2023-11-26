package com.quipux.practical_test.controller;

import com.quipux.practical_test.dto.HourInWordResponseDTO;
import com.quipux.practical_test.dto.QuipuxNumberResponseDTO;
import com.quipux.practical_test.service.QuipuxNumberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quipux-number")
public class QuipuxNumberController {
    @Autowired
    QuipuxNumberService quipuxNumberService;

    @GetMapping("/get")
    public ResponseEntity<QuipuxNumberResponseDTO> getQuipuxNumber(@Valid @RequestParam Integer number) throws Exception {
        return quipuxNumberService.getQuipuxNumber(number);
    }

}
