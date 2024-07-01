package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Excel {
    Workbook book;

    public void exportarExcel(JTable tabla,String reporteTipo) throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Libro de Excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Seleccione un archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xls");
            try {
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                archivoXLS.createNewFile();
                book = new HSSFWorkbook();
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                Sheet hoja = book.createSheet(reporteTipo);
                hoja.setDisplayGridlines(true);
                for (int i = 0; i < tabla.getRowCount(); i++) {
                    Row fila = hoja.createRow(i);
                    for (int j = 0; j < tabla.getColumnCount(); j++) {
                        Cell celda = fila.createCell(j);
                        if (i == 0) {
                            celda.setCellValue(tabla.getColumnName(j));
                        }
                    }
                }
                int filaInicio = 1;
                for (int i=0; i<tabla.getRowCount();i++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int j=0;j< tabla.getColumnCount();j++) {
                        Cell celda = fila.createCell(j);
                        if (tabla.getValueAt(i,j) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(tabla.getValueAt(i,j).toString()));
                        } else if (tabla.getValueAt(i,j) instanceof Float) {
                            celda.setCellValue(Float.parseFloat((String) tabla.getValueAt(i,j).toString()));
                        } else {
                            celda.setCellValue(String.valueOf(tabla.getValueAt(i,j)));
                        }
                    }
                }
                book.write(archivo);
                archivo.close();
            } catch (IOException | NumberFormatException e) {
                throw e;
            }
        }
    }

}
