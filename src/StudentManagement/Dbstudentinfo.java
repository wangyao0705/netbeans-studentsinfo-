/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentManagement;

import co.jp.tihtih.homework.Contact;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Dbstudentinfo {

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

    /*
ＤＢログインデータ挿入

     */
    public int addLoad(TeachersLoad tl) throws SQLException {
        String sql = "INSERT INTO login (id,password)";
        sql += "VALUES ( " + tl.getId() + ",";
        sql += "'" + tl.getPassword() + "')";

//        conn.commit();
        stmt.executeUpdate(sql);
        return 1;
    }

    /*
    update login
     */
    public int updateload(TeachersLoad tl) throws SQLException {
        String sql = "update login";
        sql += " set password=";
        sql += "'" + tl.getPassword() + "'";
        sql += " where id=";
        sql += "" + tl.getId() + ";";
        System.out.println(sql);
        stmt.executeUpdate(sql);
        return 0;
    }

    /*
DBからデータ出し,出力データと同じなら、ログインＯＫ
     */
    public int selectLoad(int id, String password) throws SQLException {
        String sql = "select * from login";
        sql += " where id=";
        sql += "" + id + "and password = ";
        sql += "'" + password + "';";
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

    /*
    login select id
     */
    public int selectloginid(int id) throws SQLException {
        String sql = "select * from login";
        sql += " where id=";
        sql += "" + id + "";
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

    /*
add teacherinfo表
     */
    public int addTeacherinfo(TeachersLoad tl) throws SQLException {
        String sql = "INSERT INTO teacherinfo (id,password,name,sex,kurasu,subject)";
        sql += "VALUES ( " + tl.getId() + ",";
        sql += "'" + tl.getPassword() + "',";
        sql += "'" + tl.getName() + "',";
        sql += "'" + tl.getSex() + "',";
        sql += "'" + tl.getKurasu() + "',";
        sql += "'" + tl.getSubject() + "')";

//        conn.commit();
        stmt.executeUpdate(sql);
        return 1;
    }

    /*
更新教師データ
     */
    public int updateTload(TeachersLoad tl) throws SQLException {
        String sql = "update teacherinfo";
        sql += " set password=";
        sql += "'" + tl.getPassword() + "',";
        sql += "name=";
        sql += "'" + tl.getName() + "',";
        sql += "sex=";
        sql += "'" + tl.getSex() + "',";
        sql += "kurasu=";
        sql += "'" + tl.getKurasu() + "',";
        sql += "subject=";
        sql += "'" + tl.getSubject() + "'";
        sql += " where id=";
        sql += "" + tl.getId() + "and kurasu=";
        sql += "'" + tl.getKurasu() + "' or subject=";
        sql += "'" + tl.getSubject() + "'";
        System.out.println(sql);
        stmt.executeUpdate(sql);
        return 0;
    }

    public int updateTload(int id, String password) throws SQLException {
        String sql = "update teacherinfo";
        sql += " set password=";
        sql += "'" + password + "'";
        sql += " where id=";
        sql += "" + id + ";";
        stmt.executeUpdate(sql);
        return 0;
    }

    /*
    select 教師表 id,class,subject を取り出し,出力値と比べ,繰り返しだめ
     */
    public int selectTload(int id, String kurasu, String subject) throws SQLException {
        String sql = "select * from teacherinfo";
        sql += " where id=";
        sql += "" + id + "and kurasu = ";
        sql += "'" + kurasu + "'and subject =";
        sql += "'" + subject + "';";
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

    public int selectTload(String kurasu, String subject) throws SQLException {
        String sql = "select * from teacherinfo";
        sql += " where kurasu =";
        sql += "'" + kurasu + "'and subject =";
        sql += "'" + subject + "';";
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

    /*
   select 教師表(id)
     */
    public int selectTload(int id) throws SQLException {
        String sql = "select * from teacherinfo";
        sql += " where id=";
        sql += "" + id + ";";
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

    public List<TeachersLoad> selectT(int id) throws SQLException {
        String sql = "select kurasu from teacherinfo";
        sql += " where id=";
        sql += "" + id + ";";
        ResultSet rs = stmt.executeQuery(sql);
        List<TeachersLoad> tload = new ArrayList<>();
        if (rs != null) {
            while (rs.next()) {
                TeachersLoad tl = new TeachersLoad();
                tl.setKurasu(rs.getString("kurasu"));
                tload.add(tl);
            }
        }
        return tload;

    }

    public List<TeachersLoad> selectTs(int id) throws SQLException {
        String sql = "select subject from teacherinfo";
        sql += " where id=";
        sql += "" + id + ";";
        ResultSet rs = stmt.executeQuery(sql);
        List<TeachersLoad> tload = new ArrayList<>();
        if (rs != null) {
            while (rs.next()) {
                TeachersLoad tl = new TeachersLoad();
                tl.setSubject(rs.getString("subject"));
                tload.add(tl);
            }
        }
        return tload;

    }

    public List<TeachersLoad> selectTsi(int id, String kurasu) throws SQLException {
        String sql = "select subject from teacherinfo";
        sql += " where id=";
        sql += "" + id + "and kurasu=";
        sql += "'" + kurasu + "';";
        ResultSet rs = stmt.executeQuery(sql);
        List<TeachersLoad> tload = new ArrayList<>();
        if (rs != null) {
            while (rs.next()) {
                TeachersLoad tl = new TeachersLoad();
                tl.setSubject(rs.getString("subject"));
                tload.add(tl);
            }
        }
        return tload;

    }

    /*
    delete 教師表(id)

     */
    public int deleteTload(int id) throws SQLException {
        String sql = "delete from teacherinfo";
        sql += " where id=";
        sql += "" + id + ";";
        stmt.executeUpdate(sql);
        System.out.println(sql);
        return 0;
    }

    public int deleteTload(int id, String kurasu, String subject, String name) throws SQLException {
        String sql = "delete from teacherinfo";
        sql += " where id=";
        sql += "" + id + "and kurasu = ";
        sql += "'" + kurasu + "'and subject =";
        sql += "'" + subject + "'and name=";
        sql += "'" + name + "';";
        stmt.executeUpdate(sql);
        System.out.println(sql);
        return 0;
    }

    /*
delete login (id)

     */
    public int deletelogin(int id) throws SQLException {
        String sql = "delete from login";
        sql += " where id=";
        sql += "" + id + ";";
        stmt.executeUpdate(sql);
        return 0;
    }

    /*
教師表全部取り出し
     */
    public List<TeachersLoad> selectAlltinfo() throws SQLException {
        List<TeachersLoad> tload = new ArrayList<>();
        String sql = "select * from teacherinfo";
        ResultSet rs = stmt.executeQuery(sql);
        if (rs != null) {
            while (rs.next()) {
                TeachersLoad tl = new TeachersLoad();
                tl.setId(rs.getInt("id"));
                tl.setPassword(rs.getString("password"));
                tl.setName(rs.getString("name"));
                tl.setSex(rs.getString("sex"));
                tl.setKurasu(rs.getString("kurasu"));
                tl.setSubject(rs.getString("subject"));
                tload.add(tl);
            }
        }
        return tload;
    }

    /*
教師　曖昧検索　使用なし

     */
    public List<TeachersLoad> liketinfo(int id, String name, String sex, String subject, String kurasu) throws SQLException {
        String sql = "select * from teacherinfo";
        sql += " where cast";
        sql += " (id as text) like";
        sql += " '%" + id + "%' or";
        sql += " name like";
        sql += " '%" + name + "%' or";
        sql += " sex like";
        sql += " '%" + sex + "%' or";
        sql += " subject like";
        sql += " '%" + subject + "%' or";
        sql += " kurasu like";
        sql += " '%" + kurasu + "%';";
//        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        List<TeachersLoad> tload = new ArrayList<>();
        if (rs != null) {
            while (rs.next()) {
                TeachersLoad tl = new TeachersLoad();
                tl.setId(rs.getInt("id"));
                tl.setPassword(rs.getString("password"));
                tl.setName(rs.getString("name"));
                tl.setSex(rs.getString("sex"));
                tl.setKurasu(rs.getString("kurasu"));
                tl.setSubject(rs.getString("subject"));
                tload.add(tl);
            }
        }
        return tload;
    }

    /*
教師　nameで曖昧検索
     */
    public List<TeachersLoad> liketinfo(String name) throws SQLException {
        String sql = "select * from teacherinfo";
        sql += " where name like";
        sql += " '%" + name + "%';";
        ResultSet rs = stmt.executeQuery(sql);
        List<TeachersLoad> tload = new ArrayList<>();
        if (rs != null) {
            while (rs.next()) {
                TeachersLoad tl = new TeachersLoad();
                tl.setId(rs.getInt("id"));
                tl.setPassword(rs.getString("password"));
                tl.setName(rs.getString("name"));
                tl.setSex(rs.getString("sex"));
                tl.setKurasu(rs.getString("kurasu"));
                tl.setSubject(rs.getString("subject"));
                tload.add(tl);
            }
        }
        return tload;
    }

    /*
教師　kurasuで判断　データ取り出し
     */
    public List<TeachersLoad> selectkurasu(String kurasu) throws SQLException {
        String sql = "select * from teacherinfo";
        sql += " where kurasu =";
        sql += "'" + kurasu + "';";
        ResultSet rs = stmt.executeQuery(sql);
        List<TeachersLoad> tload = new ArrayList<>();
        if (rs != null) {
            while (rs.next()) {
                TeachersLoad tl = new TeachersLoad();
                tl.setId(rs.getInt("id"));
                tl.setPassword(rs.getString("password"));
                tl.setName(rs.getString("name"));
                tl.setSex(rs.getString("sex"));
                tl.setKurasu(rs.getString("kurasu"));
                tl.setSubject(rs.getString("subject"));
                tload.add(tl);
            }
        }
        return tload;
    }

    /*
 教師　Id曖昧検索　

     */
    public List<TeachersLoad> liketinfoid(int id) throws SQLException {
        String sql = "select * from teacherinfo";
        sql += " where cast";
        sql += " (id as text) like";
        sql += " '%" + id + "%';";
        ResultSet rs = stmt.executeQuery(sql);
        List<TeachersLoad> tload = new ArrayList<>();
        if (rs != null) {
            while (rs.next()) {
                TeachersLoad tl = new TeachersLoad();
                tl.setId(rs.getInt("id"));
                tl.setPassword(rs.getString("password"));
                tl.setName(rs.getString("name"));
                tl.setSex(rs.getString("sex"));
                tl.setKurasu(rs.getString("kurasu"));
                tl.setSubject(rs.getString("subject"));
                tload.add(tl);
            }
        }
        return tload;
    }

    /*
    教師　id and name 曖昧検索
     */
    public List<TeachersLoad> liketinfo(int id, String name) throws SQLException {
        String sql = "select * from teacherinfo";
        sql += " where cast";
        sql += " (id as text) like";
        sql += " '%" + id + "%' and";
        sql += " name like";
        sql += " '%" + name + "%';";
        ResultSet rs = stmt.executeQuery(sql);
        List<TeachersLoad> tload = new ArrayList<>();
        if (rs != null) {
            while (rs.next()) {
                TeachersLoad tl = new TeachersLoad();
                tl.setId(rs.getInt("id"));
                tl.setPassword(rs.getString("password"));
                tl.setName(rs.getString("name"));
                tl.setSex(rs.getString("sex"));
                tl.setKurasu(rs.getString("kurasu"));
                tl.setSubject(rs.getString("subject"));
                tload.add(tl);
            }
        }
        return tload;
    }

    /*
    insert student表
     */
    public int addstudentinfo(TeachersLoad tl) throws SQLException {
        String sql = "INSERT INTO studentinformation (id,kurasu,name,sex,password)";
        sql += "VALUES ( " + tl.getId() + ",";
        sql += "'" + tl.getKurasu() + "',";
        sql += "'" + tl.getName() + "',";
        sql += "'" + tl.getSex() + "',";
        sql += "'" + tl.getPassword() + "')";

//        conn.commit();
        stmt.executeUpdate(sql);
        return 1;
    }

    /*
     student ID重複判断
     */
    public int selectsinfo(int id) throws SQLException {
        String sql = "select id from studentinformation ";
        sql += "where id=";
        sql += "" + id + "";
        ResultSet rs = stmt.executeQuery(sql);
        int result = 0;
        if (rs != null) {
            while (rs.next()) {
                result = 1;
                return result;
            }
        }
        return 0;
    }

    public int selectsinfos(int id) throws SQLException {
        String sql = "select test from seiseki ";
        sql += "where id=";
        sql += "" + id + ";";
        ResultSet rs = stmt.executeQuery(sql);
        int result = 0;
        while (rs.next()) {
            if (rs.getString(1) != null) {
                if (rs.getString(1).equals("期末")) {
                    result = 1;
                } else {
                    result = 2;
                }
            }
        }
        return result;
    }

    /*
     student kurasuで判断　データ取り出し
     */
    public List<TeachersLoad> selectstudentkurasu(String kurasu) throws SQLException {
        String sql = "select * from studentinformation";
        sql += " where kurasu =";
        sql += "'" + kurasu + "';";
        ResultSet rs = stmt.executeQuery(sql);
        List<TeachersLoad> tload = new ArrayList<>();
        if (rs != null) {
            while (rs.next()) {
                TeachersLoad tl = new TeachersLoad();
                tl.setId(rs.getInt("id"));
                tl.setPassword(rs.getString("password"));
                tl.setName(rs.getString("name"));
                tl.setSex(rs.getString("sex"));
                tl.setKurasu(rs.getString("kurasu"));
                tload.add(tl);
            }
        }
        return tload;
    }

    /*
    student nameで 曖昧検索
     */
    public List<TeachersLoad> likesinfo(String name) throws SQLException {
        String sql = "select * from studentinformation";
        sql += " where name like";
        sql += " '%" + name + "%';";
        ResultSet rs = stmt.executeQuery(sql);
        List<TeachersLoad> tload = new ArrayList<>();
        if (rs != null) {
            while (rs.next()) {
                TeachersLoad tl = new TeachersLoad();
                tl.setId(rs.getInt("id"));
                tl.setPassword(rs.getString("password"));
                tl.setName(rs.getString("name"));
                tl.setSex(rs.getString("sex"));
                tl.setKurasu(rs.getString("kurasu"));
                tload.add(tl);
            }
        }
        return tload;
    }

    /*
    student idで 曖昧検索
     */
    public List<TeachersLoad> liketsinfoid(int id) throws SQLException {
        String sql = "select * from studentinformation";
        sql += " where cast";
        sql += " (id as text) like";
        sql += " '%" + id + "%';";
        ResultSet rs = stmt.executeQuery(sql);
        List<TeachersLoad> tload = new ArrayList<>();
        if (rs != null) {
            while (rs.next()) {
                TeachersLoad tl = new TeachersLoad();
                tl.setId(rs.getInt("id"));
                tl.setPassword(rs.getString("password"));
                tl.setName(rs.getString("name"));
                tl.setSex(rs.getString("sex"));
                tl.setKurasu(rs.getString("kurasu"));
                tload.add(tl);
            }
        }
        return tload;
    }

    /*
    student  id and name 曖昧検索
     */
    public List<TeachersLoad> likesinfo(int id, String name) throws SQLException {
        String sql = "select * from studentinformation";
        sql += " where cast";
        sql += " (id as text) like";
        sql += " '%" + id + "%' and";
        sql += " name like";
        sql += " '%" + name + "%';";
        ResultSet rs = stmt.executeQuery(sql);
        List<TeachersLoad> tload = new ArrayList<>();
        if (rs != null) {
            while (rs.next()) {
                TeachersLoad tl = new TeachersLoad();
                tl.setId(rs.getInt("id"));
                tl.setPassword(rs.getString("password"));
                tl.setName(rs.getString("name"));
                tl.setSex(rs.getString("sex"));
                tl.setKurasu(rs.getString("kurasu"));
                tload.add(tl);
            }
        }
        return tload;
    }

    /*
    studentinfo 更新
     */
    public int updatestudentinfo(TeachersLoad tl) throws SQLException {
        String sql = "update studentinformation";
        sql += " set password=";
        sql += "'" + tl.getPassword() + "',";
        sql += "name=";
        sql += "'" + tl.getName() + "',";
        sql += "sex=";
        sql += "'" + tl.getSex() + "',";
        sql += "kurasu=";
        sql += "'" + tl.getKurasu() + "'";
        sql += " where id=";
        sql += "" + tl.getId() + ";";
        System.out.println(sql);
        stmt.executeUpdate(sql);
        return 0;
    }

    /*
    delete student行　　id で判断
     */
    public int deletestudentinfo(int id) throws SQLException {
        String sql = "delete from studentinformation";
        sql += " where id=";
        sql += "" + id + ";";
        stmt.executeUpdate(sql);
        System.out.println(sql);
        return 0;
    }

    /*
    student select id(曖昧検索),name,math,english,language,sum
     */
    public List<TeachersLoad> selectstudentseiseki(int id) throws SQLException {
        String sql = "select id,name,math,english,langu,sum from studentinformation";
        sql += " where cast";
        sql += " (id as text) like";
        sql += " '%" + id + "%';";
        ResultSet rs = stmt.executeQuery(sql);
        List<TeachersLoad> tload = new ArrayList<>();
        if (rs != null) {
            while (rs.next()) {
                TeachersLoad tl = new TeachersLoad();
                tl.setId(rs.getInt("id"));
                tl.setName(rs.getString("name"));
                tl.setMath(rs.getInt("math"));
                tl.setLanguage(rs.getInt("langu"));
                tl.setEnglish(rs.getInt("english"));
                tl.setSum(rs.getInt("sum"));
                tload.add(tl);
            }
        }
        return tload;
    }

    public List<TeachersLoad> seisekis(int id) throws SQLException {
        String sql = "select id,test,math,english,langu,sum from seiseki";
        sql += " where cast";
        sql += " (id as text) like";
        sql += " '%" + id + "%';";
        ResultSet rs = stmt.executeQuery(sql);
        List<TeachersLoad> tload = new ArrayList<>();
        if (rs != null) {
            while (rs.next()) {
                TeachersLoad tl = new TeachersLoad();
                tl.setId(rs.getInt("id"));
                tl.setTest(rs.getString("test"));
                tl.setMath(rs.getInt("math"));
                tl.setLanguage(rs.getInt("langu"));
                tl.setEnglish(rs.getInt("english"));
                tl.setSum(rs.getInt("sum"));
                tload.add(tl);
            }
        }
        return tload;
    }

    /*
    student classで成績検索
     */
    public List<TeachersLoad> selectseiseki(String kurasu) throws SQLException {
        String sql = "select id,name,math,english,langu,sum from studentinformation";
        sql += " where kurasu =";
        sql += "'" + kurasu + "';";
        ResultSet rs = stmt.executeQuery(sql);
        List<TeachersLoad> tload = new ArrayList<>();
        if (rs != null) {
            while (rs.next()) {
                TeachersLoad tl = new TeachersLoad();
                tl.setId(rs.getInt("id"));
                tl.setName(rs.getString("name"));
                tl.setMath(rs.getInt("math"));
                tl.setLanguage(rs.getInt("langu"));
                tl.setSum(rs.getInt("sum"));
                tl.setEnglish(rs.getInt("english"));
                tload.add(tl);
            }
        }
        return tload;
    }

    /*
    studentmarks 更新成績
     */
    public int updatemarks(TeachersLoad tl) throws SQLException {
        String sql = "update seiseki";
//        sql += " set test=";
//        sql += "'" + tl.getTest() + "',";
        sql += " set math=";
        sql += "" + tl.getMath() + ",";
        sql += "english=";
        sql += "" + tl.getEnglish() + ",";
        sql += "langu=";
        sql += "" + tl.getLanguage() + ",";
        sql += "sum=";
        sql += "" + tl.getSum() + "";
        sql += " where id=";
        sql += "" + tl.getId() + " and test=";
        sql += "'" + tl.getTest() + "';";
        System.out.println(sql);
        stmt.executeUpdate(sql);
        return 0;
    }

    public int updatemarkm(TeachersLoad tl) throws SQLException {
        String sql = "update seiseki";
//        sql += " set test=";
//        sql += "'" + tl.getTest() + "',";
        sql += " set math=";
        sql += "" + tl.getMath() + "";
//        sql += "english=";
//        sql += "" + tl.getEnglish() + ",";
//        sql += "langu=";
//        sql += "" + tl.getLanguage() + ",";
//        sql += "sum=";
//        sql += "" + tl.getSum() + "";
        sql += " where id=";
        sql += "" + tl.getId() + " and test=";
        sql += "'" + tl.getTest() + "';";
        System.out.println(sql);
        stmt.executeUpdate(sql);
        return 0;
    }

    public int updatemarkl(TeachersLoad tl) throws SQLException {
        String sql = "update seiseki ";
//        sql += " set test=";
//        sql += "'" + tl.getTest() + "',";
//        sql += " set math=";
//        sql += "" + tl.getMath() + "";
//        sql += "english=";
//        sql += "" + tl.getEnglish() + ",";
        sql += "set langu=";
        sql += "" + tl.getLanguage() + "";
//        sql += "sum=";
//        sql += "" + tl.getSum() + "";
        sql += " where id=";
        sql += "" + tl.getId() + " and test=";
        sql += "'" + tl.getTest() + "';";
        System.out.println(sql);
        stmt.executeUpdate(sql);
        return 0;
    }

    public int updatemarke(TeachersLoad tl) throws SQLException {
        String sql = "update seiseki ";
//        sql += " set test=";
//        sql += "'" + tl.getTest() + "',";
//        sql += " set math=";
//        sql += "" + tl.getMath() + "";
        sql += "set english=";
        sql += "" + tl.getEnglish() + "";
//        sql += "langu=";
//        sql += "" + tl.getLanguage() + "";
//        sql += "sum=";
//        sql += "" + tl.getSum() + "";
        sql += " where id=";
        sql += "" + tl.getId() + " and test=";
        sql += "'" + tl.getTest() + "';";
        System.out.println(sql);
        stmt.executeUpdate(sql);
        return 0;
    }

    public int selectseiseki(int id, String test) throws SQLException {
        String sql = "select * from seiseki ";
        sql += "where id=";
        sql += "" + id + "and test=";
        sql += "'" + test + "';";
        ResultSet rs = stmt.executeQuery(sql);
        int result = 0;
        if (rs != null) {
            while (rs.next()) {
                result = 1;
                return result;
            }
        }
        return 0;
    }


    /*
    sumを求め　使用なし
     */
    public int studentsum(int math, int language, int english) throws SQLException {
        String sql = "select sum(";
        sql += "" + math + ",";
        sql += "" + language + ",";
        sql += "" + english + "";
        sql += ")from studentinformation";

        stmt.executeUpdate(sql);
        return 0;
    }

    /*
    student id で検索　データ取り出し
     */
    public List<TeachersLoad> selectsinfoid(int id) throws SQLException {
        String sql = "select id,name,kurasu,password from studentinformation ";
        sql += "where id=";
        sql += "" + id + "";
        ResultSet rs = stmt.executeQuery(sql);
        int result = 0;
        List<TeachersLoad> tload = new ArrayList<>();
        if (rs != null) {
            while (rs.next()) {
                TeachersLoad tl = new TeachersLoad();
                tl.setId(rs.getInt("id"));
                tl.setName(rs.getString("name"));
                tl.setPassword(rs.getString("password"));
                tl.setKurasu(rs.getString("kurasu"));
                tload.add(tl);
            }
        }
        return tload;
    }

    /*
    student update password
     */
    public int updatestudentinfopass(TeachersLoad tl) throws SQLException {
        String sql = "update studentinformation";
        sql += " set password=";
        sql += "'" + tl.getPassword() + "'";
        sql += " where id=";
        sql += "" + tl.getId() + ";";
        System.out.println(sql);
        stmt.executeUpdate(sql);
        return 0;
    }

    /*
    student idで成績取り出し
     */
    public List<TeachersLoad> selectseiseki(int id) throws SQLException {
        String sql = "select math,english,langu,sum from studentinformation";
        sql += " where id =";
        sql += "'" + id + "';";
        ResultSet rs = stmt.executeQuery(sql);
        List<TeachersLoad> tload = new ArrayList<>();
        if (rs != null) {
            while (rs.next()) {
                TeachersLoad tl = new TeachersLoad();
                tl.setMath(rs.getInt("math"));
                tl.setLanguage(rs.getInt("langu"));
                tl.setSum(rs.getInt("sum"));
                tl.setEnglish(rs.getInt("english"));
                tload.add(tl);
            }
        }
        return tload;
    }

    public List<TeachersLoad> selectAlltinfo(String kurasu) throws SQLException {
        List<TeachersLoad> tload = new ArrayList<>();
        String sql = "select * from teacherinfo";
        sql += " where kurasu =";
        sql += "'" + kurasu + "';";
        ResultSet rs = stmt.executeQuery(sql);
        if (rs != null) {
            while (rs.next()) {
                TeachersLoad tl = new TeachersLoad();
                tl.setId(rs.getInt("id"));
                tl.setPassword(rs.getString("password"));
                tl.setName(rs.getString("name"));
                tl.setSex(rs.getString("sex"));
                tl.setKurasu(rs.getString("kurasu"));
                tl.setSubject(rs.getString("subject"));
                tload.add(tl);
            }
        }
        return tload;
    }

    public List<TeachersLoad> joinseiseki(String kurasu) throws SQLException {
        List<TeachersLoad> tload = new ArrayList<>();
        String sql = "select studentinformation.id, "
                + "seiseki.math,seiseki.english,seiseki.langu,seiseki.test,seiseki.sum from studentinformation inner join seiseki "
                + "on studentinformation.id=seiseki.id where studentinformation.kurasu ="
                + "'" + kurasu + "';";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        if (rs != null) {
            while (rs.next()) {
                TeachersLoad tl = new TeachersLoad();
                tl.setId(rs.getInt("id"));
//                tl.setName(rs.getString("name"));
                tl.setTest(rs.getString("test"));
                tl.setMath(rs.getInt("math"));
                tl.setLanguage(rs.getInt("langu"));
                tl.setSum(rs.getInt("sum"));
                tl.setEnglish(rs.getInt("english"));
                tload.add(tl);
            }
        }
        return tload;
    }

    public List<TeachersLoad> seiseki(String kurasu) throws SQLException {
        List<TeachersLoad> tload = new ArrayList<>();
        String sql = "select id from seiseki ";
        sql += " where kurasu =";
        sql += "'" + kurasu + "';";
        ResultSet rs = stmt.executeQuery(sql);
        if (rs != null) {
            while (rs.next()) {
                TeachersLoad tl = new TeachersLoad();
                tl.setId(rs.getInt("id"));
                tload.add(tl);
            }
        }
        return tload;

    }

    public List<TeachersLoad> seisekiid(int id) throws SQLException {
        List<TeachersLoad> tload = new ArrayList<>();
        String sql = "select id,test,math,english,langu,sum from seiseki";
        sql += " where id =";
        sql += "" + id + ";";
        ResultSet rs = stmt.executeQuery(sql);
        if (rs != null) {
            while (rs.next()) {
                TeachersLoad tl = new TeachersLoad();
                tl.setId(rs.getInt("id"));
//                tl.setName(rs.getString("name"));
                tl.setTest(rs.getString("test"));
                tl.setMath(rs.getInt("math"));
                tl.setLanguage(rs.getInt("langu"));
                tl.setSum(rs.getInt("sum"));
                tl.setEnglish(rs.getInt("english"));
                tload.add(tl);
            }
        }
        return tload;
    }

    public int addseiseki(TeachersLoad tl) throws SQLException {
        String sql = "INSERT INTO seiseki (id)";
        sql += "VALUES ( " + tl.getId() + ");";

//        conn.commit();
        stmt.executeUpdate(sql);
        return 1;
    }

    public int updateseiseki(TeachersLoad tl) throws SQLException {
        String sql = "update seiseki";
        sql += " set name=";
        sql += "'" + tl.getName() + "'";
        sql += " where id=";
        sql += "" + tl.getId() + ";";
        System.out.println(sql);
        stmt.executeUpdate(sql);
        return 0;
    }

    public int deleteseiseki(int id) throws SQLException {
        String sql = "delete from seiseki";
        sql += " where id=";
        sql += "" + id + ";";
        stmt.executeUpdate(sql);
        System.out.println(sql);
        return 0;
    }

    public int addseisekis(TeachersLoad tl) throws SQLException {
        String sql = "update seiseki";
        sql += " set test=";
        sql += "'" + tl.getTest() + "',";
        sql += " math=";
        sql += "" + tl.getMath() + ",";
        sql += "english=";
        sql += "" + tl.getEnglish() + ",";
        sql += "langu=";
        sql += "" + tl.getLanguage() + "";
//        sql += "sum=";
//        sql += "" + tl.getSum() + "";
        sql += " where id=";
        sql += "" + tl.getId() + ";";
        System.out.println(sql);
        stmt.executeUpdate(sql);
        return 0;
    }

    public int addSeiseki(TeachersLoad tl) throws SQLException {
        String sql = "INSERT INTO seiseki (id,test,math,english,langu)";
        sql += "VALUES ( " + tl.getId() + ",";
        sql += "'" + tl.getTest() + "',";
        sql += "" + tl.getMath() + ",";
        sql += "" + tl.getEnglish() + ",";
        sql += "" + tl.getLanguage() + ")";

//        conn.commit();
        stmt.executeUpdate(sql);
        return 1;
    }

    public int deleteseisekis(int id) throws SQLException {
        String sql = "delete from seiseki";
        sql += " where id=";
        sql += "" + id + ";";
        stmt.executeUpdate(sql);
//        System.out.println(sql);
        return 0;
    }

//    public int selectsum(int id, String test) throws SQLException {
//        String sql = "update seiseki set sum=(select SUM(math+english+langu) from seiseki)";
//        sql += " where id=";
//        sql += "" + id + "and test=";
//        sql += "'" + test + "';";
////        conn.commit();
//        stmt.executeUpdate(sql);
//        return 0;
//    }
    public int selectsum(int id, String test) throws SQLException {
        String sql = "update seiseki set sum=math+english+langu";
        sql += " where id=";
        sql += "" + id + "and test=";
        sql += "'" + test + "';";
//        conn.commit();
        stmt.executeUpdate(sql);
        return 0;
    }

}
