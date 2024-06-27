/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import controller.ListaDeEquipos;
import controller.ListaDeInsumos;
import controller.ListaDeSustanciasQuimicas;
import controller.ListaDeUsuarios;
import controller.ListaLaboratorios;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import model.Usuario;
import firebase.Conexion;
import firebase.GeneralProvider;
import javax.swing.ImageIcon;

/**
 *
 * @author Windows
 */
public class Login extends javax.swing.JFrame {

    int xMouse;
    int yMouse;
    private ListaDeUsuarios usuarios;
    private ListaLaboratorios laboratorios;
    //user: Harry1 password: 1234
    public Login() {
        initComponents();
        usuarios= new ListaDeUsuarios();
        laboratorios = new ListaLaboratorios();
        setIconImage(new ImageIcon(getClass().getResource("/file.png")).getImage());
        this.setLocationRelativeTo(null);
    }
    /*
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/file.png"));
        return retValue;
    }*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelDiseño = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelParaMover = new javax.swing.JPanel();
        panelExit = new javax.swing.JPanel();
        labelExit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txtContraseña = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JPanel();
        labelEntrar = new javax.swing.JLabel();
        error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelDiseño.setBackground(new java.awt.Color(13, 71, 161));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo_UCAB_1 (1).png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo_ingenieria-removebg-preview.png"))); // NOI18N

        javax.swing.GroupLayout panelDiseñoLayout = new javax.swing.GroupLayout(panelDiseño);
        panelDiseño.setLayout(panelDiseñoLayout);
        panelDiseñoLayout.setHorizontalGroup(
            panelDiseñoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDiseñoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelDiseñoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        panelDiseñoLayout.setVerticalGroup(
            panelDiseñoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDiseñoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(176, 176, 176)
                .addComponent(jLabel5)
                .addContainerGap(217, Short.MAX_VALUE))
        );

        panelPrincipal.add(panelDiseño, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 530));

        panelParaMover.setBackground(new java.awt.Color(255, 255, 255));
        panelParaMover.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelParaMoverMouseDragged(evt);
            }
        });
        panelParaMover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelParaMoverMousePressed(evt);
            }
        });

        panelExit.setBackground(new java.awt.Color(255, 255, 255));

        labelExit.setBackground(new java.awt.Color(255, 255, 255));
        labelExit.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelExit.setText("x");
        labelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelExitMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelExitLayout = new javax.swing.GroupLayout(panelExit);
        panelExit.setLayout(panelExitLayout);
        panelExitLayout.setHorizontalGroup(
            panelExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        panelExitLayout.setVerticalGroup(
            panelExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelExitLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelExit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelParaMoverLayout = new javax.swing.GroupLayout(panelParaMover);
        panelParaMover.setLayout(panelParaMoverLayout);
        panelParaMoverLayout.setHorizontalGroup(
            panelParaMoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelParaMoverLayout.createSequentialGroup()
                .addGap(0, 940, Short.MAX_VALUE)
                .addComponent(panelExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelParaMoverLayout.setVerticalGroup(
            panelParaMoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelParaMoverLayout.createSequentialGroup()
                .addComponent(panelExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelPrincipal.add(panelParaMover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 50));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        jLabel2.setText("INICIAR SESIÓN");
        panelPrincipal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 210, 30));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setText("CONTRASEÑA");
        panelPrincipal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        panelPrincipal.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 570, 20));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel4.setText("USUARIO");
        panelPrincipal.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, -1, -1));

        txtUsuario.setForeground(new java.awt.Color(153, 153, 153));
        txtUsuario.setText("Ingrese nombre del usuario");
        txtUsuario.setBorder(null);
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUsuarioMousePressed(evt);
            }
        });
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        panelPrincipal.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 570, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        panelPrincipal.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 570, 20));

        txtContraseña.setForeground(new java.awt.Color(153, 153, 153));
        txtContraseña.setText("**********");
        txtContraseña.setBorder(null);
        txtContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtContraseñaMousePressed(evt);
            }
        });
        panelPrincipal.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 570, -1));

        btnEntrar.setBackground(new java.awt.Color(13, 71, 161));

        labelEntrar.setBackground(new java.awt.Color(13, 71, 161));
        labelEntrar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        labelEntrar.setForeground(new java.awt.Color(255, 255, 255));
        labelEntrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEntrar.setText("ENTRAR");
        labelEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelEntrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelEntrarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnEntrarLayout = new javax.swing.GroupLayout(btnEntrar);
        btnEntrar.setLayout(btnEntrarLayout);
        btnEntrarLayout.setHorizontalGroup(
            btnEntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        btnEntrarLayout.setVerticalGroup(
            btnEntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelPrincipal.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, 160, 40));

        error.setForeground(new java.awt.Color(255, 0, 0));
        panelPrincipal.add(error, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelParaMoverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelParaMoverMousePressed
        xMouse=evt.getX();
        yMouse=evt.getY();
    }//GEN-LAST:event_panelParaMoverMousePressed

    private void panelParaMoverMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelParaMoverMouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        this.setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_panelParaMoverMouseDragged

    private void labelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_labelExitMouseClicked

    private void labelExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelExitMouseEntered
        panelExit.setBackground(Color.red);
    }//GEN-LAST:event_labelExitMouseEntered

    private void labelExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelExitMouseExited
        panelExit.setBackground(Color.white);
    }//GEN-LAST:event_labelExitMouseExited

    private void labelEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEntrarMouseEntered
        btnEntrar.setBackground(new Color(51,204,255));
    }//GEN-LAST:event_labelEntrarMouseEntered

    private void labelEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEntrarMouseExited
        btnEntrar.setBackground(new Color(0,153,255));
    }//GEN-LAST:event_labelEntrarMouseExited

    private void txtUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMousePressed
        if(txtUsuario.getText().equals("Ingrese nombre del usuario")){
            txtUsuario.setText("");
            txtUsuario.setForeground(Color.black);
        }
        if(String.valueOf(txtContraseña.getPassword()).isEmpty()){
            txtContraseña.setText("**********");
            txtContraseña.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtUsuarioMousePressed

    private void txtContraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContraseñaMousePressed
        if(String.valueOf(txtContraseña.getPassword()).equals("**********")){
            txtContraseña.setText("");
            txtContraseña.setForeground(Color.black);
        }
        if(txtUsuario.getText().isEmpty()){
            txtUsuario.setText("Ingrese nombre del usuario");
            txtUsuario.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtContraseñaMousePressed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void labelEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEntrarMouseClicked
        if ((txtUsuario.getText().equals("Ingrese nombre del usuario"))||(txtUsuario.getText().equals(""))){
            error.setText("Campo de usuario vacio, Por favor llenelo");
        }
        else{
            String username = txtUsuario.getText();
            String password = String.valueOf(txtContraseña.getPassword());
            ListaLaboratorios listalab = new ListaLaboratorios();
            ListaDeEquipos listaEquip = new ListaDeEquipos();
            ListaDeInsumos listaInsu = new ListaDeInsumos();
//            ListaDeSustanciasQuimicas listaSusQui = new ListaDeSustanciasQuimicas();*/
            Usuario usuario = usuarios.iniciarSesion(username.trim(), password.trim());
            if (usuario != null) {
                Dashboard iniciarMain = new Dashboard(usuario,usuarios,laboratorios);
                iniciarMain.setVisible(true);
                dispose();
            }
            else {
                error.setText("El usuario y la contraseña no coinciden");
            }
        }
    }//GEN-LAST:event_labelEntrarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatMaterialLighterIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnEntrar;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelEntrar;
    private javax.swing.JLabel labelExit;
    private javax.swing.JPanel panelDiseño;
    private javax.swing.JPanel panelExit;
    private javax.swing.JPanel panelParaMover;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
