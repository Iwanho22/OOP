package ch.hslu.oop.sw10.temperature;

import ch.hslu.oop.sw10.temperature.event.TemperatureChangeEvent;
import ch.hslu.oop.sw10.temperature.event.TemperatureChangeListener;
import ch.hslu.oop.sw10.temperature.event.TemperatureChangeState;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class DefaultTemperatureSequence extends AbstractSequence<Temperature> implements TemperatureSequence {

    private final List<TemperatureChangeListener> temperatureChangeListeners = new ArrayList<>();

    @Override
    public float maxTemperature() {
        var temp = super.max();
        return temp.getKelvin();
    }

    @Override
    public float minTemperature() {
        var temp = super.min();
        return temp.getKelvin();
    }

    @Override
    public float average() {
        return (float) getItems().stream().mapToDouble(Temperature::getKelvin).sum() / getCount();
    }

    @Override
    public void addTemperatureChangeListener(TemperatureChangeListener listener) {
        if (listener != null) {
            temperatureChangeListeners.add(listener);
        }
    }

    @Override
    public void removeTemperatureChangeListener(TemperatureChangeListener listener) {
        temperatureChangeListeners.remove(listener);
    }

    @Override
    public void add(Temperature item) {
        super.add(item);

        TemperatureChangeEvent event = null;
        if (Objects.equals(item, max())) {
            event = new TemperatureChangeEvent(this, item, TemperatureChangeState.NEW_MAX);
        } else if (Objects.equals(item, min())) {
            event = new TemperatureChangeEvent(this, item, TemperatureChangeState.NEW_MIN);
        }

        if (event != null) {
            fireTemperatureChangeEvent(event);
        }
    }

    private void fireTemperatureChangeEvent(TemperatureChangeEvent e) {
        temperatureChangeListeners.forEach(l -> l.maxTemperatureChange(e));
    }
}
