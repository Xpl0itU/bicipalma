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
        System.out.printf("Estación %s (id: %d) (%d anclajes)\n", direccion, id, numAnclajes());
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
        for (Anclaje anclaje : anclajes()) {
            if (!anclaje.isOcupado()) {
                anclaje.anclarBici(bici);
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
        for (Anclaje anclaje : anclajes()) {
            System.out.println(anclaje.toString());
        }
    }
}
