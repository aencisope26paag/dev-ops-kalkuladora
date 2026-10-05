package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IkasleaTest {
    @Test
    void testObjektuenEgoera_Null_NotNull_True_False() {
        Ikaslea ikasle1 = new Ikaslea("100", "Ane", true, new int[] { 7, 8, 9 });
        Ikaslea ikasleHutsa = null;
        // assertNotNull / assertNull: Objektua memorian existitzen den egiaztatzeko
        assertNotNull(ikasle1, "Ikaslea ondo sortu beharko litzateke");
        assertNull(ikasleHutsa, "Objektuak null izan behar du");
        // assertTrue / assertFalse: Boolearrak egiaztatzeko
        assertTrue(ikasle1.isAktibo(), "Ikasleak aktibo egon beharko luke");
        Ikaslea ikasle2 = new Ikaslea("101", "Jon", false, new int[] { 5, 6 });
        assertFalse(ikasle2.isAktibo(), "Ikasle honek ez luke aktibo egon behar");
    }

    @Test
    void testObjektuenKonparazioa_Equals_NotEquals() {
        Ikaslea ikasleA = new Ikaslea("100", "Ane", true, new int[] { 7, 8, 9 });
        // ikasleB-k ID bera du (100), nahiz eta izena desberdina izan
        Ikaslea ikasleB = new Ikaslea("100", "Ane M.", true, new int[] { 7, 8, 9 });
        Ikaslea ikasleC = new Ikaslea("102", "Mikel", true, new int[] { 5, 5, 5 });
        // assertEquals-ek guk idatzitako Object.equals() erabiltzen du atzealdean.
        // ID bera dutenez, testak ontzat emango du.
        assertEquals(ikasleA, ikasleB, "ID bera duten ikasleak berdinak dira gure sistemarentzat");
        // assertNotEquals
        assertNotEquals(ikasleA, ikasleC, "ID desberdina duten ikasleak ez dira berdinak");
    }

    @Test
    void testArrayKonparazioa_ArrayEquals() {
        Ikaslea ikasle1 = new Ikaslea("100", "Ane", true, new int[] { 7, 8, 9 });
        int[] esperoDirenNotak = { 7, 8, 9 };
        // Array-ak ezin dira assertEquals-ekin konparatu (memoriako erreferentziak
        // konparatzen dituelako).
        // assertArrayEquals erabili behar da elementuz elementu konparatzeko.
        assertArrayEquals(esperoDirenNotak, ikasle1.getNotak(), "Noten zerrendak zehatz-mehatz berdina izan behar du");
    }

    @Test
    void testSalbuespenak_Fail() {
        // 'fail()'-en erabilera klasiko bat: errorea gertatzea espero dugunean.
        try {
            // Honek IllegalArgumentException bat bota beharko luke
            Ikaslea ikasleAkastuna = new Ikaslea("103", null, true, new int[] {});
            // Kodea hona iristen bada, esan nahi du ez duela salbuespena bota.
            // Beraz, testak nahita huts egin behar du fail() erabiliz.
            fail("Testak huts egin du: ez du espero zen IllegalArgumentException bota (izena null delako)");
        } catch (IllegalArgumentException e) {
            // Salbuespena ondo harrapatu bada, testak arrakasta izango du
            assertNotNull(e.getMessage());
        }
    }
}