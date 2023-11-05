package ch.hslu.oop.sw07;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonNameComparatorTest {
    private PersonNameComparator comparator;

    @BeforeEach
    public void setUp() {
        comparator = new PersonNameComparator();
    }

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(PersonNameComparator.class).suppress(Warning.STRICT_INHERITANCE).verify();
    }

    @Test
    public void testCompareTo_surname_first() {
        // arrange
        var p1 = new Person(1, "Trick", "A");
        var p2 = new Person(2, "Track", "B");

        // act
        var res = comparator.compare(p1, p2);

        // assert
        assertTrue(res < 0);
    }
    @Test
    public void testCompareTo_surname_second() {
        // arrange
        var p1 = new Person(1, "Trick", "B");
        var p2 = new Person(2, "Track", "A");

        // act
        var res = comparator.compare(p1, p2);

        // assert
        assertTrue(res > 0);
    }


    @Test
    public void testCompareTo_equals() {
        // arrange
        var p1 = new Person(1, "Tick", "Duck");
        var p2 = new Person(2, "Tick", "Duck");

        // act
        var res = comparator.compare(p1, p2);

        // assert
        assertEquals(0, res);
    }

    @Test
    public void testCompareTo_firstname_first() {
        // arrange
        var p1 = new Person(1, "Tick", "Duck");
        var p2 = new Person(2, "Trick", "Duck");

        // act
        var res = comparator.compare(p1, p2);

        // assert
        assertTrue(res < 0);
    }

    @Test
    public void testCompareTo_firstname_Second() {
        // arrange
        var p1 = new Person(1, "Trick", "Duck");
        var p2 = new Person(2, "Track", "Duck");

        // act
        var res = comparator.compare(p1, p2);

        // assert
        assertTrue(res > 0);
    }

    @Test
    public void testWithList() {
        // arrange
        var p1 = new Person(1, "Trick", "A");
        var p2 = new Person(2, "Trick", "Duck");
        var p3 = new Person(3, "Track", "Duck");
        var list = new ArrayList<Person>();
        list.add(p2);
        list.add(p1);
        list.add(p3);

        // act
        list.sort(comparator);

        // assert
        assertEquals("A",list.get(0).getSurname());
        assertEquals("Track",list.get(1).getName());
        assertEquals("Trick",list.get(2).getName());
    }
}