package ch.hslu.oop.sw05;

public class Square extends Rectangle {
    public Square(int x, int y, int sideLength) {
        super(x, y, sideLength, sideLength);
    }

    public int getSideLength() {
        return getWidth();
    }
}
