package com.company;

import java.util.Random;

public class Hero {
    Random rand = new Random();
    private String name;
    int health;
    int attack;
    int cd;
    int skillActive;
    int heal;
    String skillName;

    public int skill(){
        return attack;
    }

    public int damage(){
     return attack;
    }

    public void heal(){

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
        this.health = health;
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

    public String getSkillName() {
        return skillName;
    }

    public int getSkillActive() {
        return skillActive;
    }

    public void setSkillActive(int skillActive) {
        this.skillActive = skillActive;
    }

    public int getCd() {
        return cd;
    }

    public void setCd(int cd) {
        this.cd = cd;
    }
}
