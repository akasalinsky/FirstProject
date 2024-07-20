package ru.kasalinskyandrey.lesson6;

public class StringArrayStackUse {
    public static void main(String[] args) {

        StringStack stringArrayStack = new StringArrayStack(20);
        //System.out.println(stringArrayStack.peek());

        stringArrayStack.push("One");
        stringArrayStack.push("Two");
        stringArrayStack.push("Three");
        stringArrayStack.push("Four");
        stringArrayStack.push("Five");
        stringArrayStack.push("Six");

        for(int i = 0; i < 6; i++) {
            System.out.print(stringArrayStack.pop() + ", ");
        }
        System.out.print("End.");

    }
}
