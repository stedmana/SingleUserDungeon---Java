package gameComponents;

/**
 * The tile component that will be used to build the map
 */
public class Tile {
    private Tile north;
    private Tile east;
    private Tile south;
    private Tile west;
    private TerrainInfo terrainInfo;

}

/**
 * This class contains the information on the terrain of the Tile
 */
class TerrainInfo {
    private TerrainType type;
    private boolean isPassable;
    private Slope terrainSlope;

    /**
     * Enumeration representing the material of the terrain
     */
    private enum TerrainType {
        GRASS, DIRT, ROCKY, CONCRETE, WOOD, SLATE
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
}
