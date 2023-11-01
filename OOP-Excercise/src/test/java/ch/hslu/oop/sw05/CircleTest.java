package ch.hslu.oop.sw05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void getPerimeter() {
        // arrange
        var circle = new Circle(1,2, 4);

        // act
        var perimeter = circle.getPerimeter();

        // assert
        assertEquals(12.56, perimeter, 0.2);
    }

    @Test
    void getArea() {
        // arrange
        var circle = new Circle(1,2, 4);

        // act
        var area = circle.getArea();

        // assert
        assertEquals(12.56, area, 0.2);
    }
}