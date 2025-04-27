package org.example.ticketmutxa;

import java.time.LocalDate;
import java.util.Scanner;

public class AppCompraEntradas {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        TicketMutxa.insertarEvento("Paellas", LocalDate.of(2025,4,30), 20, "Festival");
        TicketMutxa.insertarEvento("Concierto Estopa", LocalDate.of(2025,4,21), 40, "Concierto");

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
                System.out.println("\n¡BIENVENIDO!");
                TicketMutxa.comprador = user;
                TicketMutxa.verEventos();
            } else {
                System.out.println("Credenciales no válidas. Inténtalo de nuevo...");
            }
        } while (!user.autenticarse(TicketMutxa.getUsuariosRegistrados()));

        System.out.println("Espera tu turno...");

        for (int i = 4; i > 0; i--) {
            System.out.println(" -- Estás en la posición " + i + " de la cola virtual");
            Thread.sleep(3000);
        }

        System.out.println("¡Es tu turno!");

        System.out.println("¿Cuántas entradas quieres? (Máximo 7):");
        System.out.println("--------------------------------------");

        int entradas = 0;
        do {
            entradas = scanner.nextInt();

            if (entradas > 7) {
                System.out.println("No puedes añadir más de 7 entradas...");
            } else {
                TicketMutxa.comprador.anyadirAlCarrito(TicketMutxa.eventoComprador,entradas);
            }
        } while (entradas > 7);

        int opcion = 0;
        do {
            TicketMutxa.comprador.verCarrito();
            TicketMutxa.imprimirMenu();

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    int cantidad = 0;

                    System.out.println("¿Cuántas?");
                    cantidad = scanner.nextInt();

                    TicketMutxa.comprador.setCarritoCompra(TicketMutxa.eventoComprador,cantidad);

                    break;
                case 2:
                    cantidad = 0;

                    System.out.println("¿Cuántas?");
                    cantidad = scanner.nextInt();

                    TicketMutxa.comprador.setCarritoCompra(TicketMutxa.eventoComprador,-cantidad);

                    break;
                case 3:
                    System.out.println("Elige un método de pago:");
                    for (MetodoPago metodo : MetodoPago.values()) {
                        System.out.println(metodo + " (Gastos de gestión asociados: " + metodo.getPrecio() + "€).");
                    }

                    boolean tipoReal = false;
                    String opcion_pago = "";
                    do {
                        opcion_pago = scanner.next();

                        for (MetodoPago metodo : MetodoPago.values()) {
                            if (metodo.name().equalsIgnoreCase(opcion_pago)) {
                                tipoReal = true;
                            } else {
                                tipoReal = false;
                            }
                        }
                    } while (tipoReal);

                    for (MetodoPago metodo : MetodoPago.values()) {
                        if (metodo.name().equalsIgnoreCase(opcion_pago)) {
                            System.out.println("Realizando pago con " + metodo + " (+ " + metodo.getPrecio() + "€ de gastos de gestión)");
                        }
                    }

                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 3);

        System.out.println("¡MUCHAS GRACIAS! ¡DISFRUTA DEL EVENTO!");
    }
}