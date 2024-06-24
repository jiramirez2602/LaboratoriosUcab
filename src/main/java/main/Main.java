package main;

import controller.ListaDeUsuarios;
import firebase.Conexion;
import java.util.ArrayList;
import model.Usuario;


public class Main {
    public static void main(String[] args) {
        System.out.println("hola mundo");
        Conexion.conectarFirebase();
        ArrayList<String> privilegios=new ArrayList<>();
        privilegios.add("Laboratorios");
        privilegios.add("Usuarios");
        privilegios.add("Productos");
        privilegios.add("Transacciones");
        Usuario administradorLaboratorio = new Usuario("Harry1", "1234", "Harry Castellanos", privilegios, "administrador", true);
        
        ListaDeUsuarios lista1 = new ListaDeUsuarios();
        lista1.crearUsuario(administradorLaboratorio, "paula", "1234", "paula sfia", privilegios, "admin", "true");
    }
}
