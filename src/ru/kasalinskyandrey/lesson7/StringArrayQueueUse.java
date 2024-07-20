package ru.kasalinskyandrey.lesson7;


public class StringArrayQueueUse {
    public static void main(String[] args) {

        StringQueue stringArrayQueue = new StringArrayQueue();

        System.out.println(stringArrayQueue.empty());

        stringArrayQueue.insert("One");
        stringArrayQueue.insert("Two");
        stringArrayQueue.insert("Three");
        stringArrayQueue.insert("Four");
        stringArrayQueue.insert("Five");
        stringArrayQueue.insert("Six");

        System.out.println(stringArrayQueue.empty());

        for(int i = 0; i < 6; i++) {
           System.out.print(stringArrayQueue.remove() + ", ");
        }
        System.out.print("End.");

    }
}
