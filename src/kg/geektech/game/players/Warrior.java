package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Warrior extends Hero {

    public Warrior(int health, int damage) {
        super(health, damage, AbilityType.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int coeff = RPG_Game.random.nextInt(3) + 2;
        int criticDamage = getDamage() * coeff + getDamage();
        boss.setHealth(boss.getHealth() - getDamage() * coeff); // damage(10) отнимается по умолчанию поверх кристического в любом случае
        System.out.println("Warrior hits wth CRITICAL DAMAGE " + criticDamage);
    }
}
