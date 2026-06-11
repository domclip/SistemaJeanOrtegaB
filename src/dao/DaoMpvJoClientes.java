/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import bean.JMpvJoClientes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jianl
 */
public class DaoMpvJoClientes extends DaoJoAbstract {

    @Override
    public void insert(Object object) {

        JMpvJoClientes joClientes = (JMpvJoClientes) object;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/j_o_sistemacomprasvendaslivros";
            String user = "root";
            String password = "";

            Connection cnt = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO jo_clientes VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = cnt.prepareStatement(sql);

            pst.setInt(1, joClientes.getJoIdClientes());
            pst.setString(2, joClientes.getJoNome());
            pst.setString(3, joClientes.getJoCpf());
            pst.setString(4, joClientes.getJoEmail());
            pst.setString(5, joClientes.getJoTelefone());
            pst.setDate(6, null);
            pst.setString(7, joClientes.getJoGenero());
            pst.setString(8, joClientes.getJoEndereco());
            pst.setString(9, joClientes.getJoBairro());
            pst.setString(10, joClientes.getJoCidade());
            pst.setString(11, joClientes.getJoEstado());
            pst.setString(12, joClientes.getJoCep());
            pst.setDate(13, null);
            pst.setDouble(14, joClientes.getJoTotalCompras());
            pst.setString(15, joClientes.getJoStatusCliente());

            pst.executeUpdate();

            pst.close();
            cnt.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMpvJoClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvJoClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
    }

    @Override
    public void delete(Object object) {
    }

    @Override
    public Object list(int id) {
        return null;
    }

    @Override
    public Object listAll() {
        return null;
    }
}