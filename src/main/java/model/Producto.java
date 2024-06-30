package model;

import java.util.UUID;

public class Producto {
    String nombreProducto;
    String tipoDeProducto;
    int inventarioExistente;
    String observaciones;
    String idLaboratorio;
    String id;

    public static final String generarUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public Producto(String nombreProducto, String tipoDeProducto, int inventarioExistente, String observaciones, String idLaboratorio) {
        this.nombreProducto = nombreProducto;
        this.tipoDeProducto = tipoDeProducto;
        this.inventarioExistente = inventarioExistente;
        this.observaciones = observaciones;
        this.idLaboratorio = idLaboratorio;
        this.id = generarUUID();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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

    public String getLaboratorio() {
        return idLaboratorio;
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

    public void setLaboratorio(String idLboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public void necesitaCompra() {
        //TODO: Añadir logica de necesita compra;
    }
}
