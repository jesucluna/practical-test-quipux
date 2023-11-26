package com.quipux.practical_test.service;

import com.quipux.practical_test.common.LogUtils;
import com.quipux.practical_test.common.TimeUtils;
import com.quipux.practical_test.constants.Constants;
import com.quipux.practical_test.dto.HourInWordResponseDTO;
import com.quipux.practical_test.dto.QuipuxNumberResponseDTO;
import com.quipux.practical_test.exception.CustomException;
import com.quipux.practical_test.exception.InternalServerException;
import com.quipux.practical_test.exception.NotAcceptableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HourInWordsServiceImpl implements HourInWordsService {
    @Autowired
    private LogUtils logUtils;
    @Autowired
    private TimeUtils timeUtils;

    @Override
    public ResponseEntity<HourInWordResponseDTO> getHourInWords(Integer hours, Integer minutes) throws Exception {
        HourInWordResponseDTO responseDTO = new HourInWordResponseDTO();
        try {
            if (hours < 1 || hours >= 12 || minutes < 0 || minutes >= 60) {
                throw new NotAcceptableException(String.join(". ", Constants.ERROR_NOT_ACCEPTABLE,  Constants.ERROR_HOUR_MINUTE_OUT_RANGE));
            }
            responseDTO.setHour(timeUtils.convertHourInWords(hours, minutes));
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (CustomException e) {
            this.logUtils.catchThrowable(e);
            throw e;
        } catch (Exception e) {
            this.logUtils.catchThrowable(e);
            throw new InternalServerException(e.getMessage());
        }
    }
}
