package ru.kasalinskyandrey.lesson5;

import java.util.Arrays;

public class NewList implements NewListable {
    private String[] string = new String[]{"1", "2", "3"};

    public static void main(String[] args) {
        NewList newList = new NewList();

        System.out.println(newList.isEmpty());

        System.out.println(newList.getSize());

        System.out.println(Arrays.toString(newList.addFirst("mail")));

        System.out.println(Arrays.toString(newList.add(2, "mail")));

        System.out.println(Arrays.toString(newList.addLast("mail")));

        System.out.println(newList.getFirst());

        System.out.println(newList.getLast());

        System.out.println(newList.getIndex("2"));

        System.out.println(Arrays.toString(newList.removeFirst()));

        System.out.println(Arrays.toString(newList.removeLast()));

        System.out.println(Arrays.toString(newList.remove(0)));

        System.out.println(newList.contains("6"));

    }

    //Сложность - О(1)
    public boolean isEmpty() {
        return (string.length > 0);
    }

    //Сложность - О(1)
    public int getSize() {
        return (string.length);
    }

    //Сложность - О(n)
    public String[] addFirst(String str) {
        String[] stringNew = new String[string.length + 1];
        stringNew[0] = str;

        for (int i = 1; i < stringNew.length; i++) {
            stringNew[i] = string[i - 1];
        }
        return stringNew;
    }

    //Сложность - О(n^2)
    public String[] add(Integer index, String str) {
        String[] stringNew = new String[string.length + 1];
        stringNew[index] = str;

        for (int i = 0; i < index; i++) {
            stringNew[i] = string[i];
        }

        for (int j = index + 1; j < stringNew.length; j++) {
            stringNew[j] = string[j - 1];
        }
        return stringNew;
    }

    //Сложность - О(n)
    public String[] addLast(String str) {
        String[] stringNew = new String[string.length + 1];
        stringNew[stringNew.length - 1] = str;

        for (int i = 0; i < stringNew.length - 1; i++) {
            stringNew[i] = string[i];
        }
        return stringNew;
    }

    //Сложность - О(1)
    public String getFirst() {
        return string[0];
    }

    //Сложность - О(1)
    public String getLast() {
        return string[string.length - 1];
    }

    //Сложность - О(n)
    public int getIndex(String str) {
        int index = -1;

        for (int i = 0; i < string.length; i++) {
            if (string[i].equals(str)) {
                index = i;
            }
        }
        return index;
    }

    //Сложность - О(n)
    public String[] removeFirst() {
        String[] stringNew = new String[string.length - 1];

        for (int i = 0; i < stringNew.length; i++) {
            stringNew[i] = string[i + 1];
        }
        return stringNew;
    }

    //Сложность - О(n)
    public String[] removeLast() {
        String[] stringNew = new String[string.length - 1];

        for (int i = 0; i < stringNew.length; i++) {
            stringNew[i] = string[i];
        }
        return stringNew;
    }

    //Сложность - О(n^2)
    public String[] remove(Integer index) {
        String[] stringNew = new String[string.length - 1];

        for (int i = 0; i < index; i++) {
            stringNew[i] = string[i];
        }

        for (int j = index + 1; j < string.length; j++) {
            stringNew[j - 1] = string[j];
        }
        return stringNew;
    }

    //Сложность - О(n)
    public boolean contains(String str) {
        for (int i = 0; i < string.length; i++) {
            if (str.equals(string[i])) {
                return true;
            }
        }
        return false;
    }
}
