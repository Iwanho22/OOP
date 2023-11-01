package ch.hslu.oop.sw04;

/**
 * This class represents a windshield wiper of an automobile.
 */
public final class WindshieldWiper implements Switchable {
    private boolean isOn;
    private WindshieldWiperMode mode;

    public WindshieldWiper() {
        mode = WindshieldWiperMode.INTERVAL;
    }

    /**
     * Switches the windshield wiper on.
     */
    @Override
    public void switchOn() {
        isOn = true;
    }

    /**
     * Switches the windshield wiper off.
     */
    @Override
    public void switchOff() {
        isOn = false;
    }

    /**
     * Returns true if, and only if, the {@code isOn}  is true.
     *
     * @return {@code true} if {@code rpm)} is greater than {@code 0}, otherwise
     * * {@code false}
     */
    @Override
    public boolean isSwitchedOn() {
        return isOn;
    }

    public WindshieldWiperMode getMode() {
        return mode;
    }

    public void setMode(final WindshieldWiperMode mode) {
        this.mode = mode;
    }
}
