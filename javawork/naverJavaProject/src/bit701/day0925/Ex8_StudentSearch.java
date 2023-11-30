package bit701.day0925;

import bit701.dbsetting.DB_Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex8_StudentSearch {

    DB_Connect db = new DB_Connect();

    public void searchStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("검색할 이름 입력 : ");
        String name = sc.nextLine();

        String sql = "select * from student where FIRST_NAME like = ?";

        Connection connection = db.geMysqlConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{

            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, "%" + name);
            //실행
            rs = pstmt.executeQuery();

            System.out.println(name + "검색 결과");

            int cnt = 0;

            while(rs.next()){
                int no = rs.getInt("student_ID");
                String fname = rs.getString("FIRST_NAME");
                String lname = rs.getString("LAST_NAME");
                int age = rs.getInt("AGE");
                String birth = rs.getString("BIRTH_DAY");

                System.out.println(++cnt);

                System.out.println("번호 : " + no);
                System.out.println("이름(성) : " + fname);
                System.out.println("이름 : " + lname);
                System.out.println("나이 : " + age);
                System.out.println("생일 : " + birth);
            }

        }catch(SQLException e){
            e.getMessage();
        }finally {
            db.DbClose(rs,pstmt,connection);
        }
    }

    public static void main(String[] args) {
        Ex8_StudentSearch ex = new Ex8_StudentSearch();
        ex.searchStudent();
    }
}
