package ch.hslu.oop.sw10.temperature;


public interface TemperatureSequence extends Sequence<Temperature> {

    float maxTemperature();

    float minTemperature();

    float average();
}
