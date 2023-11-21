package ch.hslu.oop.sw10.autmobile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.ArgumentMatchers.any;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MotorTest {
    @InjectMocks
    private Motor motor;
    @Mock
    private ArrayList<PropertyChangeListener> propertyChangeListeners;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void isSwitchedOn_whileNotRunning_shouldBeSwitchedOn() {
        // arrange
        var motor = new Motor();
        motor.switchOn();

        // act
        var switchedOn = motor.isSwitchedOn();

        // assert
        assertTrue(switchedOn);
    }

    @Test
    void isSwitchedOn_whileNotRunning_shouldNotBeSwitchedOff() {
        // arrange
        var motor = new Motor();
        motor.switchOn();

        //act
        var switchedOff = motor.isSwitchedOff();

        // assert
        assertFalse(switchedOff);
    }


    @Test
    void isSwitchedOff_whileNotRunning_shouldBeSwitchedOff() {
        // arrange
        var motor = new Motor();
        motor.switchOff();

        // act
        var switchedOff = motor.isSwitchedOff();

        // assert
        assertTrue(switchedOff);
    }

    @Test
    void isSwitchedOff_whileNotRunning_shouldNotBeSwitchedOn() {
        // arrange
        var motor = new Motor();
        motor.switchOff();

        // act
        var switchedOn = motor.isSwitchedOn();

        // assert
        assertFalse(switchedOn);
    }

    @Test
    void switchedOn_whileNotRunning_RpmShouldBeSett() {
        // arrange
        var motor = new Motor();


        // act
        motor.switchOn();

        // assert
        var rpm = motor.getRpm();
        assertTrue(rpm > 0);
    }

    @Test
    void switchedOn_whileNotRunning_fireEvent() {
        // arrange
        var eventListener = mock(PropertyChangeListener.class);
        var motor = new Motor();
        motor.addPropertyChangeListener(eventListener);

        ArgumentCaptor<PropertyChangeEvent> captor = ArgumentCaptor.forClass(PropertyChangeEvent.class);


        // act
        motor.switchOn();

        // assert
        var rpm = motor.getRpm();
        verify(eventListener).propertyChange(captor.capture());
        var event = captor.getAllValues().getFirst();
        assertEquals("motorState", event.getPropertyName());
        assertEquals(MotorState.ON, event.getNewValue());
        assertEquals(MotorState.OFF, event.getOldValue());
        assertTrue(rpm > 0);
    }

    @Test
    void switchedOn_whileRunning_RpmShouldBeSett() {
        // arrange
        var motor = new Motor();
        motor.switchOn();

        // act
        motor.switchOn();

        // assert
        var rpm = motor.getRpm();
        assertTrue(rpm > 0);
    }

    @Test
    void switchedOn_whileNotRunning_shouldBeSwitchedOn() {
        // arrange
        var motor = new Motor();

        // act
        motor.switchOn();

        // assert
        var rpm = motor.getRpm();
        assertTrue(rpm > 0);
    }

    @Test
    void switchedOn_whileRunning_shouldBeSwitchedOn() {
        // arrange
        var motor = new Motor();
        motor.switchOn();

        // act
        motor.switchOn();

        // assert
        var rpm = motor.getRpm();
        assertTrue(rpm > 0);
    }

    @Test
    void switchedOff_whileNotRunning_RmpShouldBeZero() {
        // arrange
        var motor = new Motor();

        // act
        motor.switchOff();

        // assert
        var rpm = motor.getRpm();
        assertTrue(rpm <= 0);
    }

    @Test
    void switchedOff_whileRunning_fireEvent() {
        // arrange
        var eventListener = mock(PropertyChangeListener.class);
        var motor = new Motor();
        motor.switchOn();
        motor.addPropertyChangeListener(eventListener);

        ArgumentCaptor<PropertyChangeEvent> captor = ArgumentCaptor.forClass(PropertyChangeEvent.class);


        // act
        motor.switchOff();

        // assert
        var rpm = motor.getRpm();
        verify(eventListener).propertyChange(captor.capture());
        var event = captor.getAllValues().getFirst();
        assertEquals("motorState", event.getPropertyName());
        assertEquals(MotorState.OFF, event.getNewValue());
        assertEquals(MotorState.ON, event.getOldValue());
    }

    @Test
    void switchedOff_whileRunning_RmpShouldBeZero() {
        // arrange
        var motor = new Motor();
        motor.switchOn();

        // act
        motor.switchOff();

        // assert
        var rpm = motor.getRpm();
        assertTrue(rpm <= 0);
    }

    @Test
    void switchedOff_whileNotRunning_RmpShouldNotBeRunning() {
        // arrange
        var motor = new Motor();

        // act
        motor.switchOff();

        // assert
        assertTrue(motor.isSwitchedOff());
    }

    @Test
    void switchedOff_whileRunning_RmpShouldNotBeRunning() {
        // arrange
        var motor = new Motor();
        motor.switchOn();

        // act
        motor.switchOff();

        // assert
        assertTrue(motor.isSwitchedOff());
    }

    @Test
    void addEventListener_null(){
        // arrange
        ReflectionTestUtils.setField(motor,"propertyChangeListeners", propertyChangeListeners);

        // act
        motor.addPropertyChangeListener(null);

        // assert
        verify(propertyChangeListeners, times(0)).add(any());
    }

    @Test
    void addEventListener(){
        // arrange
        var eventListener = mock(PropertyChangeListener.class);
        ReflectionTestUtils.setField(motor,"propertyChangeListeners", propertyChangeListeners);

        // act
        motor.addPropertyChangeListener(eventListener);

        // assert
        verify(propertyChangeListeners, times(1)).add(any());
    }

    @Test
    void removeEventListener(){
        // arrange
        var eventListener = mock(PropertyChangeListener.class);
        ReflectionTestUtils.setField(motor,"propertyChangeListeners", propertyChangeListeners);

        // act
        motor.removePropertyChangeListener(eventListener);

        // assert
        verify(propertyChangeListeners, times(1)).remove(any());
    }
}