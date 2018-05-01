package gameComponents;

import java.util.ArrayList;

public class Player extends Character {
    private Tile currentLocation;

    public Player(String name, String bio, int age, Double height, Double weight, ArrayList<Item> itemList, Tile currentLocation) {
        super(name, bio, age, height, weight, itemList);
        this.currentLocation = currentLocation;
    }
    public Player(String name, String bio, int age, Double height, Double weight, ArrayList<Item> itemList) {
        this(name,bio,age,height,weight,itemList,null);
    }
    public Player(String name,String bio, int age, Double height, Double weight) {
        this(name,bio,age,height,weight,new ArrayList<Item>(),null);
    }
    public Player(String name, String bio, int age, Double height, Double weight, World1 world) {
        this(name,bio,age,height,weight,new ArrayList<>(), world.getFirstMap().getKeyTile("root"));
    }

    public Tile getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Tile currentLocation) {
        this.currentLocation = currentLocation;
    }
}
