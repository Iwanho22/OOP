package ch.hslu.oop.sw03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperaturTest {

    @Test
    void getAggregateState_withN_solid() {
        // arrange
        var temp = new Temperatur(-211);

        // act
        AggregateState res = temp.getAggregateState("N");

        // assert
        assertEquals(AggregateState.SOLID, res);
    }

    @Test
    void getAggregateState_withHg_solid() {
        // arrange
        var temp = new Temperatur(38);

        // act
        AggregateState res = temp.getAggregateState("Hg");

        // assert
        assertEquals(AggregateState.SOLID, res);
    }

    @Test
    void getAggregateState_withPb_solid() {
        // arrange
        var temp = new Temperatur(326);

        // act
        AggregateState res = temp.getAggregateState("Pb");

        // assert
        assertEquals(AggregateState.SOLID, res);
    }

    @Test
    void getAggregateState_withN_liquid() {
        // arrange
        var temp = new Temperatur(-209);

        // act
        AggregateState res = temp.getAggregateState("N");

        // assert
        assertEquals(AggregateState.LIQUID, res);
    }

    @Test
    void getAggregateState_withHg_liquid() {
        // arrange
        var temp = new Temperatur(40);

        // act
        AggregateState res = temp.getAggregateState("Hg");

        // assert
        assertEquals(AggregateState.LIQUID, res);
    }

    @Test
    void getAggregateState_withPb_liquid() {
        // arrange
        var temp = new Temperatur(328);

        // act
        AggregateState res = temp.getAggregateState("Pb");

        // assert
        assertEquals(AggregateState.LIQUID, res);
    }

    @Test
    void getAggregateState_withN_gaseous() {
        // arrange
        var temp = new Temperatur(-195);

        // act
        AggregateState res = temp.getAggregateState("N");

        // assert
        assertEquals(AggregateState.GASEOUS, res);
    }

    @Test
    void getAggregateState_withHg_gaseous() {
        // arrange
        var temp = new Temperatur(358);

        // act
        AggregateState res = temp.getAggregateState("Hg");

        // assert
        assertEquals(AggregateState.GASEOUS, res);
    }

    @Test
    void getAggregateState_withPb_gaseous() {
        // arrange
        var temp = new Temperatur(1745);

        // act
        AggregateState res = temp.getAggregateState("Pb");

        // assert
        assertEquals(AggregateState.GASEOUS, res);
    }

    @Test
    void getAggregateState_Element_withPb_gaseous() {
        // arrange
        var temp = new Temperatur(1745);
        var element = new Element();
        element.setName("Pb");
        element.setBoilingPoint(1744);

        // act
        AggregateState res = temp.getAggregateState(element);

        // assert
        assertEquals(AggregateState.GASEOUS, res);
    }
}