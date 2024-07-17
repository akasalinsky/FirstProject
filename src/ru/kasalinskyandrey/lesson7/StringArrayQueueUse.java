package ru.kasalinskyandrey.lesson7;

public class StringArrayQueueUse {
    public static void main(String[] args) {

        StringArrayQueue stringArrayQueue = new StringArrayQueue();
        //System.out.println(stringArrayStack.peek());

        stringArrayQueue.add("One");
        stringArrayQueue.add("Two");
        stringArrayQueue.add("Three");

        System.out.println(stringArrayQueue.poll());

        System.out.println(stringArrayQueue.poll());

        System.out.println(stringArrayQueue.poll());

    }
}
