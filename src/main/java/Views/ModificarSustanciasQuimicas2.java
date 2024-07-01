/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import controller.ListaDeEquipos;
import controller.ListaDeSustanciasQuimicas;
import controller.ListaLaboratorios;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Laboratorio;
import model.SustanciaQuimica;
import model.Usuario;

/**
 *
 * @author derno
 */
public class ModificarSustanciasQuimicas2 extends javax.swing.JPanel {
    
    private Usuario userActual;
    private ListaLaboratorios listalaboratorios;
    private ListaDeSustanciasQuimicas listadesustancias;
    private SustanciaQuimica sustanciaActual;
    private String nombreSustancia;
    private String nombreComercial;
    private String concentracion;
    private String formula;
    private String presentacion;
    private Boolean poseeMSD;
    private String numeroIdentificacion;
    private String metodo;
    private String permisos;
    private String unidad;
    private String proveedor;
    private DefaultTableModel tableModelLab;
    
    public ModificarSustanciasQuimicas2(Usuario user, ListaLaboratorios listaLab, ListaDeSustanciasQuimicas sustancias, SustanciaQuimica sustancia, 
                            String nombreSustancia, String nombreComercial, String concentracion,String formula, 
                            String presentacion, Boolean poseeMSD, String numeroIdentificacion, 
                            String metodo, String permisos, String unidad, String proveedor) {
        initComponents();
        this.userActual = user;
        this.listalaboratorios = listaLab;
        this.sustanciaActual = sustancia;
        this.listadesustancias = sustancias;
        this.nombreSustancia = nombreSustancia;
        this.nombreComercial = nombreComercial;
        this.concentracion = concentracion;
        this.formula = formula;
        this.presentacion = presentacion;
        this.poseeMSD = poseeMSD;
        this.numeroIdentificacion = numeroIdentificacion;
        this.metodo = metodo;
        this.permisos = permisos;
        this.unidad = unidad;
        this.proveedor = proveedor;
        initLabDisponible();
        cargarDatosSustancia();
        inicializarTablaLabActual();
        cargarLabActual();
    }
    
    private void cargarDatosSustancia() {
        if (sustanciaActual != null) {
            AlmacenadoSustanciaTxt.setText(sustanciaActual.getAlmacenadoEnvasado());
            FraseRTxt.setText(sustanciaActual.getFraseR());
            FraseSTxt.setText(sustanciaActual.getFraseS());
            GrupoRiesgoTxt.setText(sustanciaActual.getGrupoDeRiesgo());
            InventarioExistente.setText(String.valueOf(sustanciaActual.getInventarioExistente()));
            ObservacionesSutanciasTxt.setText(sustanciaActual.getObservaciones());
            PrecioEstimadoTxt.setText(String.valueOf(sustanciaActual.getPrecioEstimado()));
        }
    }
    private void inicializarTablaLabActual() {
        String[] columnas = {"Nombre Laboratorio"};
        tableModelLab = new DefaultTableModel(columnas, 0);
        LabActual.setModel(tableModelLab);
    }
    
    private void initLabDisponible() {
        ArrayList<Laboratorio> laboratorios = listalaboratorios.getListaLaboratorios();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        for (Laboratorio lab : laboratorios) {
            model.addElement(lab.getNombreLaboratorio());
        }

        LabDisponible.setModel(model);
    }

    private void LabDisponibleActionPerformed(java.awt.event.ActionEvent evt) {                                              
        String nombreLaboratorioSeleccionado = (String) LabDisponible.getSelectedItem();
        String idLaboratorio = listalaboratorios.listarLaboratorioPorNombre(nombreLaboratorioSeleccionado);
    }
    
    private void cargarLabActual() {
        tableModelLab.setRowCount(0);

        if (sustanciaActual != null) {
            String idLaboratorio = sustanciaActual.getLaboratorio();
            Laboratorio laboratorioActual = listalaboratorios.listarLaboratorio(idLaboratorio);

            if (laboratorioActual != null) {
                Object[] fila = {laboratorioActual.getNombreLaboratorio()};
                tableModelLab.addRow(fila);
            } else {
                System.out.println("Laboratorio no encontrado");
            }
        }
    }
    
