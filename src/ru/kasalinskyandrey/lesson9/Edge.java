package ru.kasalinskyandrey.lesson9;

public interface Edge<N, E> {
    E getWeight();
    N getNode1();
    N getNode2();
}