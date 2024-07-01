package Views;

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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Insumo;
import model.Usuario;

public class Insumos extends javax.swing.JPanel {
    
    private ListaLaboratorios listalaboratorios;
    private Usuario userActual;
    private ListaDeInsumos listaInsumos;
    private DefaultTableModel tableModelEquipos;
     private DefaultTableModel tableModelInsumo;
    private HashMap<Integer, String> idMapInsumos;
    
    public Insumos(Usuario user, ListaLaboratorios listaLab, ListaDeInsumos insumos) {
        this.listalaboratorios = listaLab;
        this.listaInsumos = insumos;
        this.userActual = user;
        idMapInsumos = new HashMap<>();
        initComponents();
        InitStyles();
        inicializarTablaInsumos();
        actualizarTablaInsumos();
        bloquearPorRol(userActual);
    }
    
    private void inicializarTablaInsumos() {
        String[] columnas = {"Nombre de producto", "Tipo de producto", "Inventario Existente", "Observaciones", "Descripcion", "Marca", "Modelo", "Precio Estimado"};
        tableModelInsumo = new DefaultTableModel(columnas, 0);
        JTableInsumos.setModel(tableModelInsumo);
    }
    
    private void bloquearPorRol(Usuario user){
        if(user.verificarRol(user,"Invitado")){
            BotonCrearInsumo.setEnabled(false);
            BotonEliminarInsumo.setEnabled(false);
            BotonModificarInsumo.setEnabled(false);
            ExportarBtton.setEnabled(false);
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
                Object[] fila = {
                    insumo.getNombreProducto(),
                    insumo.getTipoDeProducto(),
                    insumo.getInventarioExistente(),
                    insumo.getObservaciones(),
                    insumo.getDescripcion(),
                    insumo.getMarca(),
                    insumo.getModelo(),
                    insumo.getPrecioEstimado()
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
            ex.printStackTrace();
        }

        JTableInsumos.setDefaultEditor(Object.class, null);
    }
    
    private void InitStyles() {
        title.putClientProperty("FlatLaf.styleClass", "h1");
        title.setForeground(Color.black);
    }
    
    
    public  void ShowJPanel(JPanel p) {
        p.setSize(1038, 666);
        p.setLocation(0,0);
        BackGroundInsumos.removeAll();
        BackGroundInsumos.add(p,BorderLayout.CENTER);
        BackGroundInsumos.revalidate();
        BackGroundInsumos.repaint();
    }
    
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackGroundInsumos = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableInsumos = new javax.swing.JTable();
        BotonEliminarInsumo = new javax.swing.JButton();
        BotonModificarInsumo = new javax.swing.JButton();
        BotonCrearInsumo = new javax.swing.JButton();
        ExportarBtton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        BackGroundInsumos.setBackground(new java.awt.Color(255, 255, 255));

        title.setText("Insumos");

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

        BotonEliminarInsumo.setBackground(new java.awt.Color(18, 90, 173));
        BotonEliminarInsumo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotonEliminarInsumo.setForeground(new java.awt.Color(255, 255, 255));
        BotonEliminarInsumo.setText("Borrar");
        BotonEliminarInsumo.setBorderPainted(false);
        BotonEliminarInsumo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonEliminarInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarInsumoActionPerformed(evt);
            }
        });

        BotonModificarInsumo.setBackground(new java.awt.Color(18, 90, 173));
        BotonModificarInsumo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotonModificarInsumo.setForeground(new java.awt.Color(255, 255, 255));
        BotonModificarInsumo.setText("Editar");
        BotonModificarInsumo.setBorderPainted(false);
        BotonModificarInsumo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonModificarInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonModificarInsumoActionPerformed(evt);
            }
        });

        BotonCrearInsumo.setBackground(new java.awt.Color(18, 90, 173));
        BotonCrearInsumo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotonCrearInsumo.setForeground(new java.awt.Color(255, 255, 255));
        BotonCrearInsumo.setText("Nuevo");
        BotonCrearInsumo.setBorderPainted(false);
        BotonCrearInsumo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonCrearInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCrearInsumoActionPerformed(evt);
            }
        });

        ExportarBtton.setBackground(new java.awt.Color(18, 90, 173));
        ExportarBtton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ExportarBtton.setForeground(new java.awt.Color(255, 255, 255));
        ExportarBtton.setText("Exportar");
        ExportarBtton.setBorderPainted(false);
        ExportarBtton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ExportarBtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportarBttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BackGroundInsumosLayout = new javax.swing.GroupLayout(BackGroundInsumos);
        BackGroundInsumos.setLayout(BackGroundInsumosLayout);
        BackGroundInsumosLayout.setHorizontalGroup(
            BackGroundInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundInsumosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BackGroundInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackGroundInsumosLayout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(699, 699, 699))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackGroundInsumosLayout.createSequentialGroup()
                        .addGroup(BackGroundInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(BackGroundInsumosLayout.createSequentialGroup()
                                .addGap(331, 331, 331)
                                .addComponent(ExportarBtton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BotonCrearInsumo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BotonModificarInsumo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BotonEliminarInsumo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(50, 50, 50))))
        );
        BackGroundInsumosLayout.setVerticalGroup(
            BackGroundInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundInsumosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BackGroundInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonEliminarInsumo)
                    .addComponent(BotonModificarInsumo)
                    .addComponent(BotonCrearInsumo)
                    .addComponent(ExportarBtton))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGroundInsumos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGroundInsumos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JTableInsumosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableInsumosMousePressed

    }//GEN-LAST:event_JTableInsumosMousePressed

    private void BotonCrearInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCrearInsumoActionPerformed
        ShowJPanel(new Crearinsumos(userActual,listalaboratorios,listaInsumos));
    }//GEN-LAST:event_BotonCrearInsumoActionPerformed

    private void BotonEliminarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarInsumoActionPerformed
     int selectedRow = JTableInsumos.getSelectedRow(); // Obtener la fila seleccionada en la tabla

    if (selectedRow != -1) { // Verificar que se ha seleccionado una fila
        String idInsumoAEliminar = idMapInsumos.get(selectedRow); // Obtener el ID del insumo a eliminar

        if (idInsumoAEliminar != null && !idInsumoAEliminar.isEmpty()) { // Verificar que el ID no es nulo o vacío
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este insumo?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION); // Mostrar diálogo de confirmación

            if (confirmacion == JOptionPane.YES_OPTION) { // Si el usuario confirma la eliminación
                boolean eliminacionExitosa = listaInsumos.eliminarInsumo(userActual, idInsumoAEliminar); // Intentar eliminar el insumo

                if (eliminacionExitosa) { // Verificar si la eliminación fue exitosa
                    JOptionPane.showMessageDialog(null, "Insumo eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE); // Mostrar mensaje de éxito
                    actualizarTablaInsumos(); // Actualizar la tabla de insumos
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el insumo.", "Error", JOptionPane.ERROR_MESSAGE); // Mostrar mensaje de error
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún insumo para eliminar.", "Error", JOptionPane.ERROR_MESSAGE); // Mensaje de error si no hay insumo seleccionado
        }
    } else {
        JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE); // Mensaje de error si no se ha seleccionado ninguna fila
    }
    }//GEN-LAST:event_BotonEliminarInsumoActionPerformed

    private void BotonModificarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonModificarInsumoActionPerformed
        int selectedRow = JTableInsumos.getSelectedRow();

    if (selectedRow != -1) {
        String idInsumo = idMapInsumos.get(selectedRow); 
        Insumo insumo = null;

        try {
            insumo = listaInsumos.listarInsumo(idInsumo);
        } catch (ParseException ex) {
            Logger.getLogger(Insumos.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (insumo != null) {
            ShowJPanel(new ModificarInsumos(userActual, listalaboratorios, listaInsumos,insumo));
        } else {
            JOptionPane.showMessageDialog(null, "Insumo no encontrado", "Error", JOptionPane.ERROR_MESSAGE); // Mostrar mensaje de error si no se encuentra el insumo
        }
    } else {
        JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila para modificar.", "Error", JOptionPane.ERROR_MESSAGE); // Mensaje de error si no se ha seleccionado ninguna fila
    }
    }//GEN-LAST:event_BotonModificarInsumoActionPerformed

    private void ExportarBttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportarBttonActionPerformed
        ShowJPanel(new InsumosExcel(userActual,listalaboratorios,listaInsumos));
    }//GEN-LAST:event_ExportarBttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGroundInsumos;
    private javax.swing.JButton BotonCrearInsumo;
    private javax.swing.JButton BotonEliminarInsumo;
    private javax.swing.JButton BotonModificarInsumo;
    private javax.swing.JButton ExportarBtton;
    private javax.swing.JTable JTableInsumos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}