      private void MostrarJpanel(JPanel p){
        p.setSize(1038, 666);   
        p.setLocation(0,0);
        BackgroundCrearEquipo1.removeAll();
        BackgroundCrearEquipo1.add(p,BorderLayout.CENTER);
        BackgroundCrearEquipo1.revalidate();
        BackgroundCrearEquipo1.repaint();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Rol = new javax.swing.ButtonGroup();
        Estado = new javax.swing.ButtonGroup();
        Procesable = new javax.swing.ButtonGroup();
        BackgroundCrearEquipo1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameLbl1 = new javax.swing.JLabel();
        FraseRTxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        ModificarSustanciaFinal = new javax.swing.JButton();
        nameLbl3 = new javax.swing.JLabel();
        FraseSTxt = new javax.swing.JTextField();
        nameLbl6 = new javax.swing.JLabel();
        InventarioExistente = new javax.swing.JTextField();
        nameLbl4 = new javax.swing.JLabel();
        ObservacionesSutanciasTxt = new javax.swing.JTextField();
        nameLbl5 = new javax.swing.JLabel();
        AlmacenadoSustanciaTxt = new javax.swing.JTextField();
        nameLbl7 = new javax.swing.JLabel();
        GrupoRiesgoTxt = new javax.swing.JTextField();
        nameLbl8 = new javax.swing.JLabel();
        PrecioEstimadoTxt = new javax.swing.JTextField();
        nameLbl11 = new javax.swing.JLabel();
        LabDisponible = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        LabActual = new javax.swing.JTable();
        nameLbl13 = new javax.swing.JLabel();

        BackgroundCrearEquipo1.setBackground(new java.awt.Color(255, 255, 255));
        BackgroundCrearEquipo1.setMinimumSize(new java.awt.Dimension(1038, 666));
        BackgroundCrearEquipo1.setPreferredSize(new java.awt.Dimension(1038, 666));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Crear Sustancia Quimica");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Por favor, ingrese los datos para poder crear la sustancia: ");

