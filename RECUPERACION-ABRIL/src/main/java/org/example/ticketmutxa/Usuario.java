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
}
