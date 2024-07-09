package Views;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import controller.Excel;
import controller.ListaDeEquipos;
import controller.ListaDeInsumos;
import controller.ListaDeSustanciasQuimicas;
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
import model.Insumo;
import model.Laboratorio;
import model.SustanciaQuimica;
import model.Usuario;
import view.Login;

public class SustanciasExcel extends javax.swing.JPanel {

    private ListaLaboratorios listalaboratorios;
    private Usuario userActual;
    private ListaDeInsumos listaInsumos;
    private DefaultTableModel tableModelEquipos;
    private DefaultTableModel tableModelInsumo;
    private DefaultTableModel tableModelSustancias;
    private ListaDeSustanciasQuimicas listaQuimicas;
    private HashMap<Integer, String> idMapSustancias;
    
    public SustanciasExcel(Usuario user, ListaLaboratorios listaLab, ListaDeSustanciasQuimicas sustancias) {
        this.listalaboratorios = listaLab;
        this.listaQuimicas = sustancias;
        this.userActual = user;
        idMapSustancias = new HashMap<>();
        initComponents();
        inicializarTablaInsumos();
        actualizarTablaInsumos();
        BackgroundEquipos.setVisible(false);
        exportarExcel();
        FlatMaterialLighterIJTheme.setup();
    }

    private void inicializarTablaInsumos() {
        String[] columnas = {"Nombre de producto", "Tipo de producto", 
            "Inventario Existente", 
            "Observaciones", "Formula Química", 
            "Concentración", "Presentación","Nombre Comercial","Posee MSD","Numero de Identificacion","Grupo de Riesgo",
            "Frase R","Frase S","Método de control","Permisos","Unidad","Precio estimado","Proovedor","Almacenado","Laboratorio"};
        tableModelSustancias = new DefaultTableModel(columnas, 0);
        JTableSustancias.setModel(tableModelSustancias);
    }
    
    private void exportarExcel(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SustanciasExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            Excel exportar = new Excel();
            exportar.exportarExcel(JTableSustancias,"Reportes de Sustancias");
        }
        catch(IOException e){
            System.out.println("Error de exportación");
        }
    }

    private void actualizarTablaInsumos() {
        tableModelSustancias.setRowCount(0);
        idMapSustancias.clear();
        int row = 0;

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        try {
            ArrayList<SustanciaQuimica> sustancias = listaQuimicas.getListaSustanciasQuimicas();

            for (SustanciaQuimica sustancia : sustancias) {
                Laboratorio laboratorio = listalaboratorios.listarLaboratorio(sustancia.getLaboratorio());
                String nombreLaboratorio = (laboratorio != null) ? laboratorio.getNombreLaboratorio() : "Desconocido";
                String msd="Desconocido";
                if(sustancia.getPoseeMSD()==true){
                    msd="Posee";
                }
                else{
                    msd="No posee";
                }
                
                Object[] fila = {
                    sustancia.getNombreProducto(),
                    sustancia.getTipoDeProducto(),
                    sustancia.getInventarioExistente(),
                    sustancia.getObservaciones(),
                    sustancia.getFormulaQuimica(),
                    sustancia.getConcentracion(),
                    sustancia.getPresentacion(),
                    sustancia.getNombreComercial(),
                    msd,
                    sustancia.getNumeroDeIdentificacion(),
                    sustancia.getGrupoDeRiesgo(),
                    sustancia.getFraseR(),
                    sustancia.getFraseS(),
                    sustancia.getMetodoDeControl(),
                    sustancia.getPermisos(),
                    sustancia.getUnidad(),
                    sustancia.getPrecioEstimado(),
                    sustancia.getProveedor(),
                    sustancia.getAlmacenadoEnvasado(),
                    nombreLaboratorio
                };
                tableModelSustancias.addRow(fila);

                idMapSustancias.put(row, sustancia.getId());

                for (int i = 0; i < tableModelSustancias.getColumnCount(); i++) {
                    JTableSustancias.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }

                row++;
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Error al obtener la lista de sustancias.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        JTableSustancias.setDefaultEditor(Object.class, null);
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
        JTableSustancias = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        BackgroundEquipos.setBackground(new java.awt.Color(255, 255, 255));

        JTableSustancias.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        JTableSustancias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTableSustancias.getTableHeader().setReorderingAllowed(false);
        JTableSustancias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTableSustanciasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(JTableSustancias);

        javax.swing.GroupLayout BackgroundEquiposLayout = new javax.swing.GroupLayout(BackgroundEquipos);
        BackgroundEquipos.setLayout(BackgroundEquiposLayout);
        BackgroundEquiposLayout.setHorizontalGroup(
            BackgroundEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundEquiposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1359, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        BackgroundEquiposLayout.setVerticalGroup(
            BackgroundEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundEquiposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(493, Short.MAX_VALUE))
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

    private void JTableSustanciasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableSustanciasMousePressed

    }//GEN-LAST:event_JTableSustanciasMousePressed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackgroundEquipos;
    private javax.swing.JTable JTableSustancias;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}