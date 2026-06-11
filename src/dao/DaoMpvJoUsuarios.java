package dao;

import bean.JMpvJoUsuarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoMpvJoUsuarios extends DaoJoAbstract {

    @Override
    public void insert(Object object) {

        JMpvJoUsuarios joUsuarios = (JMpvJoUsuarios) object;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/j_o_sistemacomprasvendaslivros";
            String user = "root";
            String password = "";

            Connection cnt = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO jo_usuarios "
                    + "(JO_Nome, JO_Apelido, JO_Cpf, JO_DataNascimento, JO_Senha, JO_Nivel, JO_Ativo) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst
                    = cnt.prepareStatement(sql);

            pst.setString(1, joUsuarios.getJO_Nome());
            pst.setString(2, joUsuarios.getJO_Apelido());
            pst.setString(3, joUsuarios.getJO_Cpf());
            pst.setDate(4, new java.sql.Date(joUsuarios.getJO_DataNascimento().getTime()));
            pst.setString(5, joUsuarios.getJO_Senha());
            pst.setInt(6, joUsuarios.getJO_Nivel());
            pst.setString(7, joUsuarios.getJO_Ativo());

            pst.executeUpdate();

            pst.close();
            cnt.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMpvJoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvJoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
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
