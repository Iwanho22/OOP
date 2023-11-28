package ch.hslu.oop.sw10.temperature.event;
@FunctionalInterface
public interface TemperatureExtreamListener {
    /**
     * Fires a MaxTemperatureChange-Event.
     *
     * @param e MaxTemperatureChangeEvent containing significant information
     */
    void maxTemperatureChange(TemperatureExtremaEvent e);
}
