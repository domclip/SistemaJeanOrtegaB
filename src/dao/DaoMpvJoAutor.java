/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import bean.JMpvJoAutor;
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
public class DaoMpvJoAutor extends DaoJoAbstract{
    
    @Override
    public void insert(Object object) {

        JMpvJoAutor joAutor = (JMpvJoAutor) object;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost/j_o_sistemacomprasvendaslivros";
            String user = "root";
            String password = "";

            Connection cnt = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO jo_autor VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = cnt.prepareStatement(sql);

            pst.setInt(1, joAutor.getJo_idautor());
            pst.setString(2, joAutor.getJo_nomeautor());
            pst.setString(3, joAutor.getJo_nomeartistico());
            pst.setDate(4, null);
            pst.setString(5, joAutor.getJo_nacionalidade());
            pst.setString(6, joAutor.getJo_generosliterarios());
            pst.setString(7, joAutor.getJo_biografiacurta());

            pst.executeUpdate();

            pst.close();
            cnt.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMpvJoAutor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvJoAutor.class.getName()).log(Level.SEVERE, null, ex);
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
