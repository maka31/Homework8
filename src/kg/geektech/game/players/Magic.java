package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Magic extends Hero{

    public Magic(int health, int damage) {
        super(health, damage, AbilityType.BOOST);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int boostPoint = RPG_Game.random.nextInt(3) + 2;
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth() > 0 && heroes[i].getDamage() > 0){
            heroes[i].setDamage(heroes[i].getDamage() + boostPoint);
            }
        }
        System.out.println("Magic adds BOOST POINT + " + boostPoint);
    }
}
