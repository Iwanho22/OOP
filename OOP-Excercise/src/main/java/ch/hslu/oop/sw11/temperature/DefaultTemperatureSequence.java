package ch.hslu.oop.sw11.temperature;



import ch.hslu.oop.sw11.temperature.event.TemperatureExtreamListener;
import ch.hslu.oop.sw11.temperature.event.TemperatureExtremaEvent;
import ch.hslu.oop.sw11.temperature.event.TemperatureExtremaType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class DefaultTemperatureSequence extends AbstractSequence<Temperature> implements TemperatureSequence {

    private final List<TemperatureExtreamListener> temperatureChangeListeners = new ArrayList<>();

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
    public void addTemperatureExtremaListener(TemperatureExtreamListener listener) {
        if (listener != null) {
            temperatureChangeListeners.add(listener);
        }
    }

    @Override
    public void removeTemperatureChangeListener(TemperatureExtreamListener listener) {
        temperatureChangeListeners.remove(listener);
    }

    @Override
    public void add(Temperature item) {
        if (!items.isEmpty()) {
            TemperatureExtremaEvent event = null;
            if (item.compareTo(max()) > 0) {
                event = new TemperatureExtremaEvent(this, item, TemperatureExtremaType.NEW_MAX);
            } else if (item.compareTo(min()) < 0) {
                event = new TemperatureExtremaEvent(this, item, TemperatureExtremaType.NEW_MIN);
            }

            if (event != null) {
                fireTemperatureChangeEvent(event);
            }
        }
        super.add(item);
    }

    private void fireTemperatureChangeEvent(TemperatureExtremaEvent e) {
        temperatureChangeListeners.forEach(l -> l.maxTemperatureChange(e));
    }
}
