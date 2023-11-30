package com.example.kahki.mysqlDB;

import java.sql.*;

public class DbConnect_Local {

    static String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    static String MYSQL_URL = "jdbc:mysql://localhost:3306/aiurDB?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";

    public DbConnect_Local(){
        try {
            Class.forName(MYSQL_DRIVER);
        } catch (ClassNotFoundException e){
            System.out.println("Mysql 드라이버 오류 : " + e.getMessage());
        }
    }

    public Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(MYSQL_URL, "root", "1234");
        } catch (SQLException e){
            System.out.println("Mysql 접속 오류 : " + e.getMessage());
        }
        return conn;
    }

    public void dbClose(PreparedStatement pstmt, Connection conn){
        try {
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
        } catch (SQLException e){
            System.out.println("Mysql 종료 오류 : " + e.getMessage());
        }
    }

    public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn){
        try {
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
        } catch (SQLException e){
            System.out.println("Mysql 종료 오류 : " + e.getMessage());
        }
    }


}
