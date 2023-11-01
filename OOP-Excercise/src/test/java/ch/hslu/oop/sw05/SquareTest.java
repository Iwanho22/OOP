package ch.hslu.oop.sw05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void testGetPerimeter() {
        // arrange
        var square = new Square(1,2, 4);

        // act
        var perimeter = square.getPerimeter();

        // assert
        assertEquals(16, perimeter);
    }

    @Test
    void testGetArea() {
        // arrange
        var square = new Square(1,2, 4);

        // act
        var area = square.getArea();

        // assert
        assertEquals(16, area);
    }
}