package edu.badpals.domain;

public class Anclajes {
    private Anclaje[] anclajes;

    Anclajes(int numAnclajes) {
        anclajes = new Anclaje[numAnclajes];
        crearAnclajes();
    }

    private boolean checkIndexAnclaje(int indexAnclaje) {
        return (indexAnclaje >= anclajes.length) || (indexAnclaje < 0);
    }

    private void crearAnclajes() {
        for (int i = 0; i < anclajes().length; ++i) {
            anclajes[i] = new Anclaje();
        }
    }

    Anclaje[] anclajes() {
        return anclajes;
    }

    void ocuparAnclaje(int indexAnclaje, Bicicleta bici) {
        if (!checkIndexAnclaje(indexAnclaje)) {
            return;
        }

        anclajes()[indexAnclaje].anclarBici(bici);
    }

    boolean isAnclajeOcupado(int indexAnclaje) {
        if (!checkIndexAnclaje(indexAnclaje)) {
            return false;
        }

        return anclajes()[indexAnclaje].isOcupado();
    }

    void liberarAnclaje(int indexAnclaje) {
        if (!checkIndexAnclaje(indexAnclaje)) {
            return;
        }

        anclajes()[indexAnclaje].liberarBici();
    }

    Bicicleta getBiciAt(int indexAnclaje) {
        if (!checkIndexAnclaje(indexAnclaje)) {
            return null;
        }

        return anclajes()[indexAnclaje].getBici();
    }

    int seleccionarAnclaje() {
        for (int i = 0; i < anclajes().length; ++i) {
            if(!anclajes()[i].isOcupado()) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Numero de anclajes: " + Integer.toString(anclajes().length);
    }
}
