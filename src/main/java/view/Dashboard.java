/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Views.Equipos;
import Views.EquiposExcel;
import Views.EquiposMantenimiento;
import Views.Insumos;
import Views.Reportes;
import Views.Laboratorios;
import Views.Usuarios;
import Views.Principal;
import Views.SustanciasQuimicas;
import Views.Transacciones;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import controller.ListaDeEquipos;
import controller.ListaDeInsumos;
import controller.ListaDeUsuarios;
import controller.ListaLaboratorios;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import model.Usuario;

/**
 *
 * @author Antonio
 */
public class Dashboard extends javax.swing.JFrame {

    private ListaDeUsuarios listaUsuarios;
    private ListaLaboratorios listalaboratorios;
    private Usuario userActual;
    private ListaDeEquipos listaequipos;
    private ListaDeInsumos listaInsumos;

    public Dashboard(Usuario user,ListaDeUsuarios users, ListaLaboratorios laboratorios,ListaDeEquipos equipos, ListaDeInsumos insumos) {
        FlatMaterialLighterIJTheme.setup();
        initComponents();
        InitStyles();
        SetDate();
        InitContent();
        setIconImage(new ImageIcon(getClass().getResource("/file.png")).getImage());
        this.listaUsuarios=users;
        this.listalaboratorios=laboratorios;
        this.listaequipos = equipos;
        this.listaInsumos = insumos;
        this.userActual=user;
        usuarioLabel.setText(userActual.getUsername());
    }

    
    private void InitStyles() {
        dateText.putClientProperty("FlatLaf.style", "font: 36 $light.font");
        dateText.setForeground(Color.white);
    }
    
    private void SetDate() {
        LocalDate now = LocalDate.now();
        Locale spanishLocale = new Locale("es", "VE");
        dateText.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMMM 'de' yyyy", spanishLocale)));
    }
    
    private void InitContent() {
        ShowJPanel(new Principal());
    }
    
