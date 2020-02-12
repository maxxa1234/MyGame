package com.company;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class BackEnd {
    BufferedReader br = null;
    Scanner scan = new Scanner(System.in);
    Random random = new Random();
    File myFile = new File("Record.txt");

    String ourClass;
    int turn = 1;
    Hero warrior = new Warrior();
    Hero archer = new Archer();
    Hero mage = new Mage();
    Hero enemy = new Enemy();


    public String inputName() {
        System.out.println("Введите ваш никнейм: ");
        return scan.next();
    }

    public void inputClass() {
        System.out.println("Выберите ваш класс маг(1), воин(2), лучник(3): ");
        int heroClass = scan.nextInt();
        switch (heroClass) {
            case 1:
                ourClass = "mage";
                mage.setName(inputName());
                break;
            case 3:
                ourClass = "archer";
                archer.setName(inputName());
                break;
            case 2:
                ourClass = "warrior";
                warrior.setName(inputName());
                break;
            default:
                System.out.println("Вы ввели несуществующий класс");
                inputClass();
        }
    }

    public String outputName() {
        String ourName = null;
        switch (ourClass) {
            case "mage":
                ourName = mage.getName();
                break;
            case "archer":
                ourName = archer.getName();
                break;
            case "warrior":
                ourName = warrior.getName();
                break;
        }
        return ourName;
    }

    public void outputRules() {
        System.out.println("Здраствуй, великий " + ourClass + " " + outputName() + " , неподалёку обитает монстр под именем " + enemy.getName() + "." +
                "\n" + "Страшный монстр, которого вам предстоит победить, что бы он закончил свои злодеяния." + "\n" +
                "В начале вашего хода у вас будет 3 действия, на выбор: " + "\n"
                + "Напишите \"1\" чтобы нанести урон равный вашей атаке " + "\n"
                + "Напишите \"2\" чтобы выпить зелье, которое исцелит вас на 10 хп." + "\n"
                + "Напишите \"3\" чтобы использовать способность класса(способность можно использовать 1 раз в 3 хода).");
    }

    public void outputInfo() {
        System.out.println("========== ВАШ ХОД ==========");
        System.out.println("Ваше имя: " + outputName() + "\n" + "Ваш класс: " + ourClass);
        switch (ourClass) {
            case "mage":
                System.out.println("Ваше здоровье: " + mage.getHealth() + "\n" + "Ваша атака: " + mage.getAttack() + "\n"
                        + mage.getSkillName() + ": Призывает метеорит, который наносит 20 урона.");
                break;
            case "archer":
                System.out.println("Ваше здоровье: " + archer.getHealth() + "\n" + "Ваша атака: " + archer.getAttack());
                if(archer.getSkillActive()>0) {
                System.out.println("Ваша атака усилина +7 к урона на " + archer.getSkillActive() + " хода!");
            }
                System.out.println(archer.getSkillName() + ": На 2 хода вы оснащаете ваши стрелы огнём, что увеличит ваш урон на 7 урона.");
                break;
            case "warrior":
                System.out.println("Ваше здоровье: " + warrior.getHealth() + "\n" + "Ваша атака: " + warrior.getAttack() + "\n"
                        + warrior.getSkillName() + ": Вы подымаете щит, тем самым вы исцеляетесь на 15 хп, " +
                        "но при этом вы можете увеличить своё здоровье выше стандартного. ");
                break;
        }
    }

    public void selectOption() {
        turn++;
        int playerSelect = 0;
        if (scan.hasNextInt()) {
            playerSelect = scan.nextInt();
            if (playerSelect < 4 && playerSelect > 0) {
            } else {
                selectOption();
            }
            }else {
                selectOption();
            }
        switch (playerSelect) {
            case 1:
                switch (ourClass) {
                    case "mage":
                        enemy.setHealth(mage.damage());
                        break;
                    case "archer":
                        enemy.setHealth(archer.damage());
                        break;
                    case "warrior":
                        enemy.setHealth(warrior.damage());
                        break;
                }
                break;
            case 2:
                switch (ourClass) {
                    case "mage":
                        mage.heal();
                        break;
                    case "archer":
                        archer.heal();
                        break;
                    case "warrior":
                        warrior.heal();
                        break;
                }
             break;
            case 3:
                switch (ourClass) {
                    case "mage":
                        if (mage.cd == 3 || mage.cd == 2 || mage.cd == 1){
                        } else {
                            enemy.setHealth(mage.skill());
                        }
                        break;
                    case "archer":
                        archer.skill();

                        break;
                    case "warrior":
                        warrior.skill();
                        break;
                }
                break;
        }
    }

    public void enemyTurn(){
        System.out.println("========== ХОД ПРОТИВНИКА ==========");
        System.out.println("Имя: " +enemy.getName() + "\n" +
        "Здоровье " + enemy.getName()+": "+enemy.getHealth()+"\n"
        + "Атака " + enemy.getName()+": "+enemy.getAttack()+"\n"
        + enemy.getSkillName() + ": с вероятностью 50% удваевает урон и исцеление в 2 раза или наносит себе 10 урона");
        int rndm = random.nextInt(3);
        switch (rndm){
            case 0:
                switch (ourClass) {
                    case "mage":
                        mage.setHealth(enemy.damage());
                        break;
                    case "archer":
                        archer.setHealth(enemy.damage());
                        break;
                    case "warrior":
                        int rand = random.nextInt(5);
                        if(rand == 4){
                            System.out.println(outputName() + " заблокировал атаку щитом");
                        } else {
                            warrior.setHealth(enemy.damage());
                            break;
                        }
                }
                break;
            case 1:
                enemy.heal();
                break;
            case 2:
                enemy.skill();
                break;
        }
    }

    public void turnIs(){
        System.out.println("\n" + "\n" +"\n" + "========== Ход номер:"+turn+" ==========" + "\n" + "\n" +"\n");
    }

    public void gameEnd(){
        System.out.println("\n" + "\n" + "\n" + "Вы уничтожили босса!(странно)"+ "\n" +
                "========== КОНЕЦ ИГРЫ ==========" + "\n" + "\n" + "\n");
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(myFile, true)));
            writer.println("Player: " + outputName() + "    Class: " + ourClass + "    Turn: " + turn);
            writer.flush();
            writer.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void gameWin(){
        System.out.println("\n" + "\n" + "\n" + "Вас сожрали!("+ "\n" +
                "========== КОНЕЦ ИГРЫ ==========" + "\n" +"\n" +"\n");
    }

    public void record(){
        try{
            br = new BufferedReader(new FileReader("Record.txt"));
            String line;
            System.out.println("\n -------------------------------------");
            while((line = br.readLine())!= null){
                System.out.println(line);
            }
            System.out.println("------------------------------------- \n");
        } catch (IOException e){
            System.out.println("Вы еще не выиграли ни разу! \n");;
        }
    }

    public int choose() {
        int choose = 0;
        System.out.println("===== 1.Начать игру ===== \n ===== 2.Рекорды ===== \n ===== 3.Выход =====");
        if (scan.hasNextInt()) {
            int favor = scan.nextInt();
            switch (favor) {
                case 1:
                    return favor;
                case 2:
                    return favor;
                case 3:
                    System.exit(0);
                default:
                System.out.println("Вы выбрали не существующий вариант");
                choose();
                break;
            }
        }  else {
            System.out.println("Вы ввели не цифру");
            choose();
        }
        return choose;
    }

    public void refresh(){
        turn = 1;
        enemy.setHealth1(110);
        enemy.setAttack(5);
        mage.setHealth1(30);
        mage.setCd(0);
        archer.setHealth1(40);
        archer.setCd(0);
        archer.setSkillActive(0);
        warrior.setCd(5);
        warrior.setHealth1(60);
        warrior.setCd(0);
    }

    public int restart() {
        System.out.println("=== 1. Начать заново === \n === 2. Выход ===");
        int check = scan.nextInt();
        return check;
    }
}