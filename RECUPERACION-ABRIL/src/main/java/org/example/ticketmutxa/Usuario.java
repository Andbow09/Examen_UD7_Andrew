package org.example.ticketmutxa;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Usuario implements Acciones{
    static Scanner scanner = new Scanner(System.in);

    private String nombre;
    private String contrasena;
    private Map<Evento,Integer> carritoCompra;

    public Usuario(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        carritoCompra = new LinkedHashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public void pagar() {

    }

    @Override
    public boolean autenticarse(Set<Usuario> usuariosRegistrados) {
        for (Usuario user : usuariosRegistrados) {
            if (getNombre().equals(user.getNombre()) && getContrasena().equals(user.getContrasena())) {
                return true;
            }
        }
        return false;
    }

    public void anyadirAlCarrito(Evento evento, int cantidad) {
        carritoCompra.put(evento, cantidad);
    }

    public boolean setCarritoCompra(Evento evento, int cantidad) {
        int cantidad_anterior = 0;

        for (Map.Entry<Evento, Integer> entry : carritoCompra.entrySet()) {
            cantidad_anterior = entry.getValue();
        }

        if ((cantidad_anterior + cantidad) > 7) {
            System.out.println("No puedes realizar la operación (Entradas: min=0 y máx=7)");
            return false;
        } else {
            carritoCompra.put(evento,cantidad_anterior + cantidad);
        }

        return true;
    }

    public void verCarrito() {
        for (Map.Entry<Evento, Integer> entry : carritoCompra.entrySet()) {
            System.out.println("Carrito: " + entry.getValue() + " entradas para " + entry.getKey().getNombre() + ".");
            System.out.println("\t\t Importe total: " + (entry.getKey().getPrecio() * entry.getValue()) + "€.");
            System.out.println("\t\t Gastos de gestión: por calcular");
        }
    }
}