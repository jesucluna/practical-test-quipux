package com.quipux.practical_test.service;

import com.quipux.practical_test.common.LogUtils;
import com.quipux.practical_test.constants.Constants;
import com.quipux.practical_test.dto.HourInWordResponseDTO;
import com.quipux.practical_test.dto.QuipuxNumberResponseDTO;
import com.quipux.practical_test.exception.CustomException;
import com.quipux.practical_test.exception.InternalServerException;
import com.quipux.practical_test.exception.NotAcceptableException;
import com.quipux.practical_test.common.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuipuxNumberServiceImpl implements QuipuxNumberService {
    @Autowired
    private LogUtils logUtils;
    @Override
    public ResponseEntity<QuipuxNumberResponseDTO> getQuipuxNumber(Integer number) throws Exception {
        QuipuxNumberResponseDTO responseDTO = new QuipuxNumberResponseDTO();
        try {
            if (number < 1 || number > 100) {
                throw new NotAcceptableException(String.join(". ", Constants.ERROR_NOT_ACCEPTABLE,  Constants.ERROR_NUMBER_OUT_RANGE));
            }
            if (number %2 != 0) {
                responseDTO.setQuipuxNumber(Constants.QUIPUX);
            } else {
                if (number <= 5) responseDTO.setQuipuxNumber(Constants.NO_QUIPUX);
                if (number >= 6 && number <= 20) responseDTO.setQuipuxNumber(Constants.QUIPUX);
                if (number > 20) responseDTO.setQuipuxNumber(Constants.NO_QUIPUX);;
            }
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
