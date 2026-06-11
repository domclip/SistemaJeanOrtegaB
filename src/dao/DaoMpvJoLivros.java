/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import bean.JMpvJoLivros;
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
public class DaoMpvJoLivros extends DaoJoAbstract {

    @Override
    public void insert(Object object) {

        JMpvJoLivros joLivros = (JMpvJoLivros) object;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/j_o_sistemacomprasvendaslivros";
            String user = "root";
            String password = "";

            Connection cnt = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO jo_livros VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = cnt.prepareStatement(sql);

            pst.setInt(1, joLivros.getJo_idlivros());
            pst.setString(2, joLivros.getJo_titulo());
            pst.setString(3, joLivros.getJo_autor());
            pst.setString(4, joLivros.getJo_genero());
            pst.setDouble(5, joLivros.getJo_preco());
            pst.setString(6, joLivros.getJo_descricao());
            pst.setString(7, joLivros.getJo_editora());
            pst.setInt(8, joLivros.getJo_ano_publicacao());
            pst.setInt(9, joLivros.getJo_paginas());

            pst.executeUpdate();

            pst.close();
            cnt.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoMpvJoLivros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DaoMpvJoLivros.class.getName()).log(Level.SEVERE, null, ex);
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