package com.company;

import java.util.Random;

public class Archer extends Hero {
    Random rand = new Random();
    private String name = null;
    int health = 40;
    int attack = 5;
    int cd = 0;
    int skillActive = 0;
    int heal = 10;
    String skillName = "Зажигательная стрела";

    public int skill(){
        int simpleReturn = 2;
        if (cd > 0){
            System.out.println("Способность на перезарядке.");
            skillActive-=1;
            cd -= 1;
        } else {
            System.out.println("Вы использовали "+getSkillName()+"!");
            skillActive = 2;
            cd = 3;
        }
        return simpleReturn;
    }

    public String getSkillName() {
        return skillName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health =this.health - health;
    }
    public void setHealth1(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public int getSkillActive() {
        return skillActive;
    }

    @Override
    public void setSkillActive(int skillActive) {
        this.skillActive = skillActive;
    }

    public int getCd() {
        return cd;
    }

    public void setCd(int cd) {
        this.cd = cd;
    }

    public int damage() {
        int random = rand.nextInt(5);
        if (skillActive > 0){
            skillActive-=1;
            cd -= 1;
            if (random == 4){
                System.out.println("Критическое попадание,вы нанесли " + ((getAttack()+7)*2) +" урона!");
                return (attack + 7)*2;
            } else {
                System.out.println("Вы нанесли " + (getAttack() + 7) + " урона!");
                return attack + 7;
            }
        }
        cd -= 1;
        skillActive-=1;
        if (random == 4) {
            System.out.println("Критическое попадание,вы нанесли " + (getAttack()*2) + " урона!");
            return attack * 2;
        } else {
            System.out.println("Вы нанесли " + getAttack() + " урона!");
            return attack;
        }
    }

    public void heal() {
        skillActive-=1;
        cd -= 1;
        if (health >= 40) {
            System.out.println("Исцеление невозможно, у вас полное здоровье.");
        } else {
            if(health > (40 - heal) && health < 40) {
                health = 40;
                System.out.println("Вы исцелились на 10 поинта!");
            } else {
                System.out.println("Вы исцелились на 10 поинта!");
                health += 10;
            }
        }
    }
}
