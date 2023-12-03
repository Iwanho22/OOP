package ch.hslu.oop.sw11.temperature;

public class DefaultMeasurementSequence extends AbstractSequence<TemperatureMeasurement> implements MeasurementSequence {
    @Override
    public Temperature getAverageTemperature() {
        return Temperature.createFromKelvin((float) getItems().stream().mapToDouble(m -> m.getTemperature().getKelvin()).sum() / getItems().size());
    }
}
