package controller;

import firebase.GeneralProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import model.Usuario;

public class ListaDeUsuarios {

    ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    //MÉTODOS FIREBASE//
    public boolean guardarEnFirebase(Usuario usuario) {
        try {
            Map<String, Object> datos = new HashMap<>();
            datos.put("username", String.valueOf(usuario.getUsername()));
            datos.put("contrasena", String.valueOf(usuario.getContrasena()));
            datos.put("nombreCompleto", String.valueOf(usuario.getNombreUser()));
            datos.put("rol", String.valueOf(usuario.getRolUsuario()));
            datos.put("estado", String.valueOf(usuario.getStatus()));
            GeneralProvider.guardar("Usuarios", String.valueOf(usuario.getId()), datos);
            JOptionPane.showMessageDialog(null, "Guardado con exito");
            return true;
        } catch (Exception e) {
            System.out.println("Error al guardar controller: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarEnFirebase(Usuario usuario) {
        try {
            Map<String, Object> datos = new HashMap<>();
            datos.put("username", String.valueOf(usuario.getUsername()));
            datos.put("contrasena", String.valueOf(usuario.getContrasena()));
            datos.put("nombreCompleto", String.valueOf(usuario.getNombreUser()));
            datos.put("rol", String.valueOf(usuario.getRolUsuario()));
            datos.put("estado", String.valueOf(usuario.getStatus()));
            GeneralProvider.actualizar("Usuarios", usuario.getId(), datos);
            JOptionPane.showMessageDialog(null, "Actualizado con exito");
            return true;
        } catch (Exception e) {
            System.out.println("Error al actualizar controller: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarEnFirebase(String id) {
        try {
            GeneralProvider.eliminar("Usuarios", id);
            JOptionPane.showMessageDialog(null, "Eliminado con exito");
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }

    //MÉTODOS PRINCIPALES//
    public boolean crearUsuario(Usuario user, String username, String contrasena, String nombreCompleto, ArrayList<String> privilegio, String rol, String status) {
        Validador validar = new Validador();//Declaro objeto Validador
        boolean existe = usuarioExistente(username);//Declaro un booleano y le asigno una funcion para comprobar si un usuario existe en la lista
        boolean retornar = false;
        if (existe == true) {
            JOptionPane.showMessageDialog(null, "Ya existe un usuario con el nombre:" + username + ". Intente con otro nombre", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (!validar.validarConRegex(username, "^.{1,30}$", "Nombre del usuario", "Limite de caracteres sobrepasado, solo se puede ingresar de 5 a 30 caracteres")
                    || !validar.validarConRegex(contrasena, "^.{1,30}$", "Contraseña del usuario", "Limite de caracteres sobrepasado, solo se puede ingresar de 5 a 30 caracteres")
                    || !validar.validarConRegex(nombreCompleto, "^[a-zA-Z ]{1,30}$", "Nombre Verdadero del usuario", "El nombre es invalido, solo se aceptan caracteres alfabeticos, con un limite de 5 a 30 caracteres")
                    || !validar.validarConRegex(rol, "^[a-zA-Z]{1,30}$", "Rol del usuario", "El rol es invalido, solo se aceptan caracteres alfabeticos, con un limite de 5 a 30 caracteres")
                    ) {
                return retornar;
            } else {
                Usuario usuario = new Usuario(username, contrasena, nombreCompleto, rol,status);
                retornar = guardarEnFirebase(usuario);
            }
        }
        return retornar;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        listaUsuarios = GeneralProvider.cargarInfoUsuario();
        return listaUsuarios;
    }

    public boolean actualizarUsuario(Usuario user, String id, String username, String contrasena, String nombreCompleto, ArrayList<String> privilegio, String rol, String status) {
        Validador validar = new Validador();

        boolean retornar = false;

        if (!validar.validarConRegex(username, "^.{1,30}$", "Nombre del usuario", "Limite de caracteres sobrepasado, solo se puede ingresar de 5 a 30 caracteres")
                || !validar.validarConRegex(contrasena, "^.{1,30}$", "Contraseña del usuario", "Limite de caracteres sobrepasado, solo se puede ingresar de 5 a 30 caracteres")
                || !validar.validarConRegex(nombreCompleto, "^[a-zA-Z ]{1,30}$", "Nombre Verdadero del usuario", "El nombre es invalido, solo se aceptan caracteres alfabeticos, con un limite de 5 a 30 caracteres")
                || !validar.validarConRegex(rol, "^[a-zA-Z]{1,30}$", "Rol del usuario", "El rol es invalido, solo se aceptan caracteres alfabeticos, con un limite de 5 a 30 caracteres")
                ) {
            return retornar;
        } else {
            Usuario userModified = new Usuario(username, contrasena, nombreCompleto, rol,status);
            userModified.setId(id);
            retornar = actualizarEnFirebase(userModified);
        }

        return retornar;
    }
    
    public boolean modificarUsuarios(Usuario user,String nombre, String id, String newUser, String contrasena, String nombreCompleto, String rol, String status) {
        Validador validar = new Validador();
        String iD=listarUsuarioPorNombre(nombre);
        Usuario usuarioExiste = listarUsuario(iD);
        boolean retornar = false;
        if (usuarioExiste != null) {
            if (!validar.validarConRegex(newUser, "^.{1,30}$", "Nombre del usuario", "Limite de caracteres sobrepasado, solo se puede ingresar de 5 a 30 caracteres")
                    || !validar.validarConRegex(contrasena, "^.{1,30}$", "Contraseña del usuario", "Limite de caracteres sobrepasado, solo se puede ingresar de 5 a 30 caracteres")
                    || !validar.validarConRegex(nombreCompleto, "^[a-zA-Z ]{1,30}$", "Nombre Verdadero del usuario", "El nombre es invalido, solo se aceptan caracteres alfabeticos, con un limite de 5 a 30 caracteres")
                    || !validar.validarConRegex(rol, "^[a-zA-Z]{1,30}$", "Rol del usuario", "El rol es invalido, solo se aceptan caracteres alfabeticos, con un limite de 5 a 30 caracteres")
                    ) {
                return retornar;
            } else {
                Usuario userModded = new Usuario(newUser, contrasena, nombreCompleto, rol, status);
                for (int cont = 0; cont < listaUsuarios.size(); cont++) {
                    if (listaUsuarios.get(cont).getId().equals(iD)) {
                        listaUsuarios.set(cont, userModded);
                    }
                }
                retornar = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return retornar;
        }
        return retornar;
    }

    public boolean eliminarUsuario(Usuario user, String id) {
        try {
            return eliminarEnFirebase(id);
        } catch (Exception e) {
            System.out.println("Error" + e);
            return false;
        }

    }

    //MÉTODOS VARIOS//
    public boolean usuarioExistente(String username) {
        boolean existe = false;
        for (int cont = 0; cont < listaUsuarios.size(); cont++) {
            if (listaUsuarios.get(cont).getUsername().equals(username)) {
                existe = true;
            }
        }
        return existe;
    }

    public Usuario listarUsuario(String id) {
        for (Usuario encontrar : listaUsuarios) {
            if (encontrar.getId().equals(id)) {
                return encontrar;
            }
        }
        JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }

    public String listarUsuarioPorNombre(String nombreDeUsuario) {
        for (Usuario i : getListaUsuarios()) {
            if (i.getUsername().equals(nombreDeUsuario)) {
                return i.getId();
            }
        }
        return null;
    }

    public Usuario iniciarSesion(String user, String contrasena) {
        boolean permitirUser = false;
        boolean permitirPass = false;
        Usuario usuarioIniciado = null;
        for (int cont = 0; cont < listaUsuarios.size(); cont++) {
            if (listaUsuarios.get(cont).getUsername().equals(user) && listaUsuarios.get(cont).getContrasena().equals(contrasena)) {
                permitirUser = true;
                permitirPass = true;
                usuarioIniciado = listaUsuarios.get(cont);
            }
        }
        if (permitirUser == true && permitirPass == true) {
            return usuarioIniciado;
        } else if ((permitirUser == false && permitirPass == true) || (permitirUser == false && permitirPass == false) || (permitirUser == true && permitirPass == false)) {
            JOptionPane.showMessageDialog(null, "El usuario y la contraseña no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

}
