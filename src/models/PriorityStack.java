package models;

import java.util.EmptyStackException;
import java.util.Objects;

public class PriorityStack<R> {
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
    private Node<R> head;

    public void push(R value, int priority) {
        Node<R> newNode = new Node<>(value, priority);
        if (Objects.isNull(head) ||
                head.priority <= priority) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node<R> curNode = head;
        while (!Objects.isNull(curNode.next) &&
                curNode.next.priority > newNode.priority) {
            curNode = curNode.next;
        }
        newNode.next = curNode.next;
        curNode.next = newNode;
    }

    public R pop() {
        if (Objects.isNull(head)) throw new EmptyStackException();
        R value = head.value;
        head = head.next;
        return value;
    }

    public R peek() {
        if (Objects.isNull(head)) throw new EmptyStackException();
        return head.value;
    }

    public int size() {
        if (Objects.isNull(head)) return 0;
        int size = 1;
        Node<R> curNode = head;
        while (!Objects.isNull(curNode.next)) {
            size++;
            curNode = curNode.next;
        }
        return size;
    }

    private class Node<T> {
        public T value;
        public int priority;
        public Node<T> next;

        public Node(T value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }
}
