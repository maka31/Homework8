package kg.geektech.game.players;

public class Witcher extends Hero {

    public Witcher(int health, int damage) {
        super(health, damage, AbilityType.REVIVE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() <= 0 && heroes[i] != this) {
                heroes[i].setHealth(heroes[i].getHealth() + getHealth());
                setHealth(0);
                break;
            }
        }
    }
}
