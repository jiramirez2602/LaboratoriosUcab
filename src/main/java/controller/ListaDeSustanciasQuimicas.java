package controller;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Laboratorio;
import model.SustanciaQuimica;
import model.Usuario;

public class ListaDeSustanciasQuimicas {

    ArrayList<SustanciaQuimica> listaSustancias;

    public ListaDeSustanciasQuimicas() {
        listaSustancias = new ArrayList<>();
        ArrayList<String> privilegios=new ArrayList<>();
        privilegios.add("Laboratorios");
        privilegios.add("Usuarios");
        privilegios.add("Productos");
        privilegios.add("Transacciones");
        Usuario administradorLaboratorio = new Usuario("Harry1", "1234", "Harry Castellanos", privilegios, "administrador", true);
        Laboratorio lab = new Laboratorio("Aula 2", "Ingenieria", "Industrial", "Laboratorios",administradorLaboratorio);
        //TODO: SustanciaQuimica sustancia = new SustanciaQuimica("H20", "Liquido", "estable","Hidrogeno",false,"32232","bajo", "fraseR","FraseS","Sellado en botella","Permitido","laboratorios",100, "LaboratoriosAMAI", "Envasado", "53236", "Hidrogeno", 1,"Seguro",lab);
        //TODO: listaSustancias.add(sustancia);
    }

    public ArrayList<SustanciaQuimica> getListaSustanciasQuimicas() {
        return listaSustancias;
    }

    public void setListaSustancias(ArrayList<SustanciaQuimica> listaSustancias) {
        this.listaSustancias = listaSustancias;
    }

