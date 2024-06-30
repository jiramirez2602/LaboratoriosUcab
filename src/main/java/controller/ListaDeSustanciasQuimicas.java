package controller;

import firebase.GeneralProvider;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import model.Laboratorio;
import model.SustanciaQuimica;
import model.Transaccion;
import model.Usuario;

public class ListaDeSustanciasQuimicas {

    ArrayList<SustanciaQuimica> listaSustancias;
    ListaDeTransacciones listaDeTransacciones = new ListaDeTransacciones();

    //FIREBASE
    public boolean guardarEnFirebase(SustanciaQuimica sustancia) {
        try {
            Map<String, Object> datos = new HashMap<>();
            datos.put("formulaQuimica", String.valueOf(sustancia.getFormulaQuimica()));
            datos.put("concentracion", String.valueOf(sustancia.getConcentracion()));
            datos.put("presentacion", String.valueOf(sustancia.getPresentacion()));
            datos.put("nombreComercial", String.valueOf(sustancia.getNombreComercial()));
            datos.put("poseeMSD", String.valueOf(sustancia.getPoseeMSD()));
            datos.put("numeroDeIdentificacion", String.valueOf(sustancia.getNumeroDeIdentificacion()));
            datos.put("grupoDeRiesgo", String.valueOf(sustancia.getGrupoDeRiesgo()));
            datos.put("fraseR", String.valueOf(sustancia.getFraseR()));
            datos.put("fraseS", String.valueOf(sustancia.getFraseS()));
            datos.put("metodoDeControl", String.valueOf(sustancia.getMetodoDeControl()));
            datos.put("permisos", String.valueOf(sustancia.getPermisos()));
            datos.put("unidad", String.valueOf(sustancia.getUnidad()));
            datos.put("precioEstimado", String.valueOf(sustancia.getPrecioEstimado()));
            datos.put("proveedor", String.valueOf(sustancia.getProveedor()));
            datos.put("almacenadoEnvasado", String.valueOf(sustancia.getAlmacenadoEnvasado()));
            datos.put("nombreProducto", String.valueOf(sustancia.getNombreProducto()));
            datos.put("inventarioExistente", String.valueOf(sustancia.getInventarioExistente()));
            datos.put("observaciones", String.valueOf(sustancia.getObservaciones()));
            datos.put("idLaboratorio", String.valueOf(sustancia.getLaboratorio()));
            GeneralProvider.guardar("SustanciasQuimicas", String.valueOf(sustancia.getId()), datos);
            JOptionPane.showMessageDialog(null, "Guardado con exito");
            return true;
        } catch (Exception e) {
            System.out.println("Error al guardar controller: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarEnFirebase(SustanciaQuimica sustancia) {
        try {
            Map<String, Object> datos = new HashMap<>();
            datos.put("formulaQuimica", String.valueOf(sustancia.getFormulaQuimica()));
            datos.put("concentracion", String.valueOf(sustancia.getConcentracion()));
            datos.put("presentacion", String.valueOf(sustancia.getPresentacion()));
            datos.put("nombreComercial", String.valueOf(sustancia.getNombreComercial()));
            datos.put("poseeMSD", String.valueOf(sustancia.getPoseeMSD()));
            datos.put("numeroDeIdentificacion", String.valueOf(sustancia.getNumeroDeIdentificacion()));
            datos.put("grupoDeRiesgo", String.valueOf(sustancia.getGrupoDeRiesgo()));
            datos.put("fraseR", String.valueOf(sustancia.getFraseR()));
            datos.put("fraseS", String.valueOf(sustancia.getFraseS()));
            datos.put("metodoDeControl", String.valueOf(sustancia.getMetodoDeControl()));
            datos.put("permisos", String.valueOf(sustancia.getPermisos()));
            datos.put("unidad", String.valueOf(sustancia.getUnidad()));
            datos.put("precioEstimado", String.valueOf(sustancia.getPrecioEstimado()));
            datos.put("proveedor", String.valueOf(sustancia.getProveedor()));
            datos.put("almacenadoEnvasado", String.valueOf(sustancia.getAlmacenadoEnvasado()));
            datos.put("nombreProducto", String.valueOf(sustancia.getNombreProducto()));
            datos.put("inventarioExistente", String.valueOf(sustancia.getInventarioExistente()));
            datos.put("observaciones", String.valueOf(sustancia.getObservaciones()));
            datos.put("idLaboratorio", String.valueOf(sustancia.getLaboratorio()));
            GeneralProvider.actualizar("SustanciasQuimicas", sustancia.getId(), datos);
            JOptionPane.showMessageDialog(null, "Actualizado con exito");
            return true;
        } catch (Exception e) {
            System.out.println("Error al actualizar controller: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarEnFirebase(String id) {
        try {
            GeneralProvider.eliminar("SustanciasQuimicas", id);
            JOptionPane.showMessageDialog(null, "Eliminado con exito");
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<SustanciaQuimica> getListaSustanciasQuimicas() throws ParseException {
        listaSustancias = GeneralProvider.cargarInfoSustancias();
        return listaSustancias;
    }

    public void setListaSustancias(ArrayList<SustanciaQuimica> listaSustancias) {
        this.listaSustancias = listaSustancias;
    }

    //Crear producto Sustancia Quimica
    public boolean crearProductoSustanciaQuimica(Usuario user, String formulaQuimica, String concentracion, String presentacion, String nombreComercial, Boolean poseeMSD, String numeroDeIdentificacion, String grupoDeRiesgo, String fraseR, String fraseS, String metodoDeControl, String permisos, String unidad, String precioEstimado, String proveedor, String almacenadoEnvasado, String nombreProducto, String inventarioExistente, String observaciones, String idLaboratorio) {
        Validador validador = new Validador();

        if (!validador.validarConRegex(formulaQuimica, "^[^\\n]{0,100}$", "Formula Quimica", "Formula Quimica es invalido(a), puede usar hasta 100 caractes alfanumericos")
                || !validador.validarConRegex(concentracion, "^[^\\n]{0,100}$", "Concentracion", "Concentracion es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(fraseR, "^[^\\n]{0,100}$", "Frase R", "Frase R es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(fraseS, "^[^\\n]{0,100}$", "Frase S", "Frase S es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(metodoDeControl, "^[^\\n]{0,100}$", "Metodo De Control", "Metodo De Control es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(permisos, "^[^\\n]{0,100}$", "Permisos", "Permisos es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(almacenadoEnvasado, "^[^\\n]{0,100}$", "Almacenado Envasado", "Almacenado Envasado es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(nombreComercial, "^[^\\n]{1,100}$", "Nombre Comercial", "Nombre Comercial es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(presentacion, "^[^\\n]{0,100}$", "Presentacion", "Presentacion es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(numeroDeIdentificacion, "^[^\\n]{0,50}$", "Numero De Identificacion", "Numero De Identificacion es invalido(a), puede usar hasta 50 caractes alfabeticos")
                || !validador.validarConRegex(grupoDeRiesgo, "^[^\\n]{0,100}$", "Grupo De Riesgo", "Grupo De Riesgo es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(precioEstimado, "[+-]?((\\d+\\.?\\d*)|(\\.\\d+))", "Precio Estimado", "Precio Estimado es invalido(a), puede usar punto(.) y numeros")
                || !validador.validarConRegex(unidad, "^[^\\n]{0,10}$", "Unidad", "Unidad es invalido(a), puede usar hasta 10 caractes alfabeticos")
                || !validador.validarConRegex(proveedor, "^[^\\n]{0,50}$", "Proveedor", "Proveedor es invalido(a), puede usar hasta 50 caractes alfabeticos")
                || !validador.validarConRegex(nombreProducto, "^[^\\n]{1,50}$", "Nombre Producto", "Nombre Producto es invalido(a), puede usar hasta 50 caractes alfabeticos")
                /*TODO: Validar con radio botton poseeMSD*/
                || !validador.validarConRegex(inventarioExistente, "^[1-9][0-9]{0,5}(\\.[0-9]{1,2})?$", "Inventario Existente", "Inventario Existente es invalido(a), puede ser hasta de 0 a 999999")
                || !validador.validarConRegex(observaciones, "^[^\\n]{0,100}$", "Observaciones", "Observaciones es invalido(a), puede usar hasta 100 caractes alfabeticos")) {
            return false;
        } else {
            float precioEstimadoAux;
            int inventarioExistenteAux;

            try {
                precioEstimadoAux = Float.parseFloat(precioEstimado);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Precio ingresado invalido", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            try {
                inventarioExistenteAux = Integer.parseInt(inventarioExistente);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Existencias invalidas", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            SustanciaQuimica sustanciaAux = new SustanciaQuimica(formulaQuimica, concentracion, presentacion, nombreComercial, poseeMSD, numeroDeIdentificacion, grupoDeRiesgo, fraseR, fraseS, metodoDeControl, permisos, unidad, precioEstimadoAux, proveedor, almacenadoEnvasado, nombreProducto, inventarioExistenteAux, observaciones, idLaboratorio);
            guardarEnFirebase(sustanciaAux);
            listaDeTransacciones.guardarEnFirebase(new Transaccion(sustanciaAux, user, "Crear Sustancia Química"));
            return true;
        }
    }

    //Listar un equipo con un ID
    public SustanciaQuimica listarSustanciaQuimica(String id) throws ParseException {
        for (SustanciaQuimica i : getListaSustanciasQuimicas()) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    //Listar un equipo con un Usuario
    public ArrayList<SustanciaQuimica> listarEquipoPorUsuario(Usuario usuario) throws ParseException {
        ArrayList<SustanciaQuimica> listaSustanciaQuimicasAux = new ArrayList<>();
        if (usuario.getRolUsuario().equals("Tecnico")) {
            ListaLaboratorios listaLabs = new ListaLaboratorios();
            String idLaboratorio = listaLabs.getLaboratorioConUsuario(usuario.getId());

            for (SustanciaQuimica i : getListaSustanciasQuimicas()) {
                if (idLaboratorio.equals(i.getLaboratorio())) {
                    listaSustanciaQuimicasAux.add(i);
                }
            }
            return listaSustanciaQuimicasAux;
        } else {
            return getListaSustanciasQuimicas();
        }
    }

    //Listar un equipo con un nombre de Equipo
    public ArrayList<SustanciaQuimica> listarSustanciaQuimicaPorDato(Usuario usuario, String datoDeSustanciaQuimica) throws ParseException {
        ArrayList<SustanciaQuimica> listaSustanciaQuimicaAux = listarEquipoPorUsuario(usuario); //Lista del usuario
        ArrayList<SustanciaQuimica> listaSustanciaQuimicaFiltrada = new ArrayList<>(); //Lista a retornar
        for (SustanciaQuimica i : listaSustanciaQuimicaAux) {
            if (i.getNombreProducto().toLowerCase().equals(datoDeSustanciaQuimica.toLowerCase())
                    || i.getLaboratorio().toLowerCase().equals(datoDeSustanciaQuimica.toLowerCase())
                    || i.getId().toLowerCase().equals(datoDeSustanciaQuimica.toLowerCase())
                    || i.getFormulaQuimica().toLowerCase().equals(datoDeSustanciaQuimica.toLowerCase())
                    || i.getPresentacion().toLowerCase().equals(datoDeSustanciaQuimica.toLowerCase())) {
                listaSustanciaQuimicaFiltrada.add(i);  
            }
        }
        return listaSustanciaQuimicaFiltrada;
    }

    //Modifica Equipos
    public boolean modificarSustancia(Usuario user, String id, String formulaQuimica, String concentracion, String presentacion, String nombreComercial, Boolean poseeMSD, String numeroDeIdentificacion, String grupoDeRiesgo, String fraseR, String fraseS, String metodoDeControl, String permisos, String unidad, String precioEstimado, String proveedor, String almacenadoEnvasado, String nombreProducto, String inventarioExistente, String observaciones, String idLaboratorio) {
        Validador validador = new Validador();
        if (!validador.validarConRegex(formulaQuimica, "^[^\\n]{0,100}$", "Formula Quimica", "Formula Quimica es invalido(a), puede usar hasta 100 caractes alfanumericos")
                || !validador.validarConRegex(concentracion, "^[^\\n]{0,100}$", "Concentracion", "Concentracion es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(fraseR, "^[^\\n]{0,100}$", "Frase R", "Frase R es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(fraseS, "^[^\\n]{0,100}$", "Frase S", "Frase S es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(metodoDeControl, "^[^\\n]{0,100}$", "Metodo De Control", "Metodo De Control es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(permisos, "^[^\\n]{0,100}$", "Permisos", "Permisos es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(almacenadoEnvasado, "^[^\\n]{0,100}$", "Almacenado Envasado", "Almacenado Envasado es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(nombreComercial, "^[^\\n]{5,100}$", "Nombre Comercial", "Nombre Comercial es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(presentacion, "^[^\\n]{0,100}$", "Presentacion", "Presentacion es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(numeroDeIdentificacion, "^[^\\n]{0,50}$", "Numero De Identificacion", "Numero De Identificacion es invalido(a), puede usar hasta 50 caractes alfabeticos")
                || !validador.validarConRegex(grupoDeRiesgo, "^[^\\n]{0,100}$", "Grupo De Riesgo", "Grupo De Riesgo es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(precioEstimado, "[+-]?((\\d+\\.?\\d*)|(\\.\\d+))", "Precio Estimado", "Precio Estimado es invalido(a), puede usar punto(.) y numeros")
                || !validador.validarConRegex(unidad, "^[^\\n]{0,10}$", "Unidad", "Unidad es invalido(a), puede usar hasta 10 caractes alfabeticos")
                || !validador.validarConRegex(proveedor, "^[^\\n]{0,50}$", "Proveedor", "Proveedor es invalido(a), puede usar hasta 50 caractes alfabeticos")
                || !validador.validarConRegex(nombreProducto, "^[^\\n]{5,50}$", "Nombre Producto", "Nombre Producto es invalido(a), puede usar hasta 50 caractes alfabeticos")
                /*TODO: Validar con radio botton poseeMSD*/
                || !validador.validarConRegex(inventarioExistente, "^[1-9][0-9]{0,5}(\\.[0-9]{1,2})?$", "Inventario Existente", "Inventario Existente es invalido(a), puede ser hasta de 0 a 999999")
                || !validador.validarConRegex(observaciones, "^[^\\n]{0,100}$", "Observaciones", "Observaciones es invalido(a), puede usar hasta 100 caractes alfabeticos")) {
            return false;
        } else {
            float precioEstimadoAux;
            int inventarioExistenteAux;

            try {
                precioEstimadoAux = Float.parseFloat(precioEstimado);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Precio ingresado invalido", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            try {
                inventarioExistenteAux = Integer.parseInt(inventarioExistente);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Existencias invalidas", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            SustanciaQuimica sustanciaAux = new SustanciaQuimica(formulaQuimica, concentracion, presentacion, nombreComercial, poseeMSD, numeroDeIdentificacion, grupoDeRiesgo, fraseR, fraseS, metodoDeControl, permisos, unidad, precioEstimadoAux, proveedor, almacenadoEnvasado, nombreProducto, inventarioExistenteAux, observaciones, idLaboratorio);
            sustanciaAux.setId(id);
            actualizarEnFirebase(sustanciaAux);
            listaDeTransacciones.guardarEnFirebase(new Transaccion(sustanciaAux, user, "Modificar Sustancia Quimica"));
            return true;
        }
    }

    //Eliminar Equipos
    public boolean eliminarSustanciaQuimica(Usuario user, String id) {
        try {
            SustanciaQuimica sustancia = listarSustanciaQuimica(id);
            eliminarEnFirebase(id);
            listaDeTransacciones.guardarEnFirebase(new Transaccion(sustancia, user, "Eliminar Sustancia Química"));
            return true;
        } catch (Exception e) {
            System.out.println("Error" + e);
            return false;
        }
    }
}
