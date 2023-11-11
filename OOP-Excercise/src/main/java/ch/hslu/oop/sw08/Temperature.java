package ch.hslu.oop.sw08;

import java.util.Objects;

public final class Temperature implements Comparable<Temperature> {
    public static final float KELVIN_OFFSET = 273.15f;
    private float kelvin;

    public Temperature(float kelvin) {
        this.kelvin = kelvin;
    }

    public Temperature(Temperature temperature) {
        this.kelvin = temperature.getKelvin();
    }

    public Temperature() {
        this.kelvin = KELVIN_OFFSET;
    }


    public float getCelsius() {
        return convertKelvinToCelsius(kelvin);
    }

    public void setCelsius(float celsius) {
        this.kelvin = convertCelsiusToKelvin(celsius);
    }

    public float getKelvin() {
        return this.kelvin;
    }

    public void setKelvin(float kelvin) {
        this.kelvin = kelvin;
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

    public static float convertKelvinToCelsius(float kelvin) {
        return kelvin - KELVIN_OFFSET;
    }

    public static float convertCelsiusToKelvin(float kelvin) {
        return KELVIN_OFFSET + kelvin;
    }
}
