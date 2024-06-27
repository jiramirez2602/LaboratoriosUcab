package model;

import java.util.ArrayList;
import java.util.UUID;
import javax.swing.JOptionPane;

public class Usuario {
    private String username;
    private String contrasena;
    private String nombreUser;
    private String rolUsuario;
    private String status;
    private String id;

    public static final String generarUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
    
    public Usuario(String username, String contrasena, String nombreUser,String rolUsuario,String status) {
        this.username = username;
        this.contrasena = contrasena;
        this.nombreUser = nombreUser;
        this.rolUsuario = rolUsuario;
        this.status = status;
        this.id=generarUUID();
    }

    public String getUsername() {
        return username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public String getStatus() {
        return status;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }

    public Object getNombreCompleto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public boolean verificarRol(Usuario user,String rol){
        boolean retornar=false;
        if(user.getRolUsuario().equals(rol)){
            retornar=true;
        }
        if(retornar==false){
            JOptionPane.showMessageDialog(null,"No tienes acceso a este modulo", "Error", JOptionPane.ERROR_MESSAGE);
            return retornar;
        }
        return retornar;
    }
       
}
