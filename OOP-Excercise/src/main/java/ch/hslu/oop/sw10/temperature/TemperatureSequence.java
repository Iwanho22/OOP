package ch.hslu.oop.sw10.temperature;


import ch.hslu.oop.sw10.temperature.event.TemperatureChangeListener;

public interface TemperatureSequence extends Sequence<Temperature> {

    float maxTemperature();

    float minTemperature();

    float average();

    void addTemperatureChangeListener(TemperatureChangeListener listener);
    void removeTemperatureChangeListener(TemperatureChangeListener listener);
}
