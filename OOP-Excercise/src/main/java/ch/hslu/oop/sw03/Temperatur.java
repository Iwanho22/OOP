package ch.hslu.oop.sw03;

public class Temperatur {
    public static final float KELVIN_OFFSET = 273.15f;
    private float celsius;

    public Temperatur(float celsius) {
        this.celsius = celsius;
    }

    public Temperatur() {
        this.celsius = 20f;
    }


    public float getCelsius() {
        return celsius;
    }

    public void setCelsius(float celsius) {
        this.celsius = celsius;
    }

    public void addTempCelsius(float newTemp) {
        setCelsius(celsius + newTemp);
    }

    public void addTempKelvin(float newTemp) {
        this.addTempCelsius(newTemp - KELVIN_OFFSET);
    }

    public float getTempInKelvin() {
        return celsius + KELVIN_OFFSET;
    }

    public float getTempInFahrenheit() {
        return celsius * 1.8F + 32;
    }

    public AggregateState getAggregateState(String element) {
        AggregateState state = switch (element){
            case "N" -> getAggregateState(-210, -196);
            case "Hg" -> getAggregateState(39, 357);
            case "Pb" -> getAggregateState(327, 1744);
            default -> throw new IllegalArgumentException("Invalid Argument " + element);
        };
        return state;
    }

    public AggregateState getAggregateState(Element element) {
        return getAggregateState(element.getMeltingPoint(), element.getBoilingPoint());
    }

    private AggregateState getAggregateState(float meltingPoint, float boilingPint) {
        if (celsius < meltingPoint) {
            return AggregateState.SOLID;
        } else if (celsius < boilingPint) {
            return AggregateState.LIQUID;
        }
        return AggregateState.GASEOUS;
    }
}
