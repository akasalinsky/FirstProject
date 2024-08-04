package ru.kasalinskyandrey.lesson8;


import java.util.LinkedList;

public class MyLinkedListUse {
    public static void main(String[] args) {

        MyLinkedList<Integer> test = new MyLinkedList<Integer>();
        test.addLast(3);
        test.addFirst(2);
        test.addFirst(1);
        test.addLast(4);
        System.out.println(test.getElementByIndex(1));
        System.out.println(test.getElementByIndex(2));
        System.out.println(test.getElementByIndex(3));
        System.out.println(test.getElementByIndex(4));

        LinkedList list = new LinkedList();

    }
}
