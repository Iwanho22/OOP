package ch.hslu.oop.sw10.autmobile;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Porsche.
 */
public class Automobile implements Switchable {
    private final Motor motor;
    private final WindshieldWiper windshieldWiper;
    private final List<Switchable> switchableDevices;
    private boolean isOn;

    public Automobile() {
        motor = new Motor();
        windshieldWiper = new WindshieldWiper();
        switchableDevices = new ArrayList<>();
        switchableDevices.add(motor);
        switchableDevices.add(windshieldWiper);
        motor.addPropertyChangeListener(this::handleMotorStateChange);
    }

    /**
     * Switches the Porsche on.
     * Switches the porsche on by setting {@code isOn} to true and by calling {@code motor.switchOn()}
     */
    @Override
    public void switchOn() {
        isOn = true;
        motor.switchOn();
    }

    /**
     * Switches the Porsche off.
     * Switches the porsche on by setting {@code isOn} to false and by calling {@code motor.switchOff()}
     */
    @Override
    public void switchOff() {
        isOn = false;
        switchableDevices.forEach(Switchable::switchOff);
        motor.switchOff();
    }

    /**
     * Returns true if, and only if, the {@code isOn} and {@code motor.isSwitchedOn} is true.
     *
     * @return {@code true} if {@code rpm)} is greater than {@code 0}, otherwise
     * * {@code false}
     */
    @Override
    public boolean isSwitchedOn() {
        return isOn && motor.isSwitchedOn();
    }

    private void handleMotorStateChange(PropertyChangeEvent e) {
        if ("motorState".equals(e.getPropertyName()) && e.getNewValue() == MotorState.OFF) {
            this.switchOff();
        }
    }
}
