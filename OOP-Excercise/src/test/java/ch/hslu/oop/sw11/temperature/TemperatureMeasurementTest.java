package ch.hslu.oop.sw11.temperature;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureMeasurementTest {

    @Test
    void testEquals() {
        // assert
        EqualsVerifier.forClass(TemperatureMeasurement.class).verify();
    }

}