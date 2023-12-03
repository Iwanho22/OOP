package ch.hslu.oop.sw11.temperature;

import java.util.Objects;

public final class Temperature implements Comparable<Temperature> {
    public static final float KELVIN_OFFSET = 273.15f;
    private final float kelvin;

    private Temperature(float kelvin, TemperatureUnit unit) {

        this.kelvin = validateTemperature(switch (unit) {
            case KELVIN -> kelvin;
            case CELSIUS -> kelvin + KELVIN_OFFSET;
        });
    }

    public Temperature(Temperature temperature) {
        this.kelvin = temperature.getKelvin();
    }

    public Temperature() {
        this.kelvin = KELVIN_OFFSET;
    }

    public static float convertKelvinToCelsius(float kelvin) {
        return kelvin - KELVIN_OFFSET;
    }

    public static float convertCelsiusToKelvin(float kelvin) {
        return KELVIN_OFFSET + kelvin;
    }

    public static Temperature createFromCelsius(float celsius) {
        return new Temperature(celsius, TemperatureUnit.CELSIUS);
    }

    public static Temperature createFromKelvin(float kelvin) {
        return new Temperature(kelvin, TemperatureUnit.KELVIN);
    }

    private static float validateTemperature(float kelvin) {
        if (kelvin < 0) {
            throw new IllegalArgumentException("Temperature cannot be below 0 Kelvin.");
        }

        return kelvin;
    }

    public float getCelsius() {
        return convertKelvinToCelsius(kelvin);
    }

    public float getKelvin() {
        return this.kelvin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kelvin);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        return (obj instanceof Temperature temp) && Objects.equals(this.kelvin, temp.getKelvin());
    }

    @Override
    public int compareTo(Temperature o) {
        if (this == o) {
            return 0;
        }

        return Float.compare(kelvin, o.getKelvin());
    }

    @Override
    public String toString() {
        return String.format("Temp: %s kelvin", kelvin);
    }
}
