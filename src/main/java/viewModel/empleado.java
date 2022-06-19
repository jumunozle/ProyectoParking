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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.Empleado.inscribirAutomovil;

import view.Empleado.retirarAutomovil;

public class empleado {

    Conexion con = new Conexion();
    Connection cn = con.establecerConexion();

    public static String fechaHora = "";
    public static DateFormat dateFormat;
    public static Calendar cal;
    public static java.util.Date date;
    public static Double ValoraPagar = 0.0;
    public static String sql;
    public static String sql2;
    public static String sql3;
    public static DefaultTableModel model;

    public void inscribir() {
        automovil.placa = inscribirAutomovil.txtplaca.getText();
        automovil.telefono = (inscribirAutomovil.txttelefono.getText());
        automovil.puesto = inscribirAutomovil.puestosdisponibles.getSelectedItem().toString();
        empleado.fechaHora = "";
        empleado.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        empleado.cal = Calendar.getInstance();
        empleado.date = empleado.cal.getTime();
        empleado.fechaHora = empleado.dateFormat.format(empleado.date);
        if (automovil.placa.isEmpty() || automovil.telefono.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe completar los datos");
        } else {
            if (automovil.puesto.equalsIgnoreCase("Seleccionar puesto...")) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un puesto");
            } else {
                try {
                    String consulta = "INSERT INTO vehiculos (puesto,telefono,placa,horaentrada,estado,reporte)VALUES('" + automovil.puesto + "','" + automovil.telefono + "','" + automovil.placa + "','" + fechaHora + "','Disponible','No Disponible')";
                    String consulta2 = "UPDATE `puestos` SET `estado`='No Disponible', placa='" + automovil.placa + "' WHERE puesto='" + automovil.puesto + "'";
                    PreparedStatement ps = cn.prepareStatement(consulta);
                    ps.executeUpdate();
                    PreparedStatement ps2 = cn.prepareStatement(consulta2);
                    ps2.executeUpdate();
                    JOptionPane.showMessageDialog(null, "El vehiculo se ha registrado");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se ha podido registrar el vehiculo" + e);
                }
            }
           
        }
    }

    public void retirar() {
        automovil.placa = retirarAutomovil.txtplaca.getText();
        empleado.ValoraPagar = 0.0;
        empleado.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        empleado.cal = Calendar.getInstance();
        empleado.date = empleado.cal.getTime();
        empleado.fechaHora = empleado.dateFormat.format(empleado.date);
        empleado.sql = "SELECT horaentrada FROM vehiculos WHERE placa='" + automovil.placa + "' AND estado='Disponible'";
        empleado.sql2 = "SELECT valorminuto FROM tarifas WHERE id=1";

        if (automovil.placa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe completar los datos");
        } else {
            try {
                Statement stat2 = cn.createStatement();
                ResultSet rs2 = stat2.executeQuery(sql2);
                rs2.next();
                Statement stat = cn.createStatement();
                ResultSet rs = stat.executeQuery(sql);
                rs.next();
                String horaSalida = rs.getString(1);
                double valorminuto = rs2.getDouble(1);
                java.util.Date horasalida = dateFormat.parse(horaSalida);
                int minutosACobrar = (int) (date.getTime() - horasalida.getTime()) / 60000;
                String consulta3 = "UPDATE `puestos` SET `estado`='Disponible', placa='' WHERE placa='" + automovil.placa + "'";
                PreparedStatement ps3 = cn.prepareStatement(consulta3);
                ps3.executeUpdate();
                ValoraPagar = minutosACobrar * valorminuto;
                stat.executeUpdate("UPDATE vehiculos SET reporte ='Disponible',horasalida='" + fechaHora + "',estado='No Disponible',valorpagado='" + ValoraPagar + "' WHERE placa ='" + automovil.placa + "' AND estado='Disponible'");
                JOptionPane.showMessageDialog(null, "Se retiro el vehiculo");
            } catch (ParseException ex) {
                Logger.getLogger(retirarAutomovil.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "El vehiculo no se encuentra en el parqueadero");
                Logger.getLogger(retirarAutomovil.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
