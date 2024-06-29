package controller;

import firebase.GeneralProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import model.Laboratorio;
import model.Usuario;

public class ListaLaboratorios {

    ArrayList<Laboratorio> lista;

    public ListaLaboratorios() {
        lista = GeneralProvider.cargarInfoLaboratorios();
    }

    //MÉTODOS FIREBASE//
    public boolean guardarEnFirebase(Laboratorio labo) {
        try {
            Map<String, Object> datos = new HashMap<>();
            datos.put("nombreLaboratorio", String.valueOf(labo.getNombreLaboratorio()));
            datos.put("facultad", String.valueOf(labo.getFacultad()));
            datos.put("escuela", String.valueOf(labo.getEscuela()));
            datos.put("departamento", String.valueOf(labo.getDepartamento()));
            datos.put("administrador", String.valueOf(labo.getIdAdministrador()));
            GeneralProvider.guardar("Laboratorios", String.valueOf(labo.getId()), datos);
            JOptionPane.showMessageDialog(null, "Guardado con exito");
            return true;
        } catch (Exception e) {
            System.out.println("Error al guardar controller: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarEnFirebase(Laboratorio labo) {
        try {
            Map<String, Object> datos = new HashMap<>();
            datos.put("nombreLaboratorio", String.valueOf(labo.getNombreLaboratorio()));
            datos.put("facultad", String.valueOf(labo.getFacultad()));
            datos.put("escuela", String.valueOf(labo.getEscuela()));
            datos.put("departamento", String.valueOf(labo.getDepartamento()));
            datos.put("administrador", String.valueOf(labo.getIdAdministrador()));
            GeneralProvider.actualizar("Laboratorios", labo.getId(), datos);
            JOptionPane.showMessageDialog(null, "Actualizado con exito");
            return true;
        } catch (Exception e) {
            System.out.println("Error al actualizar controller: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarEnFirebase(String id) {
        try {
            GeneralProvider.eliminar("Laboratorios", id);
            JOptionPane.showMessageDialog(null, "Eliminado con exito");
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }
//    public void iniciarLista() {
//        //TODO: Leer todos los datos preexistentes de xml
//    }
    //TODO: Agregar logica de transacciones

    public ArrayList<Laboratorio> getListaLaboratorios() {
        lista = GeneralProvider.cargarInfoLaboratorios();
        return lista;
    }

    public boolean crearLaboratorio(Usuario user, String nombreLaboratorio, String facultad, String escuela, String departamento, String idAdministrador) {
        Validador validador = new Validador();
        if (!validador.validarConRegex(nombreLaboratorio, "^[A-Za-zñÑáéíóúÁÉÍÓÚ\\s]{5,30}$", "Nombre de laboratorio", "Nombre es invalido, puede usar hasta 30 caractes alfanumericos")
                || !validador.validarConRegex(facultad, "^[A-Za-zñÑáéíóúÁÉÍÓÚ\\s]{5,30}$", "Facultad", "Facultad es invalida, puede usar hasta 30 caractes alfabeticos")
                || !validador.validarConRegex(escuela, "^[A-Za-zñÑáéíóúÁÉÍÓÚ\\s]{5,30}$", "Escuela", "Escuela es invalida, puede usar hasta 30 caractes alfabeticos")
                || !validador.validarConRegex(departamento, "^[A-Za-zñÑáéíóúÁÉÍÓÚ\\s]{5,30}$", "Departamento", "Departamento es invalida, puede usar hasta 30 caractes alfabeticos")) {
            return false;
        } else {
            Laboratorio laboratorioAux = new Laboratorio(nombreLaboratorio, facultad, escuela, departamento, idAdministrador);
            guardarEnFirebase(laboratorioAux);
            return true;
        }

    }

    public ArrayList<Laboratorio> listarLaboratorios() {
        return lista;
    }

    public ArrayList<Laboratorio> listarLaboratorioPorUsuario(String idUsuarioLoggeado) {
        //TODO Mejorar logica para caso de usuario Admin
        ArrayList<Laboratorio> listaOriginal = listarLaboratorios();
        ArrayList<Laboratorio> listaFinal = null;
        for (Laboratorio laboratorio : listaOriginal) {
            if (laboratorio.getIdAdministrador().equals(idUsuarioLoggeado)) {
                listaFinal.add(laboratorio);
            }
        }
        return listaFinal;
    }

    public Laboratorio listarLaboratorio(String id) {
        for (Laboratorio i : lista) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        JOptionPane.showMessageDialog(null, "Laboratorio no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }

    public String listarLaboratorioPorNombre(String nombreDeLaboratorio) {
        for (Laboratorio i : listarLaboratorios()) {
            if (i.getNombreLaboratorio().equals(nombreDeLaboratorio)) {
                return i.getId();
            }
        }
        return null;
    }

    //TODO: Agregar logica de transacciones
    public boolean modificarLaboratorio(Usuario user, String idLaboratorio, String nombreLaboratorio, String facultad, String escuela, String departamento, String idAdministrador) {
        Validador validador = new Validador();
        if (!validador.validarConRegex(nombreLaboratorio, "^[A-Za-zñÑáéíóúÁÉÍÓÚ\\s]{5,30}$", "Nombre de laboratorio", "Nombre es invalido, puede usar hasta 30 caractes alfanumericos")
                || !validador.validarConRegex(facultad, "^[A-Za-zñÑáéíóúÁÉÍÓÚ\\s]{5,30}$", "Facultad", "Facultad es invalida, puede usar hasta 30 caractes alfabeticos")
                || !validador.validarConRegex(escuela, "^[A-Za-zñÑáéíóúÁÉÍÓÚ\\s]{5,30}$", "Escuela", "Escuela es invalida, puede usar hasta 30 caractes alfabeticos")
                || !validador.validarConRegex(departamento, "^[A-Za-zñÑáéíóúÁÉÍÓÚ\\s]{5,30}$", "Departamento", "Departamento es invalida, puede usar hasta 30 caractes alfabeticos")) {
            return false;
        } else {
            Laboratorio laboratorioModified = new Laboratorio(nombreLaboratorio, facultad, escuela, departamento, idAdministrador);
            laboratorioModified.setId(idLaboratorio);
            return actualizarEnFirebase(laboratorioModified);
        }

    }

    //TODO: Agregar logica de transacciones
    public boolean eliminarLaboratorio(Usuario user, String id) {
        try {
            return eliminarEnFirebase(id);
        } catch (Exception e) {
            System.out.println("Error" + e);
            return false;
        }
    }

//TODO: Ver si esta desgracia tiene sentido
//    public void comprobarProductosAsocioados(ArrayList<String> privileges, String nombreLaboratorio) {
//        for (Laboratorio i : lista) {
//            if (i.getNombreLaboratorio() == nombreLaboratorio) {
//                //TODO: Regresar ventanas con todos los productos de ese laboratorio
//            }
//        }
//    }
}
