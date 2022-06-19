/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

import Model.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastian Muñoz
 */
public class puestos {

    Conexion con = new Conexion();
    Connection cn = con.establecerConexion();

    public void ConsultarPuestos(JComboBox puestos) {
        String sql = "SELECT puesto FROM puestos WHERE estado='Disponible'";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                puestos.addItem(rs.getString("puesto"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay puestos disponibles"+e);
        }
    }

    public void updatearPuestos(JComboBox puestos) {
        String sql = "SELECT puesto FROM puestos WHERE estado='Disponible'";
        try {
            PreparedStatement ps2 = cn.prepareStatement(sql);
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                puestos.addItem(rs2.getString("puesto"));
            }
        } catch (Exception e) {

        }

    }
}