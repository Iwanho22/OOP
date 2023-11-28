package ch.hslu.oop.sw11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataWriterTest {

    @Test
    void writeNumber() {
        // arrange
        var writer = new DataWriter();

        // act
        writer.writeNumber(23);
    }

    @Test
    void readNumber() {
        // arrange
        var writer = new DataWriter();
        writer.writeNumber(23);

        // act
        var val = writer.readNumber();

        // assert
        assertEquals(23, val);
    }

    @Test
    void writeString() {
        // arrange
        var writer = new DataWriter();

        // act
        writer.writeString("Das ist ein Test mit ä ö ü");
    }
}