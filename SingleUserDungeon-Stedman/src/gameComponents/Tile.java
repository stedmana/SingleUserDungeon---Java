package gameComponents;

/**
 * The tile component that will be used to build the map
 */
public class Tile {
    private Tile north;
    private Tile east;
    private Tile south;
    private Tile west;
    private Tile up;
    private Tile down;
    private TerrainInfo terrainInfo;
    private Coordinate coordinate;

    public Tile(Tile north, Tile east, Tile south, Tile west, Tile up, Tile down, TerrainInfo terrainInfo, Coordinate coordinate) {
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
        this.up = up;
        this.down = down;
        this.terrainInfo = terrainInfo;
        this.coordinate = coordinate;
    }

    public Tile(Tile north, Tile east, Tile south, Tile west, TerrainInfo terrainInfo) {
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
        this.terrainInfo = terrainInfo;
        this.up = null;
        this.down = null;
    }
    public Tile(TerrainInfo terrainInfo) {
        this.north = null;
        this.east = null;
        this.south = null;
        this.west = null;
        this.up = null;
        this.down = null;
        this.terrainInfo = terrainInfo;
    }


    public Tile getNorth() {
        return north;
    }

    public Tile getEast() {
        return east;
    }

    public Tile getSouth() {
        return south;
    }

    public Tile getWest() {
        return west;
    }

    public Tile getUp() {
        return up;
    }

    public Tile getDown() {
        return down;
    }

    public TerrainInfo getTerrainInfo() {
        return terrainInfo;
    }

    public void setNorth(Tile north) {
        this.north = north;
    }

    public void setEast(Tile east) {
        this.east = east;
    }

    public void setSouth(Tile south) {
        this.south = south;
    }

    public void setWest(Tile west) {
        this.west = west;
    }

    public void setUp(Tile up) {
        this.up = up;
    }

    public void setDown(Tile down) {
        this.down = down;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}

/**
 * This class contains the information on the terrain of the Tile
 */
class TerrainInfo {
    private TerrainMaterial material;
    private TerrainType type;
    private boolean isPassable;
    private Slope terrainSlope;

    public TerrainInfo(TerrainMaterial material, TerrainType type, boolean isPassable, Slope terrainSlope) {
        this.material = material;
        this.type = type;
        this.isPassable = isPassable;
        this.terrainSlope = terrainSlope;
    }

    public TerrainInfo(TerrainMaterial material) {
        this.material = material;
        this.type = TerrainType.FLAT;
        this.isPassable = true;
        this.terrainSlope = new Slope();

    }
    public TerrainInfo(TerrainMaterial material, boolean isPassable) {
        this.material = material;
        this.isPassable = isPassable;
        this.type = TerrainType.WALL;
        if (this.isPassable) {
            this.type = TerrainType.FLAT;
        }
        this.terrainSlope = new Slope();
    }

    public TerrainMaterial getMaterial() {
        return material;
    }

    public TerrainType getType() {
        return type;
    }

    public boolean isPassable() {
        return isPassable;
    }

    public Slope getTerrainSlope() {
        return terrainSlope;
    }

    /**
     * Enumeration representing the material of the terrain
     */
    public enum TerrainMaterial {
        GRASS, DIRT, ROCKY, CONCRETE, WOOD, SLATE
    }

    /**
     * Enumeration representing the type of the terrain
     */
    public enum TerrainType {
        FLAT, JAGGED, STAIRS, LADDER, WALL
    }

}

/**
 * The class used to store the slope of the current tile
 */
class Slope {
    /**
     * Angle of the slope
     */
    private Double angle;
    /**
     * Upper side of slope (aka the side of the tile with highest elevation)
     */
    private Direction upperSide;
    /**
     * The side of the tile which has the lower elevation
     */
    private Direction lowerSide;

    /**
     * Default constructor for Slope, need to input all parameters
     * @param angle
     * @param upperSide
     * @param lowerSide
     */
    public Slope(Double angle, Direction upperSide, Direction lowerSide) {
        this.angle = angle;
        this.upperSide = upperSide;
        this.lowerSide = lowerSide;
    }

    /**
     * The constructor which will be used if the tile does not have any slope. sets angle to 0 and upper and lower sides to null.
     */
    public Slope() {
        this.angle = 0.0;
        this.upperSide = null;
        this.lowerSide = null;
    }

    public Double getAngle() {
        return angle;
    }

    public Direction getUpperSide() {
        return upperSide;
    }

    public Direction getLowerSide() {
        return lowerSide;
    }
}
