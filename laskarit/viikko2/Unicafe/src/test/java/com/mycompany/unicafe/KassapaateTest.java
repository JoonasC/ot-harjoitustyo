package com.mycompany.unicafe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KassapaateTest {
    Kassapaate kassapaate;

    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
    }

    @Test
    public void luodussaKassapaatteessaOnOikeaMaaraRahaaJaMyytyjaLounaita() {
        assertEquals(1000, (kassapaate.kassassaRahaa() / 100));
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kateisostoKassapaatteellaToimiiOdotetusti() {
        assertEquals(0, kassapaate.syoEdullisesti(240));
        assertEquals(1002, (kassapaate.kassassaRahaa() / 100));
        assertEquals(40, (kassapaate.kassassaRahaa() % 100));
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(10, kassapaate.syoEdullisesti(250));
        assertEquals(1004, (kassapaate.kassassaRahaa() / 100));
        assertEquals(80, (kassapaate.kassassaRahaa() % 100));
        assertEquals(2, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(230, kassapaate.syoEdullisesti(230));
        assertEquals(1004, (kassapaate.kassassaRahaa() / 100));
        assertEquals(80, (kassapaate.kassassaRahaa() % 100));
        assertEquals(2, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(0, kassapaate.syoMaukkaasti(400));
        assertEquals(1008, (kassapaate.kassassaRahaa() / 100));
        assertEquals(80, (kassapaate.kassassaRahaa() % 100));
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
        assertEquals(10, kassapaate.syoMaukkaasti(410));
        assertEquals(1012, (kassapaate.kassassaRahaa() / 100));
        assertEquals(80, (kassapaate.kassassaRahaa() % 100));
        assertEquals(2, kassapaate.maukkaitaLounaitaMyyty());
        assertEquals(390, kassapaate.syoMaukkaasti(390));
        assertEquals(1012, (kassapaate.kassassaRahaa() / 100));
        assertEquals(80, (kassapaate.kassassaRahaa() % 100));
        assertEquals(2, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void korttiostoKassapaatteellaToimiiOdotetusti() {
        Maksukortti kortti = new Maksukortti(640);
        assertTrue(kassapaate.syoEdullisesti(kortti));
        assertEquals(400, kortti.saldo());
        assertEquals(1000, (kassapaate.kassassaRahaa() / 100));
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
        assertTrue(kassapaate.syoMaukkaasti(kortti));
        assertEquals(0, kortti.saldo());
        assertEquals(1000, (kassapaate.kassassaRahaa() / 100));
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
        assertFalse(kassapaate.syoEdullisesti(kortti));
        assertEquals(0, kortti.saldo());
        assertEquals(1000, (kassapaate.kassassaRahaa() / 100));
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
        assertFalse(kassapaate.syoMaukkaasti(kortti));
        assertEquals(0, kortti.saldo());
        assertEquals(1000, (kassapaate.kassassaRahaa() / 100));
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kortinLataaminenKassapaatteellaToimiiOdotetusti() {
        Maksukortti kortti = new Maksukortti(0);
        kassapaate.lataaRahaaKortille(kortti, 240);
        assertEquals(240, kortti.saldo());
        assertEquals(1002, (kassapaate.kassassaRahaa() / 100));
        assertEquals(40, (kassapaate.kassassaRahaa() % 100));
        kassapaate.lataaRahaaKortille(kortti, -10);
        assertEquals(240, kortti.saldo());
        assertEquals(1002, (kassapaate.kassassaRahaa() / 100));
        assertEquals(40, (kassapaate.kassassaRahaa() % 100));
    }
}
