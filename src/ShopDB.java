
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import objects.UserInfo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class ShopDB {

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
                // PostgreSQLへ接続
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();

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

    public int addShopinfo(Shop sp) throws SQLException {

        String sql = "INSERT INTO Shopinfo (id,name,tel,address) ";
        sql += "VALUES ( " + sp.getId() + ",";
        sql += "'" + sp.getName() + "',";
        sql += "'" + sp.getTel() + "',";
        sql += "'" + sp.getAddress() + "')";
        System.out.println(sql);

        stmt.executeUpdate(sql);
        return 1;
    }

}
