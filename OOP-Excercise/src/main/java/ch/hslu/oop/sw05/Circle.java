package ch.hslu.oop.sw05;

public class Circle extends Shape {
    private int diameter;

    public Circle(int x, int y, int diameter) {
        super(x, y);
        this.diameter = diameter;
    }

    @Override
    public double getPerimeter() {
        return diameter * Math.PI;
    }

    @Override
    public double getArea() {
        return Math.pow(diameter / 2d, 2) * Math.PI;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getDiameter() {
        return diameter;
    }
}
