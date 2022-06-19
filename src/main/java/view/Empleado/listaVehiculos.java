/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.Empleado;

import java.sql.Connection;
import Model.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import viewModel.automovil;
import viewModel.empleado;
import static viewModel.empleado.model;
import static viewModel.empleado.sql3;
import viewModel.puestos;

/**
 *
 * @author Sebastian Muñoz
 */
public class listaVehiculos extends javax.swing.JFrame {

    Conexion con = new Conexion();
    Connection cn = con.establecerConexion();

    public listaVehiculos() {
        initComponents();
        setLocationRelativeTo(null);
        empleado.sql3 = "select id, puesto, telefono, placa, horaentrada, horasalida, estado,valorpagado from vehiculos";
        Statement st;
        empleado.model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Puesto");
        model.addColumn("Telefono");
        model.addColumn("Placa");
        model.addColumn("Hora de entrada");
        model.addColumn("Hora de salida");
        model.addColumn("Estado");
        model.addColumn("Valor pagado");
        listaVehiculos.tablaautomoviles.setModel(model);
        puestos a6 = new puestos();
        a6.ConsultarPuestos(puestomodificado);

        String[] datos = new String[8];
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql3);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                model.addRow(datos);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());

        }
    }
    void limpiar(){
        txtplacamodificada.setText("");
        txttelefonomodificado.setText("");
        txtplacaseleccionada.setText(""); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        volver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaautomoviles = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtplacaseleccionada = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        txttelefonomodificado = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtplacamodificada = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        modificarautomoviles = new javax.swing.JButton();
        eliminarautomoviles = new javax.swing.JButton();
        puestomodificado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        volver.setBackground(new java.awt.Color(0, 204, 255));
        volver.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        volver.setForeground(new java.awt.Color(255, 255, 255));
        volver.setText("Volver al menu");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 32));

        tablaautomoviles.setBackground(new java.awt.Color(0, 204, 255));
        tablaautomoviles.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        tablaautomoviles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaautomoviles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaautomovilesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaautomoviles);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1030, 360));

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(256, 256, 256)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 0, 230, 640));

        txtplacaseleccionada.setEditable(false);
        txtplacaseleccionada.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        txtplacaseleccionada.setBorder(null);
        txtplacaseleccionada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtplacaseleccionadaActionPerformed(evt);
            }
        });
        jPanel1.add(txtplacaseleccionada, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 500, 210, 20));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 520, 210, 20));

        txttelefonomodificado.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        txttelefonomodificado.setBorder(null);
        txttelefonomodificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonomodificadoActionPerformed(evt);
            }
        });
        jPanel1.add(txttelefonomodificado, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 210, 20));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 210, 20));

        jLabel7.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        jLabel7.setText("AUTOMOVIL SELECCIONADO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 480, -1, -1));

        jLabel8.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        jLabel8.setText("MODIFICAR TELEFONO");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, -1, -1));

        jLabel9.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        jLabel9.setText("MODIFICAR PLACA");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 480, -1, -1));

        txtplacamodificada.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        txtplacamodificada.setBorder(null);
        txtplacamodificada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtplacamodificadaActionPerformed(evt);
            }
        });
        jPanel1.add(txtplacamodificada, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 500, 210, 20));

        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 520, 210, 20));

        jLabel10.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        jLabel10.setText("MODIFICAR PUESTO");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 480, -1, -1));

        modificarautomoviles.setBackground(new java.awt.Color(0, 204, 255));
        modificarautomoviles.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        modificarautomoviles.setForeground(new java.awt.Color(255, 255, 255));
        modificarautomoviles.setText("Modificar");
        modificarautomoviles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarautomovilesActionPerformed(evt);
            }
        });
        jPanel1.add(modificarautomoviles, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 550, 170, 60));

        eliminarautomoviles.setBackground(new java.awt.Color(0, 204, 255));
        eliminarautomoviles.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        eliminarautomoviles.setForeground(new java.awt.Color(255, 255, 255));
        eliminarautomoviles.setText("Eliminar");
        eliminarautomoviles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarautomovilesActionPerformed(evt);
            }
        });
        jPanel1.add(eliminarautomoviles, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 550, 170, 60));

        puestomodificado.setBackground(new java.awt.Color(0, 204, 255));
        puestomodificado.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        puestomodificado.setForeground(new java.awt.Color(255, 255, 255));
        puestomodificado.setBorder(null);
        puestomodificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puestomodificadoActionPerformed(evt);
            }
        });
        jPanel1.add(puestomodificado, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 500, 180, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        this.setVisible(false);
        menuEmpleado volver3 = new menuEmpleado();
        volver3.setVisible(true);
    }//GEN-LAST:event_volverActionPerformed

    private void txtplacaseleccionadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtplacaseleccionadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtplacaseleccionadaActionPerformed

    private void txttelefonomodificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonomodificadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonomodificadoActionPerformed

    private void tablaautomovilesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaautomovilesMouseClicked
    int seleccionado = tablaautomoviles.rowAtPoint(evt.getPoint());
    txtplacaseleccionada.setText(String.valueOf(tablaautomoviles.getValueAt(seleccionado,3)));
    }//GEN-LAST:event_tablaautomovilesMouseClicked

    private void txtplacamodificadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtplacamodificadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtplacamodificadaActionPerformed

    private void modificarautomovilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarautomovilesActionPerformed
    automovil a1 = new automovil();
    a1.Modificar();
    a1.actualizarlista();
    limpiar();
    puestos a3 = new puestos();
    puestomodificado.removeAllItems();
    a3.updatearPuestos(puestomodificado);
    }//GEN-LAST:event_modificarautomovilesActionPerformed

    private void eliminarautomovilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarautomovilesActionPerformed
    automovil a2 = new automovil();
    a2.Eliminar();
    a2.actualizarlista();
    limpiar();
    }//GEN-LAST:event_eliminarautomovilesActionPerformed

    private void puestomodificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puestomodificadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_puestomodificadoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(listaVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listaVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listaVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listaVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listaVehiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eliminarautomoviles;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JButton modificarautomoviles;
    public static javax.swing.JComboBox<String> puestomodificado;
    public static javax.swing.JTable tablaautomoviles;
    public static javax.swing.JTextField txtplacamodificada;
    public static javax.swing.JTextField txtplacaseleccionada;
    public static javax.swing.JTextField txttelefonomodificado;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
