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
        Usuario administradorLaboratorio = new Usuario("Harry1", "1234", "Harry Castellanos", "administrador","Activo");

        ListaDeUsuarios lista1 = new ListaDeUsuarios();
        //lista1.crearUsuario(administradorLaboratorio, "paula", "1234", "paula sfia", privilegios, "admin", "true");
        //lista1.actualizarUsuario(administradorLaboratorio, "fe8d07e3-2d90-4a6b-bc03-0dc5cb49090a", "Jorge", "4321", "Jorge Ramirez", privilegios, "administrador", "true");
        //lista1.eliminarUsuario(administradorLaboratorio, "469838e0-d985-4558-aaab-5bf154201942");
        //lista1.getListaUsuarios();

       //Inteamos para ejemplificar:
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios = lista1.getListaUsuarios();
        listaUsuarios.forEach(elemento -> {
            System.out.println(elemento.getId());
        });
    }
}
