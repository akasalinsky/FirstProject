package ru.kasalinskyandrey.lesson2;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Double.NaN;

public class calculator {

    //Создаем массив символов, с которыми будем сравнивать введенные пользователем
    static String[] mathSymbols = new String[]{"+", "-", "/", "*"};


    public static void main(String[] args) {
        // Приветсвенное сообщение и пояснение для пользователя по использованию калькулятора
        System.out.println("Это простой калькулятор, который использует следующие операции: " +
                Arrays.toString(mathSymbols) + "с двумя числами за раз. Для выхода введите exit. " +
                "Для очистки памяти введите clear");
        System.out.println("Введите операцию с двуми числами");

        //Получение выражения в виде строки
        final Scanner console = new Scanner(System.in);
        String inputString = console.nextLine();
        double summ = 0;

        //Проверяем введены ли стоп слова
        while (!inputString.equals("exit")) {


            if (inputString.equals("clear")) {
                System.out.println("Введите операцию с двуми числами");
                inputString = console.nextLine();
                summ = calculat(inputString);
            } else if (getFirstNumber(inputString) != getFirstNumber(inputString)) {
                summ = calculat(inputString, summ);
            } else {
                summ = calculat(inputString);
            }

            inputString = console.nextLine();
        }
        System.out.println("Работа программы окончена");
    }

    //Метод для вычисления операции. Возвращает результат
    public static double calculat(String name) {

        String symbolName = getSymbol(name);
        double firstNumber = getFirstNumber(name);
        double secondNumber = getSecondNumber(name);
        double summ = 0;

        switch (symbolName) {
            case ("+"):
                summ = firstNumber + secondNumber;
                break;
            case ("-"):
                summ = firstNumber - secondNumber;
                break;
            case ("*"):
                summ = firstNumber * secondNumber;
                break;
            case ("/"):
                summ = firstNumber / secondNumber;
                break;
        }
        System.out.println(summ);
        System.out.println("Введите следующую операцию:");

        return summ;
    }

    public static double calculat(String name, double firstNumber) {

        String symbolName = getSymbol(name);
        double secondNumber = getSecondNumber(name);
        double summ = 0;

        switch (symbolName) {
            case ("+"):
                summ = firstNumber + secondNumber;
                break;
            case ("-"):
                summ = firstNumber - secondNumber;
                break;
            case ("*"):
                summ = firstNumber * secondNumber;
                break;
            case ("/"):
                summ = firstNumber / secondNumber;
                break;
        }
        System.out.println(summ);
        System.out.println("Введите следующую операцию:");

        return summ;
    }

    //Получение введенного знака
    public static String getSymbol(String name){
        //Получаем индекс знака

        //Объявляю переменную в которой будет храниться знак
        int indexSymbol = 0;
        // Ищу знак сравнивая с массивом операций
        for (int i = 0; i < mathSymbols.length; i++){
            indexSymbol = name.indexOf(mathSymbols[i]);
            if (indexSymbol != (-1)) {
                break;
            }
        }
        String symbolName = name.substring(indexSymbol, indexSymbol + 1);
        return symbolName;
    }

    //Получение первого числа из подстроки
    public static double getFirstNumber(String name) {
        //Удалим пробелы
        String name2 = name.trim();

        //Получим индекс знака из очищенной строки
        int index = name2.indexOf(getSymbol(name2));

        if (index == 0) {
            return NaN;
        } else {

            //Получим подстроку с первым числом и преобразуем в тип double
            String firstNumberString = name2.substring(0, index);

            //Переведем строку в число и вернем его
            double firstNumber = Double.parseDouble(firstNumberString);
            return firstNumber;
        }
    }

    public static double getSecondNumber(String name) {
        //Удалим пробелы
        String name2 = name.trim();

        //Получим индекс знака из очищенной строки
        int index = name2.indexOf(getSymbol(name2));

        //Получим подстроку с первым числом и преобразуем в тип double
        String secondNumberString = name2.substring(index + 1);

        //Переведем строку в число и вернем его
        double secondNumber = Double.parseDouble(secondNumberString);
        return secondNumber;
    }
}


