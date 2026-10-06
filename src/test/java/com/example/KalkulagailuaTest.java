package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KalkulagailuaTest {

    @Test
    void oinarrizkoBatuketaTest() {
        // 1. Prestaketa (Arrange)
        Kalkulagailua kalk = new Kalkulagailua();
        
        // 2. Exekuzioa (Act)
        int emaitza = kalk.batu(2, 3);

        // 3. Egiaztapena (Assert)
        assertEquals(5, emaitza, "2 + 3 batuketak 5 izan beharko luke");

        // kenketa
        assertEquals(6, kalk.kendu(10, 4));

        // biderketa
        assertEquals(25, kalk.bidertu(5, 5));
    }
}