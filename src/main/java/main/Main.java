package main;

import controller.ListaDeEquipos;
import controller.ListaDeUsuarios;
import controller.ListaLaboratorios;
import firebase.Conexion;
import java.text.ParseException;
import java.util.ArrayList;
import model.Equipo;
import model.Laboratorio;
import model.Usuario;

public class Main {

    public static void main(String[] args) throws ParseException {
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
 /*
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
         */
 /*
        //Equipos
        ListaDeEquipos lista3 = new ListaDeEquipos();
        //lista3.crearProductoEquipo(administradorLaboratorio, "Equipo importante", "GM", "ael-88g", "22fdfd-44", "233211", "Normal", "200 V", "true", "Nada", "26/02/2001", "No Aplica", "26/02/2001", "26/02/2030", "26/02/2020", "26/02/2024", "GM Latam", true, "Motor de vapor", "33", "No tengo observaciones", "af473a5b-ab43-4d1a-8bb1-b6f4cd5e392f");
        //lista3.modificarEquipo(administradorLaboratorio, "0a42753a-2f07-4491-8525-bb3d299227f9","Equipo actualizado", "GM actualizado", "ael-88g actualizado", "22fdfd-44 actualizado", "875", "Normal actualizado", "200 V actualizado", "false", "Nada actualizado", "26/02/2011", "No Aplica actualizado", "26/02/2011", "26/02/2033", "26/02/2022", "26/02/2044", "GM Latam actualizado", true, "Motor de vapor actualizado", "44", "No tengo observaciones actualizado", "af473a5b-ab43-4d1a-8bb1-b6f4cd5e392f");
        //lista3.eliminarEquipo(administradorLaboratorio, "ede6013f-f7e4-44fc-9e94-9f13b4f48c72");
        //lista3.getListaEquipos();

        //Iteramos para ejemplificar:
        ArrayList<Equipo> listaEquiposAux = new ArrayList<>();
        listaEquiposAux = lista3.getListaEquipos();

        listaEquiposAux.forEach(elemento -> {
            System.out.println(elemento.getId());
            System.out.println(elemento.getNombreProducto());
        });
*/
    }
}
