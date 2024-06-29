package firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Precondition;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import controller.ListaDeUsuarios;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import model.Equipo;
import model.Insumo;
import model.Laboratorio;
import model.SustanciaQuimica;
import model.Usuario;

public class GeneralProvider {

    CollectionReference reference;
    static Firestore db;

    public static boolean guardar(String coleccion, String documento, Map<String, Object> data) {
        db = FirestoreClient.getFirestore();
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.set(data);
            System.out.println("Guardado correctamente");
            return true;
        } catch (Exception e) {
            System.out.println("Error al guardar provider: " + e.getMessage());
        }
        return false;

    }

    public static boolean actualizar(String coleccion, String documento, Map<String, Object> data) {
        db = FirestoreClient.getFirestore();
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.update(data);
            System.out.println("Actualizado correctamente");
            return true;
        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
        return false;

    }

    public static boolean eliminar(String coleccion, String documento) {
        db = FirestoreClient.getFirestore();
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.delete(Precondition.NONE);
            System.out.println("Eliminado correctamente");
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
        return false;

    }

    public static ArrayList<Usuario> cargarInfoUsuario() {
        //ListaDeUsuarios listaUsers = new ListaDeUsuarios();
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

        try {
            CollectionReference usuarios = Conexion.db.collection("Usuarios");
            ApiFuture<QuerySnapshot> querySnap = usuarios.get();
            for (DocumentSnapshot document : querySnap.get().getDocuments()) {
                /*Convertir a array list
                String s1 = document.getString("privilegios");
                String replace = s1.replace("[", "").replace("]", "");
                List<String> privileges = new ArrayList<>(Arrays.asList(replace.split(",")));*/

                //crear user cada vez con parse
                Usuario user = new Usuario(document.getString("username"), document.getString("contrasena"), document.getString("nombreCompleto"), document.getString("rol"), document.getString("estado"));
                user.setId(document.getId());

                //listaUsers.crearUsuarioLocal(user);
                listaUsuarios.add(user);
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error al obtener lista: " + e.getMessage());
        }
        return listaUsuarios;
    }

    public static ArrayList<Laboratorio> cargarInfoLaboratorios() {
        //ListaDeUsuarios listaUsers = new ListaDeUsuarios();
        ArrayList<Laboratorio> listaLaboratorios = new ArrayList<>();

        try {
            CollectionReference laboratorios = Conexion.db.collection("Laboratorios");
            ApiFuture<QuerySnapshot> querySnap = laboratorios.get();
            for (DocumentSnapshot document : querySnap.get().getDocuments()) {
                //crear user cada vez con parse
                Laboratorio labo = new Laboratorio(document.getString("nombreLaboratorio"), document.getString("facultad"), document.getString("escuela"), document.getString("departamento"), document.getString("administrador"));
                labo.setId(document.getId());

                //listaUsers.crearUsuarioLocal(user);
                listaLaboratorios.add(labo);
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error al obtener lista: " + e.getMessage());
        }
        return listaLaboratorios;
    }

    public static ArrayList<Equipo> cargarInfoEquipos() throws ParseException {
        //ListaDeUsuarios listaUsers = new ListaDeUsuarios();
        ArrayList<Equipo> listaEquipos = new ArrayList<>();

        try {
            CollectionReference equipos = Conexion.db.collection("Equipos");
            ApiFuture<QuerySnapshot> querySnap = equipos.get();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

            for (DocumentSnapshot document : querySnap.get().getDocuments()) {
                //crear user cada vez con parse

                Equipo equipo = new Equipo(document.getString("descripcion"),
                        document.getString("marca"),
                        document.getString("modelo"),
                        document.getString("numeroSerial"),
                        document.getString("numeroActivo"),
                        document.getString("presentacion"),
                        document.getString("voltaje"),
                        document.getString("procesable"),
                        document.getString("materialRequerido"),
                        formatter.parse(document.getString("añoDeCompraAux")),
                        document.getString("aplicacion"),
                        formatter.parse(document.getString("ultimoMantenimientoAux")),
                        formatter.parse(document.getString("proximoMantenimientoAux")),
                        formatter.parse(document.getString("ultimaCalibracionAux")),
                        formatter.parse(document.getString("proximaCalibracionAux")),
                        document.getString("proovedoresDeServicios"),
                        document.getString("encendidoDenoche"),
                        document.getString("nombreProducto"),
                        Integer.valueOf(document.getString("inventarioExistenteAux")),
                        document.getString("observaciones"),
                        document.getString("idLaboratorio")
                );
                equipo.setId(document.getId());

                //listaUsers.crearUsuarioLocal(user);
                listaEquipos.add(equipo);
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error al obtener lista: " + e.getMessage());
        }
        return listaEquipos;
    }

    public static ArrayList<SustanciaQuimica> cargarInfoSustancias() throws ParseException {
        ArrayList<SustanciaQuimica> listaSustancia = new ArrayList<>();

        try {
            CollectionReference sustanciaAux = Conexion.db.collection("SustanciasQuimicas");
            ApiFuture<QuerySnapshot> querySnap = sustanciaAux.get();

            for (DocumentSnapshot document : querySnap.get().getDocuments()) {
                //crear user cada vez con parse
                SustanciaQuimica sustancia = new SustanciaQuimica(document.getString("formulaQuimica"),
                        document.getString("concentracion"),
                        document.getString("presentacion"),
                        document.getString("nombreComercial"),
                        Boolean.valueOf(document.getString("poseeMSD")),
                        document.getString("numeroDeIdentificacion"),
                        document.getString("grupoDeRiesgo"),
                        document.getString("fraseR"),
                        document.getString("fraseS"),
                        document.getString("metodoDeControl"),
                        document.getString("permisos"),
                        document.getString("unidad"),
                        Float.parseFloat(document.getString("precioEstimado")),
                        document.getString("proveedor"),
                        document.getString("almacenadoEnvasado"),
                        document.getString("nombreProducto"),
                        Integer.valueOf(document.getString("inventarioExistente")),
                        document.getString("observaciones"),
                        document.getString("idLaboratorio")
                );
                sustancia.setId(document.getId());
                //listaUsers.crearUsuarioLocal(user);
                listaSustancia.add(sustancia);
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error al obtener lista: " + e.getMessage());
        }
        return listaSustancia;
    }

    public static ArrayList<Insumo> cargarInfoInsumos() throws ParseException {
        ArrayList<Insumo> listaInsumo = new ArrayList<>();

        try {
            CollectionReference insumoAux = Conexion.db.collection("Insumos");
            ApiFuture<QuerySnapshot> querySnap = insumoAux.get();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

            for (DocumentSnapshot document : querySnap.get().getDocuments()) {
                //crear user cada vez con parse

                Insumo insum = new Insumo(document.getString("descripcion"),
                        document.getString("marca"),
                        document.getString("modelo"),
                        document.getString("presentacion"),
                        document.getString("clasificacion"),
                        document.getString("categoria"),
                        formatter.parse(document.getString("ultimaCompra")),
                        Float.parseFloat(document.getString("precioEstimado")),
                        document.getString("unidad"),
                        document.getString("proveedor"),
                        document.getString("nombreProducto"),
                        Integer.valueOf(document.getString("existencias")),
                        document.getString("observaciones"),
                        document.getString("idLaboratorio")
                );
                insum.setId(document.getId());
                //listaUsers.crearUsuarioLocal(user);
                listaInsumo.add(insum);
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error al obtener lista: " + e.getMessage());
        }
        return listaInsumo;
    }
}
