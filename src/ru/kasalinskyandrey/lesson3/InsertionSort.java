package ru.kasalinskyandrey.lesson3;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arrayName = Binary.arrayCreate(10);

        arraySort(arrayName);

        System.out.println(Arrays.toString(arrayName));


    }


    public static void arraySort(int[] arrayName) {
        System.out.println("Первоначальный массив");
        System.out.println(Arrays.toString(arrayName));

        for (int i = 1; i < arrayName.length; i++) {
            int j;
            int swap = arrayName[i];
            for (j = i; j > 0 && swap < arrayName[j - 1]; j--) {

                arrayName[j] = arrayName[j - 1];
            }
            arrayName[j] = swap;

            System.out.println("Один прогон");
            System.out.println(Arrays.toString(arrayName));
        }
    }
}

