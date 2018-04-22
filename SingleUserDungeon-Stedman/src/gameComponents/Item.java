package gameComponents;

/**
 * outline of properties that an item will have
 */
public abstract class Item {
    private String name;
    private int exp;
    private int ID;

    public Item(String name, int exp, int ID) {
        this.name = name;
        this.exp = exp;
        this.ID = ID;
    }
}
