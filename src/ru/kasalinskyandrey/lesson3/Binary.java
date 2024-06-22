package ru.kasalinskyandrey.lesson3;

import java.util.Arrays;

public class Binary {

    public static void main(String[] args) {

        //int[] arrayName = {0, 1, 2, 3, 4, 5};
        int[] arrayName = arrayCreate(100);

        System.out.println(binarySearch(arrayName, 1));
        System.out.println(Arrays.toString(arrayName));
        //System.out.println(binarySearch(arrayName, 1));
    }

    public static int[] arrayCreate(int arrayLength) {
        // создаем массив, размер которого указал пользователь
        int[] arrayName = new int[arrayLength];

        for (int i = 0; i < arrayName.length; i++) {
            arrayName[i] = (int) (100 - Math.random()*100);
        }
        return arrayName;
    }

    public static int[] arraySorting(int[] arrayName) {
        Arrays.sort(arrayName);
        return arrayName;
    }

    public static int binarySearch(int[] arrayName, int numberToFind) {
        int[] newArray = arraySorting(arrayName);
        int left = 0, right = newArray.length - 1;



        while (left <= right) {
            int index = (right + left) / 2;

            if (newArray[index] < numberToFind) {
                left = index + 1;
                System.out.println("Прибавляем");

            } else if (newArray[index] > numberToFind) {
                right = index - 1;
                System.out.println("Убавляем");

            } else if (newArray[index] == numberToFind) {
                System.out.println("Нашли");
                return newArray[index];

            }
        }


        return -1;
    }


}
