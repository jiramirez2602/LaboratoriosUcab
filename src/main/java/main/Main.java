package main;

import controller.ListaDeEquipos;
import controller.ListaDeInsumos;
import controller.ListaDeSustanciasQuimicas;
import controller.ListaDeTransacciones;
import controller.ListaDeUsuarios;
import controller.ListaLaboratorios;
import firebase.Conexion;
import java.text.ParseException;
import java.util.ArrayList;
import model.Equipo;
import model.Insumo;
import model.Laboratorio;
import model.SustanciaQuimica;
import model.TransaccionDeTabla;
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
        //lista3.crearProductoEquipo(administradorLaboratorio, "Equipo importante", "GM", "ael-88g", "22fdfd-44", "233211", "Normal", "200 V", "true", "Nada", "26/02/2001", "No Aplica", "26/02/2001", "26/02/2030", "26/02/2020", "26/02/2024", "GM Latam", "Si", "Motor de vapor", "33", "No tengo observaciones", "af473a5b-ab43-4d1a-8bb1-b6f4cd5e392f");
       //lista3.modificarEquipo(administradorLaboratorio, "0a42753a-2f07-4491-8525-bb3d299227f9","Equipo actualizado", "GM actualizado", "ael-88g actualizado", "22fdfd-44 actualizado", "875", "Normal actualizado", "200 V actualizado", "false", "Nada actualizado", "26/02/2011", "No Aplica actualizado", "26/02/2011", "26/02/2033", "26/02/2022", "26/02/2044", "GM Latam actualizado", "true", "Motor de vapor actualizado", "44", "No tengo observaciones actualizado", "af473a5b-ab43-4d1a-8bb1-b6f4cd5e392f");
        //lista3.eliminarEquipo(administradorLaboratorio, "0a42753a-2f07-4491-8525-bb3d299227f9");
        //lista3.getListaEquipos();

//        //Iteramos para ejemplificar:
//        ArrayList<Equipo> listaEquiposAux = new ArrayList<>();
//        listaEquiposAux = lista3.getListaEquipos();
//
//        listaEquiposAux.forEach(elemento -> {
//            System.out.println(elemento.getId());
//            System.out.println(elemento.getNombreProducto());
//        });
         */
 /*
        //Sustancia Quimica:
        ListaDeSustanciasQuimicas lista4 = new ListaDeSustanciasQuimicas();
        //lista4.crearProductoSustanciaQuimica(administradorLaboratorio, "H2O", "100", "Liquida", "Agua", Boolean.TRUE, "aaiituktuk", "Riesgo es no tomarla", "NA", "NA", "Tuberias", "Hidro Capial", "ml", "100", "Estado", "Si", "Agua", "3", "No tengo Sed", "af473a5b-ab43-4d1a-8bb1-b6f4cd5e392f");
        //lista4.modificarSustancia(administradorLaboratorio,"50a4a4ee-1a6a-4eec-afa0-e6b590e5ce5c", "H2OO", "10", "Liquidax", "Aguax", Boolean.FALSE, "tuki", "Riesgo es no tomarlax", "NAx", "NAx", "Tuberiasx", "Hidro Capialx", "mlx", "1000", "Estadox", "Six", "Aguax", "22", "No tengo Sedx", "af473a5b-ab43-4d1a-8bb1-b6f4cd5e392f");
        //lista4.eliminarSustanciaQuimica(administradorLaboratorio, "0d4cee85-d774-45ce-9892-f449aa039518");
        //lista4.getListaSustanciasQuimicas();

        //Iteramos para ejemplificar:
        ArrayList<SustanciaQuimica> listaSustanciasAux = new ArrayList<>();
        listaSustanciasAux = lista4.getListaSustanciasQuimicas();

        listaSustanciasAux.forEach(elemento -> {
            System.out.println(elemento.getId());
            System.out.println(elemento.getNombreProducto());
        });
         */
 /*
        //Insumos
        ListaDeInsumos lista5 = new ListaDeInsumos();
        //lista5.crearProductoInsumo(administradorLaboratorio, "descripcion", "BlackAndDecker", "3000", "Acero", "Repuesto", "Taladros", "26/02/2001", "20", "Unidad", "Importadora Harry", "Punta de destornillador", "2", "Estan oxidados", "af473a5b-ab43-4d1a-8bb1-b6f4cd5e392f");
        //lista5.modificarInsumo(administradorLaboratorio, "85b92edb-f82c-4e4a-8924-8542bac5ba5a","descripcionx", "BlackAndDeckerx", "333", "Acerox", "Repuestox", "Taladrosx", "26/02/2011", "200", "Unidadx", "Importadora Harryx", "Punta de destornilladorx", "22", "Estan oxidadosx", "af473a5b-ab43-4d1a-8bb1-b6f4cd5e392f");
        //lista5.eliminarInsumo(administradorLaboratorio, "e30f4f3f-ffb0-4c1c-9101-a030a65f7efd");
        //lista5.getListaInsumos();

        //Iteramos para ejemplificar:
        ArrayList<Insumo> listaInsumosAux = new ArrayList<>();
        listaInsumosAux = lista5.getListaInsumos();

        listaInsumosAux.forEach(elemento -> {
            System.out.println(elemento.getId());
            System.out.println(elemento.getNombreProducto());
        });
         */
 /*
        //Transacciones
        ListaDeTransacciones lista6 = new ListaDeTransacciones();
        //lista6.getListaTransacciones();
        
        //Iteramos para ejemplificar:
        ArrayList<TransaccionDeTabla> listaTransacciones = new ArrayList<>();
        listaTransacciones = lista6.getListaTransacciones();

        listaTransacciones.forEach(elemento -> {
            System.out.println(elemento.getId());
            System.out.println(elemento.getNombreProducto());
        });*/
    }
}
