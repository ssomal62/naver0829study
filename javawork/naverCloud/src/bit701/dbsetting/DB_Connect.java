package bit701.dbsetting;

import java.sql.*;

public class DB_Connect {

    static String MYSQL_URL = "jdbc:mysql://localhost:3306/classicmodels?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
    static String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";

    static String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    static String ORCLE_DRIVER = "oracle.jdbc.driver.OracleDriver";

    public DB_Connect(){
        try{
            Class.forName(MYSQL_DRIVER);
        }catch (ClassNotFoundException e){
            System.out.println("MYSQL 드라이버 오류 : " + e.getMessage());
        }

        try{
            Class.forName(ORCLE_DRIVER);
        }catch (ClassNotFoundException e){
            System.out.println("ORCLE 드라이버 오류 : " + e.getMessage());
        }
    }

    public Connection getOracleConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(ORACLE_URL,"aiur","1234");
        }catch (SQLException e){
            System.out.println("오라클 연결 실패 :" + e.getMessage());
        }
        return connection;
    }

    public Connection geMysqlConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(MYSQL_URL,"aiur","1234");
        }catch (SQLException e){
            System.out.println("MYSQL 연결 실패 :" + e.getMessage());
        }
        return connection;
    }

    //Close 시작
    public void DbClose(Statement statement, Connection connection){
        try{
            statement.close();
            connection.close();
        }catch (SQLException|NullPointerException e){
            System.out.println("Close 시 오류 발생(1) : " + e.getMessage());
        }
    }

    public void DbClose(ResultSet resultSet, Statement statement, Connection connection){
        try{
            resultSet.close();
            statement.close();
            connection.close();
        }catch (SQLException|NullPointerException e){
            System.out.println("Close 시 오류 발생(2) : " + e.getMessage());
        }
    }

    public void DbClose(PreparedStatement pstmt, Connection connection){
        try{
            pstmt.close();
            connection.close();
        }catch (SQLException|NullPointerException e){
            System.out.println("Close 시 오류 발생(1) : " + e.getMessage());
        }
    }

    public void DbClose(ResultSet resultSet, PreparedStatement pstmt, Connection connection){
        try{
            resultSet.close();
            pstmt.close();
            connection.close();
        }catch (SQLException|NullPointerException e){
            System.out.println("Close 시 오류 발생(2) : " + e.getMessage());
        }
    }

}
