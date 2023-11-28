package ch.hslu.oop.sw08;

import ch.hslu.oop.sw10.temperature.event.TemperatureExtreamListener;

public interface TemperatureSequence extends Sequence<Temperature> {

    float maxTemperature();

    float minTemperature();

    float average();
}
