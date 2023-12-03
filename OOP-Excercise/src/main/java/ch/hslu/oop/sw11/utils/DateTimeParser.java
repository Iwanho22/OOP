package ch.hslu.oop.sw11.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeParser {
    public static LocalDateTime parseDate(String timestampAsString) {
        return LocalDateTime.parse(timestampAsString, DateTimeFormatter.ofPattern("\"yyyy/MM/dd HH:mm:ss\""));
    }
}
