package com.example.bankcards.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CardTermUtil {

    public static String getExpiryDate() {
        return LocalDate.now()
                .plusYears(5)
                .format(DateTimeFormatter.ofPattern("MMyy"));
    }
}
