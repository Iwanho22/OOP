package ch.hslu.oop.sw02;

public class Temperatur {
    public static final float KELVIN_OFFSET = 273.15f;
    private float celsius;

    public Temperatur(float celsius) {
        this.celsius = celsius;
    }

    public Temperatur() {
        this.celsius = 20f;
    }


    public float getCelsius() {
        return celsius;
    }

    public void setCelsius(float celsius) {
        this.celsius = celsius;
    }

    public void addTempCelsius(float newTemp) {
        setCelsius(celsius + newTemp);
    }

    public void addTempKelvin(float newTemp) {
        this.addTempCelsius(newTemp - KELVIN_OFFSET);
    }

    public float getTempInKelvin() {
        return celsius + KELVIN_OFFSET;
    }

    public float getTempInFahrenheit() {
        return celsius * 1.8F + 32;
    }
}
