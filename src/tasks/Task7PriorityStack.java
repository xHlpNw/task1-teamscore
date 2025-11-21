package tasks;

import models.PriorityStack;

public class Task7PriorityStack {
    /*
        1.7	СТЕК С ПРИОРИТЕТОМ
        Напишите реализацию обобщённого отсортированного стека с приоритетом:
        значения проталкиваются в стек в порядке приоритета, а извлекается
        всегда верхнее значение (с наивысшим приоритетом). Сами проталкиваемые
        в стек значения могут быть любого типа.

        Класс PriorityStack должен содержать методы:
        •	size - Количество элементов в стеке.
        •	push – протолкнуть в стек значение с указанным приоритетом.
            Чем меньше приоритет, тем выше (ближе к началу) элемент в стеке.
        •	pop - извлечь (удалить и вернуть) значение верхнего
            (первого) элемента в стеке.
        •	peek – посмотреть верхнее значение стека, не извлекая его.
    */
    public static void run() {
        System.out.println("\nTask 7.");
        PriorityStack<String> stack = new PriorityStack<>();
        stack.push("second", 2);
        stack.push("first", 3);
        stack.push("forth", 1);
        stack.push("third", 1);

        System.out.println("size: " + stack.size());
        System.out.println("peek: " + stack.peek());

        System.out.println("\npops:");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
