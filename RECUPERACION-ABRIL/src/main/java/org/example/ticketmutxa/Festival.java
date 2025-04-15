package org.example.ticketmutxa;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Festival extends Evento{
    static Scanner scanner = new Scanner(System.in);

    private Set<String> listaArtistas;

    public Festival(String nombre, LocalDate fecha, double precio) {
        super(nombre, fecha, precio);
        listaArtistas = new HashSet<>();

        setArtistas();
    }

    public void setArtistas() {
        String artista = "";

        System.out.println("Introduce los artistas que actuarán en el festival (o 'salir' para terminar):");
        do {
            artista = scanner.next();

            if (!artista.equalsIgnoreCase("salir")) {
                listaArtistas.add(artista);
            }
        } while (!artista.equalsIgnoreCase("salir"));
    }
}
