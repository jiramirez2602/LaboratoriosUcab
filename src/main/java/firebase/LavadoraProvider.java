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
//import controller.ListaDeLavadoras;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutionException;
//import model.Lavadora;

public class LavadoraProvider {

    CollectionReference reference;
    static Firestore db;

    public static boolean guardarLavadora(String coleccion, String documento, Map<String, Object> data) {
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

    public static boolean actualizarLavadora(String coleccion, String documento, Map<String, Object> data) {
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

    public static boolean eliminarLavadora(String coleccion, String documento) {
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

    /*
    public static ArrayList<Lavadora> cargarInfoLavadora() {
        ListaDeLavadoras listaLav = new ListaDeLavadoras();
        try {
            CollectionReference lavadoras = Conexion.db.collection("Lavadoras");
            ApiFuture<QuerySnapshot> querySnap = lavadoras.get();
            for (DocumentSnapshot document : querySnap.get().getDocuments()) {
                listaLav.crearLavadoraLocal(document.getId(),
                        document.getString("precioBase"),
                        document.getString("color"),
                        document.getString("consumoEnergetico"),
                        document.getString("peso"),
                        document.getString("carga")
                );
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error al obtener: " + e.getMessage());
        }
        return listaLav.getListaLocal();
    }*/
}
