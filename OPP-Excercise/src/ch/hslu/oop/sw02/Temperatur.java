package ch.hslu.oop.sw02;

public class Temperatur {
    private float tempInCelsius;

    public Temperatur(float tempInCelsius) {
        this.tempInCelsius = tempInCelsius;
    }

    public Temperatur() {
        this.tempInCelsius = 20F;
    }

    public float getTempInCelsius() {
        return tempInCelsius;
    }

    public void setTempInCelsius(float tempInCelsius) {
        this.tempInCelsius = tempInCelsius;
    }

    public void addToTemp(float newTemp) {
        setTempInCelsius(tempInCelsius + newTemp);
    }

    public float getTempInKelvin() {
        return tempInCelsius + 273.15F;
    }

    public float getTempInFahrenheit() {
        return tempInCelsius * 1.8F + 32;
    }
}
