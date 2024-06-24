package model;

import java.util.UUID;

public class Producto {

    String codigo;
    String nombreProducto;
    String tipoDeProducto;
    int inventarioExistente;
    String observaciones;
    Laboratorio laboratorio;
    String id;

    public static final String generarUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public Producto(String codigo, String nombreProducto, String tipoDeProducto, int inventarioExistente, String observaciones, Laboratorio laboratorio) {
        this.codigo = codigo;
        this.nombreProducto = nombreProducto;
        this.tipoDeProducto = tipoDeProducto;
        this.inventarioExistente = inventarioExistente;
        this.observaciones = observaciones;
        this.laboratorio = laboratorio;
        this.id = generarUUID();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
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

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public void necesitaCompra() {
        //TODO: Añadir logica de necesita compra;
    }
}
