package org.example.excursion;

public class AppExcursiones {
    public static void main(String[] args) {
        System.out.println("***** APP EXCURSIONES *****");

        Excursion excursion = new Excursion("Terra Mítica","Benidorm",30.0);

        excursion.insertarProfesor();

        excursion.inscribirAsistente();
        excursion.inscribirAsistente();
        excursion.inscribirAsistente();

        excursion.verAsistentes();

        excursion.eliminarAsistentePorEdad(21);
        System.out.println("Después de eliminar a los menores de 21 años: ");
        excursion.verAsistentes();

        System.out.println("Importe a ingresar para la actividad " + excursion.getNombre_actividad() + " en " + excursion.getLocalidad() + ": " + excursion.calcularImporteIngreso() + "€.");

    }
}
