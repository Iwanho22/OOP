package ch.hslu.oop.sw04;

import ch.hslu.oop.sw05.CountingSwitchable;

public final class Motor implements CountingSwitchable {
    private static final int AVERAGE_RPM = 900;
    private int rpm;
    private long switchCount;

    /**
     * Switches the motor on by setting the {@code rmp}.
     * The {@code rmp} is set to the average rounds per minute in idle
     */
    @Override
    public void switchOn() {
        rpm = AVERAGE_RPM;
        switchCount++;
    }
    /**
     * Switches the motor off.
     * The {@code rmp} is set to {@code 0}.
     */
    @Override
    public void switchOff() {
        rpm = 0;
    }

    /**
     * Returns true if, and only if, the {@code rmp} is greater than 0.
     * @return {@code true} if {@code rpm)} is greater than {@code 0}, otherwise
     *      * {@code false}
     */
    @Override
    public boolean isSwitchedOn() {
        return rpm > 0;
    }

    public int getRpm() {
        return rpm;
    }

    @Override
    public long getSwitchCount() {
        return switchCount;
    }
}
