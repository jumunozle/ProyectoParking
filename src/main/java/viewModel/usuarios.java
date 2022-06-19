/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

import Model.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import view.Admin.menuAdmin;
import view.Empleado.menuEmpleado;
import view.login.login;

public class usuarios {

    Conexion con = new Conexion();
    Connection cn = con.establecerConexion();

    public static String nombre;
    public static String apellido;
    public static String clave;
    public static String tipousuario;
    public static String usuario;

    public void Login() {
        usuario = login.txtusuario.getText();
        clave = login.txtclave.getText();
        if (!usuario.equals("") || !clave.equals("")) {
            try {
                PreparedStatement ps = cn.prepareStatement("SELECT tipo_nivel FROM usuarios WHERE usuario='" + usuario + "' and clave='" + clave + "'");
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String tiponivel = rs.getString("tipo_nivel");
                    if (tiponivel.equalsIgnoreCase("Administrador")) {
                        login a2 = new login();
                        a2.setVisible(false);
                        menuAdmin a1 = new menuAdmin();
                        a1.setVisible(true);
                    } else if (tiponivel.equalsIgnoreCase("Empleado")) {
                        login a2 = new login();
                        a2.setVisible(false);
                        menuEmpleado a1 = new menuEmpleado();
                        a1.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o clave incorrectos");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al iniciar sesion" + e);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe completar los datos");

        }
    }
}
