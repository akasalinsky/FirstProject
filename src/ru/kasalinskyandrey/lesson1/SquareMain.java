package ru.kasalinskyandrey.lesson1;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SquareMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Привет! Это программа для рисования квадрата. Введите start, чтобы ");
        while (scanner.nextLine() ) {



            System.out.println("Чтобы нарисовать квадрат, введите внешний размер квадрата");
            int numberA = scanner.nextInt();

            // Проверяем, чтобы число было положительным.
            while (numberA < 0) {
                System.out.println("Ошибка. Число должно быть положительным. Введите размер квадрата заново");
                numberA = scanner.nextInt();
            }

            System.out.println("Теперь введите размер внутреннего квадрата");
            int numberB = scanner.nextInt();
            // Проверяем, чтобы высота была положительной.
            while ((numberB < 0) || (numberA - numberB) % 2 == 1) {
                System.out.println("Ошибка. Число должно быть положительным и должно быть меньше внешнего размера квадрата как минимум на 2 значения. Введите  размер внутреннего квадрата заново");
                numberB = scanner.nextInt();
            }


            //Иницилизируем массив и заполняем его полностью символами *.
            String[][] square = new String[numberA][numberA];
            for (int i = 0; i < numberA; i++) {
                for (int j = 0; j < numberA; j++) {
                    square[i][j] = "* ";
                }
            }

            // определим начальные координаты внутреннего квадрата в массиве
            int numberX = (numberA - numberB) / 2;


            //вводим в массив символы " " по размеру внутреннего квадрата
            for (int i = numberX; i < (numberB + numberX); i++) {
                for (int j = numberX; j < (numberB + numberX); j++) {
                    square[i][j] = "  ";
                }
            }

            //Выводим в консоль все элементы массива
            for (int i = 0; i < numberA; i++) {
                for (int j = 0; j < numberA; j++) {
                    System.out.print(square[i][j]);
                }
                System.out.println();

            }

        }


    }
}