package models;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

public class MonthInfo {
    /*
        1.4	МЕСЯЦЫ
        Реализуйте класс MonthInfo, который будет выводить информацию о дате,
        переданной ему в конструкторе. Если дата не передана (конструктор без
        параметров), использовать текущую дату и время.
        Реализуйте методы, возвращающие:
        •	Полное название месяца на русском языке.
        •	Номер месяца в виде числа (1 — январь, 2 — февраль, …).
        •	День недели первого числа месяца в виде краткого текста
            (пн, вт, ср, чт, пт, сб, вс).
        •	Дату последнего дня месяца.
        •	Количество дней в месяце.
        •	Номер квартала, к которому относится месяц, с годом и приставкой Q
            ("2023 Q1", "2023 Q2", "2023 Q3", "2023 Q4").
    */
    private final LocalDate date;

    public MonthInfo() {
        date = LocalDate.now();
    }

    public MonthInfo(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public String getMonthFullName() {
        return date.getMonth()
                .getDisplayName(TextStyle.FULL, new Locale("ru", "RU"));
    }

    public int getMonthNumber() {
        return date.getMonthValue();
    }

    public String getFirstDayOfWeekShort() {
        LocalDate firstDay = date.withDayOfMonth(1);
        DayOfWeek dow = firstDay.getDayOfWeek();

        return switch (dow) {
            case MONDAY -> "пн";
            case TUESDAY -> "вт";
            case WEDNESDAY -> "ср";
            case THURSDAY -> "чт";
            case FRIDAY -> "пт";
            case SATURDAY -> "сб";
            case SUNDAY -> "вс";
        };
    }

    public LocalDate getLastDateOfMonth() {
        YearMonth ym = YearMonth.from(date);
        return ym.atEndOfMonth();
    }

    public int getDaysInMonth() {
        return YearMonth.from(date).lengthOfMonth();
    }

    public String getQuarter() {
        int month = date.getMonthValue();
        int q = (month - 1) / 3 + 1;
        return date.getYear() + " Q" + q;
    }
}
