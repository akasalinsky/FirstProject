package ru.kasalinskyandrey.lesson7;

import ru.kasalinskyandrey.lesson6.StringArrayStack;
import ru.kasalinskyandrey.lesson6.StringStack;

public class StringArrayQueueUse {
    public static void main(String[] args) {

        StringQueue stringArrayQueue = new StringArrayQueue();

        stringArrayQueue.insert("One");
        stringArrayQueue.insert("Two");
        stringArrayQueue.insert("Three");
        stringArrayQueue.insert("Four");
        stringArrayQueue.insert("Five");
        stringArrayQueue.insert("Six");

        for(int i = 0; i < 6; i++) {
            System.out.println(stringArrayQueue.peek());
            System.out.println(stringArrayQueue.remove() + ", ");
        }
        System.out.print("End.");

    }
}
