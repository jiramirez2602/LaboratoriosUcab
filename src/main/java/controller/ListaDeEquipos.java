package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Equipo;
import model.Laboratorio;
import model.Usuario;

public class ListaDeEquipos {

    ArrayList<Equipo> listaEquipos;

    public ListaDeEquipos() {
        listaEquipos = new ArrayList<>();
        Date date = new Date(2004,05,06);
        Date date2= new Date(2024,06,01);
        Date date3= new Date(2024,06,11);
        Date date4= new Date(2024,06,13);
        ArrayList<String> privilegios=new ArrayList<>();
        privilegios.add("Laboratorios");
        privilegios.add("Usuarios");
        privilegios.add("Productos");
        privilegios.add("Transacciones");
        Usuario administradorLaboratorio = new Usuario("Harry1", "1234", "Harry Castellanos", privilegios, "administrador", true);
        Laboratorio lab = new Laboratorio("Aula 2", "Ingenieria", "Industrial", "Laboratorios",administradorLaboratorio);
        //TODO: Equipo equipoInicial=new Equipo("ver atomos", "Casio", "modeloS", "213212", "132123","prsentable","80watts","procesar","Hidrogeno",date, "ver en el micro",date2,date3,date2,date4,"Laboratorios Santa Ines",true,"563723","Microscopio",1,"Buen estado",lab);
        //TODO: listaEquipos.add(equipoInicial);
    }

    public ArrayList<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    //TODO: Agregar logica de transacciones
    //Crear producto Equipos
    public boolean crearProductoEquipo(Usuario user, String descripcion, String marca, String modelo, String numeroSerial, String numeroActivo, String presentacion, String voltaje, String procesable, String materialRequerido, String añoDeCompra, String aplicacion, String ultimoMantenimiento, String proximoMantenimiento, String ultimaCalibracion, String proximaCalibracion, String proovedoresDeServicios, Boolean encendidoDenoche, String codigo, String nombreProducto, String inventarioExistente, String observaciones, Laboratorio laboratorio) {
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
                || !validador.validarConRegex(codigo, "^[^\\n]{0,100}$", "Codigo", "Codigo es invalido(a), puede usar hasta 100 caractes alfabeticos")
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

            //TODO: Equipo equipoAux = new Equipo(descripcion, marca, modelo, numeroSerial, numeroActivo, presentacion, voltaje, procesable, materialRequerido, añoDeCompraAux, aplicacion, ultimoMantenimientoAux, proximoMantenimientoAux, ultimaCalibracionAux, proximaCalibracionAux, proovedoresDeServicios, encendidoDenoche, codigo, nombreProducto, inventarioExistenteAux, observaciones, laboratorio);
            //TODO: listaEquipos.add(equipoAux);
            return true;
        }
    }

    //Listar un equipo con un ID
    public Equipo listarEquipo(String id) {
        for (Equipo i : getListaEquipos()) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    //Listar un equipo con un Usuario
    public ArrayList<Equipo> listarEquipoPorUsuario(Usuario usuario) {
        ArrayList<Equipo> listaEquipoAux = new ArrayList<>();

        for (Equipo i : getListaEquipos()) {
            //TODO: if (i.getLaboratorio().getAdministrador().getNombreUser().equals(usuario.getNombreUser())) {
            //TODO:     listaEquipoAux.add(i);
            //TODO: }
        }
        return listaEquipoAux;
    }

    //Listar un equipo con un nombre de Equipo
    public String listarEquipoPorNombre(Usuario usuario, String nombreDeEquipo) {
        for (Equipo i : listarEquipoPorUsuario(usuario)) {
            if (i.getNombreProducto().toLowerCase().equals(nombreDeEquipo.toLowerCase())) {
                return i.getId();
            }
        }
        return null;
    }

    //TODO: Agregar logica de transacciones
    //Modifica Equipos
    public boolean modificarEquipo(Usuario user, String id, String descripcion, String marca, String modelo, String numeroSerial, String numeroActivo, String presentacion, String voltaje, String procesable, String materialRequerido, String añoDeCompra, String aplicacion, String ultimoMantenimiento, String proximoMantenimiento, String ultimaCalibracion, String proximaCalibracion, String proovedoresDeServicios, Boolean encendidoDenoche, String codigo, String nombreProducto, String inventarioExistente, String observaciones, Laboratorio laboratorio) {
        Equipo product = listarEquipo(id);
        if (product != null) {
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
                    || !validador.validarConRegex(codigo, "^[^\\n]{0,100}$", "Codigo", "Codigo es invalido(a), puede usar hasta 100 caractes alfabeticos")
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

                //TODO: Equipo equipoAux = new Equipo(descripcion, marca, modelo, numeroSerial, numeroActivo, presentacion, voltaje, procesable, materialRequerido, añoDeCompraAux, aplicacion, ultimoMantenimientoAux, proximoMantenimientoAux, ultimaCalibracionAux, proximaCalibracionAux, proovedoresDeServicios, encendidoDenoche, codigo, nombreProducto, inventarioExistenteAux, observaciones, laboratorio);

                //TODO: equipoAux.setId(id);

                int acumulador = 0;
                for (Equipo i : listaEquipos) {
                    if (i.getId().equals(id)) {
                        //TODO: listaEquipos.set(acumulador, equipoAux);
                    }
                    acumulador++;
                }
                return true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Equipo no se puede modificar", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    //TODO: Agregar logica de transacciones
    //Eliminar Equipos
    public boolean eliminarEquipo(Usuario user, String id) {
        Equipo equipo = listarEquipo(id);
        if (equipo != null) {
            int acumulador = 0;
            for (Equipo i : listaEquipos) {
                if (i.getId().equals(id)) {
                    listaEquipos.remove(acumulador);
                    return Boolean.TRUE;
                }
                acumulador++;
            }
        }
        JOptionPane.showMessageDialog(null, "Equipo no encontrado, no pudo eliminarse", "Error", JOptionPane.ERROR_MESSAGE);
        return Boolean.FALSE;
    }
}
