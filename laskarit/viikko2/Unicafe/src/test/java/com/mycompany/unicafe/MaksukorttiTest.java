package com.mycompany.unicafe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void saldoOnOikeinLuodussaKortissa() {
        assertEquals(10, kortti.saldo());
    }

    @Test
    public void rahanLataaminenKasvattaaKortinSaldoa() {
        kortti.lataaRahaa(10);
        assertEquals(20, kortti.saldo());
    }

    @Test
    public void rahanOttaminenKortiltaToimiiOdotetusti() {
        assertTrue(kortti.otaRahaa(5));
        assertEquals(5, kortti.saldo());
        assertFalse(kortti.otaRahaa(10));
        assertEquals(5, kortti.saldo());
    }

    @Test
    public void kortinToStringToimiiOdotetusti() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
}
