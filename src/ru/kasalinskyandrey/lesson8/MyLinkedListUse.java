package ru.kasalinskyandrey.lesson8;


import java.util.LinkedList;

public class MyLinkedListUse {
    public static void main(String[] args) {

        MyLinkedList<Integer> test = new MyLinkedList<Integer>();
        test.addLast(3);
        test.addFirst(2);
        test.addFirst(2);
        test.addFirst(1);
        test.addLast(4);

        System.out.println(test.getFirstElement());
        System.out.println(test.getLastElement());

        System.out.println();

        test.removeFirst();
        test.removeLast();

        System.out.println(test.getElementByIndex(1));
        System.out.println(test.getElementByIndex(2));
        System.out.println(test.getElementByIndex(3));
        System.out.println(test.getElementByIndex(4));

        System.out.println();

        System.out.println("indexOf: " + test.indexOf(2));

        System.out.println();

        test.clearAll();

        System.out.println(test.getElementByIndex(1));
        System.out.println(test.getElementByIndex(2));
        System.out.println(test.getElementByIndex(3));
        System.out.println(test.getElementByIndex(4));


    }
}
