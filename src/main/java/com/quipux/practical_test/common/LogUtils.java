package com.quipux.practical_test.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogUtils {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    public LogUtils() {}
    public void catchThrowable(Throwable e) {
        logger.error(e.getMessage(), e);
        while (e.getCause() != null) {
            e = e.getCause();
            logger.error(e.getMessage(), e);
        }
    }

}
