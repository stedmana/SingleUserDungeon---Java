package gameComponents;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class World1 {
    private ArrayList<Map> listOfMaps;
    public World1() {
        Map spawnRoom = BuildSpawnRoom();
        this.listOfMaps = new ArrayList<>();
        this.listOfMaps.add(spawnRoom);

    }

    public ArrayList<Map> getListOfMaps() {
        return listOfMaps;
    }

    private Map BuildSpawnRoom() {
        return buildRandomSquareRoom(100);
    }

    private Map buildRandomSquareRoom(int n) {
        Map toReturn = new Map(generateRandomTile());
        for (int i = -n; i <= n; i++) {
            for (int j = -n; j <= n; j++) {
                toReturn.addTile(generateRandomTile(), new Coordinate(i,j));
            }
        }
        return toReturn;

    }

    private Tile generateRandomTile() {
        Tile toReturn = null;
        TerrainInfo randomInfo = generateRandomTerrainInfo();
        toReturn = new Tile(randomInfo);
        return toReturn;

    }

    /**
     * This method randomly generates terraininfo for the random generation of the tiles
     * @return The randomly generated TerrainInfo
     */
    private TerrainInfo generateRandomTerrainInfo() {
        //The sections of code below are used to randomly choose materials

        //This is the Random generation of the terrain material
        int random = generateRandom(1,6);
        TerrainInfo.TerrainMaterial terrainMatIn;
        switch (random) {

            case 1: terrainMatIn = TerrainInfo.TerrainMaterial.GRASS; break;
            case 2: terrainMatIn = TerrainInfo.TerrainMaterial.DIRT;break;
            case 3: terrainMatIn = TerrainInfo.TerrainMaterial.ROCKY;break;
            case 4: terrainMatIn = TerrainInfo.TerrainMaterial.CONCRETE;break;
            case 5: terrainMatIn = TerrainInfo.TerrainMaterial.WOOD;break;
            case 6: terrainMatIn = TerrainInfo.TerrainMaterial.SLATE;break;
            default: terrainMatIn = TerrainInfo.TerrainMaterial.GRASS; break;

        }
        //this is the generation of the the Terrain type
        random = generateRandom(1,5);
        TerrainInfo.TerrainType terrainTypeIn;
        switch (random) {

            case 1: terrainTypeIn = TerrainInfo.TerrainType.FLAT;break;
            case 2: terrainTypeIn = TerrainInfo.TerrainType.JAGGED;break;
            case 3: terrainTypeIn = TerrainInfo.TerrainType.STAIRS;break;
            case 4: terrainTypeIn = TerrainInfo.TerrainType.LADDER;break;
            case 5: terrainTypeIn = TerrainInfo.TerrainType.WALL;break;
            default: terrainTypeIn = TerrainInfo.TerrainType.FLAT;break;

        }

        //This decides if the tile will be passable based on if it is a wall
        boolean passable = true;
        if (terrainTypeIn.equals(TerrainInfo.TerrainType.WALL)) {
            passable = false;
        }
        Slope retrunSlope = generateRandomSlope();
        return new TerrainInfo(terrainMatIn,terrainTypeIn,passable,retrunSlope);

    }

    private Slope generateRandomSlope() {
        double randomSlopeDegree = Math.random()*45;
        int randomUp = generateRandom(1,4);
        Direction upper;
        switch (randomUp) {
            case 1: upper = Direction.NORTH;
            case 2: upper = Direction.EAST;
            case 3: upper = Direction.SOUTH;
            case 4: upper = Direction.WEST;
            default: upper = Direction.NORTH;
        }

        int randomDown = generateRandom(1,4);
        if (randomDown == randomUp) {
            if (randomDown == 4) {
                randomDown--;
            }
            else if (randomDown == 1) {
                randomDown++;
            }
            else if (generateRandom(1,10) > 5) {
                randomDown++;
            }
            else {
                randomDown--;
            }
        }
        Direction lower;
        switch (randomDown) {
            case 1: lower = Direction.NORTH;
            case 2: lower = Direction.EAST;
            case 3: lower = Direction.SOUTH;
            case 4: lower = Direction.WEST;
            default: lower = Direction.SOUTH;
        }
        return new Slope(randomSlopeDegree,upper,lower);
    }

    /**
     * generates a random number, within inclusive range of min and max
     * @param min minimum value of random gen (inclusive)
     * @param max maximum value of random gen (inclusive)
     * @return
     */
    public int generateRandom(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1); //+1 cause the upper bound is exclusive
    }

    public Map getFirstMap() {
        return this.listOfMaps.get(0);
    }

}
