package ru.kasalinskyandrey.lesson6;

public class StringArrayStackUse {
    public static void main(String[] args) {

        StringArrayStack stringArrayStack = new StringArrayStack();
        //System.out.println(stringArrayStack.peek());

        stringArrayStack.push("One");
        stringArrayStack.push("Two");
        stringArrayStack.push("Three");

        System.out.println(stringArrayStack.peek());

        System.out.println(stringArrayStack.pop());

        System.out.println(stringArrayStack.peek());

        System.out.println(stringArrayStack.pop());

        System.out.println(stringArrayStack.pop());

        System.out.println(stringArrayStack.pop());



    }
}
