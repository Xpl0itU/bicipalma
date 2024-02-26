package edu.badpals.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnclajesTest {

    @Test
    void testToString() {
        Anclajes anclajes = new Anclajes(6);
        assertEquals("Numero de anclajes: 6", anclajes.toString());
    }
}