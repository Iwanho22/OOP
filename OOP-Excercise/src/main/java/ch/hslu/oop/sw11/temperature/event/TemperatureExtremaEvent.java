package ch.hslu.oop.sw11.temperature.event;

import ch.hslu.oop.sw11.temperature.Temperature;

import java.util.EventObject;

public class TemperatureExtremaEvent extends EventObject {
    private Temperature tempertaure;
    private TemperatureExtremaType temperatureExtremaType;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public TemperatureExtremaEvent(Object source) {
        super(source);
    }

    public TemperatureExtremaEvent(Object source, Temperature tempertaure, TemperatureExtremaType temperatureExtremaType) {
        super(source);
        this.tempertaure = tempertaure;
        this.temperatureExtremaType = temperatureExtremaType;
    }

    public Temperature getTempertaure() {
        return Temperature.createFromKelvin(tempertaure.getKelvin());
    }

    public TemperatureExtremaType getTemperatureChangeState() {
        return temperatureExtremaType;
    }

    @Override
    public String toString() {
        return switch (temperatureExtremaType) {
            case NEW_MAX -> "New max temperature reached: " + tempertaure;
            case NEW_MIN -> "New min temperature reached: " + tempertaure;
        };
    }
}
