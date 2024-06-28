package model;

public class SustanciaQuimica extends Producto{

    String formulaQuimica;
    String concentracion;
    String presentacion;
    String nombreComercial;
    Boolean poseeMSD;
    String numeroDeIdentificacion;
    String grupoDeRiesgo;
    String fraseR;
    String fraseS;
    String metodoDeControl;
    String permisos;
    String unidad;
    float precioEstimado;
    String proveedor;
    String almacenadoEnvasado;

    public SustanciaQuimica(String formulaQuimica, String concentracion, String presentacion, String nombreComercial, Boolean poseeMSD, String numeroDeIdentificacion, String grupoDeRiesgo, String fraseR, String fraseS, String metodoDeControl, String permisos, String unidad, float precioEstimado, String proveedor, String almacenadoEnvasado, String codigo, String nombreProducto, int inventarioExistente, String observaciones, String idLaboratorio) {
        super(nombreProducto, "Sustancia quimica", inventarioExistente, observaciones, idLaboratorio);
        this.formulaQuimica = formulaQuimica;
        this.concentracion = concentracion;
        this.presentacion = presentacion;
        this.nombreComercial = nombreComercial;
        this.poseeMSD = poseeMSD;
        this.numeroDeIdentificacion = numeroDeIdentificacion;
        this.grupoDeRiesgo = grupoDeRiesgo;
        this.fraseR = fraseR;
        this.fraseS = fraseS;
        this.metodoDeControl = metodoDeControl;
        this.permisos = permisos;
        this.unidad = unidad;
        this.precioEstimado = precioEstimado;
        this.proveedor = proveedor;
        this.almacenadoEnvasado = almacenadoEnvasado;
    }

    public String getFormulaQuimica() {
        return formulaQuimica;
    }

    public String getConcentracion() {
        return concentracion;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public Boolean getPoseeMSD() {
        return poseeMSD;
    }

    public String getNumeroDeIdentificacion() {
        return numeroDeIdentificacion;
    }

    public String getGrupoDeRiesgo() {
        return grupoDeRiesgo;
    }

    public String getFraseR() {
        return fraseR;
    }

    public String getFraseS() {
        return fraseS;
    }

    public String getMetodoDeControl() {
        return metodoDeControl;
    }

    public String getPermisos() {
        return permisos;
    }

    public String getUnidad() {
        return unidad;
    }

    public float getPrecioEstimado() {
        return precioEstimado;
    }

    public String getProveedor() {
        return proveedor;
    }

    public String getAlmacenadoEnvasado() {
        return almacenadoEnvasado;
    }

    public void setFormulaQuimica(String formulaQuimica) {
        this.formulaQuimica = formulaQuimica;
    }

    public void setConcentracion(String concentracion) {
        this.concentracion = concentracion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public void setPoseeMSD(Boolean poseeMSD) {
        this.poseeMSD = poseeMSD;
    }

    public void setNumeroDeIdentificacion(String numeroDeIdentificacion) {
        this.numeroDeIdentificacion = numeroDeIdentificacion;
    }

    public void setGrupoDeRiesgo(String grupoDeRiesgo) {
        this.grupoDeRiesgo = grupoDeRiesgo;
    }

    public void setFraseR(String fraseR) {
        this.fraseR = fraseR;
    }

    public void setFraseS(String fraseS) {
        this.fraseS = fraseS;
    }

    public void setMetodoDeControl(String metodoDeControl) {
        this.metodoDeControl = metodoDeControl;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public void setPrecioEstimado(float precioEstimado) {
        this.precioEstimado = precioEstimado;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public void setAlmacenadoEnvasado(String almacenadoEnvasado) {
        this.almacenadoEnvasado = almacenadoEnvasado;
    }

}
