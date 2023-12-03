package ch.hslu.oop.sw11.temperature;

import java.time.LocalDateTime;
import java.util.Objects;

public final class TemperatureMeasurement implements Comparable<TemperatureMeasurement> {
    private final LocalDateTime timestamp;
    private final Temperature temperature;

    public TemperatureMeasurement(LocalDateTime timestamp, Temperature temperature) {
        this.temperature = temperature;
        this.timestamp = timestamp;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        return (obj instanceof TemperatureMeasurement measurement) && Objects.equals(temperature,
                measurement.temperature) && Objects.equals(timestamp, measurement.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, temperature);
    }

    @Override
    public int compareTo(TemperatureMeasurement o) {
        return timestamp.compareTo(o.getTimestamp());
    }

    @Override
    public String toString() {
        return temperature + " at " + timestamp;
    }
}
