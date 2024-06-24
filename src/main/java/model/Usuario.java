package model;

import java.util.ArrayList;
import java.util.UUID;
import javax.swing.JOptionPane;

public class Usuario {
    private String username;
    private String contrasena;
    private String nombreUser;
    private ArrayList<String> privilegios;
    private String rolUsuario;
    private boolean status;
    private String id;

    public static final String generarUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
    
    public Usuario(String username, String contrasena, String nombreUser, ArrayList<String> privilegios, String rolUsuario, boolean status) {
        this.username = username;
        this.contrasena = contrasena;
        this.nombreUser = nombreUser;
        this.privilegios = privilegios;
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

    public ArrayList<String> getPrivilegios() {
        return privilegios;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public boolean isStatus() {
        return status;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPrivilegios(ArrayList<String> privilegios) {
        this.privilegios = privilegios;
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

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public Object getNombreCompleto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public boolean verificarPrivilegios(Usuario user,String privilegio){
        ArrayList<String> comprobarPrivi=user.getPrivilegios();
        boolean retornar=false;
        for(String recorrer:comprobarPrivi){
            if(recorrer.equals(privilegio)){
                retornar=true;
            }
        }
        if(retornar==false){
            JOptionPane.showMessageDialog(null,"No tienes acceso a este modulo", "Error", JOptionPane.ERROR_MESSAGE);
            return retornar;
        }
        return retornar;
    }
       
}
