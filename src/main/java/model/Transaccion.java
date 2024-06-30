package model;

import java.util.UUID;
import static model.Laboratorio.generarUUID;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

public class Transaccion {

    public Equipo equipo;
    public Insumo insumo;
    public SustanciaQuimica sustanciaQuimica;
    public String fecha;
    public Usuario user;
    public String id;
    public String tipoDeTransaccion;

    public static final String generarUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public Transaccion(SustanciaQuimica sustanciaQuimica, Usuario user, String tipoDeTransaccion) {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.fecha = myDateObj.format(myFormatObj);
        this.sustanciaQuimica = sustanciaQuimica;
        this.equipo = null;
        this.insumo = null;
        this.user = user;
        this.id = generarUUID();
        this.tipoDeTransaccion = tipoDeTransaccion;
    }

    public Transaccion(Insumo insumo, Usuario user, String tipoDeTransaccion) {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.fecha = myDateObj.format(myFormatObj);
        this.insumo = insumo;
        this.sustanciaQuimica = null;
        this.equipo = null;
        this.user = user;
        this.id = generarUUID();
        this.tipoDeTransaccion = tipoDeTransaccion;
    }

    public Transaccion(Equipo equipo, Usuario user, String tipoDeTransaccion) {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.fecha = myDateObj.format(myFormatObj);
        this.equipo = equipo;
        this.sustanciaQuimica = null;
        this.insumo = null;
        this.user = user;
        this.id = generarUUID();
        this.tipoDeTransaccion = tipoDeTransaccion;
    }

    public String getTipoDeTransaccion() {
        return tipoDeTransaccion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public SustanciaQuimica getSustanciaQuimica() {
        return sustanciaQuimica;
    }

    public String getFecha() {
        return fecha;
    }

    public Usuario getUser() {
        return user;
    }

    public String getId() {
        return id;
    }

    public void setTipoDeTransaccion(String tipoDeTransaccion) {
        this.tipoDeTransaccion = tipoDeTransaccion;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public void setSustanciaQuimica(SustanciaQuimica sustanciaQuimica) {
        this.sustanciaQuimica = sustanciaQuimica;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public void setId(String id) {
        this.id = id;
    }

}
