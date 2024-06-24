package model;

import java.util.Date;

public class Equipo extends Producto{
    String descripcion;
    String marca;
    String modelo;
    String numeroSerial;
    String numeroActivo;
    String presentacion;
    String voltaje;
    String procesable;
    String materialRequerido;
    Date añoDeCompra; 
    String aplicacion;
    Date ultimoMantenimiento;
    Date proximoMantenimiento;
    Date ultimaCalibracion;
    Date proximaCalibracion;
    String proovedoresDeServicios;
    Boolean encendidoDenoche;

    public Equipo(String descripcion, String marca, String modelo, String numeroSerial, String numeroActivo, String presentacion, String voltaje, String procesable, String materialRequerido, Date añoDeCompra, String aplicacion, Date ultimoMantenimiento, Date proximoMantenimiento, Date ultimaCalibracion, Date proximaCalibracion, String proovedoresDeServicios, Boolean encendidoDenoche, String codigo, String nombreProducto, int inventarioExistente, String observaciones, Laboratorio laboratorio) {
        super(codigo, nombreProducto, "Equipo", inventarioExistente, observaciones, laboratorio);
        this.descripcion = descripcion;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroSerial = numeroSerial;
        this.numeroActivo = numeroActivo;
        this.presentacion = presentacion;
        this.voltaje = voltaje;
        this.procesable = procesable;
        this.materialRequerido = materialRequerido;
        this.añoDeCompra = añoDeCompra;
        this.aplicacion = aplicacion;
        this.ultimoMantenimiento = ultimoMantenimiento;
        this.proximoMantenimiento = proximoMantenimiento;
        this.ultimaCalibracion = ultimaCalibracion;
        this.proximaCalibracion = proximaCalibracion;
        this.proovedoresDeServicios = proovedoresDeServicios;
        this.encendidoDenoche = encendidoDenoche;
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

    public String getNumeroSerial() {
        return numeroSerial;
    }

    public String getNumeroActivo() {
        return numeroActivo;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public String getVoltaje() {
        return voltaje;
    }

    public String getProcesable() {
        return procesable;
    }

    public String getMaterialRequerido() {
        return materialRequerido;
    }

    public Date getAñoDeCompra() {
        return añoDeCompra;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public Date getUltimoMantenimiento() {
        return ultimoMantenimiento;
    }

    public Date getProximoMantenimiento() {
        return proximoMantenimiento;
    }

    public Date getUltimaCalibracion() {
        return ultimaCalibracion;
    }

    public Date getProximaCalibracion() {
        return proximaCalibracion;
    }

    public String getProovedoresDeServicios() {
        return proovedoresDeServicios;
    }

    public Boolean getEncendidoDenoche() {
        return encendidoDenoche;
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

    public void setNumeroSerial(String numeroSerial) {
        this.numeroSerial = numeroSerial;
    }

    public void setNumeroActivo(String numeroActivo) {
        this.numeroActivo = numeroActivo;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public void setVoltaje(String voltaje) {
        this.voltaje = voltaje;
    }

    public void setProcesable(String procesable) {
        this.procesable = procesable;
    }

    public void setMaterialRequerido(String materialRequerido) {
        this.materialRequerido = materialRequerido;
    }

    public void setAñoDeCompra(Date añoDeCompra) {
        this.añoDeCompra = añoDeCompra;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public void setUltimoMantenimiento(Date ultimoMantenimiento) {
        this.ultimoMantenimiento = ultimoMantenimiento;
    }

    public void setProximoMantenimiento(Date proximoMantenimiento) {
        this.proximoMantenimiento = proximoMantenimiento;
    }

    public void setUltimaCalibracion(Date ultimaCalibracion) {
        this.ultimaCalibracion = ultimaCalibracion;
    }

    public void setProximaCalibracion(Date proximaCalibracion) {
        this.proximaCalibracion = proximaCalibracion;
    }

    public void setProovedoresDeServicios(String proovedoresDeServicios) {
        this.proovedoresDeServicios = proovedoresDeServicios;
    }

    public void setEncendidoDenoche(Boolean encendidoDenoche) {
        this.encendidoDenoche = encendidoDenoche;
    }
    
    public void calcularEdad(){
//        TODO:hacer codigo para calcular edad
    }
    public void necesitaMantenimiento(){
//        TODO:hacer codigo para notificar mantenimiento
    }
    public void necesitaCalibracion(){
//        TODO:hacer codigo para notificar Calibracion
    }    
}
