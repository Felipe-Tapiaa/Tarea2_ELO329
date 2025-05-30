public class GPSPosition {
    public int t;
    public double x, y;

    public GPSPosition(int t, double x, double y) {
        this.t = t;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return t + " " + x + " " + y;
    }
}
