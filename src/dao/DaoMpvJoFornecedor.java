/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import bean.JmpvJoFornecedor;
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
public class DaoMpvJoFornecedor extends DaoJoAbstract {

    @Override
    public void insert(Object object) {

        JmpvJoFornecedor joFornecedor = (JmpvJoFornecedor) object;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost/j_o_sistemacomprasvendaslivros";
            String user = "root";
            String password = "";

            Connection cnt = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO jo_fornecedor VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = cnt.prepareStatement(sql);

            pst.setInt(1, joFornecedor.getJo_idfornecedor());
            pst.setString(2, joFornecedor.getJo_nome_fornecedor());
            pst.setString(3, joFornecedor.getJo_cnpj());
            pst.setString(4, joFornecedor.getJo_email());
            pst.setString(5, joFornecedor.getJo_telefone());
            pst.setString(6, joFornecedor.getJo_contato_responsavel());
            pst.setString(7, joFornecedor.getJo_endereco());
            pst.setString(8, joFornecedor.getJo_bairro());
            pst.setString(9, joFornecedor.getJo_cidade());
            pst.setString(10, joFornecedor.getJo_estado());
            pst.setString(11, joFornecedor.getJo_cep());
            pst.setDate(12, null);
            pst.setString(13, joFornecedor.getJo_categoria_produto());
            pst.setInt(14, joFornecedor.getJo_prazo_entrega());
            pst.setString(15, joFornecedor.getJo_status_fornecedor());

            pst.executeUpdate();

            pst.close();
            cnt.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMpvJoFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvJoFornecedor.class.getName()).log(Level.SEVERE, null, ex);
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
