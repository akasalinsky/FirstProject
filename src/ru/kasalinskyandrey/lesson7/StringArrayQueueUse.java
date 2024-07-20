package ru.kasalinskyandrey.lesson7;


public class StringArrayQueueUse {
    public static void main(String[] args) {

        StringQueue stringArrayQueue = new StringArrayQueue();


        stringArrayQueue.add("One");
        stringArrayQueue.add("Two");
        stringArrayQueue.add("Three");
        stringArrayQueue.add("Four");
        stringArrayQueue.add("Five");
        stringArrayQueue.add("Six");


        for(int i = 0; i < 6; i++) {
           System.out.print(stringArrayQueue.poll() + ", ");
        }
        System.out.print("End.");

    }
}
