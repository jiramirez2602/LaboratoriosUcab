package controller;

import firebase.GeneralProvider;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import model.Insumo;
import model.Laboratorio;
import model.Transaccion;
import model.Usuario;

public class ListaDeInsumos {

    ArrayList<Insumo> listaInsumos;
    ListaDeTransacciones listaDeTransacciones = new ListaDeTransacciones();

    //FIREBASE
    public boolean guardarEnFirebase(Insumo insumo) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Map<String, Object> datos = new HashMap<>();
            datos.put("descripcion", String.valueOf(insumo.getDescripcion()));
            datos.put("marca", String.valueOf(insumo.getMarca()));
            datos.put("modelo", String.valueOf(insumo.getModelo()));
            datos.put("presentacion", String.valueOf(insumo.getPresentacion()));
            datos.put("clasificacion", String.valueOf(insumo.getClasificacion()));
            datos.put("categoria", String.valueOf(insumo.getCategoria()));
            datos.put("ultimaCompra", String.valueOf(dateFormat.format(insumo.getUltimaCompra())));
            datos.put("precioEstimado", String.valueOf(insumo.getPrecioEstimado()));
            datos.put("unidad", String.valueOf(insumo.getUnidad()));
            datos.put("proveedor", String.valueOf(insumo.getProveedor()));
            datos.put("nombreProducto", String.valueOf(insumo.getNombreProducto()));
            datos.put("inventarioExistente", String.valueOf(insumo.getInventarioExistente()));
            datos.put("observaciones", String.valueOf(insumo.getObservaciones()));
            datos.put("idLaboratorio", String.valueOf(insumo.getLaboratorio()));
            GeneralProvider.guardar("Insumos", String.valueOf(insumo.getId()), datos);
            JOptionPane.showMessageDialog(null, "Guardado con exito");
            return true;
        } catch (Exception e) {
            System.out.println("Error al guardar controller: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarEnFirebase(Insumo insumo) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Map<String, Object> datos = new HashMap<>();
            datos.put("descripcion", String.valueOf(insumo.getDescripcion()));
            datos.put("marca", String.valueOf(insumo.getMarca()));
            datos.put("modelo", String.valueOf(insumo.getModelo()));
            datos.put("presentacion", String.valueOf(insumo.getPresentacion()));
            datos.put("clasificacion", String.valueOf(insumo.getClasificacion()));
            datos.put("categoria", String.valueOf(insumo.getCategoria()));
            datos.put("ultimaCompra", String.valueOf(dateFormat.format(insumo.getUltimaCompra())));
            datos.put("precioEstimado", String.valueOf(insumo.getPrecioEstimado()));
            datos.put("unidad", String.valueOf(insumo.getUnidad()));
            datos.put("proveedor", String.valueOf(insumo.getProveedor()));
            datos.put("nombreProducto", String.valueOf(insumo.getNombreProducto()));
            datos.put("inventarioExistente", String.valueOf(insumo.getInventarioExistente()));
            datos.put("observaciones", String.valueOf(insumo.getObservaciones()));
            datos.put("idLaboratorio", String.valueOf(insumo.getLaboratorio()));
            GeneralProvider.actualizar("Insumos", insumo.getId(), datos);
            JOptionPane.showMessageDialog(null, "Actualizado con exito");
            return true;
        } catch (Exception e) {
            System.out.println("Error al actualizar controller: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarEnFirebase(String id) {
        try {
            GeneralProvider.eliminar("Insumos", id);
            JOptionPane.showMessageDialog(null, "Eliminado con exito");
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Insumo> getListaInsumos() throws ParseException {
        listaInsumos = GeneralProvider.cargarInfoInsumos();
        return listaInsumos;
    }

    public void setListaEquipos(ArrayList<Insumo> listaEquipos) {
        this.listaInsumos = listaEquipos;
    }

    //Crear producto Insumo
    public boolean crearProductoInsumo(Usuario user, String descripcion, String marca, String modelo, String presentacion, String clasificacion, String categoria, String ultimaCompra, String precioEstimado, String unidad, String proveedor, String nombreProducto, String inventarioExistente, String observaciones, String idLaboratorio) {
        Validador validador = new Validador();

        if (!validador.validarConRegex(descripcion, "^[^\\n]{0,100}$", "Descripcion", "Descripcion es invalido(a), puede usar hasta 100 caractes alfanumericos")
                || !validador.validarConRegex(marca, "^[^\\n]{0,100}$", "Marca", "Marca es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(modelo, "^[^\\n]{1,100}$", "Modelo", "Modelo es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(presentacion, "^[^\\n]{0,100}$", "Presentacion", "Presentacion es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(clasificacion, "^[^\\n]{0,100}$", "Clasificacion", "Clasificacion es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(categoria, "^[^\\n]{0,100}$", "Categoria", "Categoria es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(ultimaCompra, "^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$", "Ultima Compra", "Ultima Compra es invalido(a), use el formato dd/mm/yyyy")
                || !validador.validarConRegex(precioEstimado, "[+-]?((\\d+\\.?\\d*)|(\\.\\d+))", "Precio Estimado", "Precio Estimado es invalido(a), puede usar punto(.) y numeros")
                || !validador.validarConRegex(unidad, "^[^\\n]{0,10}$", "Unidad", "Unidad es invalido(a), puede usar hasta 10 caractes alfabeticos")
                || !validador.validarConRegex(proveedor, "^[^\\n]{0,50}$", "Proveedor", "Proveedor es invalido(a), puede usar hasta 50 caractes alfabeticos")
                || !validador.validarConRegex(nombreProducto, "^[^\\n]{1,50}$", "Nombre Producto", "Nombre Producto es invalido(a), puede usar hasta 50 caractes alfabeticos")
                || !validador.validarConRegex(inventarioExistente, "^[1-9][0-9]{0,5}(\\.[0-9]{1,2})?$", "Inventario Existente", "Inventario Existente es invalido(a), puede ser hasta de 0 a 999999")
                || !validador.validarConRegex(observaciones, "^[^\\n]{0,100}$", "Observaciones", "Observaciones es invalido(a), puede usar hasta 100 caractes alfabeticos")) {
            return false;
        } else {
            Date ultimaCompraAux;
            float precioEstimadoAux;
            int existenciasAux;

            try {
                //Convertir a Date ultimaCompra
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                ultimaCompraAux = formatter.parse(ultimaCompra);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Fecha ingresada invalida", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            try {
                precioEstimadoAux = Float.parseFloat(precioEstimado);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Precio ingresado invalido", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            try {
                existenciasAux = Integer.parseInt(inventarioExistente);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Existencias invalidas", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            Insumo insumoAux = new Insumo(descripcion, marca, modelo, presentacion, clasificacion, categoria, ultimaCompraAux, precioEstimadoAux, unidad, proveedor, nombreProducto, existenciasAux, observaciones, idLaboratorio);
            guardarEnFirebase(insumoAux);
            listaDeTransacciones.guardarEnFirebase(new Transaccion(insumoAux, user, "Crear Insumo"));
            return true;
        }
    }

    //Listar un insumo con un ID
    public Insumo listarInsumo(String id) throws ParseException {
        for (Insumo i : getListaInsumos()) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    //Listar un equipo con un Usuario
    public ArrayList<Insumo> listarEquipoPorUsuario(Usuario usuario) throws ParseException {
        ArrayList<Insumo> listaInsumoAux = new ArrayList<>();
        if (usuario.getRolUsuario().equals("Tecnico")) {
            ListaLaboratorios listaLabs = new ListaLaboratorios();
            String idLaboratorio = listaLabs.getLaboratorioConUsuario(usuario.getId());

            for (Insumo i : getListaInsumos()) {
                if (idLaboratorio.equals(i.getLaboratorio())) {
                    listaInsumoAux.add(i);
                }
            }
            return listaInsumoAux;
        } else {
            return getListaInsumos();
        }
    }

    //Listar un equipo con un nombre de Equipo
    public ArrayList<Insumo> listarInsumoPorDato(Usuario usuario, String datoDelInsumo) throws ParseException {
        ArrayList<Insumo> listaInsumoAux = listarEquipoPorUsuario(usuario); //Lista del usuario
        ArrayList<Insumo> listaInsumoFiltrada = new ArrayList<>(); //Lista a retornar
        for (Insumo i : listaInsumoAux) {
            if (i.getNombreProducto().toLowerCase().equals(datoDelInsumo.toLowerCase())
                    || i.getLaboratorio().toLowerCase().equals(datoDelInsumo.toLowerCase())
                    || i.getId().toLowerCase().equals(datoDelInsumo.toLowerCase())
                    || i.getDescripcion().toLowerCase().equals(datoDelInsumo.toLowerCase()) 
                    || i.getCategoria().toLowerCase().equals(datoDelInsumo.toLowerCase())
                    || i.getMarca().toLowerCase().equals(datoDelInsumo.toLowerCase())
                    || i.getModelo().toLowerCase().equals(datoDelInsumo.toLowerCase())) {
                listaInsumoFiltrada.add(i);
            }
        }
        return listaInsumoFiltrada;
    }
    
    //Modifica Insumos
    public boolean modificarInsumo(Usuario user, String id, String descripcion, String marca, String modelo, String presentacion, String clasificacion, String categoria, String ultimaCompra, String precioEstimado, String unidad, String proveedor, String nombreProducto, String inventarioExistente, String observaciones, String idLaboratorio) {
        Validador validador = new Validador();
        if (!validador.validarConRegex(descripcion, "^[^\\n]{0,100}$", "Descripcion", "Descripcion es invalido(a), puede usar hasta 100 caractes alfanumericos")
                || !validador.validarConRegex(marca, "^[^\\n]{0,100}$", "Marca", "Marca es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(modelo, "^[^\\n]{1,100}$", "Modelo", "Modelo es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(presentacion, "^[^\\n]{0,100}$", "Presentacion", "Presentacion es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(clasificacion, "^[^\\n]{0,100}$", "Clasificacion", "Clasificacion es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(categoria, "^[^\\n]{0,100}$", "Categoria", "Categoria es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(ultimaCompra, "^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$", "Ultima Compra", "Ultima Compra es invalido(a), use el formato dd/mm/yyyy")
                || !validador.validarConRegex(precioEstimado, "[+-]?((\\d+\\.?\\d*)|(\\.\\d+))", "Precio Estimado", "Precio Estimado es invalido(a), puede usar punto(.) y numeros")
                || !validador.validarConRegex(unidad, "^[^\\n]{0,10}$", "Unidad", "Unidad es invalido(a), puede usar hasta 10 caractes alfabeticos")
                || !validador.validarConRegex(proveedor, "^[^\\n]{0,50}$", "Proveedor", "Proveedor es invalido(a), puede usar hasta 50 caractes alfabeticos")
                || !validador.validarConRegex(nombreProducto, "^[^\\n]{1,50}$", "Nombre Producto", "Nombre Producto es invalido(a), puede usar hasta 50 caractes alfabeticos")
                || !validador.validarConRegex(inventarioExistente, "^[1-9][0-9]{0,5}(\\.[0-9]{1,2})?$", "Inventario Existente", "Inventario Existente es invalido(a), puede ser hasta de 0 a 999999")
                || !validador.validarConRegex(observaciones, "^[^\\n]{0,100}$", "Observaciones", "Observaciones es invalido(a), puede usar hasta 100 caractes alfabeticos")) {
            return false;
        } else {
            Date ultimaCompraAux;
            float precioEstimadoAux;
            int existenciasAux;

            try {
                //Convertir a Date ultimaCompra
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                ultimaCompraAux = formatter.parse(ultimaCompra);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Fecha ingresada invalida", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            try {
                precioEstimadoAux = Float.parseFloat(precioEstimado);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Precio ingresado invalido", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            try {
                existenciasAux = Integer.parseInt(inventarioExistente);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Existencias invalidas", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            Insumo insumoAux = new Insumo(descripcion, marca, modelo, presentacion, clasificacion, categoria, ultimaCompraAux, precioEstimadoAux, unidad, proveedor, nombreProducto, existenciasAux, observaciones, idLaboratorio);
            insumoAux.setId(id);
            actualizarEnFirebase(insumoAux);
            listaDeTransacciones.guardarEnFirebase(new Transaccion(insumoAux, user, "Modificar Insumo"));
            return true;
        }
    }

    //Eliminar Equipos
    public boolean eliminarInsumo(Usuario user, String id) {
        try {
            Insumo insumo = listarInsumo(id);
            eliminarEnFirebase(id);
            listaDeTransacciones.guardarEnFirebase(new Transaccion(insumo, user, "Eliminar Insumo"));
            return true;
        } catch (Exception e) {
            System.out.println("Error" + e);
            return false;
        }
    }
}
