package edu.badpals.domain;

public class Anclaje {
    // dummy values to avoid null pointer exceptions
    private boolean ocupado = false;
    private Bicicleta bici = new Bicicleta(0);

    Anclaje() {}

    boolean isOcupado() {
        return ocupado;
    }

    Bicicleta getBici() {
        return bici;
    }

    void anclarBici(Bicicleta bici) {
        if(bici != null) {
            this.bici = bici;
            ocupado = true;
        }
    }

    void liberarBici() {
        ocupado = false;
    }

    @Override
    public String toString() {
        return "ocupado: " + isOcupado();
    }
}
