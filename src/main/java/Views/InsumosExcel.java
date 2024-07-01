package Views;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import controller.Excel;
import controller.ListaDeEquipos;
import controller.ListaDeInsumos;
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
import model.Usuario;
import view.Login;

public class InsumosExcel extends javax.swing.JPanel {

    private ListaLaboratorios listalaboratorios;
    private Usuario userActual;
    private ListaDeInsumos listaInsumos;
    private DefaultTableModel tableModelEquipos;
    private DefaultTableModel tableModelInsumo;
    private HashMap<Integer, String> idMapInsumos;
    
    public InsumosExcel(Usuario user, ListaLaboratorios listaLab, ListaDeInsumos insumos) {
        this.listalaboratorios = listaLab;
        this.listaInsumos = insumos;
        this.userActual = user;
        idMapInsumos = new HashMap<>();
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
            "Observaciones", "Descripción", 
            "Marca", "Modelo","Presentación","Clasificación","Categoria","Última Compra", "Precio Estimado","Unidad","Proovedor","Laboratorio"};
        tableModelInsumo = new DefaultTableModel(columnas, 0);
        JTableInsumos.setModel(tableModelInsumo);
    }
    
    private void exportarExcel(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(InsumosExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            Excel exportar = new Excel();
            exportar.exportarExcel(JTableInsumos,"Reportes de Insumos");
        }
        catch(IOException e){
            System.out.println("Error de exportación");
        }
    }

    private void actualizarTablaInsumos() {
        tableModelInsumo.setRowCount(0);
        idMapInsumos.clear();
        int row = 0;

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        try {
            ArrayList<Insumo> insumos = listaInsumos.getListaInsumos();

            for (Insumo insumo : insumos) {
                Laboratorio laboratorio = listalaboratorios.listarLaboratorio(insumo.getLaboratorio());
                String nombreLaboratorio = (laboratorio != null) ? laboratorio.getNombreLaboratorio() : "Desconocido";
                Object[] fila = {
                    insumo.getNombreProducto(),
                    insumo.getTipoDeProducto(),
                    insumo.getInventarioExistente(),
                    insumo.getObservaciones(),
                    insumo.getDescripcion(),
                    insumo.getMarca(),
                    insumo.getModelo(),
                    insumo.getPresentacion(),
                    insumo.getClasificacion(),
                    insumo.getCategoria(),
                    insumo.getUltimaCompra(),
                    insumo.getPrecioEstimado(),
                    insumo.getUnidad(),
                    insumo.getProveedor(),
                    nombreLaboratorio
                };
                tableModelInsumo.addRow(fila);

                idMapInsumos.put(row, insumo.getId());

                for (int i = 0; i < tableModelInsumo.getColumnCount(); i++) {
                    JTableInsumos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }

                row++;
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Error al obtener la lista de insumos.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        JTableInsumos.setDefaultEditor(Object.class, null);
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
        JTableInsumos = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        BackgroundEquipos.setBackground(new java.awt.Color(255, 255, 255));

        JTableInsumos.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        JTableInsumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTableInsumos.getTableHeader().setReorderingAllowed(false);
        JTableInsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTableInsumosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(JTableInsumos);

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

    private void JTableInsumosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableInsumosMousePressed

    }//GEN-LAST:event_JTableInsumosMousePressed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackgroundEquipos;
    private javax.swing.JTable JTableInsumos;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}