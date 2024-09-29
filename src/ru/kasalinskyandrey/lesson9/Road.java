package ru.kasalinskyandrey.lesson9;

public class Road<N, E> implements Edge<N, E> {
    E distance;
    N city1;
    N city2;

    Road (){}

    Road (N city1, N city2, E distance){
        this.city1 = city1;
        this.city2 = city2;
        this.distance = distance;
    }

    @Override
    public N getNode1(){
        return city1;
    }

    @Override
    public N getNode2(){
        return city2;
    }

    @Override
    public E getWeight() {
        return distance;
    }
}

