package ru.kasalinskyandrey.lesson7;

public interface StringQueue {
    String peek(); // возвращает (но не удаляет из очереди) элемент.
    String poll(); //возвращает элемент из очереди и удаляет его.
    void add(String str); // добавляет новый элемент в очередь.

}
