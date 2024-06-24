package model;

import java.util.Date;

public class Insumo extends Producto{
    String descripcion;
    String marca;
    String modelo;
    String presentacion;
    String clasificacion;
    String categoria;
    Date ultimaCompra;
    float precioEstimado;
    String unidad;
    String proveedor;

    public Insumo(String descripcion, String marca, String modelo, String presentacion, String clasificacion, String categoria, Date ultimaCompra, float precioEstimado, String unidad, String proveedor, String codigo, String nombreProducto, int inventarioExistente, String observaciones, String laboratorio) {
        super(codigo, nombreProducto, "Insumo", inventarioExistente, observaciones, laboratorio);
        this.descripcion = descripcion;
        this.marca = marca;
        this.modelo = modelo;
        this.presentacion = presentacion;
        this.clasificacion = clasificacion;
        this.categoria = categoria;
        this.ultimaCompra = ultimaCompra;
        this.precioEstimado = precioEstimado;
        this.unidad = unidad;
        this.proveedor = proveedor;
    }

   

    public String getDescripcion() {
        return descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public Date getUltimaCompra() {
        return ultimaCompra;
    }

    public float getPrecioEstimado() {
        return precioEstimado;
    }

    public String getUnidad() {
        return unidad;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setUltimaCompra(Date ultimaCompra) {
        this.ultimaCompra = ultimaCompra;
    }

    public void setPrecioEstimado(float precioEstimado) {
        this.precioEstimado = precioEstimado;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
    
}
