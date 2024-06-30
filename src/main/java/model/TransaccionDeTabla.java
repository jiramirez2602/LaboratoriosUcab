package model;

import java.util.ArrayList;

public class TransaccionDeTabla {

    String nombreProducto;
    String tipoDeProducto;
    int inventarioExistente;
    String observaciones;
    String nombreLaboratorio;
    String fecha;
    String nombreCompleto;
    String id;
    String tipoDeTransaccion;

    public TransaccionDeTabla(String nombreProducto, String tipoDeProducto, int inventarioExistente, String observaciones, String nombreLaboratorio, String fecha, String nombreCompleto, String id, String tipoDeTransaccion) {
        this.nombreProducto = nombreProducto;
        this.tipoDeProducto = tipoDeProducto;
        this.inventarioExistente = inventarioExistente;
        this.observaciones = observaciones;
        this.nombreLaboratorio = nombreLaboratorio; //Sacar el nombre del id
        this.fecha = fecha;
        this.nombreCompleto = nombreCompleto;
        this.id = id;
        this.tipoDeTransaccion = tipoDeTransaccion;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getTipoDeProducto() {
        return tipoDeProducto;
    }

    public int getInventarioExistente() {
        return inventarioExistente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public String getNombreLaboratorio() {
        return nombreLaboratorio;
    }

    public String getFecha() {
        return fecha;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getId() {
        return id;
    }

    public String getTipoDeTransaccion() {
        return tipoDeTransaccion;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setTipoDeProducto(String tipoDeProducto) {
        this.tipoDeProducto = tipoDeProducto;
    }

    public void setInventarioExistente(int inventarioExistente) {
        this.inventarioExistente = inventarioExistente;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setNombreLaboratorio(String nombreLaboratorio) {
        this.nombreLaboratorio = nombreLaboratorio;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setNombreUsuario(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTipoDeTransaccion(String tipoDeTransaccion) {
        this.tipoDeTransaccion = tipoDeTransaccion;
    }
    
    
}
