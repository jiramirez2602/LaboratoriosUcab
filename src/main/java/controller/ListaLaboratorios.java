package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Laboratorio;
import model.Usuario;

public class ListaLaboratorios {

    ArrayList<Laboratorio> lista;
    public ListaLaboratorios(){
        lista = new ArrayList();
    }

//    public void iniciarLista() {
//        //TODO: Leer todos los datos preexistentes de xml
//    }
    //TODO: Agregar logica de transacciones
    public boolean crearLaboratorio(Usuario user, String nombreLaboratorio, String facultad, String escuela, String departamento, String idAdministrador) {
        Validador validador = new Validador();
        if (!validador.validarConRegex(nombreLaboratorio, "^[A-Za-z0-9\\s]{5,30}$", "Nombre de laboratorio", "Nombre es invalido, puede usar hasta 30 caractes alfanumericos")
                || !validador.validarConRegex(facultad, "^[A-Za-z\\s]{5,30}$", "Facultad", "Facultad es invalida, puede usar hasta 30 caractes alfabeticos")
                || !validador.validarConRegex(escuela, "^[A-Za-z\\s]{5,30}$", "Escuela", "Escuela es invalida, puede usar hasta 30 caractes alfabeticos")
                || !validador.validarConRegex(departamento, "^[A-Za-z\\s]{0,30}$", "Departamento", "Departamento es invalida, puede usar hasta 30 caractes alfabeticos")) {
            return false;
        } else {
            Laboratorio laboratorioAux = new Laboratorio(nombreLaboratorio, facultad, escuela, departamento, idAdministrador);
            lista.add(laboratorioAux);
            return true;
        }

    }

    public ArrayList<Laboratorio> listarLaboratorios() {
        return lista;
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
    public boolean modificarLaboratorio(Usuario user, String id, String nombreLaboratorio, String facultad, String escuela, String departamento, String idAdministrador) {
        Laboratorio lab = listarLaboratorio(id);
        if (lab != null) {
            Validador validador = new Validador();
            if (!validador.validarConRegex(nombreLaboratorio, "^[A-Za-z0-9\\s]{5,30}$", "Nombre de laboratorio", "Nombre es invalido, puede usar hasta 30 caractes alfanumericos")
                    || !validador.validarConRegex(facultad, "^[A-Za-z\\s]{5,30}$", "Facultad", "Facultad es invalida, puede usar hasta 30 caractes alfabeticos")
                    || !validador.validarConRegex(escuela, "^[A-Za-z\\s]{5,30}$", "Escuela", "Escuela es invalida, puede usar hasta 30 caractes alfabeticos")
                    || !validador.validarConRegex(departamento, "^[A-Za-z\\s]{0,30}$", "Departamento", "Departamento es invalida, puede usar hasta 30 caractes alfabeticos")) {
                return false;
            } else {
                Laboratorio laboratorioAux = new Laboratorio(nombreLaboratorio, facultad, escuela, departamento, idAdministrador);
                int acumulador = 0;
                for (Laboratorio i : lista) {
                    if (i.getId().equals(id)) {
                        lista.set(acumulador, laboratorioAux);
                    }
                    acumulador++;
                }
                return true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Laboratorio no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    //TODO: Agregar logica de transacciones
    public void eliminarLaboratorio(Usuario user, String id) {
        Laboratorio lab = listarLaboratorio(id);
        if (lab != null) {
            int acumulador = 0;
            for (Laboratorio i : lista) {
                if (i.getId().equals(id)) {
                    lista.remove(acumulador);
                }
                acumulador++;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Laboratorio no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
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
