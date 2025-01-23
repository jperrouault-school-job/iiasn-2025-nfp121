package thread;

public class Point {
    private int x;
    private int y;

    public void translate(int xx, int yy) {
        this.x += xx;
        this.y += yy;
    }

    @Override
    public String toString() {
        return "[x = " + this.x + ", y = " + this.y + "]";
    }
}
