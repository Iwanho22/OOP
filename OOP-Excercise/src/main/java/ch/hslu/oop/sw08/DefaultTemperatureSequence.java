package ch.hslu.oop.sw08;

public final class DefaultTemperatureSequence extends AbstractSequence<Temperature> implements TemperatureSequence {

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
    public void add(Temperature item) {
        super.add(item);
    }
}
