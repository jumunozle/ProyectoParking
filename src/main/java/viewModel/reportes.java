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
import java.time.LocalDate;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static view.Admin.visualizaReporte.model3;
import static view.Admin.visualizaReporte.tablareportesadmin;
import static view.Admin.visualizaReporte.txtfecha;
import static view.Admin.visualizaReporte.txtganancia;
import static view.Admin.visualizaReporte.txtnombrereporte;
import static view.Empleado.generarReporte.fechafinal;
import static view.Empleado.generarReporte.fechainicial;
import static view.Empleado.generarReporte.model2;
import static view.Empleado.generarReporte.nombrereporte;
import static view.Empleado.generarReporte.tablareportes;
import static view.Admin.visualizaReporte.txtreporteseleccionado;

/**
 *
 * @author Sebastian Muñoz
 */
public class reportes {

    float ganancia;
    String SQL;
    String SQL2;
    Conexion con = new Conexion();
    Connection cn = con.establecerConexion();

    public void GenerarReporte() {
        try {
            double fila = 0.0;
            double total = 0.0;
            for (int i = 0; i < tablareportes.getRowCount(); i++) {
                fila = Double.parseDouble(tablareportes.getValueAt(i, 4).toString());
                total += fila;
            }

            String fecha_realizacion = LocalDate.now().toString();
            String nombre = nombrereporte.getText();
            String consulta = "INSERT INTO reportes (nombrereporte,fecha,ganancias)VALUES('" + nombre + "','" + fecha_realizacion + "','" + total + "')";
            PreparedStatement ps = cn.prepareStatement(consulta);
            ps.executeUpdate();
            String consulta2 = "UPDATE vehiculos SET reporte='Hecho'";
            PreparedStatement ps2 = cn.prepareStatement(consulta2);
            ps2.executeUpdate();
            JOptionPane.showMessageDialog(null, "Reporte generado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo generar el reporte" + e);
        }
    }

    public void listaporFechas() {
        model2.setRowCount(0);
        int dia, mes, ano, hora1;
        int dia2, mes2, ano2, hora2;
        String fecha1, fecha2;

        dia = fechainicial.getCalendar().get(Calendar.DAY_OF_MONTH);
        mes = fechainicial.getCalendar().get(Calendar.MONTH) + 1;
        ano = fechainicial.getCalendar().get(Calendar.YEAR);
        hora1 = fechainicial.getCalendar().get(Calendar.HOUR);
        fecha1 = ano + "-" + mes + "-" + dia;

        dia2 = fechafinal.getCalendar().get(Calendar.DAY_OF_MONTH);
        mes2 = fechafinal.getCalendar().get(Calendar.MONTH) + 1;
        ano2 = fechafinal.getCalendar().get(Calendar.YEAR);
        hora2 = fechafinal.getCalendar().get(Calendar.HOUR);
        fecha2 = ano2 + "-" + mes2 + "-" + dia2;

        String[] datos2 = new String[5];
        try {
            SQL2 = "select id, placa, horaentrada, horasalida, valorpagado from vehiculos where horasalida between '" + fecha1 + "' and '" + fecha2 + "'";
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL2);
            while (rs.next()) {
                datos2[0] = rs.getString(1);
                datos2[1] = rs.getString(2);
                datos2[2] = rs.getString(3);
                datos2[3] = rs.getString(4);
                datos2[4] = rs.getString(5);
                model2.addRow(datos2);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());

        }

    }

    public void actualizarReportesEmpleado() {
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

    public void actualizarReportesAdmin() {
        model3 = new DefaultTableModel();
        model3.addColumn("ID");
        model3.addColumn("Nombre del Reporte");
        model3.addColumn("Fecha de Realizacion");
        model3.addColumn("Ganancias");
        tablareportesadmin.setModel(model3);

        String[] datos = new String[4];
        try {
            String SQL4;
            SQL4 = "select id,nombrereporte,fecha,ganancias from reportes";
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL4);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                model3.addRow(datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());

        }
    }

    public void Modificar() {
        if (tablareportesadmin.getSelectedRowCount() != 1) {
            JOptionPane.showMessageDialog(null, "Escoja un reporte");
            return;
        }
        String nombrereporte2 = txtnombrereporte.getText();
        String fecha2 = txtfecha.getText();
        double ganancias = Double.parseDouble(txtganancia.getText());
        String nombrereporte3 = txtreporteseleccionado.getText();
        try {
            String consulta2 = "UPDATE reportes SET nombrereporte='" + nombrereporte2 + "', fecha='" + fecha2 + "',ganancias='" + ganancias + "' WHERE nombrereporte='" + nombrereporte3 + "'";
            PreparedStatement ps2 = cn.prepareStatement(consulta2);
            ps2.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se modifico el reporte");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar el reporte");
        }

    }

    public void Eliminar() {
     if (tablareportesadmin.getSelectedRowCount() != 1) {
         JOptionPane.showMessageDialog(null, "Escoja un reporte");
         return;
        }
     String nombrereporte3 = txtreporteseleccionado.getText();
        try {
            String consulta3 = "DELETE FROM reportes WHERE nombrereporte='"+nombrereporte3+"'";
            PreparedStatement ps3 = cn.prepareStatement(consulta3);
            ps3.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se elimino el reporte");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el reporte");
        } 
    }
}
