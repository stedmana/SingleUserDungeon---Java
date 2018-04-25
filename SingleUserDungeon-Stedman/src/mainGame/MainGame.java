package mainGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import gameComponents.*;

public class MainGame {
    public static void main(String[] args) {
        System.out.println("Hello world");
        HashMap<String,Integer> test = new HashMap<>();
        Integer t = test.get("he");
        System.out.println(t);


        World1 firstTry = new World1();
        Player myPlayer = generatePlayer(firstTry.getFirstMap().getKeyTile("root"),new ArrayList<Item>());
        playGame(firstTry,myPlayer);

    }
    private static Player generatePlayer(Tile startingTile, ArrayList<Item> itemListIn) {
        String playerName = "";
        while (playerName.equals("")) {
            playerName = getValueFromUser("Please input a name for your character", "Invalid Characters used. Please input a valid alphanumeric character", "[a-zA-Z0-9 ]*");
        }

        String playerBio = "";
        while (playerBio.equals("")) {
            playerBio = getValueFromUser("Please import a bio for your character", "Invalid input. Try again.", ".*");
        }

        int playerAge = -1;
        while (playerAge < 0) {
            playerAge = getNextIntFromUser("Enter your players age", "please enter a positive integer");
        }

        Double playerHeight = -1.0;
        while (playerHeight < 0.0) {
            playerHeight = (Double)getNextDoubleFromUser("Enter your height in cm", "Please enter a valid floating point number");
        }

        Double playerWeight = -1.0;
        while (playerWeight < 0.0) {
            playerWeight = (Double)getNextDoubleFromUser("Enter your weight in kg", "Please enter a valid floating point number");
        }

        return new Player(playerName,playerBio,playerAge,playerHeight,playerWeight, itemListIn, startingTile);

    }

    private static String getValueFromUser(String preMessage, String errorMessage, String regexPattern) {
        System.out.println(preMessage);
        String returnString = "";
        try {
            Scanner myScan = new Scanner(System.in);
            returnString = myScan.next(regexPattern);
        }
        catch (InputMismatchException e) {
            System.out.println(errorMessage);
            returnString = "";
        }
        return returnString;
    }

    private static int getNextIntFromUser(String preMessage, String errorMessage) {
        System.out.println(preMessage);
        int returnInt = 0;
        try {
            Scanner myScan = new Scanner(System.in);
            returnInt = myScan.nextInt();
        } catch (Exception e) {
            System.out.println(errorMessage);
        }

        return returnInt;
    }

    private static Double getNextDoubleFromUser(String preMessage, String errorMessage) {
        System.out.println(preMessage);
        Double returnDouble = 0.0;
        try {
            Scanner myScan = new Scanner(System.in);
            returnDouble = myScan.nextDouble();
        } catch (Exception e) {
            System.out.println(errorMessage);
        }

        return returnDouble;
    }

    private static void playGame(World1 worldIn, Player playerIn) {
        while (true) {
            //Code the repeatedly runs to run game occurs

            String scannedString = "";
            while (scannedString.equals("")) {
                scannedString = getValueFromUser("Enter a command", "enter a valid command",".*");
            }
            if (scannedString.equals("info")) {
                printTileInfo(playerIn.getCurrentLocation());
            }
            else if (scannedString.equals("stop")) break;
            else {
                System.out.println("Enter a command...");
            }
        }
    }
    private static void printTileInfo(Tile workingTile) {
        String toPrint = "";

        try {
            switch (workingTile.getTerrainInfo().getType()) {
                case FLAT:
                    toPrint = toPrint + "This flat ground appears to be ";
                    break;
                case JAGGED:
                    toPrint = toPrint + "This pointy ground appears to be ";
                    break;
                case STAIRS:
                    toPrint = toPrint + "These stairs appear to be ";
                    break;
                case LADDER:
                    toPrint = toPrint + "There is a ladder here that appears to on ground ";
                    break;
                case WALL:
                    toPrint = toPrint + "There is a Wall here, on ground ";
                    break;
                default:
                    toPrint = toPrint + "There is default here, on ground";
                    break;
            }
        } catch (Exception e) {
            System.out.println("error:" + e);
        }
        try {
            switch (workingTile.getTerrainInfo().getMaterial()) {
                case GRASS:
                    toPrint = toPrint + "made of grass";
                    break;
                case DIRT:
                    toPrint = toPrint + "made of dirt";
                    break;
                case WOOD:
                    toPrint = toPrint + "made of wood";
                    break;
                case ROCKY:
                    toPrint = toPrint + "made of rock";
                    break;
                case SLATE:
                    toPrint = toPrint + "made of slate";
                    break;
                case CONCRETE:
                    toPrint = toPrint + "made of concrete";
                    break;
                default:
                    toPrint = toPrint + "made of default";
                    break;
            }
        } catch (Exception e) {
            System.out.println("error:" + e);
        }
        if (workingTile.getTerrainInfo().getTerrainSlope().getAngle() > 40.0) {
            toPrint = toPrint + ", and it is quite steep";
        } else if (workingTile.getTerrainInfo().getTerrainSlope().getAngle() > 30.0) {
            toPrint = toPrint + ", and it is steep";
        } else if (workingTile.getTerrainInfo().getTerrainSlope().getAngle() > 15.0) {
            toPrint = toPrint + ", and it is slightly sloped";
        } else {
            toPrint = toPrint + ", and it is flat";
        }

        //TODO: add printing of item list, and up and down tile if they exist
        System.out.println(toPrint);
    }

}
