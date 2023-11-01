package ch.hslu.oop.sw05;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class RectangleTest {

    @Test
    void testGetPerimeter() {
        // arrange
        var rectangle = new Rectangle(1,2, 4, 3);

        // act
        var perimeter = rectangle.getPerimeter();

        // assert
        assertEquals(14, perimeter);
    }

    @Test
    void testGetArea() {
        // arrange
        var rectangle = new Rectangle(1,2, 4, 3);

        // act
        var area = rectangle.getArea();

        // assert
        assertEquals(12, area);
    }
}