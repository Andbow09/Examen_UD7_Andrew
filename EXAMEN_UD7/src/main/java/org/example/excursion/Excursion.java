package org.example.excursion;

import java.util.*;

public class Excursion {
    static Scanner scanner = new Scanner(System.in);

    private String nombre_actividad;
    private String localidad;
    private double precio;
    private ArrayList<String> profesores;
    private List<Estudiante> listaEstudiantes;

    public Excursion(String nombre_actividad, String localidad, double precio) {
        this.nombre_actividad = nombre_actividad;
        this.localidad = localidad;
        this.precio = precio;
        this.profesores = new ArrayList<>();
        this.listaEstudiantes = new LinkedList<>();
    }

    public String getNombre_actividad() {
        return nombre_actividad;
    }

    public void setNombre_actividad(String nombre_actividad) {
        this.nombre_actividad = nombre_actividad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void insertarProfesor() {
        System.out.println("Introduce el nombre del profesor/a para la excursión " + getNombre_actividad());
        String profesor = scanner.nextLine();
        profesores.add(profesor);

        System.out.println("Profesor añadido correctamente a la excursión " + getNombre_actividad());
    }

    public void inscribirAsistente() {
        System.out.println();
        System.out.println("Creando estudiante:");

        System.out.print("Inserta los apellidos: ");
        String apellidos = scanner.nextLine();

        System.out.print("Inserta el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Inserta el curso: ");
        String curso = scanner.nextLine();

        System.out.print("Inserta su edad:");
        int edad = scanner.nextInt();

        scanner.nextLine();

        Estudiante estudiante = new Estudiante(apellidos,nombre,curso,edad);

        if (!listaEstudiantes.isEmpty()) {
            for (Estudiante est : listaEstudiantes) {
                if (est.equals(new Estudiante(apellidos,nombre,curso,edad))) {
                    System.out.println("El estudiante ya existe en la lista de asistentes a la actividad " + getNombre_actividad());
                    break;
                }
            }
        }

        listaEstudiantes.add(estudiante);
        System.out.println("Añadido correctamente el estudiante " + estudiante.getNombre() + " " + estudiante.getApellidos() + " del curso " + estudiante.getCurso());
    }

    public void verAsistentes() {
        Collections.sort(listaEstudiantes);
        System.out.println(listaEstudiantes);
    }

    public void eliminarAsistentePorEdad(int edad) {
        for (Estudiante est : listaEstudiantes) {
            if (est.getEdad() < edad) {
                listaEstudiantes.remove(est);
            }
        }
    }

    public double calcularImporteIngreso() {
        double total = 0;

        for (Estudiante est : listaEstudiantes) {
            total += getPrecio();
        }
        return total;
    }
}
