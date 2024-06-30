package controller;

import firebase.Conexion;
import firebase.GeneralProvider;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import model.SustanciaQuimica;
import model.Transaccion;
import model.TransaccionDeTabla;
import model.Usuario;

public class ListaDeTransacciones {

    ArrayList<TransaccionDeTabla> listaTransacciones = new ArrayList<>();

    public ArrayList<TransaccionDeTabla> getListaTransacciones() throws ParseException {
        listaTransacciones = GeneralProvider.cargarInfoTransacciones();
        return listaTransacciones;
    }

    public boolean guardarEnFirebase(Transaccion transaccion) {
        try {
            Map<String, Object> datos = new HashMap<>();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            datos.put("username", String.valueOf(transaccion.user.getUsername()));
            datos.put("nombreCompleto", String.valueOf(transaccion.user.getNombreUser()));
            if (transaccion.insumo != null) {
                datos.put("descripcion", String.valueOf(transaccion.insumo.getDescripcion()));
                datos.put("marca", String.valueOf(transaccion.insumo.getMarca()));
                datos.put("modelo", String.valueOf(transaccion.insumo.getModelo()));
                datos.put("presentacion", String.valueOf(transaccion.insumo.getPresentacion()));
                datos.put("clasificacion", String.valueOf(transaccion.insumo.getClasificacion()));
                datos.put("categoria", String.valueOf(transaccion.insumo.getCategoria()));
                datos.put("ultimaCompra", String.valueOf(dateFormat.format(transaccion.insumo.getUltimaCompra())));
                datos.put("precioEstimado", String.valueOf(transaccion.insumo.getPrecioEstimado()));
                datos.put("unidad", String.valueOf(transaccion.insumo.getUnidad()));
                datos.put("proveedor", String.valueOf(transaccion.insumo.getProveedor()));
                datos.put("nombreProducto", String.valueOf(transaccion.insumo.getNombreProducto()));
                datos.put("existencias", String.valueOf(transaccion.insumo.getInventarioExistente()));
                datos.put("observaciones", String.valueOf(transaccion.insumo.getObservaciones()));
                datos.put("idLaboratorio", String.valueOf(transaccion.insumo.getLaboratorio()));
            } else if (transaccion.equipo != null) {
                datos.put("descripcion", String.valueOf(transaccion.equipo.getDescripcion()));
                datos.put("marca", String.valueOf(transaccion.equipo.getMarca()));
                datos.put("modelo", String.valueOf(transaccion.equipo.getModelo()));
                datos.put("numeroSerial", String.valueOf(transaccion.equipo.getNumeroSerial()));
                datos.put("numeroActivo", String.valueOf(transaccion.equipo.getNumeroActivo()));
                datos.put("presentacion", String.valueOf(transaccion.equipo.getPresentacion()));
                datos.put("voltaje", String.valueOf(transaccion.equipo.getVoltaje()));
                datos.put("procesable", String.valueOf(transaccion.equipo.getProcesable()));
                datos.put("materialRequerido", String.valueOf(transaccion.equipo.getMaterialRequerido()));
                datos.put("añoDeCompraAux", String.valueOf(dateFormat.format(transaccion.equipo.getAñoDeCompra())));
                datos.put("aplicacion", String.valueOf(transaccion.equipo.getAplicacion()));
                datos.put("ultimoMantenimientoAux", String.valueOf(dateFormat.format(transaccion.equipo.getUltimoMantenimiento())));
                datos.put("proximoMantenimientoAux", String.valueOf(dateFormat.format(transaccion.equipo.getProximoMantenimiento())));
                datos.put("ultimaCalibracionAux", String.valueOf(dateFormat.format(transaccion.equipo.getUltimaCalibracion())));
                datos.put("proximaCalibracionAux", String.valueOf(dateFormat.format(transaccion.equipo.getProximaCalibracion())));
                datos.put("proovedoresDeServicios", String.valueOf(transaccion.equipo.getProovedoresDeServicios()));
                datos.put("encendidoDenoche", String.valueOf(transaccion.equipo.getEncendidoDenoche()));
                datos.put("nombreProducto", String.valueOf(transaccion.equipo.getNombreProducto()));
                datos.put("inventarioExistente", String.valueOf(transaccion.equipo.getInventarioExistente()));
                datos.put("observaciones", String.valueOf(transaccion.equipo.getObservaciones()));
                datos.put("idLaboratorio", String.valueOf(transaccion.equipo.getLaboratorio()));
            } else if (transaccion.sustanciaQuimica != null) {
                datos.put("formulaQuimica", String.valueOf(transaccion.sustanciaQuimica.getFormulaQuimica()));
                datos.put("concentracion", String.valueOf(transaccion.sustanciaQuimica.getConcentracion()));
                datos.put("presentacion", String.valueOf(transaccion.sustanciaQuimica.getPresentacion()));
                datos.put("nombreComercial", String.valueOf(transaccion.sustanciaQuimica.getNombreComercial()));
                datos.put("poseeMSD", String.valueOf(transaccion.sustanciaQuimica.getPoseeMSD()));
                datos.put("numeroDeIdentificacion", String.valueOf(transaccion.sustanciaQuimica.getNumeroDeIdentificacion()));
                datos.put("grupoDeRiesgo", String.valueOf(transaccion.sustanciaQuimica.getGrupoDeRiesgo()));
                datos.put("fraseR", String.valueOf(transaccion.sustanciaQuimica.getFraseR()));
                datos.put("fraseS", String.valueOf(transaccion.sustanciaQuimica.getFraseS()));
                datos.put("metodoDeControl", String.valueOf(transaccion.sustanciaQuimica.getMetodoDeControl()));
                datos.put("permisos", String.valueOf(transaccion.sustanciaQuimica.getPermisos()));
                datos.put("unidad", String.valueOf(transaccion.sustanciaQuimica.getUnidad()));
                datos.put("precioEstimado", String.valueOf(transaccion.sustanciaQuimica.getPrecioEstimado()));
                datos.put("proveedor", String.valueOf(transaccion.sustanciaQuimica.getProveedor()));
                datos.put("almacenadoEnvasado", String.valueOf(transaccion.sustanciaQuimica.getAlmacenadoEnvasado()));
                datos.put("nombreProducto", String.valueOf(transaccion.sustanciaQuimica.getNombreProducto()));
                datos.put("inventarioExistente", String.valueOf(transaccion.sustanciaQuimica.getInventarioExistente()));
                datos.put("observaciones", String.valueOf(transaccion.sustanciaQuimica.getObservaciones()));
                datos.put("idLaboratorio", String.valueOf(transaccion.sustanciaQuimica.getLaboratorio()));
            }
            datos.put("fecha", String.valueOf(transaccion.getFecha()));
            datos.put("tipoDeTransaccion", String.valueOf(transaccion.getTipoDeTransaccion()));
            GeneralProvider.guardar("Transacciones", String.valueOf(transaccion.getId()), datos);
            return true;
        } catch (Exception e) {
            System.out.println("Error al guardar controller: " + e.getMessage());
            return false;
        }
    }

}
