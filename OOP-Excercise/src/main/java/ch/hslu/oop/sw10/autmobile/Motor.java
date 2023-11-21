package ch.hslu.oop.sw10.autmobile;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public final class Motor implements Switchable {
    private static final int IDLE_RPM = 900;
    private final ArrayList<PropertyChangeListener> propertyChangeListeners = new ArrayList<>();
    private MotorState motorState;
    private int rpm;

    /**
     * Switches the motor on by setting the {@code rmp}.
     * The {@code rmp} is set to the average rounds per minute in idle
     */
    @Override
    public void switchOn() {
        if (isSwitchedOff()) {
            rpm = IDLE_RPM;
            motorState = MotorState.ON;
            this.firePropertyChangeEvent(new PropertyChangeEvent(this, "motorState", MotorState.OFF, MotorState.ON));
        }
    }

    /**
     * Switches the motor off.
     * The {@code rmp} is set to {@code 0}.
     */
    @Override
    public void switchOff() {
        if (isSwitchedOn()) {
            rpm = 0;
            motorState = MotorState.OFF;
            this.firePropertyChangeEvent(new PropertyChangeEvent(this, "motorState", MotorState.ON, MotorState.OFF));
        }
    }

    /**
     * Returns true if, and only if, the {@code motorState} is equal to {@code MotorState.ON}.
     *
     * @return {@code true} if {@code rpm)} is greater than {@code 0}, otherwise
     * * {@code false}
     */
    @Override
    public boolean isSwitchedOn() {
        return motorState == MotorState.ON;
    }


    public void addPropertyChangeListener(PropertyChangeListener listener) {
        if (listener != null) {
            propertyChangeListeners.add(listener);
        }
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeListeners.remove(listener);
    }

    public void firePropertyChangeEvent(PropertyChangeEvent event) {
        propertyChangeListeners.forEach(l -> l.propertyChange(event));
    }

    public int getRpm() {
        return rpm;
    }
}
