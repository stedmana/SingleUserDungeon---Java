package gameComponents;

import java.util.ArrayList;
import java.util.HashMap;

public class Map {
    private String name;
    private Tile root;
    private HashMap<Coordinate,Tile> tileMap;
    private HashMap<String,Tile> keyTiles;

    public Map(Tile root) {
        this(root,"default");
    }

    public Map(Tile root, String mapName) {
        this.name = mapName;
        this.root = root;
        this.tileMap = new HashMap<>();
        Coordinate tempRoot = new Coordinate(0,0);
        this.tileMap.put(tempRoot, this.root);
        this.root.setCoordinate(tempRoot);
        this.keyTiles = new HashMap<>();
        this.keyTiles.put("root",this.root);
    }

    public void addTile(Tile toAdd, Coordinate addLocation) {
        toAdd.setCoordinate(addLocation);
        this.tileMap.put(addLocation,toAdd);
    }

    public void addKeyTile(Tile toAdd, Coordinate addLocation, String keyTileString) {
        addTile(toAdd,addLocation);
        this.keyTiles.put(keyTileString,toAdd);
    }

    /**
     * This method gets a map of the tiles surrounding the input tile
     * @param currentTile the tile which you would like to find the surrounding tile of (set coordinate of tile before)
     * @return returns a hashmap of the tiles which are surrounding the current tile
     */
    public HashMap<Direction,Tile> getSurrounding(Tile currentTile) {
        HashMap<Direction,Tile> toReturn = new HashMap<>();
        Coordinate mainCoord = currentTile.getCoordinate();

        //Adding tile to north if it exists
        Tile workingTile = this.tileMap.get(new Coordinate(mainCoord.getX(),mainCoord.getY()+1));
        if (workingTile != null) {
            toReturn.put(Direction.NORTH,workingTile);
            workingTile = null;
        }

        //Adding tile to east if it exists
        workingTile = this.tileMap.get(new Coordinate(mainCoord.getX()+1,mainCoord.getY()));
        if (workingTile != null) {
            toReturn.put(Direction.EAST,workingTile);
            workingTile = null;
        }

        //Adding tile to South if E
        workingTile = this.tileMap.get(new Coordinate(mainCoord.getX(),mainCoord.getY()-1));
        if (workingTile != null) {
            toReturn.put(Direction.SOUTH, workingTile);
            workingTile = null;
        }

        //Adding tile to West if E
        workingTile = this.tileMap.get(new Coordinate(mainCoord.getX()-1,mainCoord.getY()));
        if (workingTile != null) {
            toReturn.put(Direction.WEST, workingTile);

        }


        return toReturn;
    }

    /*
     * updates the north south east and west references in the current tile according to tilemap
     * @param input
     */
//    public void updateSurrounding(Tile input) {
//
//
//        Coordinate mainCoord = input.getCoordinate();
//
//        //Update tile to north if it exists
//        Tile workingTile = this.tileMap.get(new Coordinate(mainCoord.getX(),mainCoord.getY()+1));
//        if (workingTile != null) {
//            input.setNorth(workingTile);
//            workingTile = null;
//        }
//
//        //Adding tile to east if it exists
//        workingTile = this.tileMap.get(new Coordinate(mainCoord.getX()+1,mainCoord.getY()));
//        if (workingTile != null) {
//            input.setEast(workingTile);
//            workingTile = null;
//        }
//
//        //Adding tile to South if E
//        workingTile = this.tileMap.get(new Coordinate(mainCoord.getX(),mainCoord.getY()-1));
//        if (workingTile != null) {
//            input.setSouth(workingTile);
//            workingTile = null;
//        }
//
//        //Adding tile to West if E
//        workingTile = this.tileMap.get(new Coordinate(mainCoord.getX()-1,mainCoord.getY()));
//        if (workingTile != null) {
//            input.setWest(workingTile);
//        }
//    }

    /*
     * updates the surrounding tiles, so their references point to the new tile
     * @param input
     */
//    public void addTileToSurrounding(Tile input) {
//
//
//        Coordinate mainCoord = input.getCoordinate();
//
//        //Update the slot south property of the tile to the north
//        Tile workingTile = this.tileMap.get(new Coordinate(mainCoord.getX(),mainCoord.getY()+1));
//        if (workingTile != null) {
//            workingTile.setSouth(input);
//            workingTile = null;
//        }
//
//        //update the west property of the tile to the east
//        workingTile = this.tileMap.get(new Coordinate(mainCoord.getX()+1,mainCoord.getY()));
//        if (workingTile != null) {
//            workingTile.setWest(input);
//            workingTile = null;
//        }
//
//        //update the north property of the tile to the south
//        workingTile = this.tileMap.get(new Coordinate(mainCoord.getX(),mainCoord.getY()-1));
//        if (workingTile != null) {
//            workingTile.setNorth(input);
//            workingTile = null;
//        }
//
//        //update the east property of tile to the west
//        workingTile = this.tileMap.get(new Coordinate(mainCoord.getX()-1,mainCoord.getY()));
//        if (workingTile != null) {
//            workingTile.setEast(input);
//            input.setWest(workingTile);
//        }
//    }

    public Tile getKeyTile(String keyString) {
        return this.keyTiles.get(keyString);
    }

    public HashMap<Coordinate, Tile> getTileMap() {
        return tileMap;
    }
}

