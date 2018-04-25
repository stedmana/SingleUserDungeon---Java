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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }
}
