package org.example.ticketmutxa;

import java.time.LocalDate;
import java.util.*;

public class TicketMutxa {
    static Scanner scanner = new Scanner(System.in);

    static Usuario comprador;
    static Set<Evento> listaEventos = new HashSet<>();
    static Set<Usuario> usuariosRegistrados = new HashSet<>();

    static void insertarEvento(String nombre, LocalDate fecha, double precio, String tipo) {
        if (tipo.toLowerCase().equals("festival")) {
            System.out.println("Creando festival...");
            Evento evento = new Festival(nombre,fecha,precio);
            listaEventos.add(evento);
        } else if (tipo.toLowerCase().equals("concierto")) {
            System.out.println("Creando concierto...");
            Evento evento = new Concierto(nombre,fecha,precio);
            listaEventos.add(evento);
        } else {
            System.out.println("El tipo de evento elegido no existe.");
        }
    }

    static void generarUsuarios(int cantidad) {
        Random random = new Random();
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String[] listaCaracteres = caracteres.split("");

        String usuario = "";
        String contrasena = "";
        for (int i = 0; i < cantidad; i++) {
            for (int j = 0; j < 8; j++) {
                usuario += listaCaracteres[random.nextInt(0, listaCaracteres.length)];
                contrasena += listaCaracteres[random.nextInt(0, listaCaracteres.length)];
            }
            Usuario user = new Usuario(usuario,contrasena);
            usuariosRegistrados.add(user);
            System.out.println("Chivato de usuarios generados -- " + usuario + " " + contrasena);
            usuario = "";
            contrasena = "";
        }
    }

    public static void verEventos() {
        System.out.println("----------------");
        System.out.println("Hola " + comprador.getNombre() + ". Elige un evento para iniciar la compra:");

        int i = 1;
        for (Evento evento : listaEventos) {
            System.out.println("[" + i + "]." + evento.getNombre() + " " + evento.getFecha());
            i++;
        }

        System.out.println("----------------");
        int opcion = scanner.nextInt();
    }

    public static Set<Usuario> getUsuariosRegistrados() {
        return usuariosRegistrados;
    }

    public static Evento getEvento(int posicion) {
        return listaEventos
    }
}
