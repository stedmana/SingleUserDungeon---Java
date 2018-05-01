package mainGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import gameComponents.*;

public class MainGame {
    private ArrayList<String> commandList;
    private HashMap<String,String> commandInfoList;

    public static void main(String[] args) {
        World1 firstTry = new World1();
        println("Do you want to create your own player? Y/N");
        Scanner scan = new Scanner(System.in);
        String genPlayer = scan.next();
        Player myPlayer;
        if (genPlayer.equals("Y") || genPlayer.equals("y")) {
            myPlayer = generatePlayer(firstTry.getFirstMap().getRoot(),new ArrayList<>());
        } else {
            myPlayer = generateRandomPlayer();
            myPlayer.setCurrentLocation(firstTry.getFirstMap().getRoot());
        }

        playGame(firstTry,myPlayer);

    }

    /**
     * Generates a player based on user inputs
     * @param startingTile
     * @param itemListIn
     * @return
     */
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

    private static Player generateRandomPlayer() {
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("Jeff");
        nameList.add("Leeroy");
        nameList.add("Dan");
        nameList.add("Phillip");
        nameList.add("Thor");
        nameList.add("Loki");

        nameList.add("Jennifer");
        nameList.add("Paige");
        nameList.add("Lisa");
        nameList.add("Blair");
        nameList.add("Pamela");
        nameList.add("Marion");

        String name = nameList.get(ThreadLocalRandom.current().nextInt(0,nameList.size()));

        ArrayList<String> bioList = new ArrayList<>();
        bioList.add("Stronger than steel, hotter than jetfuel.");
        bioList.add("The strongest Avenger");
        bioList.add("Meaner than a really mean person, but smells kinda good");
        bioList.add("Tasty and Tenacious");
        String bio = bioList.get(ThreadLocalRandom.current().nextInt(0,bioList.size()));

        int age = ThreadLocalRandom.current().nextInt(5,99);

        Double height = ThreadLocalRandom.current().nextDouble(100.0,250.0);

        Double weight = ThreadLocalRandom.current().nextDouble(25.0, 200.0);



        return new Player(name,bio,age,height,weight);
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
        boolean loopControl = true;
        while (loopControl) {
            //Code the repeatedly runs to run game occurs

            String scannedString = "";
            while (scannedString.equals("")) {
                scannedString = getValueFromUser("Enter a command", "enter a valid command",".*");
            }

            switch (scannedString) {
                case "info": printTileInfo(playerIn.getCurrentLocation()); break;
                case "exit":
                case "et":
                case "stop": loopControl = false; break;
                case "start":
                    playerIn.setCurrentLocation(worldIn.getFirstMap().getKeyTile("root"));
                    break;
                case "help":
                    System.out.println(commandList(NameOrInfo.NAME));
                    break;
                case "moreHelp":
                    System.out.println(commandList(NameOrInfo.INFO));
                    break;
                case "playerInfo":
                    System.out.println("Player name is: " + playerIn.getName());
                    System.out.println("Player Bio is: " + playerIn.getBio());
                    System.out.println("Player age is: "+ playerIn.getAge() + " years");
                    System.out.println("Player height is: " + playerIn.getHeight() + " cm");
                    System.out.println("Player weight is: " + playerIn.getWeight() + " kg");
                    break;
                case "n":
                case "north":
                    if (movePlayer(Direction.NORTH, playerIn, worldIn)) {
                        System.out.println("You have moved one tile north.");
                    } else {
                        System.out.println("Location invalid, please look somewhere else");
                    }
                    break;
                case "e":
                case "east":
                    if (movePlayer(Direction.EAST,playerIn,worldIn)) {
                        System.out.println("You moved one tile east.");
                    } else {
                        System.out.println("Location invalid, please look somewhere else");
                    }
                    break;
                case "s":
                case "south":
                    if (movePlayer(Direction.SOUTH,playerIn,worldIn)) {
                        System.out.println("You moved one tile south.");
                    } else {
                        System.out.println("Location invalid, please look somewhere else");
                    }
                    break;
                case "w":
                case "west":
                    if (movePlayer(Direction.WEST,playerIn,worldIn)) {
                        System.out.println("You moved one tile west.");
                    } else {
                        System.out.println("Location invalid, please look somewhere else");
                    }
                    break;
                default: System.out.println("Enter a valid command..."); break;
            }
        }
    }

