package mysql.db;

import java.sql.*;

public class DbConnect_local {

    static String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    //static String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
    static String MYSQL_URL = "jdbc:mysql://db-jbnp5-kr.vpc-pub-cdb.ntruss.com:3306/studydb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";


    public DbConnect_local() {
        try {
            Class.forName(MYSQL_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Mysql 드라이버 오류 : " + e.getMessage());
        }

    }

    //전체 출력

    public Connection getConnetcion(){
        Connection conn = null;
        try {
            //로컬연걸
            //conn = DriverManager.getConnection(MYSQL_URL,"aiur","1234");
            conn = DriverManager.getConnection(MYSQL_URL,"study","bitcamp123!@#");
        } catch (SQLException e) {
            System.out.println("Mysql Local 연결 실패 : " + e.getMessage());
        }
        return conn;
    }

    public void dbClose(PreparedStatement pstmt, Connection conn){
        try {
            pstmt.close();
            conn.close();
        } catch (SQLException | NullPointerException e){
            e.printStackTrace();
        }
    }

    public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn){
        try {
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException | NullPointerException e){
            e.printStackTrace();
        }
    }
}
