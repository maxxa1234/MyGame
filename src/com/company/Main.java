package com.company;

import java.io.File;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public final class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BackEnd activator = new BackEnd();
        double version = 0.29;
        System.out.println("Добро пожаловать в игру Fight RPG Simulator \n \n \n -------------------------------------");
        System.out.println("Версия игры: " + version + "\n"+
                "Все права защищены \n ------------------------------------- \n \n");
        for(int k = 0;k < 1000;k++) {
            for (int j = 0; j < 1000; j++) {
                if (activator.choose() == 2) {
                    activator.record();
                } else break;
            }
            activator.inputClass();
            activator.outputRules();
            for (int i = 0; i < 100; i++) {
                activator.turnIs();
                if (activator.archer.getHealth() <= 0 || activator.mage.getHealth() <= 0 || activator.warrior.getHealth() <= 0) {
                    activator.gameWin();
                    break;
                }
                activator.outputInfo();
                activator.selectOption();
                if (activator.enemy.getHealth() <= 0) {
                    activator.gameEnd();
                    break;
                }
                activator.enemyTurn();
                if (activator.enemy.getHealth() <= 0) {
                    activator.gameEnd();
                    break;
                }
            }
            switch (activator.restart()){
                case 1:
                    activator.refresh();
                    break;
                case 2:
                    System.exit(0);
                default:
                    System.exit(0);
            }
        }
    }
}



