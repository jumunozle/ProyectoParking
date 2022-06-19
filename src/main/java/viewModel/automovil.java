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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.Empleado.listaVehiculos;
import static view.Empleado.listaVehiculos.puestomodificado;
import static view.Empleado.listaVehiculos.tablaautomoviles;
import static view.Empleado.listaVehiculos.txtplacamodificada;
import static view.Empleado.listaVehiculos.txttelefonomodificado;
import static viewModel.empleado.model;
import static viewModel.empleado.sql3;
import static view.Empleado.listaVehiculos.txtplacaseleccionada;

public class automovil {

    Conexion con = new Conexion();
    Connection cn = con.establecerConexion();

    public static String propietario;
    public static String placa;
    public static String telefono;
    public static String tipoautomovil;
    public static String puesto;

    public void actualizarlista() {
        empleado.sql3 = "select id, puesto, telefono, placa, horaentrada, horasalida, estado from vehiculos";
        Statement st;
        empleado.model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Puesto");
        model.addColumn("Telefono");
        model.addColumn("Placa");
        model.addColumn("Hora de entrada");
        model.addColumn("Hora de salida");
        model.addColumn("Estado");
        listaVehiculos.tablaautomoviles.setModel(model);

        String[] datos = new String[7];
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
                model.addRow(datos);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());

        }

    }

    public void Modificar() {
        if (listaVehiculos.tablaautomoviles.getSelectedRowCount() != 1) {
            JOptionPane.showMessageDialog(null, "Escoja un automovil");
            return;
        }
        String telefonomodificado = txttelefonomodificado.getText();
        String placamodificada = txtplacamodificada.getText();
        String placa2 = txtplacaseleccionada.getText();
        String puesto2 = puestomodificado.getSelectedItem().toString();
        try {
            String consulta2 = "UPDATE vehiculos SET telefono='"+telefonomodificado+"',placa='"+placamodificada+"',puesto='"+puesto2+"' WHERE placa='"+placa2+"'";
            PreparedStatement ps2 = cn.prepareStatement(consulta2);
            ps2.executeUpdate();
             String consulta3 = "UPDATE puestos SET estado='Disponible',placa='' WHERE placa='"+placa2+"'";
            PreparedStatement ps3 = cn.prepareStatement(consulta3);
            ps3.executeUpdate();
            String consulta4 = "UPDATE puestos SET estado='No Disponible',placa='"+placamodificada+"' WHERE puesto='"+puesto2+"'";
            PreparedStatement ps4 = cn.prepareStatement(consulta4);
            ps4.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se modificaron los datos del automovil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar los datos del automovil"+e);
        }
    }

    public void Eliminar() {
        if (tablaautomoviles.getSelectedRowCount() != 1) {
            JOptionPane.showMessageDialog(null, "Escoja un automovil");
            return;
        }
        String nombrereporte3 = txtplacaseleccionada.getText();
        try {
            String consulta3 = "DELETE FROM vehiculos WHERE placa='"+nombrereporte3+"'";
            PreparedStatement ps3 = cn.prepareStatement(consulta3);
            ps3.executeUpdate();
            String consulta4 = "UPDATE puestos SET estado='Disponible',placa='' WHERE placa='"+nombrereporte3+"'";
            PreparedStatement ps4= cn.prepareStatement(consulta4);
            ps4.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se elimino el automovil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el automovil"+e);
        }
    }
}
