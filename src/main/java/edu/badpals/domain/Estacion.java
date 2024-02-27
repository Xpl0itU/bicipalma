package edu.badpals.domain;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Estacion {
    private final Anclajes anclajes;
    public int id;
    public String direccion;

    public Estacion(int id, String direccion, int numAnclajes) {
        this.id = id;
        this.direccion = direccion;
        this.anclajes = new Anclajes(numAnclajes);
    }

    private int getId() {
        return id;
    }

    private String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return String.format("id: %d %ndireccion: %s %nanclajes: %s", getId(), getDireccion(), numAnclajes());
    }

    private Anclaje[] anclajes() {
        return anclajes.anclajes();
    }

    private int numAnclajes() {
        return anclajes().length;
    }

    public void consultarEstacion() {
        System.out.println("id: " + getId());
        System.out.println("direccion: " + getDireccion());
        System.out.println("numeroAnclajes: " + numAnclajes());
    }

    public int anclajesLibres() {
        return (int) Arrays.stream(anclajes()).filter(anclaje -> !anclaje.isOcupado()).count();
    }

    public void anclarBicicleta(Bicicleta bici) {
        OptionalInt freeIndex = IntStream.range(0, anclajes().length).filter(i -> !anclajes()[i].isOcupado()).findAny();
        if (freeIndex.isEmpty()) {
            return;
        }
        anclajes()[freeIndex.getAsInt()].anclarBici(bici);
        System.out.printf("bicicleta: %d anclada en el anclaje: %d\n", bici.getId(), freeIndex.getAsInt() + 1);
    }

    public boolean leerTarjetaUsuario(TarjetaUsuario tarjetaUsuario) {
        return tarjetaUsuario.isActivada();
    }

    public void retirarBicicleta(TarjetaUsuario tarjetaUsuario) {
        if (!leerTarjetaUsuario(tarjetaUsuario)) {
            return;
        }

        OptionalInt freeIndex = IntStream.range(0, anclajes().length).filter(i -> anclajes()[i].isOcupado()).findAny();
        if (freeIndex.isEmpty()) {
            System.out.println("No hay anclajes con bicicletas!");
            return;
        }

        System.out.printf("bicicleta retirada: %d del anclaje: %d", anclajes()[freeIndex.getAsInt()].getBici().getId(), freeIndex.getAsInt() + 1);
        anclajes()[freeIndex.getAsInt()].liberarBici();
    }

    public void consultarAnclajes() {
        for (int i = 0; i < anclajes().length; ++i) {
            System.out.println("Anclaje " + (i + 1) + " " + (anclajes()[i].isOcupado() ? anclajes()[i].getBici().getId() : "libre"));
        }
    }
}
