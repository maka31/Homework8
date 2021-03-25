package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Tank extends Hero {

    public Tank(int health, int damage) {
        super(health, damage, AbilityType.RECEIVE_PART_OF_DAMAGE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int partOfDamage = boss.getDamage() / 5;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && heroes[i] != this && !RPG_Game.isBossStunned) {
                setHealth(getHealth() - partOfDamage);
                heroes[i].setHealth(heroes[i].getHealth() + partOfDamage);
            }
        }
        if (partOfDamage > 0) {
            System.out.println("Tank RECEIVES PART OF DAMAGE " + partOfDamage);
        }
    }
}
