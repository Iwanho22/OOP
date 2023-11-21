package ch.hslu.oop.sw10.autmobile;

/**
 * Implementing this interface allows an object to determine its on and off state.
 * This interface allows an object to be switched on/off and to determine if it's switched on/off.
 */
public interface Switchable {
    /**
     * Switches the element on.
     */
    void switchOn();

    /**
     * Switches the element off.
     */
    void switchOff();

    /**
     * Determines if the object is currently switched on.
     * @return true if the object is switched on
     */
    boolean isSwitchedOn();
    /**
     * Determines if the object is currently switched off.
     * Determines the state by negating the {@link #isSwitchedOn()}.
     * @return true if the object is switched on
     */
    default boolean isSwitchedOff() {
        return !isSwitchedOn();
    }
}