    //TODO: Agregar logica de transacciones
    //Crear producto Sustancia Quimica
    public boolean crearProductoSustanciaQuimica(Usuario user, String formulaQuimica, String concentracion, String presentacion, String nombreComercial, Boolean poseeMSD, String numeroDeIdentificacion, String grupoDeRiesgo, String fraseR, String fraseS, String metodoDeControl, String permisos, String unidad, String precioEstimado, String proveedor, String almacenadoEnvasado, String codigo, String nombreProducto, String inventarioExistente, String observaciones, Laboratorio laboratorio) {
        Validador validador = new Validador();

        if (!validador.validarConRegex(formulaQuimica, "^[^\\n]{0,100}$", "Formula Quimica", "Formula Quimica es invalido(a), puede usar hasta 100 caractes alfanumericos")
                || !validador.validarConRegex(concentracion, "^[^\\n]{0,100}$", "Concentracion", "Concentracion es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(fraseR, "^[^\\n]{0,100}$", "Frase R", "Frase R es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(fraseS, "^[^\\n]{0,100}$", "Frase S", "Frase S es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(metodoDeControl, "^[^\\n]{0,100}$", "Metodo De Control", "Metodo De Control es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(permisos, "^[^\\n]{0,100}$", "Permisos", "Permisos es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(almacenadoEnvasado, "^[^\\n]{0,100}$", "Almacenado Envasado", "Almacenado Envasado es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(nombreComercial, "^[^\\n]{5,100}$", "Nombre Comercial", "Nombre Comercial es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(presentacion, "^[^\\n]{0,100}$", "Presentacion", "Presentacion es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(numeroDeIdentificacion, "^[^\\n]{0,50}$", "Numero De Identificacion", "Numero De Identificacion es invalido(a), puede usar hasta 50 caractes alfabeticos")
                || !validador.validarConRegex(grupoDeRiesgo, "^[^\\n]{0,100}$", "Grupo De Riesgo", "Grupo De Riesgo es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(precioEstimado, "[+-]?((\\d+\\.?\\d*)|(\\.\\d+))", "Precio Estimado", "Precio Estimado es invalido(a), puede usar punto(.) y numeros")
                || !validador.validarConRegex(unidad, "^[^\\n]{0,10}$", "Unidad", "Unidad es invalido(a), puede usar hasta 10 caractes alfabeticos")
                || !validador.validarConRegex(proveedor, "^[^\\n]{0,50}$", "Proveedor", "Proveedor es invalido(a), puede usar hasta 50 caractes alfabeticos")
                || !validador.validarConRegex(codigo, "^[^\\n]{0,100}$", "Codigo", "Codigo es invalido(a), puede usar hasta 100 caractes alfabeticos")
                || !validador.validarConRegex(nombreProducto, "^[^\\n]{5,50}$", "Nombre Producto", "Nombre Producto es invalido(a), puede usar hasta 50 caractes alfabeticos")
                /*TODO: Validar con radio botton poseeMSD*/
                || !validador.validarConRegex(inventarioExistente, "^[1-9][0-9]{0,5}(\\.[0-9]{1,2})?$", "Inventario Existente", "Inventario Existente es invalido(a), puede ser hasta de 0 a 999999")
                || !validador.validarConRegex(observaciones, "^[^\\n]{0,100}$", "Observaciones", "Observaciones es invalido(a), puede usar hasta 100 caractes alfabeticos")) {
            return false;
        } else {
            float precioEstimadoAux;
            int inventarioExistenteAux;

            try {
                precioEstimadoAux = Float.parseFloat(precioEstimado);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Precio ingresado invalido", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            try {
                inventarioExistenteAux = Integer.parseInt(inventarioExistente);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Existencias invalidas", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            //TODO: SustanciaQuimica sustanciaAux = new SustanciaQuimica(formulaQuimica, concentracion, presentacion, nombreComercial, poseeMSD, numeroDeIdentificacion, grupoDeRiesgo, fraseR, fraseS, metodoDeControl, permisos, unidad, precioEstimadoAux, proveedor, almacenadoEnvasado, codigo, nombreProducto, inventarioExistenteAux, observaciones, laboratorio);
            //TODO: listaSustancias.add(sustanciaAux);
            return true;
        }
    }

    //Listar un equipo con un ID
    public SustanciaQuimica listarSustanciaQuimica(String id) {
        for (SustanciaQuimica i : getListaSustanciasQuimicas()) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    //Listar un equipo con un Usuario
    public ArrayList<SustanciaQuimica> listarSustanciaQuimicaPorUsuario(Usuario usuario) {
        ArrayList<SustanciaQuimica> listaSustanciaQuimicaAux = new ArrayList<>();

        for (SustanciaQuimica i : getListaSustanciasQuimicas()) {
            //TODO: if (i.getLaboratorio().getAdministrador().getNombreUser().equals(usuario.getNombreUser())) {
            //TODO:     listaSustanciaQuimicaAux.add(i);
            //TODO: }
        }
        return listaSustanciaQuimicaAux;
    }
    
    //Listar una sustancia Quimica con un nombre 
    public String listarSustanciaQumicaPorNombre(Usuario usuario, String nombreDeSustancia) {
        for (SustanciaQuimica i : listarSustanciaQuimicaPorUsuario(usuario)) {
            if (i.getNombreProducto().toLowerCase().equals(nombreDeSustancia.toLowerCase())) {
                return i.getId();
            }
        }
        return null;
    }

    //TODO: Agregar logica de transacciones
    //Modifica Equipos
    public boolean modificarSustancia(Usuario user, String id, String formulaQuimica, String concentracion, String presentacion, String nombreComercial, Boolean poseeMSD, String numeroDeIdentificacion, String grupoDeRiesgo, String fraseR, String fraseS, String metodoDeControl, String permisos, String unidad, String precioEstimado, String proveedor, String almacenadoEnvasado, String codigo, String nombreProducto, String inventarioExistente, String observaciones, Laboratorio laboratorio) {
        SustanciaQuimica product = listarSustanciaQuimica(id);
        if (product != null) {
            Validador validador = new Validador();
            if (!validador.validarConRegex(formulaQuimica, "^[^\\n]{0,100}$", "Formula Quimica", "Formula Quimica es invalido(a), puede usar hasta 100 caractes alfanumericos")
                    || !validador.validarConRegex(concentracion, "^[^\\n]{0,100}$", "Concentracion", "Concentracion es invalido(a), puede usar hasta 100 caractes alfabeticos")
                    || !validador.validarConRegex(fraseR, "^[^\\n]{0,100}$", "Frase R", "Frase R es invalido(a), puede usar hasta 100 caractes alfabeticos")
                    || !validador.validarConRegex(fraseS, "^[^\\n]{0,100}$", "Frase S", "Frase S es invalido(a), puede usar hasta 100 caractes alfabeticos")
                    || !validador.validarConRegex(metodoDeControl, "^[^\\n]{0,100}$", "Metodo De Control", "Metodo De Control es invalido(a), puede usar hasta 100 caractes alfabeticos")
                    || !validador.validarConRegex(permisos, "^[^\\n]{0,100}$", "Permisos", "Permisos es invalido(a), puede usar hasta 100 caractes alfabeticos")
                    || !validador.validarConRegex(almacenadoEnvasado, "^[^\\n]{0,100}$", "Almacenado Envasado", "Almacenado Envasado es invalido(a), puede usar hasta 100 caractes alfabeticos")
                    || !validador.validarConRegex(nombreComercial, "^[^\\n]{5,100}$", "Nombre Comercial", "Nombre Comercial es invalido(a), puede usar hasta 100 caractes alfabeticos")
                    || !validador.validarConRegex(presentacion, "^[^\\n]{0,100}$", "Presentacion", "Presentacion es invalido(a), puede usar hasta 100 caractes alfabeticos")
                    || !validador.validarConRegex(numeroDeIdentificacion, "^[^\\n]{0,50}$", "Numero De Identificacion", "Numero De Identificacion es invalido(a), puede usar hasta 50 caractes alfabeticos")
                    || !validador.validarConRegex(grupoDeRiesgo, "^[^\\n]{0,100}$", "Grupo De Riesgo", "Grupo De Riesgo es invalido(a), puede usar hasta 100 caractes alfabeticos")
                    || !validador.validarConRegex(precioEstimado, "[+-]?((\\d+\\.?\\d*)|(\\.\\d+))", "Precio Estimado", "Precio Estimado es invalido(a), puede usar punto(.) y numeros")
                    || !validador.validarConRegex(unidad, "^[^\\n]{0,10}$", "Unidad", "Unidad es invalido(a), puede usar hasta 10 caractes alfabeticos")
                    || !validador.validarConRegex(proveedor, "^[^\\n]{0,50}$", "Proveedor", "Proveedor es invalido(a), puede usar hasta 50 caractes alfabeticos")
                    || !validador.validarConRegex(codigo, "^[^\\n]{0,100}$", "Codigo", "Codigo es invalido(a), puede usar hasta 100 caractes alfabeticos")
                    || !validador.validarConRegex(nombreProducto, "^[^\\n]{5,50}$", "Nombre Producto", "Nombre Producto es invalido(a), puede usar hasta 50 caractes alfabeticos")
                    /*TODO: Validar con radio botton poseeMSD*/
                    || !validador.validarConRegex(inventarioExistente, "^[1-9][0-9]{0,5}(\\.[0-9]{1,2})?$", "Inventario Existente", "Inventario Existente es invalido(a), puede ser hasta de 0 a 999999")
                    || !validador.validarConRegex(observaciones, "^[^\\n]{0,100}$", "Observaciones", "Observaciones es invalido(a), puede usar hasta 100 caractes alfabeticos")) {
                return false;
            } else {
                float precioEstimadoAux;
                int inventarioExistenteAux;

                try {
                    precioEstimadoAux = Float.parseFloat(precioEstimado);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Precio ingresado invalido", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }

                try {
                    inventarioExistenteAux = Integer.parseInt(inventarioExistente);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Existencias invalidas", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }

                //TODO: //TODO: SustanciaQuimica sustanciaAux = new SustanciaQuimica(formulaQuimica, concentracion, presentacion, nombreComercial, poseeMSD, numeroDeIdentificacion, grupoDeRiesgo, fraseR, fraseS, metodoDeControl, permisos, unidad, precioEstimadoAux, proveedor, almacenadoEnvasado, codigo, nombreProducto, inventarioExistenteAux, observaciones, laboratorio);
                //TODO: sustanciaAux.setId(id);

                int acumulador = 0;
                for (SustanciaQuimica i : listaSustancias) {
                    if (i.getId().equals(id)) {
                        //TODO: listaSustancias.set(acumulador, sustanciaAux);
                    }
                    acumulador++;
                }
                return true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Sustancia Quimica no se puede modificar", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    //TODO: Agregar logica de transacciones
    //Eliminar Equipos
    public boolean eliminarSustanciaQuimica(Usuario user, String id) {
        SustanciaQuimica sustancia = listarSustanciaQuimica(id);
        if (sustancia != null) {
            int acumulador = 0;
            for (SustanciaQuimica i : listaSustancias) {
                if (i.getId().equals(id)) {
                    listaSustancias.remove(acumulador);
                    return Boolean.TRUE;
                }
                acumulador++;
            }
        }
        JOptionPane.showMessageDialog(null, "Sustancia Quimica no encontrada, no pudo eliminarse", "Error", JOptionPane.ERROR_MESSAGE);
        return Boolean.FALSE;
    }
}
