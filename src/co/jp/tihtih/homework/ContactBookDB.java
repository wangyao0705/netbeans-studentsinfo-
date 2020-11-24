/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.jp.tihtih.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ContactBookDB {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;

    String DB_URL = "jdbc:postgresql://localhost:5432/wang";
    String USER = "postgres";
    String PASS = "postgres";

    public Connection getDBcon() throws ClassNotFoundException {
        if (conn == null) {

            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
            } catch (SQLException e) {
            }
        }
        return conn;
    }

    public void closeDBcon() throws SQLException {
        if (conn != null) {
            stmt.close();
            conn.close();
        }
    }

    public int addContactBook(Contact contact) throws SQLException {
        String sql = "INSERT INTO contactbook (company,katagaki,name,email)";
        sql += "VALUES ( '" + contact.getCompany() + "',";
        sql += "'" + contact.getKatagaki() + "',";
        sql += "'" + contact.getName() + "',";
        sql += "'" + contact.getEmail() + "')";

//        conn.commit();
        stmt.executeUpdate(sql);
        return 1;
    }

    public int update(Contact co) throws SQLException {

        String sql = "update contactbook";
        sql += " set katagaki=";
        sql += "'" + co.getKatagaki() + "',";
        sql += "name=";
        sql += "'" + co.getName() + "',";
        sql += "email=";
        sql += "'" + co.getEmail() + "'";
        sql += "where company=";
        sql += "'" + co.getCompany() + "';";
//        System.out.println(sql);
        stmt.executeUpdate(sql);
        return 0;

    }

    public int selectCompany(String company) throws SQLException {
        String sql = "select * from contactbook";
        sql += " where company=";
        sql += "'" + company + "';";
        ResultSet rs = stmt.executeQuery(sql);
        int result = 0;
        if (rs != null) {

            while (rs.next()) {
                result = 1;
                return result;
            }
        }
        return result;
    }

    public List<Contact> selectAll() throws SQLException {
        List<Contact> contact = new ArrayList<>();
        String sql = "select * from contactbook";
        ResultSet rs = stmt.executeQuery(sql);
        if (rs != null) {
            while (rs.next()) {
                Contact con = new Contact();
                con.setCompany(rs.getString("company"));
                con.setKatagaki(rs.getString("katagaki"));
                con.setName(rs.getString("name"));
                con.setEmail(rs.getString("email"));
                contact.add(con);
            }
        }

        return contact;

    }
}
