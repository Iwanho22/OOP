package ch.hslu.oop.sw11;

import ch.hslu.oop.sw11.io.ExperimentalDataWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExperimentalDataWriterTest {
    private ExperimentalDataWriter writer;

    @BeforeEach
    public void setUp() {
        writer = new ExperimentalDataWriter();
    }

    @Test
    void writeNumber() {
        // act
        writer.writeNumber(23);
    }

    @Test
    void readNumber() {
        // arrange
        writer.writeNumber(23);

        // act
        var val = writer.readNumber();

        // assert
        assertEquals(23, val);
    }

    @Test
    void writeString() {
        // act
        writer.writeString("Das ist ein Test mit ä ö ü");
    }

    @Test
    void testReadAndWriteMultiple() {
        // act
        var result = writer.readAndWriteMultiple(60D, 32);

        // assert
        assertEquals("Double value: 60.0,Int value: 32", result);
    }
}