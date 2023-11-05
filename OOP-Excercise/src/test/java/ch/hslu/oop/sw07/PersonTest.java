package ch.hslu.oop.sw07;


import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void person_TestCtor() {
        // act
        var p = new Person(1, "Donald", "Duck");

        //assert
        assertEquals(1, p.getId());
        assertEquals("Donald", p.getName());
        assertEquals("Duck", p.getSurname());
    }

    @Test
    public void testImmutability() {
        //arrange
        var person = new Person(1, "Donald", "Duck");

        // act
        var name = person.getName();
        name = "New Name";
        var surname = person.getSurname();
        surname = "new Surname";

        // assert
        assertNotEquals(name, person.getName());
        assertNotEquals(surname, person.getSurname());
    }

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(Person.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    public void testComparable() {
        // arrange
        var p1 = new Person(1, "Tick", "Duck");
        var p2 = new Person(2, "Trick", "Duck");
        var p3 = new Person(3, "Track", "Duck");

        // act
        var sortedSet = new TreeSet<Person>();
        sortedSet.add(p3);
        sortedSet.add(p1);
        sortedSet.add(p2);

        // assert
        assertEquals(1, sortedSet.getFirst().getId());
        assertEquals(1, sortedSet.getLast().getId());
    }
}