package org.example.excursion;

import java.util.Objects;

public class Estudiante implements Comparable<Estudiante> {
    private String apellidos;
    private String nombre;
    private String curso;
    private int edad;

    public Estudiante(String apellidos, String nombre, String curso, int edad) {
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.curso = curso;
        this.edad = edad;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudiante that = (Estudiante) o;
        return Objects.equals(apellidos, that.apellidos) && Objects.equals(nombre, that.nombre) && Objects.equals(curso, that.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apellidos, nombre, curso);
    }

    @Override
    public int compareTo(Estudiante estudiante) {
        int compCurso = curso.compareTo(estudiante.curso);

        if (compCurso != 0) {
            return compCurso;
        }

        return apellidos.compareTo(estudiante.apellidos);
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "apellidos='" + apellidos + '\'' +
                ", nombre='" + nombre + '\'' +
                ", curso='" + curso + '\'' +
                ", edad=" + edad +
                '}';
    }
}
