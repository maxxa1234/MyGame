package com.company;

import java.util.Random;

public class Enemy extends Hero{
    Random rand = new Random();

    private String name = "Гартарейн";
    int health = 120;
    int attack = 5;
    int skillActive;
    int cd;
    String skillName = "Драконья удача";

    public int skill(){
        int random = rand.nextInt(2);
        if (cd > 0) {
            System.out.println("Способность на перезарядке.");
            skillActive -= 1;
            cd -= 1;
        } else {
            if (random == 0) {
                System.out.println("Удача подвела. - 10хп");
                health -= 10;
            } else {
                System.out.println(getName() + " использовал " + getSkillName() + "!");
                skillActive = 3;
                cd = 3;
            }
        }
        return random;
    }

    public int damage(){
        if (skillActive > 0){
            skillActive-=1;
            cd -= 1;
            attack += 2;
            System.out.println(getName() + " нанес вам " + (getAttack()*2) +" урона!");
            return attack * 2;
        }
        attack += 2;
        System.out.println(getName() + " нанес вам " + getAttack()+ " урона!");
        cd -= 1;
        skillActive-=1;
        return attack;
    }

    public void heal(){
        if (skillActive > 0){
            skillActive-=1;
            cd -= 1;
            System.out.println(getName() + " исцелил 8 хп");
            health += 8;
        }else {
            System.out.println(getName() + " исцелил 4 хп");
            health += 4;
            cd -= 1;
            skillActive -= 1;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health =this.health - health;
    }
    public void setHealth1(int health) {
        this.health = health;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
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

    @Override
    public String getSkillName() {
        return skillName;
    }
}
