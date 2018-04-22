package gameComponents;

import java.util.Objects;

public class Coordinate {
    /**
     * positive x is east
     * negative x is west
     */
    private int x;
    /**
     * positive y is north
     * negative y is south
     */
    private int y;

    /**
     * Create a new coordinate
     * @param x +e -w
     * @param y +n -s
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Coordinate c) {
        return (this.x == c.x && this.y == c.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
