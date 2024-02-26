package edu.badpals.domain;

public class Bicicleta {
    private final int id;

    public Bicicleta(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return Integer.toString(this.getId());
    }
}