    /**
     * Creates the list of commands using to print
     */
    private static String commandList(NameOrInfo option) {
        ArrayList<String> stringList = new ArrayList<>();
        HashMap<String,String> infoMap = new HashMap<>();

        String command = "info";
        String commandWriteup = "Prints the information about the current tile.";
        addCommand(stringList,infoMap,command,commandWriteup);

        command = "help";
        commandWriteup = "Displays all of the commands available";
        addCommand(stringList,infoMap,command,commandWriteup);

        command = "moreHelp";
        commandWriteup = "Displays all commands available, with command info";
        addCommand(stringList,infoMap,command,commandWriteup);

        command = "stop";
        commandWriteup = "Stops the game.";
        addCommand(stringList,infoMap,command,commandWriteup);

        command = "start";
        commandWriteup = "Starts the game, placing the player at the root of the map.";
        addCommand(stringList,infoMap,command,commandWriteup);

        command = "north";
        commandWriteup = "Moves the player north one tile.";
        addCommand(stringList,infoMap,command,commandWriteup);

        command = "east";
        commandWriteup = "Move the player east one tile.";
        addCommand(stringList,infoMap,command,commandWriteup);

        command = "south";
        commandWriteup = "Move the player south one tile.";
        addCommand(stringList,infoMap,command,commandWriteup);

        command = "west";
        commandWriteup = "Move the player west one tile.";
        addCommand(stringList,infoMap,command,commandWriteup);


        switch (option) {
            case NAME:
                //String toPrint = "";
                StringBuilder toPrint = new StringBuilder();
                toPrint.append("List of commands: \n");
                for (String s:stringList) {
                    toPrint.append(s);
                    toPrint.append(", ");
                }
                toPrint.deleteCharAt(toPrint.lastIndexOf(" "));
                toPrint.deleteCharAt(toPrint.lastIndexOf(","));
                return toPrint.toString();
            case INFO:
                StringBuilder infoPrint = new StringBuilder();
                infoPrint.append("List of commands with info: \n");
                for (String s:stringList) {
                    infoPrint.append(s);
                    infoPrint.append(": ");
                    infoPrint.append(infoMap.get(s));
                    infoPrint.append("\n");
                }
                return infoPrint.toString();
        }
        return "";

    }

    /**
     * Used to control if the method commandList(option) returns just the name, or the name with its info
     */
    enum NameOrInfo {
        NAME, INFO
    }


    private static void addCommand(ArrayList<String> commandList, HashMap<String,String> commandInfoList, String command, String commandInfo) {
        commandList.add(command);
        commandInfoList.put(command,commandInfo);
    }

    //TODO: fix code to move player
    /**
     * moves the player to the new location if valid, if player removed it returns true, else false
     * @param dirIn the direction the player wants to move in
     * @param toMove the player which will be moved
     * @param worldIn the world the player is in and will get moved within
     * @return true if the player has been moved
     */
    private static boolean movePlayer(Direction dirIn, Player toMove, World1 worldIn) {
        boolean toReturn = false;
        Map myMap = worldIn.getFirstMap();
        HashMap<String,Tile> keyMap = myMap.getTileMap();
        Coordinate currentCoords = toMove.getCurrentLocation().getCoordinate();
        switch (dirIn) {
            case NORTH:
                Coordinate northCoord = new Coordinate(currentCoords.getX(),currentCoords.getY()+1);
                toReturn = isValidMove(keyMap,northCoord);
                if (toReturn) toMove.setCurrentLocation(keyMap.get(northCoord.toString()));
                break;
            case EAST:
                Coordinate eastCoord = new Coordinate(currentCoords.getX()+1,currentCoords.getY());
                toReturn = isValidMove(keyMap,eastCoord);
                if (toReturn) toMove.setCurrentLocation(keyMap.get(eastCoord.toString()));
                break;
            case SOUTH:
                Coordinate southCoord = new Coordinate(currentCoords.getX(),currentCoords.getY()-1);
                toReturn = isValidMove(keyMap,southCoord);
                if (toReturn) toMove.setCurrentLocation(keyMap.get(southCoord.toString()));
                break;
            case WEST:
                Coordinate westCoord = new Coordinate(currentCoords.getX()-1,currentCoords.getY());
                toReturn = isValidMove(keyMap,westCoord);
                if (toReturn) toMove.setCurrentLocation(keyMap.get(westCoord.toString()));
                break;
        }
        return toReturn;
    }

    /**
     * Checks if a move is valid, returns true if it is
     * Essentially checks if the tile exists, or if it is a wall at this point
     * @param tileHashMap the map in which the coordinate is checked
     * @param newLocation the new loaction which the player wants to move to
     * @return true if the move is valid
     */
    private static boolean isValidMove(HashMap<String,Tile> tileHashMap, Coordinate newLocation) {
        Tile moveTo = tileHashMap.get(newLocation.toString());
        if (moveTo == null) return false;
        else if (moveTo.getTerrainInfo().getType() == TerrainInfo.TerrainType.WALL) return false;

        return true;
    }


    /**
     * Prints information on the input tile
     * @param workingTile the tile which one wants to print information about
     */
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
                    toPrint = toPrint + "There is a ladder here that appears to be on ground ";
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

    private static void println(String in) {
        System.out.println(in);
    }
}
