package utils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateUtils {
    public static String getCountdown(LocalDateTime date) {
        LocalDateTime now = LocalDateTime.now();

        if (!date.isAfter(now)) {
            return "Уже наступило!";
        }

        long minutesBetween = ChronoUnit.MINUTES.between(now, date);

        long days = minutesBetween / (24 * 60);
        long hours = (minutesBetween % (24 * 60)) / 60;
        long minutes = minutesBetween % 60;

        StringBuilder result = new StringBuilder();

        if (days > 0) result.append(days).append(" ")
                .append(WordUtils.getWordForm(days, "день", "дня", "дней"));
        if (hours > 0) {
            if (!result.isEmpty()) result.append(" ");
            result.append(hours).append(" ")
                    .append(WordUtils.getWordForm(hours, "час", "часа", "часов"));
        }
        if (minutes > 0) {
            if (!result.isEmpty()) result.append(" ");
            result.append(minutes).append(" ")
                    .append(WordUtils.getWordForm(minutes, "минута", "минуты", "минут"));
        }

        return result.toString();
    }
}
