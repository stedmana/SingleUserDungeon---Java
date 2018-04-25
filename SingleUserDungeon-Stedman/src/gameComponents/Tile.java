package gameComponents;
import java.util.ArrayList;
import java.util.Objects;

/**
 * The tile component that will be used to build the map
 */
public class Tile {
    private Tile up;
    private Tile down;
    private TerrainInfo terrainInfo;
    private Coordinate coordinate;
    private ArrayList<Item> itemList;

    public Tile(Tile up, Tile down, TerrainInfo terrainInfo, Coordinate coordinate) {

        this.up = up;
        this.down = down;
        this.terrainInfo = terrainInfo;
        this.coordinate = coordinate;
        this.itemList = new ArrayList<>();
    }

    public Tile(TerrainInfo terrainInfo) {
        this.up = null;
        this.down = null;
        this.terrainInfo = terrainInfo;
        this.itemList = new ArrayList<>();
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


    public boolean equals(Tile t) {
        return (this.terrainInfo.getMaterial().equals(t.terrainInfo.getMaterial()) &&
                this.terrainInfo.getType().equals(t.terrainInfo.getType()) &&
                this.terrainInfo.getTerrainSlope().equals(t.terrainInfo.getTerrainSlope())
        );
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUp(), getDown(), getTerrainInfo(), getCoordinate(), itemList);
    }
}
