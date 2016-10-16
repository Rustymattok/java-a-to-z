package game.models;

/**
 * Class describe parameters of point.
 */
public class Point {
    private int x;
    private int y;
    private Vision res;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, Vision res) {
        this.x = x;
        this.y = y;
        this.res = res;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Vision getRes() {
        return res;
    }

    public void setRes(Vision res) {
        this.res = res;
    }
}
