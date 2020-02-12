package com.company;

public class Mage extends Hero{

    private String name = null;
    int health = 30;
    int attack = 7;
    int cd;
    int heal = 10;
    String skillName = "Метеорит";

    public int skill() {
        int random = rand.nextInt(5);
        int addDamage  = 0;
        if (cd > 0){
            if (random == 4){
                cd = 0;
                addDamage = 20;
                System.out.println("Способность обновилась.Вы использовали "+getSkillName()+"!");
                return addDamage;
            }else {
                System.out.println("Способность на перезарядке.");
                cd -= 1;
            }
        } else {
            System.out.println("Вы использовали "+getSkillName()+"!");
            cd = 3;
            if (random == 4){
                cd = 0;
                System.out.println("Способность "+skillName+" обновилась!");
            }
            addDamage = 20;
        }
        return addDamage;
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

    public int damage() {
        int random = rand.nextInt(5);
        if (random == 4){
            cd = 0;
            System.out.println("Способность "+skillName+" обновилась!");
        }
        System.out.println("Вы нанесли " + getAttack()+" урона!");
        cd-=1;
        return attack;
    }

    public void heal() {
        int random = rand.nextInt(5);
        if (random == 4){
            cd = 0;
            System.out.println("Способность "+skillName+" обновилась!");
        }
        cd-=1;
        if (health >= 30) {
            System.out.println("Исцеление невозможно, у вас полное здоровье.");
        } else {
            if(health > (30 - heal)  && health < 30){
                health = 30;
                System.out.println("Вы исцелились на 10 поинта!");
            } else {
                System.out.println("Вы исцелились на 10 поинта!");
                health += heal;
            }
        }
    }
}