        nameLbl1.setText("Ingrese la Frase R:");

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));

        ModificarSustanciaFinal.setBackground(new java.awt.Color(21, 101, 192));
        ModificarSustanciaFinal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ModificarSustanciaFinal.setForeground(new java.awt.Color(255, 255, 255));
        ModificarSustanciaFinal.setText("Modificar");
        ModificarSustanciaFinal.setBorder(null);
        ModificarSustanciaFinal.setBorderPainted(false);
        ModificarSustanciaFinal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ModificarSustanciaFinal.setIconTextGap(13);
        ModificarSustanciaFinal.setInheritsPopupMenu(true);
        ModificarSustanciaFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarSustanciaFinalActionPerformed(evt);
            }
        });

        nameLbl3.setText("Ingrese la Frase S:");

        nameLbl6.setText("Ingrese el inventario existente:");

        nameLbl4.setText("Ingrese las observaciones:");

        nameLbl5.setText("Ingrese el almacenado:");

        nameLbl7.setText("Ingrese el grupo riesgo:");

        nameLbl8.setText("Ingrese el precio estimado:");

        nameLbl11.setText("Escoja el laboratorio a asignar:");

        LabDisponible.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        LabActual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(LabActual);

        nameLbl13.setText("Laboratorio Actual");

        javax.swing.GroupLayout BackgroundCrearEquipo1Layout = new javax.swing.GroupLayout(BackgroundCrearEquipo1);
        BackgroundCrearEquipo1.setLayout(BackgroundCrearEquipo1Layout);
        BackgroundCrearEquipo1Layout.setHorizontalGroup(
            BackgroundCrearEquipo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundCrearEquipo1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(BackgroundCrearEquipo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundCrearEquipo1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                        .addGap(847, 847, 847))
                    .addGroup(BackgroundCrearEquipo1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(543, 543, 543))
                    .addGroup(BackgroundCrearEquipo1Layout.createSequentialGroup()
                        .addGroup(BackgroundCrearEquipo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BackgroundCrearEquipo1Layout.createSequentialGroup()
                                .addComponent(nameLbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(117, 117, 117))
                            .addGroup(BackgroundCrearEquipo1Layout.createSequentialGroup()
                                .addComponent(nameLbl3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(331, 331, 331))
                            .addGroup(BackgroundCrearEquipo1Layout.createSequentialGroup()
                                .addComponent(nameLbl5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(331, 331, 331))
                            .addGroup(BackgroundCrearEquipo1Layout.createSequentialGroup()
                                .addComponent(nameLbl7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(300, 300, 300))
                            .addGroup(BackgroundCrearEquipo1Layout.createSequentialGroup()
                                .addGroup(BackgroundCrearEquipo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(PrecioEstimadoTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(BackgroundCrearEquipo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nameLbl8, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(BackgroundCrearEquipo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(GrupoRiesgoTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                                            .addComponent(AlmacenadoSustanciaTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(FraseSTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(FraseRTxt, javax.swing.GroupLayout.Alignment.LEADING))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(BackgroundCrearEquipo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BackgroundCrearEquipo1Layout.createSequentialGroup()
                                .addGap(317, 317, 317)
                                .addGroup(BackgroundCrearEquipo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(LabDisponible, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nameLbl11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(159, 159, 159))
                            .addGroup(BackgroundCrearEquipo1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(BackgroundCrearEquipo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(BackgroundCrearEquipo1Layout.createSequentialGroup()
                                        .addComponent(ModificarSustanciaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(BackgroundCrearEquipo1Layout.createSequentialGroup()
                                        .addGroup(BackgroundCrearEquipo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(BackgroundCrearEquipo1Layout.createSequentialGroup()
                                                .addComponent(nameLbl6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(112, 112, 112))
                                            .addGroup(BackgroundCrearEquipo1Layout.createSequentialGroup()
                                                .addComponent(nameLbl4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(281, 281, 281))
                                            .addGroup(BackgroundCrearEquipo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(InventarioExistente, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(ObservacionesSutanciasTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(BackgroundCrearEquipo1Layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addComponent(nameLbl13, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(147, 147, 147))))))))
        );
        BackgroundCrearEquipo1Layout.setVerticalGroup(
            BackgroundCrearEquipo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundCrearEquipo1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(BackgroundCrearEquipo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BackgroundCrearEquipo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(BackgroundCrearEquipo1Layout.createSequentialGroup()
                            .addComponent(nameLbl6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(InventarioExistente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(nameLbl4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(ObservacionesSutanciasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addGroup(BackgroundCrearEquipo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(BackgroundCrearEquipo1Layout.createSequentialGroup()
                                    .addComponent(nameLbl13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(BackgroundCrearEquipo1Layout.createSequentialGroup()
                                    .addComponent(nameLbl11)
                                    .addGap(18, 18, 18)
                                    .addComponent(LabDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ModificarSustanciaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(BackgroundCrearEquipo1Layout.createSequentialGroup()
                            .addComponent(nameLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(FraseRTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(nameLbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(FraseSTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(nameLbl5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(AlmacenadoSustanciaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(nameLbl7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(GrupoRiesgoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(nameLbl8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(PrecioEstimadoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(58, 190, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundCrearEquipo1, javax.swing.GroupLayout.DEFAULT_SIZE, 1142, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundCrearEquipo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ModificarSustanciaFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarSustanciaFinalActionPerformed
        String almacenado = AlmacenadoSustanciaTxt.getText();
        String fraseR = FraseRTxt.getText();
        String fraseS = FraseSTxt.getText();
        String grupoRiesgo = GrupoRiesgoTxt.getText();
        String inventarioExistente = InventarioExistente.getText();
        String observaciones = ObservacionesSutanciasTxt.getText();
        String precioEstimado = PrecioEstimadoTxt.getText();
        
        String nombreLaboratorioSeleccionado = (String) LabDisponible.getSelectedItem();
        String idLaboratorio = listalaboratorios.listarLaboratorioPorNombre(nombreLaboratorioSeleccionado);

        boolean creado = listadesustancias.modificarSustancia(userActual,sustanciaActual.getId(), formula, concentracion, presentacion, nombreComercial, poseeMSD, numeroIdentificacion, grupoRiesgo, fraseR, fraseS, metodo, permisos, unidad, precioEstimado,proveedor,almacenado, nombreSustancia, inventarioExistente, observaciones, idLaboratorio);
        if (creado) {
            JOptionPane.showMessageDialog(this, "Sustancia creada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Error al crear la sustancia. Verifique los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ModificarSustanciaFinalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AlmacenadoSustanciaTxt;
    private javax.swing.JPanel BackgroundCrearEquipo1;
    private javax.swing.ButtonGroup Estado;
    private javax.swing.JTextField FraseRTxt;
    private javax.swing.JTextField FraseSTxt;
    private javax.swing.JTextField GrupoRiesgoTxt;
    private javax.swing.JTextField InventarioExistente;
    private javax.swing.JTable LabActual;
    private javax.swing.JComboBox<String> LabDisponible;
    private javax.swing.JButton ModificarSustanciaFinal;
    private javax.swing.JTextField ObservacionesSutanciasTxt;
    private javax.swing.JTextField PrecioEstimadoTxt;
    private javax.swing.ButtonGroup Procesable;
    private javax.swing.ButtonGroup Rol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel nameLbl1;
    private javax.swing.JLabel nameLbl11;
    private javax.swing.JLabel nameLbl13;
    private javax.swing.JLabel nameLbl3;
    private javax.swing.JLabel nameLbl4;
    private javax.swing.JLabel nameLbl5;
    private javax.swing.JLabel nameLbl6;
    private javax.swing.JLabel nameLbl7;
    private javax.swing.JLabel nameLbl8;
    // End of variables declaration//GEN-END:variables
}
