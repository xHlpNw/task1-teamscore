package tasks;

import utils.DateUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class Task5Countdown {
    /*
        1.5	ОБРАТНЫЙ ОТСЧЕТ
        Пользователь вводит дату и время какого-то события. Необходимо вывести,
        сколько до него осталось дней, часов, минут.
        Например, если сейчас 10.11.2025 10:31, а пользователь ввел
        01.12.2025 13:35 – это 21 день 3 часа и 4 минуты.
        •	Все числа выводить как целые.
        •	Если введенная дата и время ранее или равны текущим,
            вывести «Уже наступило!».
        •	Единицы времени больше дней (недели, месяцы, годы) выводить не
            нужно. Если получилось 100 дней – так и пишем.
        •	Если получается 0 дней, или 0 часов, или 0 минут – соответствующую
            часть пропустить.
        •	Окончания всех слов должны согласовываться с числом (1 день, 3 дня,
            1005 дней, 21 минута и т.д.). Желательно выделить отдельный метод,
            который будет выбирать нужный вариант окончания/слова.
        •	Циклы для решения не нужны.
        •	Добавьте возможность передать дату как аргумент командной строки.
    */
    public static void run(Scanner scanner, String[] args) {
        System.out.println("\nTask 5.");

        LocalDateTime inputDateTime = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        if (args.length > 0) {
            inputDateTime = LocalDateTime.parse(args[0], formatter);
        }
        while (Objects.isNull(inputDateTime)) {
            System.out.print("Введите дату и время (в формате DD.MM.YYYY HH:MM): ");
            try {
                inputDateTime = LocalDateTime.parse(scanner.nextLine(), formatter);
            } catch (Exception e) {
                System.out.println("Ошибка! Введите корректную дату.");
            }
        }

        System.out.println(DateUtils.getCountdown(inputDateTime));
    }
}
