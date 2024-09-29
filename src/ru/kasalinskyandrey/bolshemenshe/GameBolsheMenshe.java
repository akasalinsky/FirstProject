package ru.kasalinskyandrey.bolshemenshe;

import java.util.Scanner;

public class GameBolsheMenshe implements Game {

    private static final int INIT_NUMBER = 160;

    private void comparison(int number){
        if (number == INIT_NUMBER) {
            closeGame();
        }
        else if (number < INIT_NUMBER) {
            System.out.println("Меньше");
            start();
        }
        else {
            System.out.println("Больше");
            start();
        }
    }

    public void start() {
        System.out.println("Введите число");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        comparison(number);
    }

    private void closeGame() {
        System.out.println("Вы угадали! Игра завершена!");
    }

}
