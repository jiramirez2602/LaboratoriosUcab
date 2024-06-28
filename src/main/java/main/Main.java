package main;

import controller.ListaDeUsuarios;
import controller.ListaLaboratorios;
import firebase.Conexion;
import java.util.ArrayList;
import model.Laboratorio;
import model.Usuario;

public class Main {

    public static void main(String[] args) {
        Conexion.conectarFirebase();
        Usuario administradorLaboratorio = new Usuario("Harry1", "1234", "Harry Castellanos", "administrador", "Activo");

        /*
        ListaDeUsuarios lista1 = new ListaDeUsuarios();
        lista1.crearUsuario(administradorLaboratorio, "Harry1", "1234", "Harry Castellanos", "administrador", "Activo");
        //lista1.actualizarUsuario(administradorLaboratorio, "fe8d07e3-2d90-4a6b-bc03-0dc5cb49090a", "Jorge", "4321", "Jorge Ramirez", privilegios, "administrador", "true");
        //lista1.eliminarUsuario(administradorLaboratorio, "469838e0-d985-4558-aaab-5bf154201942");
        //lista1.getListaUsuarios();

       //Iteramos para ejemplificar:
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios = lista1.getListaUsuarios();
        listaUsuarios.forEach(elemento -> {
            System.out.println(elemento.getId());
        });
         */
        //Laboratorios:
        ListaLaboratorios lista2 = new ListaLaboratorios();
        //lista2.crearLaboratorio(administradorLaboratorio, "Sanitaria", "Ingeniería", "Industrial", "Facultad", "1d8e2ce3-c5d9-4eae-96e8-6bfc519521f6");
        //lista2.modificarLaboratorio(administradorLaboratorio, "64ddd118-e6b5-4ecd-8db8-f8715f50188b", "Hidraulica", "Ingeniería", "Civil", "Materiales", "1d8e2ce3-c5d9-4eae-96e8-6bfc519521f6");
        //lista2.eliminarLaboratorio(administradorLaboratorio, "d53f07ba-cd3c-40f6-b0dc-a3fd7be92d7f");
        //lista2.getListaLaboratorios();

        //Iteramos para ejemplificar:
        ArrayList<Laboratorio> listaLaboratorios = new ArrayList<>();
        listaLaboratorios = lista2.getListaLaboratorios();
        listaLaboratorios.forEach(elemento -> {
            System.out.println(elemento.getId());
            System.out.println(elemento.getNombreLaboratorio());

        });

    }
}
