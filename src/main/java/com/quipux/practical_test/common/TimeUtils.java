package com.quipux.practical_test.common;

import com.quipux.practical_test.constants.Constants;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TimeUtils {
    public TimeUtils() {}
    private final Map<Integer, String> numberInWords = Map.ofEntries(
            Map.entry(1, "uno"),
            Map.entry(2, "dos"),
            Map.entry(3, "tres"),
            Map.entry(4, "cuatro"),
            Map.entry(5, "cinco"),
            Map.entry(6, "seis"),
            Map.entry(7, "siete"),
            Map.entry(8, "ocho"),
            Map.entry(9, "nueve"),
            Map.entry(10, "diez"),
            Map.entry(11, "once"),
            Map.entry(12, "doce"),
            Map.entry(13, "trece"),
            Map.entry(14, "catorce"),
            Map.entry(15, "quince"),
            Map.entry(16, "dieciséis"),
            Map.entry(17, "diecisiete"),
            Map.entry(18, "dieciocho"),
            Map.entry(19, "diecinueve"),
            Map.entry(20, "veinte"));
    private final Map<Integer, String> tensInWords = Map.ofEntries(
            Map.entry(2, "veinti"),
            Map.entry(3, "treinta"),
            Map.entry(4, "cuarenta"),
            Map.entry(5, "cincuenta"));

    public String convertHourInWords(int hours, int minutes) {
        String hoursInWords = numberInWords.get(hours);
        if (minutes == 0) return String.join(" ", hoursInWords, Constants.TIME_OCLOCK);
        if (minutes == 30) return String.join(" ", hoursInWords, Constants.TIME_HALF);

        String minutesInWords = String.join(" ", convertMinutesInWords(minutes), Constants.TIME_MINUTES);
        return String.join(" y ", hoursInWords, minutesInWords);
    }

    private String convertMinutesInWords(int minutes) {
        if (minutes <= 20) return numberInWords.get(minutes);
        if (minutes < 30) return tensInWords.get(2) + numberInWords.get(minutes - 20);

        int units = minutes % 10;
        return tensInWords.get(minutes / 10) + (units > 0 ? (" y " + numberInWords.get(units)) : "");
    }

}
