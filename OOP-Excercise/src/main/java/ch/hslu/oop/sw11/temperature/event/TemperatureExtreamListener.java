package ch.hslu.oop.sw11.temperature.event;

@FunctionalInterface
public interface TemperatureExtreamListener {
    /**
     * Fires a MaxTemperatureChange-Event.
     *
     * @param e MaxTemperatureChangeEvent containing significant information
     */
    void maxTemperatureChange(TemperatureExtremaEvent e);
}
