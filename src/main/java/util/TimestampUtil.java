package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampUtil {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private TimestampUtil() {
    }


    public static LocalDateTime getCurrentDateTime() {
        String formattedDateTime = LocalDateTime.now().format(FORMATTER);
        return LocalDateTime.parse(formattedDateTime, FORMATTER);
    }


}
