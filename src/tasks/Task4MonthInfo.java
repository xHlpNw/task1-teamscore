package tasks;

import models.MonthInfo;

import java.time.LocalDate;

public class Task4MonthInfo {
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

        Тестовые примеры:
        Дата	    Результаты методов
        2023-11-12	ноябрь	11	ср	2023-11-30	30	2023 Q4
        1900-01-01	январь	1	пн	1900-01-31	31	1900 Q1
        2020-02-12	февраль	2	сб	2020-02-29	29	2020 Q1

    */
    public static void run() {
        System.out.println("\nTask 4.");

        print(new MonthInfo(LocalDate.of(2023, 11, 12)));
        print(new MonthInfo(LocalDate.of(1900, 1, 1)));
        print(new MonthInfo(LocalDate.of(2020, 2, 12)));
    }

    public static void print(MonthInfo mi) {
        System.out.printf("%10s | %8s | %2d | %2s | %10s | %2d | %2s\n",
                mi.getDate().toString(),
                mi.getMonthFullName(),
                mi.getMonthNumber(),
                mi.getFirstDayOfWeekShort(),
                mi.getLastDateOfMonth(),
                mi.getDaysInMonth(),
                mi.getQuarter()
        );
    }
}
