package gameComponents;

public class Slope {

    /**
     * Angle of the slope in degrees
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

    public boolean equals(Slope s) {
        return (this.angle.equals(s.angle) &&
                this.upperSide.equals(s.upperSide) &&
                this.lowerSide.equals(s.lowerSide)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Slope)) return false;

        Slope slope = (Slope) o;

        if (!getAngle().equals(slope.getAngle())) return false;
        if (getUpperSide() != slope.getUpperSide()) return false;
        return getLowerSide() == slope.getLowerSide();
    }

    @Override
    public int hashCode() {
        int result = getAngle().hashCode();
        result = 31 * result + getUpperSide().hashCode();
        result = 31 * result + getLowerSide().hashCode();
        return result;
    }
}
