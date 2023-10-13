package bit701.day0922;

import java.sql.*;

public class EX1_MysqlJdbc {
    String url = "jdbc:mysql://localhost:3306/bit701?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
    //mysql8을은 -> 이걸 추가로 붙여줘야 함.   characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 실패" + e.getMessage());
        }
    }
    public void lodeStudentDB(){

        String sql = "SELECT * FROM student";
        Connection connection = null;
        Statement statement =null;
        ResultSet resultSet =null;



        try {
            connection = DriverManager.getConnection(url, "aiur", "1234");
            statement = connection.createStatement();
            resultSet =statement.executeQuery(sql);

            while(resultSet.next()){
                String student_ID = resultSet.getString("STUDENT_ID");
                String firstName = resultSet.getString("FIRST_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                String age = resultSet.getString("AGE");

                System.out.println(student_ID+"\t"+firstName+"\t"+ lastName +"\t"+ age);
            }


        }catch (SQLException e){
            System.out.println("연결 실패" + e.getMessage());
        }finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();

            } catch (SQLException|NullPointerException e) {
            }
        }






    }

}
