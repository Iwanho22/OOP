package ch.hslu.oop.sw03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {
    @Test
    void max_withFirstValueGrater() {
        // arrange
        int a = 3;
        int b = 2;

        // act
        int res = NumberComparator.max(a, b);

        // assert
        assertEquals(res, a);
    }

    @Test
    void max_withSecondValueGrater() {
        // arrange
        int a = 2;
        int b = 3;

        // act
        int res = NumberComparator.max(a, b);

        // assert
        assertEquals(res, b);
    }
}