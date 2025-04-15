package org.example.ticketmutxa;

import javax.security.auth.callback.TextOutputCallback;
import java.time.LocalDate;
import java.util.Scanner;

public class AppCompraEntradas {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TicketMutxa.insertarEvento("Paellas", LocalDate.now(), 20, "Festival");
        TicketMutxa.insertarEvento("Concierto Estopa", LocalDate.now(), 40, "Concierto");

        TicketMutxa.generarUsuarios(4);

        System.out.println("**** BIENVENIDO A TICKETMUTXA ****");
        System.out.println("\nIniciar Sesión");
        Usuario user;
        do {
            System.out.print("\tUsuario: ");
            String usuario = scanner.next();

            System.out.print("\tContraseña: ");
            String contrasena = scanner.next();
            user = new Usuario(usuario, contrasena);
            if (user.autenticarse(TicketMutxa.getUsuariosRegistrados())) {
                System.out.println("¡BIENVENIDO!");
                TicketMutxa.comprador = user;
                TicketMutxa.verEventos();
            } else {
                System.out.println("Credenciales no válidas. Inténtalo de nuevo...");
            }
        } while (!user.autenticarse(TicketMutxa.getUsuariosRegistrados()));
    }
}
