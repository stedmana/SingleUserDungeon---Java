package gameComponents;

import java.util.ArrayList;

public class Player extends Character {
    private Tile currentLocation;

    public Player(String name, String bio, int age, Double height, Double weight, ArrayList<Item> itemList, Tile currentLocation) {
        super(name, bio, age, height, weight, itemList);
        this.currentLocation = currentLocation;
    }

    public Tile getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Tile currentLocation) {
        this.currentLocation = currentLocation;
    }
}
