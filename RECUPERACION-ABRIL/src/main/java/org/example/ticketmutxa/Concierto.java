package org.example.ticketmutxa;

import java.time.LocalDate;
import java.util.Scanner;

public class Concierto extends Evento{
    static Scanner scanner = new Scanner(System.in);

    private String artista;

    public Concierto(String nombre, LocalDate fecha, double precio) {
        super(nombre, fecha, precio);

        setArtista();
    }

    public String getArtista() {
        return this.artista;
    }

    public void setArtista() {
        System.out.print("Artista: ");
        this.artista = scanner.next();
    }
}
