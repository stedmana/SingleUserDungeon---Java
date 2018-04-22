package gameComponents;

import java.util.ArrayList;

/**
 *  This class contains general traits used by all characters
 */
public abstract class Character {
    /**
     * Characters name
     */
    private String name;
    /**
     *small writeup about character
     */
    private String bio;
    /**
     * age of character in years
     */
    private int age;
    /**
     * height stored in centimeters
     */
    private Double height;
    /**
     * weight stored in kilograms
     */
    private Double weight;
    /**
     * list of characters items
     */
    private ArrayList<Item> itemList;

    public Character(String name, String bio, int age, Double height, Double weight, ArrayList<Item> itemList) {
        this.name = name;
        this.bio = bio;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.itemList = itemList;
    }
}
