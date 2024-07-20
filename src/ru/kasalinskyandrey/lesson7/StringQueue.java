package ru.kasalinskyandrey.lesson7;

public interface StringQueue {
    String peek(); // возвращает (но не удаляет из очереди) элемент.
    String remove(); //возвращает элемент из очереди и удаляет его.
    void insert(String str); // добавляет новый элемент в очередь.
}
