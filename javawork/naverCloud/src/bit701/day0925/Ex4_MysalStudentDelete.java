package bit701.day0925;

import bit701.dbsetting.DB_Connect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex4_MysalStudentDelete {

    DB_Connect db = new DB_Connect();

    public void studentDBDelete(){

        Scanner sc = new Scanner(System.in);
        System.out.println("삭제할 학생 ID를 입력하세요");
        String student_ID = sc.nextLine();

        String sql = "delete from student where student_ID = " + student_ID;

        System.out.println(sql);

        Connection connection = null;
        Statement statement = null;

        connection = db.geMysqlConnection();

        try{
            statement = connection.createStatement();
            int n = statement.executeUpdate(sql);

            if(n==0){
                System.out.println(student_ID + "학생은 목록에 없습니다.");
            }else {
                System.out.println("총 " + n + "명의 학생DB를 삭제했습니다.");
            }
        }catch (SQLException e){
                e.printStackTrace();
        }finally {
                db.DbClose(statement,connection);
        }


    }

    public static void main(String[] args) {
        Ex4_MysalStudentDelete ex = new Ex4_MysalStudentDelete();
        ex.studentDBDelete();
    }


}
