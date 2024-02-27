package edu.badpals.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BicicletaTest {
    Bicicleta bici = null;

    @BeforeEach
    public void setup() {
        this.bici = new Bicicleta(999);
    }

    @Test
    public void constructorBiciTest() {
        assertEquals(999, bici.getId());
    }

    @Test
    public void toStringTest() {
        assertEquals("999", bici.toString());
    }
}
