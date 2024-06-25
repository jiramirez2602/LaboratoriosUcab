package main;

import controller.ListaDeUsuarios;
import firebase.Conexion;
import java.util.ArrayList;
import model.Usuario;

public class Main {

    public static void main(String[] args) {
        System.out.println("hola mundo");
        Conexion.conectarFirebase();
        ArrayList<String> privilegios = new ArrayList<>();
        privilegios.add("Laboratorios");
        privilegios.add("Usuarios");
        privilegios.add("Productos");
        privilegios.add("Transacciones");
        Usuario administradorLaboratorio = new Usuario("Harry1", "1234", "Harry Castellanos", privilegios, "administrador", Boolean.TRUE);

        ListaDeUsuarios lista1 = new ListaDeUsuarios();
        //lista1.crearUsuario(administradorLaboratorio, "paula", "1234", "paula sfia", privilegios, "admin", "true");
        //lista1.actualizarUsuario(administradorLaboratorio, "d1db1ffb-1300-4f4b-812f-fed7abee5c20", "Jorge", "4321", "Jorge Ramirez", privilegios, "administrador", "true");
        //lista1.eliminarUsuario(administradorLaboratorio, "caad584c-fac5-491b-aadf-0fed4bf48185");
    }
}
