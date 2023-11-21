package ch.hslu.oop.sw10.autmobile;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AutomobileTest {

    @Test
    void testHandleEvent() {
        // arrange
        var auto = new Automobile();
        var motor = (Motor) ReflectionTestUtils.getField(auto, "motor");

        auto.switchOn();

        // act
        motor.switchOff();

        // assert
        assertTrue(auto.isSwitchedOff());
    }

}