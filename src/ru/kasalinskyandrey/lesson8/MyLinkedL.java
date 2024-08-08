package ru.kasalinskyandrey.lesson8;

public interface MyLinkedL<E> {

    void addLast(E e);
    void addFirst(E e);

    E getElementByIndex(int counter);

    void remove(E e);
    void removeFirst();
    void removeLast();

    E getFirstElement();
    E getLastElement();

    int indexOf(E e);
    void clearAll();

}
