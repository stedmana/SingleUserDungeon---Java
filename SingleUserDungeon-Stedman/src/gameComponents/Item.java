package gameComponents;

/**
 * outline of properties that an item will have
 */
public abstract class Item {
    private String name;
    private double weight;
    private int exp;
    private int ID;


    public Item(String name, double weight, int exp, int ID) {
        this.name = name;
        this.weight = weight;
        this.exp = exp;
        this.ID = ID;
    }
    public Item(){
        //TODO: generate random item here
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
