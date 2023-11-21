package ch.hslu.oop.sw08;

import ch.hslu.oop.sw10.temperature.DefaultTemperatureSequence;
import ch.hslu.oop.sw10.temperature.TemperatureSequence;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultTemperatureSequenceTest {
    private TemperatureSequence tempSequence;

    @BeforeEach
    public void setUp() {
        tempSequence = new DefaultTemperatureSequence();
    }

    @Test
    void add() {
        // arrange
        var temp = new Temperature();

        // act
        tempSequence.add(temp);

        // assert
        assertEquals(1, tempSequence.getCount());

    }

    @Test
    void getCount() {
        // arrange
        var temp1 = new Temperature(10f);
        var temp2 = new Temperature(20f);

        // act
        tempSequence.add(temp1);
        tempSequence.add(temp2);

        // assert
        assertEquals(2, tempSequence.getCount());
    }

    @Test
    void clear() {
        // arrange
        var temp1 = new Temperature();
        var temp2 = new Temperature();
        tempSequence.add(temp1);
        tempSequence.add(temp2);

        // act
        tempSequence.clear();

        // assert
        assertEquals(0, tempSequence.getCount());
    }

    @Test
    void testEquals() {
        EqualsVerifier.forClass(DefaultTemperatureSequence.class).verify();
    }

    @Test
    void testMax() {
        // arrange
        var temp1 = new Temperature(50f);
        var temp2 = new Temperature(60f);
        tempSequence.add(temp1);
        tempSequence.add(temp2);

        //act
        var max = tempSequence.maxTemperature();

        // assert
        assertEquals(60f, max, 0.0001);
    }

    @Test
    void testMin() {
        // arrange
        var temp1 = new Temperature(50f);
        var temp2 = new Temperature(60f);
        tempSequence.add(temp1);
        tempSequence.add(temp2);

        //act
        var min = tempSequence.minTemperature();

        // assert
        assertEquals(50f, min, 0.0001);
    }

    @Test
    void testAverage() {
        // arrange
        var temp1 = new Temperature(50f);
        var temp2 = new Temperature(60f);
        tempSequence.add(temp1);
        tempSequence.add(temp2);

        //act
        var average = tempSequence.average();

        // assert
        assertEquals(55f, average, 0.0001);
    }
}