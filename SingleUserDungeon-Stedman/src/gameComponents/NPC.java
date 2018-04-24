package gameComponents;

import java.util.ArrayList;

/**
 * this is the Non-player character object that will be placed on tiles
 */
public class NPC extends Character {
    private ArrayList<String> reactionList;

    public NPC(String name, String bio, int age, Double height, Double weight, ArrayList<Item> itemList, ArrayList<String> reactionList) {
        super(name, bio, age, height, weight, itemList);
        this.reactionList = reactionList;
    }
}
