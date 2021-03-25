package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Berserk extends Hero {

    public Berserk(int health, int damage) {
        super(health, damage, AbilityType.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int revertDamage = boss.getDamage() / 5 + getDamage();
        if (!RPG_Game.isBossStunned) {
            boss.setHealth(boss.getHealth() - boss.getDamage() / 5); // damage(15) отнимается по умолчанию в любом случае, поэтому здесь отнимаю только часть урона
            System.out.println("Berserk SAVES DAMAGE and REVERTS " + revertDamage);
        }
    }
}
