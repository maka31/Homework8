package kg.geektech.game.players;

public class Boss extends GameEntity {
    int getBackDamage; // damage, который возращается после пропуска раунда в следствие оглушения его Тором

    public Boss(int health, int damage,int getBackDamage) {
        super(health, damage);
        this.getBackDamage = getBackDamage;
    }

    public int getGetBackDamage() {
        return getBackDamage;
    }
}
