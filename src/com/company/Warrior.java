package com.company;

public class Warrior extends Hero{

    private String name = null;
    int cd = 0;
    int health = 60;
    int attack = 5;
    int heal = 10;
    String skillName = "Глухая оборона";

    public int skill(){
        int healthPoint = 0;
        if (cd > 0){
            System.out.println("Способность на перезарядке.");
            cd -= 1;
        } else {
            System.out.println("Вы использовали "+getSkillName()+"!");
            health +=15;
            cd = 3;
        }
        return healthPoint;
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

    public int getCd() {
        return cd;
    }

    public void setCd(int cd) {
        this.cd = cd;
    }

    public int damage(){
        System.out.println("Вы нанесли " + getAttack()+" урона!");
        cd -= 1;
        return attack;
    }

    public void heal(){
        cd -= 1;
        if (health >= 60){
            System.out.println("Исцеление невозможно, у вас полное здоровье.");
        } else{
            if(health > (60 - heal)  && health < 60){
                health = 60;
                System.out.println("Вы исцелились на 10 поинта!");
            } else {
                System.out.println("Вы исцелились на 10 поинта!");
                health += heal;
            }
        }
    }
}
