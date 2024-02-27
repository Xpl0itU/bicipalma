package edu.badpals.domain;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Estacion {
    public int id;
    public String direccion;
    private final Anclajes anclajes;

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
        return String.format("id: %d %ndireccion: %s %nanclajes: %s",
                getId(), getDireccion(), numAnclajes());
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
        int freeIndex = IntStream.range(0, anclajes().length)
                .filter(i -> !anclajes()[i].isOcupado())
                .findAny().orElseGet(() -> -1);
        if (freeIndex < 0) {
            return;
        }
        anclajes()[freeIndex].anclarBici(bici);
        System.out.printf("bicicleta: %d anclada en el anclaje: %d\n", bici.getId(), freeIndex + 1);
    }

    public boolean leerTarjetaUsuario(TarjetaUsuario tarjetaUsuario) {
        return tarjetaUsuario.isActivada();
    }

    public void retirarBicicleta(TarjetaUsuario tarjetaUsuario) {
        if (!leerTarjetaUsuario(tarjetaUsuario)) {
            return;
        }

        int freeIndex = IntStream.range(0, anclajes().length)
                .filter(i -> anclajes()[i].isOcupado())
                .findAny().orElseGet(() -> -1);
        if (freeIndex < 0) {
            System.out.println("No hay anclajes con bicicletas!");
            return;
        }

        System.out.println("bicicleta retirada: " + anclajes()[freeIndex].getBici().getId() + " del anclaje: " + (freeIndex + 1));
        anclajes()[freeIndex].liberarBici();
    }

    public void consultarAnclajes() {
        for (int i = 0; i < anclajes().length; ++i) {
            System.out.println("Anclaje " + (i + 1) + " " + (anclajes()[i].isOcupado() ? anclajes()[i].getBici().getId() : "libre"));
        }
    }
}
