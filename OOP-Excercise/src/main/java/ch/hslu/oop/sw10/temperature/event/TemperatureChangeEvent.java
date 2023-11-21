package ch.hslu.oop.sw10.temperature.event;

import ch.hslu.oop.sw10.temperature.Temperature;

import java.util.EventObject;

public class TemperatureChangeEvent extends EventObject {
    private Temperature newTemperature;
    private TemperatureChangeState temperatureChangeState;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public TemperatureChangeEvent(Object source) {
        super(source);
    }

    public TemperatureChangeEvent(Object source, Temperature newTemperature, TemperatureChangeState temperatureChangeState) {
        super(source);
        this.newTemperature = newTemperature;
        this.temperatureChangeState = temperatureChangeState;
    }

    public Temperature getNewTemperature() {
        return Temperature.createFromKelvin(newTemperature.getKelvin());
    }

    public TemperatureChangeState getTemperatureChangeState() {
        return temperatureChangeState;
    }
}
