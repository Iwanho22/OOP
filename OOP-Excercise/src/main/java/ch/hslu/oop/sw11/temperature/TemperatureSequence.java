package ch.hslu.oop.sw11.temperature;

import ch.hslu.oop.sw11.temperature.event.TemperatureExtreamListener;


public interface TemperatureSequence extends Sequence<Temperature> {

    float maxTemperature();

    float minTemperature();

    float average();

    void addTemperatureExtremaListener(TemperatureExtreamListener listener);
    void removeTemperatureChangeListener(TemperatureExtreamListener listener);
}
