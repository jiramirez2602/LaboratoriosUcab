package main;

//import controller.ListaDeUsuarios;
//import firebase.Conexion;
import controller.ListaDeUsuarios;
import firebase.Conexion;
import java.util.ArrayList;
import model.Usuario;

public class Main {

    public static void main(String[] args) {
        //Creo un array de privilegios para el ejemplo
        ArrayList<String> privilegios = new ArrayList<>();
        privilegios.add("Laboratorios");
        privilegios.add("Usuarios");
        privilegios.add("Productos");
        privilegios.add("Transacciones");

        //Creo un usaurio para simular que ya alguien inició sesión
        Usuario userLogeado = new Usuario("Harry", "1234", "HarryCatellanos", privilegios, "administrador", true);

        //Conectar a la base de datos:
        Conexion.conectarFirebase();

        //Creo ahora un usuario con el controlador como se hara en produccion
        ListaDeUsuarios listaUsers = new ListaDeUsuarios();
        listaUsers.crearUsuario(userLogeado, "Jorge", "123", "Jorge Ignacio Ramirez Millan", privilegios, "administrador", "true");
    }
}
