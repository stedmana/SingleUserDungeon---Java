package gameComponents.Items;

import gameComponents.Item;

public class Weapon extends Item {
    private int damageDealt;

    public Weapon(String name, double weight, int exp, int ID, int damageDealt) {
        super(name, weight, exp, ID);
        this.damageDealt = damageDealt;
    }
}