    public  void ShowJPanel(JPanel p) {
        p.setSize(1038, 666);
        p.setLocation(0,0);
        Contenido.removeAll();
        Contenido.add(p,BorderLayout.CENTER);
        Contenido.revalidate();
        Contenido.repaint();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        btn_prin = new javax.swing.JButton();
        BotonUsuarios = new javax.swing.JButton();
        BotonLaboratorios = new javax.swing.JButton();
        BotonEquipos = new javax.swing.JButton();
        BotonTransacciones = new javax.swing.JButton();
        BotonReportes = new javax.swing.JButton();
        usuarioLabel = new javax.swing.JLabel();
        BotonInsumos = new javax.swing.JButton();
        BotonSustanciasQuimicas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        dateText = new javax.swing.JLabel();
        Contenido = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1392, 698));

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setMinimumSize(new java.awt.Dimension(1038, 666));

        menu.setBackground(new java.awt.Color(13, 71, 161));
        menu.setPreferredSize(new java.awt.Dimension(270, 640));

        btn_prin.setBackground(new java.awt.Color(21, 101, 192));
        btn_prin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_prin.setForeground(new java.awt.Color(255, 255, 255));
        btn_prin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-outline.png"))); // NOI18N
        btn_prin.setText("Principal");
        btn_prin.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_prin.setBorderPainted(false);
        btn_prin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_prin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_prin.setIconTextGap(13);
        btn_prin.setInheritsPopupMenu(true);
        btn_prin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prinActionPerformed(evt);
            }
        });

        BotonUsuarios.setBackground(new java.awt.Color(21, 101, 192));
        BotonUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotonUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        BotonUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/account-multiple.png"))); // NOI18N
        BotonUsuarios.setText("Usuarios");
        BotonUsuarios.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        BotonUsuarios.setBorderPainted(false);
        BotonUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BotonUsuarios.setIconTextGap(13);
        BotonUsuarios.setInheritsPopupMenu(true);
        BotonUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonUsuariosActionPerformed(evt);
            }
        });

        BotonLaboratorios.setBackground(new java.awt.Color(21, 101, 192));
        BotonLaboratorios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotonLaboratorios.setForeground(new java.awt.Color(255, 255, 255));
        BotonLaboratorios.setText("Laboratorios");
        BotonLaboratorios.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        BotonLaboratorios.setBorderPainted(false);
        BotonLaboratorios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonLaboratorios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BotonLaboratorios.setIconTextGap(13);
        BotonLaboratorios.setInheritsPopupMenu(true);
        BotonLaboratorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLaboratoriosActionPerformed(evt);
            }
        });

        BotonEquipos.setBackground(new java.awt.Color(21, 101, 192));
        BotonEquipos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotonEquipos.setForeground(new java.awt.Color(255, 255, 255));
        BotonEquipos.setText("Equipos");
        BotonEquipos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        BotonEquipos.setBorderPainted(false);
        BotonEquipos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonEquipos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BotonEquipos.setIconTextGap(13);
        BotonEquipos.setInheritsPopupMenu(true);
        BotonEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEquiposActionPerformed(evt);
            }
        });

        BotonTransacciones.setBackground(new java.awt.Color(21, 101, 192));
        BotonTransacciones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotonTransacciones.setForeground(new java.awt.Color(255, 255, 255));
        BotonTransacciones.setText("Transacciones");
        BotonTransacciones.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        BotonTransacciones.setBorderPainted(false);
        BotonTransacciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonTransacciones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BotonTransacciones.setIconTextGap(13);
        BotonTransacciones.setInheritsPopupMenu(true);
        BotonTransacciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonTransaccionesActionPerformed(evt);
            }
        });

        BotonReportes.setBackground(new java.awt.Color(21, 101, 192));
        BotonReportes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotonReportes.setForeground(new java.awt.Color(255, 255, 255));
        BotonReportes.setText("Mantenimiento de equipos");
        BotonReportes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        BotonReportes.setBorderPainted(false);
        BotonReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonReportes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BotonReportes.setIconTextGap(13);
        BotonReportes.setInheritsPopupMenu(true);
        BotonReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonReportesActionPerformed(evt);
            }
        });

        usuarioLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        usuarioLabel.setForeground(new java.awt.Color(255, 255, 255));
        usuarioLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usuarioLabel.setText("Usuario");

        BotonInsumos.setBackground(new java.awt.Color(21, 101, 192));
        BotonInsumos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotonInsumos.setForeground(new java.awt.Color(255, 255, 255));
        BotonInsumos.setText("Insumos");
        BotonInsumos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        BotonInsumos.setBorderPainted(false);
        BotonInsumos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonInsumos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BotonInsumos.setIconTextGap(13);
        BotonInsumos.setInheritsPopupMenu(true);
        BotonInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInsumosActionPerformed(evt);
            }
        });

        BotonSustanciasQuimicas.setBackground(new java.awt.Color(21, 101, 192));
        BotonSustanciasQuimicas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotonSustanciasQuimicas.setForeground(new java.awt.Color(255, 255, 255));
        BotonSustanciasQuimicas.setText("Sustancias Quimicas");
        BotonSustanciasQuimicas.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        BotonSustanciasQuimicas.setBorderPainted(false);
        BotonSustanciasQuimicas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonSustanciasQuimicas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BotonSustanciasQuimicas.setIconTextGap(13);
        BotonSustanciasQuimicas.setInheritsPopupMenu(true);
        BotonSustanciasQuimicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSustanciasQuimicasActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Usuario:");

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BotonUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_prin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotonLaboratorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usuarioLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(BotonEquipos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotonSustanciasQuimicas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotonTransacciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotonReportes, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addComponent(BotonInsumos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuarioLabel)
                    .addComponent(jLabel1))
                .addGap(57, 57, 57)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(BotonUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_prin, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(BotonLaboratorios, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(BotonEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(BotonSustanciasQuimicas, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(BotonInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(BotonTransacciones, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(BotonReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(293, Short.MAX_VALUE))
        );

        header.setBackground(new java.awt.Color(25, 118, 210));
        header.setPreferredSize(new java.awt.Dimension(744, 150));

        dateText.setText("Hoy es {dayname} {day} de {month} de {year}");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(434, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        Contenido.setBackground(new java.awt.Color(255, 255, 255));
        Contenido.setMinimumSize(new java.awt.Dimension(1140, 698));
        Contenido.setPreferredSize(new java.awt.Dimension(1038, 666));

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 1147, Short.MAX_VALUE))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 1141, Short.MAX_VALUE))
            .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE))
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_prinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prinActionPerformed
        ShowJPanel(new Principal());
    }//GEN-LAST:event_btn_prinActionPerformed

    private void BotonUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonUsuariosActionPerformed
        ShowJPanel(new Usuarios(userActual,listaUsuarios));
    }//GEN-LAST:event_BotonUsuariosActionPerformed

    private void BotonLaboratoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLaboratoriosActionPerformed
        ShowJPanel(new Laboratorios(userActual,listalaboratorios,listaUsuarios));
    }//GEN-LAST:event_BotonLaboratoriosActionPerformed

    private void BotonEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEquiposActionPerformed
        ShowJPanel(new Equipos(userActual,listalaboratorios,listaequipos));
    }//GEN-LAST:event_BotonEquiposActionPerformed

    private void BotonTransaccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonTransaccionesActionPerformed
        
    }//GEN-LAST:event_BotonTransaccionesActionPerformed

    private void BotonReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonReportesActionPerformed
        ShowJPanel(new EquiposMantenimiento(userActual,listalaboratorios,listaequipos));
    }//GEN-LAST:event_BotonReportesActionPerformed

    private void BotonInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInsumosActionPerformed
        ShowJPanel(new Insumos(userActual,listalaboratorios,listaInsumos));
    }//GEN-LAST:event_BotonInsumosActionPerformed

    private void BotonSustanciasQuimicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSustanciasQuimicasActionPerformed
        ShowJPanel(new SustanciasQuimicas());
    }//GEN-LAST:event_BotonSustanciasQuimicasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEquipos;
    private javax.swing.JButton BotonInsumos;
    private javax.swing.JButton BotonLaboratorios;
    private javax.swing.JButton BotonReportes;
    private javax.swing.JButton BotonSustanciasQuimicas;
    private javax.swing.JButton BotonTransacciones;
    private javax.swing.JButton BotonUsuarios;
    private javax.swing.JPanel Contenido;
    private javax.swing.JPanel background;
    private javax.swing.JButton btn_prin;
    private javax.swing.JLabel dateText;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel usuarioLabel;
    // End of variables declaration//GEN-END:variables
}
