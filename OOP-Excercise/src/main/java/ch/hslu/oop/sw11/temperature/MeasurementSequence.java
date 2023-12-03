package ch.hslu.oop.sw11.temperature;

public interface MeasurementSequence extends Sequence<TemperatureMeasurement> {
    Temperature getAverageTemperature();

}
