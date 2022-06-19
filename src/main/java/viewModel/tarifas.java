/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

import Model.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.Admin.establecerPrecios;
import view.Empleado.retirarAutomovil;

public class tarifas {

    Conexion con = new Conexion();
    Connection cn = con.establecerConexion();

    static double valorminuto;
    static String consulta;
    static String sql3;
    static double valorminuto2;

    public void mostrarTarifa() {
        sql3 = "SELECT valorminuto FROM tarifas WHERE id=1";

        try {
            Statement stat = cn.createStatement();
            ResultSet rs = stat.executeQuery(sql3);
            rs.next();
            valorminuto2 = rs.getDouble(1);
            establecerPrecios.txtminutoactual.setText(Double.toString(valorminuto2));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "");
            Logger.getLogger(retirarAutomovil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void EstablecerTarifa() {
        tarifas.valorminuto = Double.parseDouble(establecerPrecios.txtminuto.getText());
        try {
            tarifas.consulta = "UPDATE tarifas SET valorminuto=" + tarifas.valorminuto + " WHERE id=1";
            PreparedStatement ps = cn.prepareStatement(tarifas.consulta);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Ha actualizado las tarifas");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido actualizar las tarifas" + e);
        }
    }

}


