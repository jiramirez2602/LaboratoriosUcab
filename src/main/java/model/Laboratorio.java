package model;

import java.util.UUID;

public class Laboratorio {

    String nombreLaboratorio;
    String facultad;
    String escuela;
    String departamento;
    Usuario administrador;
    String id;

    public static final String generarUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public Laboratorio(String nombreLaboratorio, String facultad, String escuela, String departamento, Usuario administrador) {
        this.nombreLaboratorio = nombreLaboratorio;
        this.facultad = facultad;
        this.escuela = escuela;
        this.departamento = departamento;
        this.administrador = administrador;
        this.id = generarUUID();
    }

    public String getId() {
        return id;
    }

    public Usuario getAdministrador() {
        return administrador;
    }

    public String getNombreLaboratorio() {
        return nombreLaboratorio;
    }

    public String getFacultad() {
        return facultad;
    }

    public String getEscuela() {
        return escuela;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setNombreLaboratorio(String nombreLaboratorio) {
        this.nombreLaboratorio = nombreLaboratorio;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setAdministrador(Usuario administrador) {
        this.administrador = administrador;
    }

}
