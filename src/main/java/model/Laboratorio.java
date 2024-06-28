package model;

import controller.ListaDeUsuarios;
import firebase.GeneralProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.swing.JOptionPane;

public class Laboratorio {

    String nombreLaboratorio;
    String facultad;
    String escuela;
    String departamento;
    String idAdministrador;
    String id;

    public static final String generarUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    //MÉTODOS FIREBASE//
    public boolean guardarEnFirebase(Usuario usuario) {
        try {
            Map<String, Object> datos = new HashMap<>();
            datos.put("username", String.valueOf(usuario.getUsername()));
            datos.put("contrasena", String.valueOf(usuario.getContrasena()));
            datos.put("nombreCompleto", String.valueOf(usuario.getNombreUser()));
            datos.put("rol", String.valueOf(usuario.getRolUsuario()));
            datos.put("estado", String.valueOf(usuario.getStatus()));
            GeneralProvider.guardar("Usuarios", String.valueOf(usuario.getId()), datos);
            JOptionPane.showMessageDialog(null, "Guardado con exito");
            return true;
        } catch (Exception e) {
            System.out.println("Error al guardar controller: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarEnFirebase(Usuario usuario) {
        try {
            Map<String, Object> datos = new HashMap<>();
            datos.put("username", String.valueOf(usuario.getUsername()));
            datos.put("contrasena", String.valueOf(usuario.getContrasena()));
            datos.put("nombreCompleto", String.valueOf(usuario.getNombreUser()));
            datos.put("rol", String.valueOf(usuario.getRolUsuario()));
            datos.put("estado", String.valueOf(usuario.getStatus()));
            GeneralProvider.actualizar("Usuarios", usuario.getId(), datos);
            JOptionPane.showMessageDialog(null, "Actualizado con exito");
            return true;
        } catch (Exception e) {
            System.out.println("Error al actualizar controller: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarEnFirebase(String id) {
        try {
            GeneralProvider.eliminar("Usuarios", id);
            JOptionPane.showMessageDialog(null, "Eliminado con exito");
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }

    public Laboratorio(String nombreLaboratorio, String facultad, String escuela, String departamento, String idAdministrador) {
        this.nombreLaboratorio = nombreLaboratorio;
        this.facultad = facultad;
        this.escuela = escuela;
        this.departamento = departamento;
        this.idAdministrador = idAdministrador;
        this.id = generarUUID();
    }

    public String getId() {
        return id;
    }

    public String getIdAdministrador() {
        return idAdministrador;
    }

    public Usuario getAdminInfo() {
        ListaDeUsuarios lista1 = new ListaDeUsuarios();
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios = lista1.getListaUsuarios();
        return lista1.listarUsuario(getIdAdministrador());
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

    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

}
