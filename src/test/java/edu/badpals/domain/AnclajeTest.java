package edu.badpals.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnclajeTest {
    Anclaje anclaje;
    Bicicleta bici;

    @BeforeEach
    void setUp() {
        anclaje = new Anclaje();
        bici = new Bicicleta(911);
    }

    @Test
    void ocuparAnclaje() {
        anclaje.anclarBici(bici);
        assertTrue(anclaje.isOcupado());
    }

    @Test
    void liberarAnclaje() {
        assertFalse(anclaje.isOcupado());
        anclaje.anclarBici(bici);
        assertTrue(anclaje.isOcupado());
        anclaje.liberarBici();
        assertFalse(anclaje.isOcupado());
    }

    @Test
    void getBici() {
        anclaje.anclarBici(bici);
        assertEquals(bici, anclaje.getBici());
    }
}