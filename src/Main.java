import tasks.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //  1.1	ОКРУГЛЕНИЕ
        Task1RoundingTable.run();

        //  1.2	СТЕПЕНИ
        Task2PowerDigits.run();

        //  1.3	ЗНАКОПОВТОРЕНИЯ
        Task3SignSequence.run(scanner);

        //  1.4	МЕСЯЦЫ
        Task4MonthInfo.run();

        //  1.5	ОБРАТНЫЙ ОТСЧЕТ
        Task5Countdown.run(scanner, args);

        //  1.6	СТАТИСТИКА
        Task6ArrayStatistics.run();

        //  1.7	СТЕК С ПРИОРИТЕТОМ
        Task7PriorityStack.run();
    }
}