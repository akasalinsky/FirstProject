package ru.kasalinskyandrey.lesson6;

public interface StringStack {
    void push(String str); // добавляет элемент на верх стека.
    String pop(); // удаляет верхний элемент из стека и возвращает его.
    String peek(); // возвращает верхний элемент стека, но не удаляет его из стека.
    boolean empty(); // проверяет пуст ли стек

}
