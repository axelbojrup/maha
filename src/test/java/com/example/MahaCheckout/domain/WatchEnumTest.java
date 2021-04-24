package com.example.MahaCheckout.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WatchEnumTest {

    @Test
    void toDomainRolex() {
        WatchEnum rolex = WatchEnum.toDomain("001");
        assertEquals("Rolex", rolex.getName());
    }

    @Test
    void toDomainMichaelKors() {
        WatchEnum michaelkors = WatchEnum.toDomain("002");
        assertEquals("Michael Kors", michaelkors.getName());
    }

    @Test
    void toDomainSwatch() {
        WatchEnum swatch = WatchEnum.toDomain("003");
        assertEquals("Swatch", swatch.getName());
    }

    @Test
    void toDomainCasio() {
        WatchEnum casio = WatchEnum.toDomain("004");
        assertEquals("Casio", casio.getName());
    }

    @Test
    void toDomainUknown0() {
        WatchEnum unknown0 = WatchEnum.toDomain("000");
        assertEquals("Unknown", unknown0.getName());
    }

    @Test
    void toDomainUknown5() {
        WatchEnum unknown5 = WatchEnum.toDomain("005");
        assertEquals("Unknown", unknown5.getName());
    }

    @Test
    void toDomainUknown9999() {
        WatchEnum unknown9999 = WatchEnum.toDomain("9999");
        assertEquals("Unknown", unknown9999.getName());
    }
}