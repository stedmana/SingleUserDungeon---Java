package gameComponents;

import java.util.ArrayList;
import java.util.HashMap;

public class Map {
    private Tile root;
    private HashMap<Coordinate,Tile> tileMap;
    private HashMap<String,Tile> keyTiles;

    public Map(Tile root) {
        this.root = root;
        this.tileMap = new HashMap<>();
        Coordinate tempRoot = new Coordinate(0,0);
        this.tileMap.put(tempRoot, this.root);
        this.root.setCoordinate(tempRoot);
        this.keyTiles = new HashMap<>();
        this.keyTiles.put("root",this.root);
    }

    public void addTile(Tile toAdd, Coordinate addLocation) {
        //HashMap<Direction,Tile> surrounding = getSurrounding(toAdd)
        //TODO: Finish this method, and fix the get Surrounding method so that it uses the coordinate of the tile, and its not based on NESW
    }
    public HashMap<Direction,Tile> getSurrounding(Tile currentTile) {
        HashMap<Direction,Tile> toReturn = new HashMap<>();
        Coordinate mainCoord = currentTile.getCoordinate();
        Tile north = currentTile.getNorth();
        Tile east = currentTile.getEast();
        Tile west = currentTile.getWest();
        Tile south = currentTile.getSouth();
        if (north != null) toReturn.put(Direction.NORTH,north);
        if (east != null) toReturn.put(Direction.EAST,east);
        if (south != null) toReturn.put(Direction.SOUTH,south);
        if (west != null) toReturn.put(Direction.WEST,west);
        return toReturn;
    }


}

