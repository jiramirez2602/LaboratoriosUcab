package Views;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import controller.Excel;
import controller.ListaDeEquipos;
import controller.ListaLaboratorios;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Equipo;
import model.Laboratorio;
import model.Usuario;
import view.Login;

public class EquiposExcel extends javax.swing.JPanel {

    private ListaLaboratorios listalaboratorios;
    private Usuario userActual;
    private ListaDeEquipos listaequipos;
    private DefaultTableModel tableModelEquipos;
    private HashMap<Integer, String> idMapEquipos;

    public EquiposExcel(Usuario user, ListaLaboratorios listaLab, ListaDeEquipos equipos) {
        this.listalaboratorios = listaLab;
        this.listaequipos = equipos;
        this.userActual = user;
        idMapEquipos = new HashMap<>();
        initComponents();
        inicializarTablaEquipos(); 
        actualizarTablaEquipos();
        BackgroundEquipos.setVisible(false);
        exportarExcel();
        FlatMaterialLighterIJTheme.setup();
        MostrarJPanel(new Principal());
    }

    private void inicializarTablaEquipos() {
        String[] columnas = {
            "Nombre", "Tipo", "Inventario", "Marca", "Modelo", "Número Serial",
            "Número Activo", "Presentación", "Voltaje", "Descripción", "Procesable",
            "Material Requerido", "Año de Compra", "Aplicación", "Último Mantenimiento",
            "Próximo Mantenimiento", "Última Calibración", "Próxima Calibración",
            "Proveedores de Servicios", "Encendido de Noche", "Laboratorio"
        };
        tableModelEquipos = new DefaultTableModel(columnas, 0);
        jTable1.setModel(tableModelEquipos);
    }
    
    private void exportarExcel(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(EquiposExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            Excel exportar = new Excel();
            exportar.exportarExcel(jTable1,"Reportes de Equipos");
        }
        catch(IOException e){
            System.out.println("Error de exportación");
        }
    }

    private void actualizarTablaEquipos() {
        tableModelEquipos.setRowCount(0);
        idMapEquipos.clear();
        int row = 0;

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        try {
            ArrayList<Equipo> equipos = listaequipos.getListaEquipos();

            for (Equipo equipo : equipos) {
                Laboratorio laboratorio = listalaboratorios.listarLaboratorio(equipo.getLaboratorio());
                String nombreLaboratorio = (laboratorio != null) ? laboratorio.getNombreLaboratorio() : "Desconocido";

                Object[] fila = {
                    equipo.getNombreProducto(),
                    equipo.getTipoDeProducto(),
                    equipo.getInventarioExistente(),
                    equipo.getMarca(),
                    equipo.getModelo(),
                    equipo.getNumeroSerial(),
                    equipo.getNumeroActivo(),
                    equipo.getPresentacion(),
                    equipo.getVoltaje(),
                    equipo.getDescripcion(),
                    equipo.getProcesable(),
                    equipo.getMaterialRequerido(),
                    equipo.getAñoDeCompra(),
                    equipo.getAplicacion(),
                    equipo.getUltimoMantenimiento(),
                    equipo.getProximoMantenimiento(),
                    equipo.getUltimaCalibracion(),
                    equipo.getProximaCalibracion(),
                    equipo.getProovedoresDeServicios(),
                    equipo.getEncendidoDenoche(),
                    nombreLaboratorio
                };
                tableModelEquipos.addRow(fila);

                idMapEquipos.put(row, equipo.getId());

                for (int i = 0; i < tableModelEquipos.getColumnCount(); i++) {
                    jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }

                row++;
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Error al obtener la lista de equipos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void MostrarJPanel(JPanel p) {
        p.setSize(1392, 698);
        p.setLocation(0, 0);
        BackgroundEquipos.removeAll();
        BackgroundEquipos.add(p, BorderLayout.CENTER);
        BackgroundEquipos.revalidate();
        BackgroundEquipos.repaint();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundEquipos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        BackgroundEquipos.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout BackgroundEquiposLayout = new javax.swing.GroupLayout(BackgroundEquipos);
        BackgroundEquipos.setLayout(BackgroundEquiposLayout);
        BackgroundEquiposLayout.setHorizontalGroup(
            BackgroundEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundEquiposLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1359, Short.MAX_VALUE)
                .addContainerGap())
        );
        BackgroundEquiposLayout.setVerticalGroup(
            BackgroundEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundEquiposLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(384, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackgroundEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackgroundEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        
    }//GEN-LAST:event_jTable1MousePressed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackgroundEquipos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}