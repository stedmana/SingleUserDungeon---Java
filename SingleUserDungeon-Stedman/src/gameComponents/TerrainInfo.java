package gameComponents;

/**
 * This class contains the information on the terrain of the Tile
 */
public class TerrainInfo {
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
