package ch.hslu.oop.sw03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {
    @Test
    void max_twoParams_withFirstValueGrater() {
        // arrange
        int a = 3;
        int b = 2;

        // act
        int res = NumberComparator.max(a, b);

        // assert
        assertEquals(a, res);
    }

    @Test
    void max_twoParams_withSecondValueGrater() {
        // arrange
        int a = 2;
        int b = 3;

        // act
        int res = NumberComparator.max(a, b);

        // assert
        assertEquals(b, res);
    }

    @Test
    void max_threeParams_withFirstValueGrater() {
        // arrange
        int a = 3;
        int b = 2;
        int c = 1;

        // act
        int res = NumberComparator.max(a, b, c);

        // assert
        assertEquals(a, res);
    }

    @Test
    void max_threeParams_withSecondValueGrater() {
        // arrange
        int a = 2;
        int b = 3;
        int c = 1;

        // act
        int res = NumberComparator.max(a, b, c);

        // assert
        assertEquals(b, res);
    }

    @Test
    void max_threeParams_withThirdValueGrater() {
        // arrange
        int a = 1;
        int b = 2;
        int c = 3;

        // act
        int res = NumberComparator.max(a, b, c);

        // assert
        assertEquals(res, c);
    }
}