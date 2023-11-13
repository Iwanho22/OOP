package ch.hslu.oop.sw09;

import ch.hslu.oop.sw09.Temperature;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

    private Temperature temperature;

    @BeforeEach
    public void setUp() {
        temperature = Temperature.createFromKelvin(273.15f);
    }

    @Test
    void getCelsius() {
        // assert
        assertEquals(0, temperature.getCelsius(), 0.0001);
        assertEquals(273.15f, temperature.getKelvin(), 0.0001);
    }

    @Test
    void getKelvin() {
        // assert
        assertEquals(273.15f, temperature.getKelvin(), 0.0001);
    }

    @Test
    void testEquals() {
        // assert
        EqualsVerifier.forClass(Temperature.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    void compareTo_greater() {
        // arrange
        var temp = Temperature.createFromKelvin(50);

        // act
        var res = temperature.compareTo(temp);

        // assert
        assertTrue(res > 0);
    }

    @Test
    void compareTo_samller() {
        // arrange
        var temp = Temperature.createFromKelvin(300);

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

    @Test
    void testCreateFromKelvin() {
        // act
        var temperature = Temperature.createFromKelvin(0f);
        // assert
        assertEquals(0, temperature.getKelvin(), 0.001);
    }

    @Test
    void testCreateFromCelsius() {
        // act
        var temperature = Temperature.createFromCelsius(0f);

        // assert
        assertEquals(273.15, temperature.getKelvin(), 0.001);
    }

    @Test
    void testCreateFromKelvin_invalid() {
        // act
        var exc = assertThrows(IllegalArgumentException.class, () -> Temperature.createFromKelvin(-50f));
        // assert
        assertEquals("Temperature cannot be below 0 Kelvin.", exc.getMessage());
    }

    @Test
    void testCreateFromCelsius_invalid() {
        // act
        var exc = assertThrows(IllegalArgumentException.class, () -> Temperature.createFromCelsius(-300f));
        // assert
        assertEquals("Temperature cannot be below 0 Kelvin.", exc.getMessage());
    }
}