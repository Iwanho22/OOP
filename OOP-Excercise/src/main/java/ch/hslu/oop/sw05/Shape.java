package ch.hslu.oop.sw05;

public abstract class Shape {
    private int x;
    private int y;

    public Shape(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public void move(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public abstract double getPerimeter();
    public abstract double getArea();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
