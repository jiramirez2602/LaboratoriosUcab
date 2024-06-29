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
import model.Equipo;
import model.Laboratorio;
import model.Transaccion;
import model.Usuario;

public class ListaDeEquipos {

    ArrayList<Equipo> listaEquipos;
    ListaDeTransacciones listaDeTransacciones = new ListaDeTransacciones();

    //FIREBASE
    public boolean guardarEnFirebase(Equipo equipo) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Map<String, Object> datos = new HashMap<>();
            datos.put("descripcion", String.valueOf(equipo.getDescripcion()));
            datos.put("marca", String.valueOf(equipo.getMarca()));
            datos.put("modelo", String.valueOf(equipo.getModelo()));
            datos.put("numeroSerial", String.valueOf(equipo.getNumeroSerial()));
            datos.put("numeroActivo", String.valueOf(equipo.getNumeroActivo()));
            datos.put("presentacion", String.valueOf(equipo.getPresentacion()));
            datos.put("voltaje", String.valueOf(equipo.getVoltaje()));
            datos.put("procesable", String.valueOf(equipo.getProcesable()));
            datos.put("materialRequerido", String.valueOf(equipo.getMaterialRequerido()));
            datos.put("añoDeCompraAux", String.valueOf(dateFormat.format(equipo.getAñoDeCompra())));
            datos.put("aplicacion", String.valueOf(equipo.getAplicacion()));
            datos.put("ultimoMantenimientoAux", String.valueOf(dateFormat.format(equipo.getUltimoMantenimiento())));
            datos.put("proximoMantenimientoAux", String.valueOf(dateFormat.format(equipo.getProximoMantenimiento())));
            datos.put("ultimaCalibracionAux", String.valueOf(dateFormat.format(equipo.getUltimaCalibracion())));
            datos.put("proximaCalibracionAux", String.valueOf(dateFormat.format(equipo.getProximaCalibracion())));
            datos.put("proovedoresDeServicios", String.valueOf(equipo.getProovedoresDeServicios()));
            datos.put("encendidoDenoche", String.valueOf(equipo.getEncendidoDenoche()));
            datos.put("nombreProducto", String.valueOf(equipo.getNombreProducto()));
            datos.put("inventarioExistenteAux", String.valueOf(equipo.getInventarioExistente()));
            datos.put("observaciones", String.valueOf(equipo.getObservaciones()));
            datos.put("idLaboratorio", String.valueOf(equipo.getLaboratorio()));
            GeneralProvider.guardar("Equipos", String.valueOf(equipo.getId()), datos);
            JOptionPane.showMessageDialog(null, "Guardado con exito");
            return true;
        } catch (Exception e) {
            System.out.println("Error al guardar controller: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarEnFirebase(Equipo equipo) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Map<String, Object> datos = new HashMap<>();
            datos.put("descripcion", String.valueOf(equipo.getDescripcion()));
            datos.put("marca", String.valueOf(equipo.getMarca()));
            datos.put("modelo", String.valueOf(equipo.getModelo()));
            datos.put("numeroSerial", String.valueOf(equipo.getNumeroSerial()));
            datos.put("numeroActivo", String.valueOf(equipo.getNumeroActivo()));
            datos.put("presentacion", String.valueOf(equipo.getPresentacion()));
            datos.put("voltaje", String.valueOf(equipo.getVoltaje()));
            datos.put("procesable", String.valueOf(equipo.getProcesable()));
            datos.put("materialRequerido", String.valueOf(equipo.getMaterialRequerido()));
            datos.put("añoDeCompraAux", String.valueOf(dateFormat.format(equipo.getAñoDeCompra())));
            datos.put("aplicacion", String.valueOf(equipo.getAplicacion()));
            datos.put("ultimoMantenimientoAux", String.valueOf(dateFormat.format(equipo.getUltimoMantenimiento())));
            datos.put("proximoMantenimientoAux", String.valueOf(dateFormat.format(equipo.getProximoMantenimiento())));
            datos.put("ultimaCalibracionAux", String.valueOf(dateFormat.format(equipo.getUltimaCalibracion())));
            datos.put("proximaCalibracionAux", String.valueOf(dateFormat.format(equipo.getProximaCalibracion())));
            datos.put("proovedoresDeServicios", String.valueOf(equipo.getProovedoresDeServicios()));
            datos.put("encendidoDenoche", String.valueOf(equipo.getEncendidoDenoche()));
            datos.put("nombreProducto", String.valueOf(equipo.getNombreProducto()));
            datos.put("inventarioExistenteAux", String.valueOf(equipo.getInventarioExistente()));
            datos.put("observaciones", String.valueOf(equipo.getObservaciones()));
            datos.put("idLaboratorio", String.valueOf(equipo.getLaboratorio()));
            GeneralProvider.actualizar("Equipos", equipo.getId(), datos);
            JOptionPane.showMessageDialog(null, "Actualizado con exito");
            return true;
        } catch (Exception e) {
            System.out.println("Error al actualizar controller: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarEnFirebase(String id) {
        try {
            GeneralProvider.eliminar("Equipos", id);
            JOptionPane.showMessageDialog(null, "Eliminado con exito");
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }

    public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }
    
    //Crear producto Equipos
    public boolean crearProductoEquipo(Usuario user, String descripcion, String marca, String modelo, String numeroSerial, String numeroActivo, String presentacion, String voltaje, String procesable, String materialRequerido, String añoDeCompra, String aplicacion, String ultimoMantenimiento, String proximoMantenimiento, String ultimaCalibracion, String proximaCalibracion, String proovedoresDeServicios, String encendidoDenoche, String nombreProducto, String inventarioExistente, String observaciones, String idLaboratorio) {
        Validador validador = new Validador();

        if (!validador.validarConRegex(descripcion, "^[^\\n]{0,100}$", "Descripcion", "Descripcion es invalido(a), puede usar hasta 100 caractes alfanumericos")
                || !validador.validarConRegex(marca, "^[^\\n]{0,100}$", "Marca", "Marca es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(modelo, "^[^\\n]{5,100}$", "Modelo", "Modelo es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(presentacion, "^[^\\n]{0,100}$", "Presentacion", "Presentacion es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(numeroSerial, "^[^\\n]{0,100}$", "Numero de serial", "Numero de serial es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(numeroActivo, "^[^\\n]{0,100}$", "Numero de activo", "Numero de activo es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(voltaje, "^[^\\n]{0,100}$", "Voltaje", "Voltaje es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(procesable, "^[^\\n]{0,100}$", "Procesable", "Procesable es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(materialRequerido, "^[^\\n]{0,100}$", "Material Requerido", "Material Requerido es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(aplicacion, "^[^\\n]{0,100}$", "Aplicacion", "Aplicacion es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(añoDeCompra, "^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$", "Año de Compra", "Año de Compra es invalido(a), use el formato dd/mm/yyyy")
                || !validador.validarConRegex(ultimoMantenimiento, "^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$", "Ultimo Mantenimiento", "Ultimo Mantenimiento es invalido(a), use el formato dd/mm/yyyy")
                || !validador.validarConRegex(proximoMantenimiento, "^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$", "Proximo Mantenimiento", "Proximo Mantenimiento es invalido(a), use el formato dd/mm/yyyy")
                || !validador.validarConRegex(ultimaCalibracion, "^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$", "Ultima Calibracion", "Ultima Calibracion es invalido(a), use el formato dd/mm/yyyy")
                || !validador.validarConRegex(proximaCalibracion, "^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$", "Proxima Calibracion", "Proxima Calibracion es invalido(a), use el formato dd/mm/yyyy")
                || !validador.validarConRegex(proovedoresDeServicios, "^[^\\n]{0,100}$", "Proovedores De Servicios", "Proovedores De Servicios es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(materialRequerido, "^[^\\n]{0,100}$", "Material Requerido", "Material Requerido es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(materialRequerido, "^[^\\n]{0,100}$", "Material Requerido", "Material Requerido es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(nombreProducto, "^[^\\n]{5,50}$", "Nombre Producto", "Nombre Producto es invalido(a), puede usar hasta 50 caractes alfabeticos")
                || !validador.validarConRegex(inventarioExistente, "^[1-9][0-9]{0,5}(\\.[0-9]{1,2})?$", "Inventario Existente", "Inventario Existente es invalido(a), puede ser hasta de 0 a 999999")
                || !validador.validarConRegex(observaciones, "^[^\\n]{0,100}$", "Observaciones", "Observaciones es invalido(a), puede usar hasta 100 caractes alfabeticos")) {
            return false;
        } else {
            Date añoDeCompraAux;
            Date ultimoMantenimientoAux;
            Date proximoMantenimientoAux;
            Date ultimaCalibracionAux;
            Date proximaCalibracionAux;
            int inventarioExistenteAux;

            try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                añoDeCompraAux = formatter.parse(añoDeCompra);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Fecha ingresada invalida", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                ultimoMantenimientoAux = formatter.parse(ultimoMantenimiento);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Fecha ingresada invalida", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                proximoMantenimientoAux = formatter.parse(proximoMantenimiento);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Fecha ingresada invalida", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                ultimaCalibracionAux = formatter.parse(ultimaCalibracion);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Fecha ingresada invalida", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                proximaCalibracionAux = formatter.parse(proximaCalibracion);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Fecha ingresada invalida", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            try {
                inventarioExistenteAux = Integer.parseInt(inventarioExistente);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Existencias invalidas", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            Equipo equipoAux = new Equipo(descripcion, marca, modelo, numeroSerial, numeroActivo, presentacion, voltaje, procesable, materialRequerido, añoDeCompraAux, aplicacion, ultimoMantenimientoAux, proximoMantenimientoAux, ultimaCalibracionAux, proximaCalibracionAux, proovedoresDeServicios, encendidoDenoche, nombreProducto, inventarioExistenteAux, observaciones, idLaboratorio);
            guardarEnFirebase(equipoAux);
            listaDeTransacciones.guardarEnFirebase(new Transaccion(equipoAux, user, "Crear Equipo"));
            return true;
        }
    }

    //Listar un equipo con un ID
    public Equipo listarEquipo(String id) throws ParseException {
        for (Equipo i : getListaEquipos()) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    public ArrayList<Equipo> getListaEquipos() throws ParseException {
        listaEquipos = GeneralProvider.cargarInfoEquipos();
        return listaEquipos;
    }

//    //Listar un equipo con un Usuario
//    public ArrayList<Equipo> listarEquipoPorUsuario(Usuario usuario) {
//        ArrayList<Equipo> listaEquipoAux = new ArrayList<>();
//
//        for (Equipo i : getListaEquipos()) {
//            if (i.getLaboratorio().getAdministrador().getNombreUser().equals(usuario.getNombreUser())) {
//                listaEquipoAux.add(i);
//            }
//        }
//        return listaEquipoAux;
//    }
//    //Listar un equipo con un nombre de Equipo
//    public String listarEquipoPorNombre(Usuario usuario, String nombreDeEquipo) {
//        for (Equipo i : listarEquipoPorUsuario(usuario)) {
//            if (i.getNombreProducto().toLowerCase().equals(nombreDeEquipo.toLowerCase())) {
//                return i.getId();
//            }
//        }
//        return null;
//    }
    
    //Modifica Equipos
    public boolean modificarEquipo(Usuario user, String id, String descripcion, String marca, String modelo, String numeroSerial, String numeroActivo, String presentacion, String voltaje, String procesable, String materialRequerido, String añoDeCompra, String aplicacion, String ultimoMantenimiento, String proximoMantenimiento, String ultimaCalibracion, String proximaCalibracion, String proovedoresDeServicios, String encendidoDenoche, String nombreProducto, String inventarioExistente, String observaciones, String idLaboratorio) {
        Validador validador = new Validador();
        if (!validador.validarConRegex(descripcion, "^[^\\n]{0,100}$", "Descripcion", "Descripcion es invalido(a), puede usar hasta 100 caractes alfanumericos")
                || !validador.validarConRegex(marca, "^[^\\n]{0,100}$", "Marca", "Marca es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(modelo, "^[^\\n]{5,100}$", "Modelo", "Modelo es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(presentacion, "^[^\\n]{0,100}$", "Presentacion", "Presentacion es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(numeroSerial, "^[^\\n]{0,100}$", "Numero de serial", "Numero de serial es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(numeroActivo, "^[^\\n]{0,100}$", "Numero de activo", "Numero de activo es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(voltaje, "^[^\\n]{0,100}$", "Voltaje", "Voltaje es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(procesable, "^[^\\n]{0,100}$", "Procesable", "Procesable es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(materialRequerido, "^[^\\n]{0,100}$", "Material Requerido", "Material Requerido es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(aplicacion, "^[^\\n]{0,100}$", "Aplicacion", "Aplicacion es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(añoDeCompra, "^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$", "Año de Compra", "Año de Compra es invalido(a), use el formato dd/mm/yyyy")
                || !validador.validarConRegex(ultimoMantenimiento, "^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$", "Ultimo Mantenimiento", "Ultimo Mantenimiento es invalido(a), use el formato dd/mm/yyyy")
                || !validador.validarConRegex(proximoMantenimiento, "^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$", "Proximo Mantenimiento", "Proximo Mantenimiento es invalido(a), use el formato dd/mm/yyyy")
                || !validador.validarConRegex(ultimaCalibracion, "^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$", "Ultima Calibracion", "Ultima Calibracion es invalido(a), use el formato dd/mm/yyyy")
                || !validador.validarConRegex(proximaCalibracion, "^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$", "Proxima Calibracion", "Proxima Calibracion es invalido(a), use el formato dd/mm/yyyy")
                || !validador.validarConRegex(proovedoresDeServicios, "^[^\\n]{0,100}$", "Proovedores De Servicios", "Proovedores De Servicios es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(materialRequerido, "^[^\\n]{0,100}$", "Material Requerido", "Material Requerido es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(materialRequerido, "^[^\\n]{0,100}$", "Material Requerido", "Material Requerido es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(nombreProducto, "^[^\\n]{5,50}$", "Nombre Producto", "Nombre Producto es invalido(a), puede usar hasta 50 caractes alfabeticos")
                || !validador.validarConRegex(inventarioExistente, "^[1-9][0-9]{0,5}(\\.[0-9]{1,2})?$", "Inventario Existente", "Inventario Existente es invalido(a), puede ser hasta de 0 a 999999")
                || !validador.validarConRegex(observaciones, "^[^\\n]{0,100}$", "Observaciones", "Observaciones es invalido(a), puede usar hasta 100 caractes alfabeticos")) {
            return false;
        } else {
            Date añoDeCompraAux;
            Date ultimoMantenimientoAux;
            Date proximoMantenimientoAux;
            Date ultimaCalibracionAux;
            Date proximaCalibracionAux;
            int inventarioExistenteAux;

            try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                añoDeCompraAux = formatter.parse(añoDeCompra);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Fecha ingresada invalida", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            try {
                //Convertir a Date ultimaCompra
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                ultimoMantenimientoAux = formatter.parse(ultimoMantenimiento);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Fecha ingresada invalida", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            try {
                //Convertir a Date ultimaCompra
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                proximoMantenimientoAux = formatter.parse(proximoMantenimiento);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Fecha ingresada invalida", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            try {
                //Convertir a Date ultimaCompra
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                ultimaCalibracionAux = formatter.parse(ultimaCalibracion);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Fecha ingresada invalida", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            try {
                //Convertir a Date ultimaCompra
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                proximaCalibracionAux = formatter.parse(proximaCalibracion);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Fecha ingresada invalida", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            try {
                inventarioExistenteAux = Integer.parseInt(inventarioExistente);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Existencias invalidas", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            Equipo equipoModified = new Equipo(descripcion, marca, modelo, numeroSerial, numeroActivo, presentacion, voltaje, procesable, materialRequerido, añoDeCompraAux, aplicacion, ultimoMantenimientoAux, proximoMantenimientoAux, ultimaCalibracionAux, proximaCalibracionAux, proovedoresDeServicios, encendidoDenoche, nombreProducto, inventarioExistenteAux, observaciones, idLaboratorio);
            equipoModified.setId(id);
            actualizarEnFirebase(equipoModified);
            listaDeTransacciones.guardarEnFirebase(new Transaccion(equipoModified, user, "Modificar Equipo"));
            return true;
        }
    }

    //Eliminar Equipos
    public boolean eliminarEquipo(Usuario user, String id) {
        try {
            Equipo equipo = listarEquipo(id);
            eliminarEnFirebase(id);
            listaDeTransacciones.guardarEnFirebase(new Transaccion(equipo, user, "Eliminar Equipo"));
            return true;
        } catch (Exception e) {
            System.out.println("Error" + e);
            return false;
        }
    }
}
