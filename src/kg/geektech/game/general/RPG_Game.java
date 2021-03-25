package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {

    public static Random random = new Random();

    public static boolean isBossStunned;

    public static void start() {
        Boss boss = new Boss(2500, 50, 50);
        Warrior warrior = new Warrior(270, 10);
        Thor thor = new Thor(200, 15);
        Berserk berserk = new Berserk(260, 15);
        Magic magic = new Magic(250, 20);
        Tank tank = new Tank(350, 5);
        Witcher witcher = new Witcher(400, 0);
        Medic doctor = new Medic(230, 10, 10);
        Medic assistant = new Medic(280, 5, 5);

        Hero[] heroes = {warrior, thor, berserk, magic, tank, witcher, doctor, assistant};

        System.out.println("     THE GAME IS ON     ");
        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
            bossHits(boss, heroes);
        }
        heroesHit(boss, heroes);
        heroesApplyAbilities(boss, heroes);
        printStatistics(boss, heroes);
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes WON!!!");
            return true;
        }

        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss WON!!!");
        }
        return allHeroesDead;
    }

    public static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("------------------------------------");
        System.out.println("Boss's health: " + boss.getHealth() + "[" + boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() + "'s health: " + heroes[i].getHealth() +
                    "[" + heroes[i].getDamage() + "]");
        }
        System.out.println("------------------------------------");
    }

    public static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    public static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0 && heroes[i].getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    public static void heroesApplyAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0 && heroes[i].getHealth() > 0) {
                heroes[i].applySuperAbility(boss, heroes);
            }
        }
    }
}

