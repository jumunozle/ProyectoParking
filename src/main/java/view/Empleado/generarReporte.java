/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.Empleado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Model.Conexion;
import javax.swing.table.DefaultTableModel;
import viewModel.reportes;

/**
 *
 * @author Sebastian Muñoz
 */
public class generarReporte extends javax.swing.JFrame {

    Conexion con = new Conexion();
    Connection cn = con.establecerConexion();
    String SQL;
    public static DefaultTableModel model2 = new DefaultTableModel();

    public generarReporte() {
        initComponents();
        setLocationRelativeTo(null);
        model2 = new DefaultTableModel();
        model2.addColumn("ID");
        model2.addColumn("Placa");
        model2.addColumn("Hora de Entrada");
        model2.addColumn("Hora de Salida");
        model2.addColumn("Precio Pagado");
        tablareportes.setModel(model2);

        String[] datos = new String[5];
        try {
            SQL = "select id, placa, horaentrada, horasalida, valorpagado from vehiculos where estado='No Disponible' and reporte='Disponible'";
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);

                model2.addRow(datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        menu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        generar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablareportes = new javax.swing.JTable();
        fechainicial = new com.toedter.calendar.JDateChooser();
        buscar = new javax.swing.JButton();
        fechafinal = new com.toedter.calendar.JDateChooser();
        nombrereporte = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 300));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu.setBackground(new java.awt.Color(0, 204, 255));
        menu.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        menu.setForeground(new java.awt.Color(255, 255, 255));
        menu.setText("Volver al menu");
        menu.setBorder(null);
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });
        jPanel1.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 120, 30));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        jLabel1.setText("Nombre del reporte");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 520, -1, -1));

        generar.setBackground(new java.awt.Color(0, 204, 255));
        generar.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        generar.setForeground(new java.awt.Color(255, 255, 255));
        generar.setText("Generar Reporte");
        generar.setBorder(null);
        generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarActionPerformed(evt);
            }
        });
        jPanel1.add(generar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 540, 200, 50));

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(230, 500));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 0, 230, 600));

        tablareportes.setBackground(new java.awt.Color(0, 204, 255));
        tablareportes.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        tablareportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablareportes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 980, 390));

        fechainicial.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(fechainicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        buscar.setBackground(new java.awt.Color(0, 204, 255));
        buscar.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        buscar.setForeground(new java.awt.Color(255, 255, 255));
        buscar.setText("Buscar reportes");
        buscar.setBorder(null);
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        jPanel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 550, 160, 30));

        fechafinal.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(fechafinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 550, -1, -1));

        nombrereporte.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        nombrereporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombrereporteActionPerformed(evt);
            }
        });
        jPanel1.add(nombrereporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 540, 170, 40));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel2.setText("GENERAR REPORTES");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
    this.setVisible(false);
    menuEmpleado a1 = new menuEmpleado();
    a1.setVisible(true);
    }//GEN-LAST:event_menuActionPerformed

    private void generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarActionPerformed
    reportes a3 = new reportes();
    a3.GenerarReporte();
    a3.actualizarReportesEmpleado();
    }//GEN-LAST:event_generarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
    reportes a2 = new reportes();
    a2.listaporFechas();
    }//GEN-LAST:event_buscarActionPerformed

    private void nombrereporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombrereporteActionPerformed
    
    }//GEN-LAST:event_nombrereporteActionPerformed

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
            java.util.logging.Logger.getLogger(generarReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(generarReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(generarReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(generarReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new generarReporte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    public static com.toedter.calendar.JDateChooser fechafinal;
    public static com.toedter.calendar.JDateChooser fechainicial;
    private javax.swing.JButton generar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton menu;
    public static javax.swing.JTextField nombrereporte;
    public static javax.swing.JTable tablareportes;
    // End of variables declaration//GEN-END:variables
}