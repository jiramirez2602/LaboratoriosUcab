package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Validador {

    public String dato;
    public String regex;
    public ArrayList<String> listaValida = new ArrayList<>();

    public void setListaValida(String listaValida) {
        this.listaValida = stringToSubstringsList(listaValida);
    }

    public static ArrayList<String> stringToSubstringsList(String text) {
        String[] substrings = text.split(",");
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList(substrings));
        return stringList;
    }

    public boolean esRegexValido() {
        Pattern patron = Pattern.compile(regex);
        Matcher matcher = patron.matcher(dato);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esItemEnLista() {
        return listaValida.contains(dato);
    }

    public boolean validarConRegex(String dato, String regex, String campo, String descripcion) {
        this.regex = regex;
        this.dato = dato;
        boolean auxBool = true;

        if (!esRegexValido()) {
            String auxStr = "Dato: '" + campo + "' \nError: " + descripcion;
            JOptionPane.showMessageDialog(null, auxStr, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }    
}
