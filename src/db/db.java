/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ob.us;

/**
 *
 * @author user
 */
public class db {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;

    //接続文字列
    String DB_URL = "jdbc:postgresql://localhost:5432/wang";
    String USER = "postgres";
    String PASS = "postgres";

    public Connection getDBcon() throws ClassNotFoundException {
        if (conn == null) {

            try {
                Class.forName("org.postgresql.Driver");
                // PostgreSQLへ接続
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = (Statement) conn.createStatement();

            } catch (SQLException e) {
                // TODO
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

    public int addus(us user) throws SQLException {

        String sql = "INSERT INTO us (USERID, PASSWORD) ";
        sql += "VALUES ( " + user.getId() + ",";
        sql += "'" + user.getPassword() + "')";

        System.out.println(sql);

        stmt.executeUpdate(sql);
        return 1;
    }

}
