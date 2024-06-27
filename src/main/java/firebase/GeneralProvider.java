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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
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
                Usuario user = new Usuario(document.getString("username"), document.getString("contrasena"), document.getString("nombreCompleto"), document.getString("rol"),document.getString("estado"));
                user.setId(document.getId());
                
                //listaUsers.crearUsuarioLocal(user);
                listaUsuarios.add(user);
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error al obtener lista: " + e.getMessage());
        }
        return listaUsuarios;
    }
    /*
    public static ArrayList<Televisor> cargarInfoTelevisor() {
        ListaDeTelevisores listaTv = new ListaDeTelevisores();
        try {
            CollectionReference televisores = Conexion.db.collection("Televisores");
            ApiFuture<QuerySnapshot> querySnap = televisores.get();
            for (DocumentSnapshot document : querySnap.get().getDocuments()) {
                String TDT;
                if ("false".equals(document.getString("TDT"))) {
                    TDT = "No";
                } else {
                    TDT = "Si";
                }
                listaTv.crearTelevisorLocal(document.getId(),
                        document.getString("precioBase"),
                        document.getString("color"),
                        document.getString("consumoEnergetico"),
                        document.getString("peso"),
                        document.getString("pulgadas"),
                        TDT
                );
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error al obtener: " + e.getMessage());
        }
        return listaTv.getListaLocal();
    }*/
}
