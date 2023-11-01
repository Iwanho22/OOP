package ch.hslu.oop.sw05;

public class Rectangle extends Shape {
    private int height;
    private int width;

    public Rectangle(int x, int y, int height, int width) {
        super(x, y);
        this.height = height;
        this.width = width;
    }

    public void changeDimension(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double getPerimeter() {
        return 2 * width + 2 * height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
