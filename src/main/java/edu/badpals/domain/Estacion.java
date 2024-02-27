package edu.badpals.domain;

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
        int anclajesLibres = 0;
        for (Anclaje anclaje : anclajes()) {
            if (!anclaje.isOcupado()) {
                anclajesLibres += 1;
            }
        }
        return anclajesLibres;
    }

    public void anclarBicicleta(Bicicleta bici) {
        for (int i = 0; i < anclajes().length; ++i) {
            if (!anclajes()[i].isOcupado()) {
                anclajes()[i].anclarBici(bici);
                System.out.printf("bicicleta: %d anclada en el anclaje: %d\n", bici.getId(), i + 1);
                return;
            }
        }
    }

    public boolean leerTarjetaUsuario(TarjetaUsuario tarjetaUsuario) {
        return tarjetaUsuario.isActivada();
    }

    public void retirarBicicleta(TarjetaUsuario tarjetaUsuario) {
        if (!leerTarjetaUsuario(tarjetaUsuario)) {
            return;
        }

        for (Anclaje anclaje : anclajes()) {
            if (anclaje.isOcupado()) {
                anclaje.liberarBici();
                return;
            }
        }
    }

    public void consultarAnclajes() {
        for (int i = 0; i < anclajes().length; ++i) {
            System.out.println("Anclaje " + (i + 1) + " " + (anclajes()[i].isOcupado() ? anclajes()[i].getBici().getId() : "libre"));
        }
    }
}
