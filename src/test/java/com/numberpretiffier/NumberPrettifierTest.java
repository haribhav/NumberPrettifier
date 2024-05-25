package com.numberpretiffier;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberPrettifierTest {
    @Test
    public void testNumbersBelowMillion() {
        assertEquals("678", NumberPrettifier.prettifyNumber(678));
        assertEquals("999999", NumberPrettifier.prettifyNumber(999999));
    }

    @Test
    public void testNumbersInMillions() {
        assertEquals("1M", NumberPrettifier.prettifyNumber(1000000));
        assertEquals("2.8M", NumberPrettifier.prettifyNumber(2800000.87));
    }

    @Test
    public void testNumbersInBillions() {
        assertEquals("2.1B", NumberPrettifier.prettifyNumber(2123456789));
    }

    @Test
    public void testNumbersInTrillions() {
        assertEquals("7.1T", NumberPrettifier.prettifyNumber(7123456789123L));
    }

    @Test
    public void testNegativeNumbers() {
        assertEquals("-1.1B", NumberPrettifier.prettifyNumber(-1123455789));
    }

    @Test
    public void testFloatingPointNumbers() {
        assertEquals("645.1", NumberPrettifier.prettifyNumber(645.1));
    }

    @Test
    public void testNumbersAboveTrillions() {
        assertEquals("1.2T", NumberPrettifier.prettifyNumber(1234567890123L));
        assertEquals("1234.6T", NumberPrettifier.prettifyNumber(1234567890123456L));
    }
}