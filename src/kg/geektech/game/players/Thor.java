package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Thor extends Hero {

    public Thor(int health, int damage) {
        super(health, damage, AbilityType.STUN);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int random = RPG_Game.random.nextInt(2);
        if (random == 1) {
            RPG_Game.isBossStunned = true;
            boss.setDamage(0);

            System.out.println("Boss is STUNNED");
        } else {
            RPG_Game.isBossStunned = false;
            boss.setDamage(boss.getBackDamage);
        }
    }
}

