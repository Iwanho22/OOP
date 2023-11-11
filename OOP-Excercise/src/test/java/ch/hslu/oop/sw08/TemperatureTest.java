package ch.hslu.oop.sw08;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TemperatureTest {

    private Temperature temperature;

    @BeforeEach
    public void setUp() {
        temperature = new Temperature();
    }

    @Test
    void getCelsius() {
        // assert
        assertEquals(0, temperature.getCelsius(), 0.0001);
        assertEquals(273.15f, temperature.getKelvin(), 0.0001);
    }

    @Test
    void setCelsius() {
        // act
        temperature.setCelsius(20);

        // assert
        assertEquals(20, temperature.getCelsius(), 0.0001);
        assertEquals(293.15f, temperature.getKelvin(), 0.0001);
    }

    @Test
    void getKelvin() {
        // assert
        assertEquals(273.15f, temperature.getKelvin(), 0.0001);
    }

    @Test
    void setKelvin() {
        // act
        temperature.setKelvin(0);

        // assert
        assertEquals(0, temperature.getKelvin(), 0.0001);
    }

    @Test
    void testEquals() {
        // assert
        EqualsVerifier.forClass(Temperature.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    void compareTo_greater() {
        // arrange
        var temp = new Temperature(50);

        // act
        var res = temperature.compareTo(temp);

        // assert
        assertTrue(res > 0);
    }

    @Test
    void compareTo_samller() {
        // arrange
        var temp = new Temperature(300);

        // act
        var res = temperature.compareTo(temp);

        // assert
        assertTrue(res < 0);
    }

    @Test
    void compareTo_same() {
        // arrange
        var temp = new Temperature(temperature);

        // act
        var res = temperature.compareTo(temp);

        // assert
        assertEquals(0, res);
    }

    @Test
    void testToString() {
        // assert
        assertEquals("Temp: 273.15 kelvin", temperature.toString());
    }

    @Test
    void convertKelvinToCelsius() {
        // assert
        assertEquals(0, Temperature.convertKelvinToCelsius(Temperature.KELVIN_OFFSET), 0.0001);
    }

    @Test
    void convertCelsiusToKelvin() {
        // assert
        assertEquals(0, Temperature.convertCelsiusToKelvin(-Temperature.KELVIN_OFFSET), 0.0001);
    }
}