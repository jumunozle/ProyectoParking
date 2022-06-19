/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

import Model.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import view.Admin.registro;
import static viewModel.usuarios.apellido;
import static viewModel.usuarios.clave;
import static viewModel.usuarios.nombre;
import static viewModel.usuarios.tipousuario;
import static viewModel.usuarios.usuario;

public class administrador {

    Conexion con = new Conexion();
    Connection cn = con.establecerConexion();
    
    public void Registrar() {
        nombre = registro.txtnombre.getText();
        apellido = registro.txtapellido.getText();
        clave = registro.txtclave.getText();
        tipousuario = registro.tipodeusuario.getSelectedItem().toString();
        usuario = registro.txtusuario.getText();

        if (nombre.isEmpty() || apellido.isEmpty() || clave.isEmpty() || usuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe completar los datos");
        } else {
            if (tipousuario.equalsIgnoreCase("Seleccionar")) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de usuario");
            } else {
                try {
                    String consulta = "INSERT INTO usuarios (nombre,apellido,clave,tipo_nivel,usuario)VALUES('" + nombre + "','" + apellido + "','" + clave + "','" + tipousuario + "','" + usuario + "')";
                    PreparedStatement ps = cn.prepareStatement(consulta);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Datos guardados");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se pudo guardar el usuario");
                }
            }
        }
    }
}
