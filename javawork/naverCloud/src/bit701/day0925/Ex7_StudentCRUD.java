package bit701.day0925;

import bit701.dbsetting.DB_Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex7_StudentCRUD {

    DB_Connect db = new DB_Connect();
    Scanner sc = new Scanner(System.in);

    public void selectALL(){
        System.out.println("💙 전체 학생 목록을 출력합니다.");
        System.out.println("학생ID"+"\t"+ "이름(성)" +"\t"+"이름" +"\t"+"나이" +"\t"+"생일");
        System.out.println("=".repeat(30));

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "Select * From student order by student_ID";

        connection = db.geMysqlConnection();

        try{
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                int no = rs.getInt("student_ID");
                String fname = rs.getString("FIRST_NAME");
                String lname = rs.getString("LAST_NAME");
                int age = rs.getInt("AGE");
                String birth = rs.getString("BIRTH_DAY");

                System.out.println(no+"\t"+ fname +"\t"+lname +"\t"+age +"\t"+birth);
            }
        }catch (SQLException e){
            e.getMessage();
        }finally {
            db.DbClose(rs,pstmt,connection);
        }




    }

    public void insertStudent(){
        System.out.println("💙 학생 정보을 등록합니다.");
        System.out.printf("학생 ID :");
        int student_ID = Integer.parseInt(sc.nextLine());
        System.out.printf("이름(성) 입력 :");
        String fName = sc.nextLine();
        System.out.printf("이름 입력 :");
        String lName = sc.nextLine();
        System.out.printf("나이 입력 :");
        int age = Integer.parseInt(sc.nextLine());
        System.out.printf("생일 입력 :");
        String birthDay = sc.nextLine();

        String sql = "insert into student (student_ID, FIRST_NAME,LAST_NAME, AGE, BIRTH_DAY) values (?,?,?,?,?)";
        //여기서는 실제 테이블 열 이름을 써줘야한다규 !!!!

        Connection connection = db.geMysqlConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = connection.prepareStatement(sql);//이때 Sql문을 검사한다 !!

            //물음표(?) 갯수만큼 값을 넣어준다.
            pstmt.setInt(1, student_ID);
            pstmt.setString(2, fName);
            pstmt.setString(3, lName);
            pstmt.setInt(4, age);
            pstmt.setString(5, birthDay);

            //실행
            pstmt.execute();  //주의 : sql문이 없다.
            System.out.println("학생 정보를 추가하였습니다.");

        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            db.DbClose(pstmt,connection);
        }
    }

    public void deleteStudent(){
        System.out.println("💙 학생 정보를 삭제합니다.");
        System.out.print("학생 이름을 입력하세요(FirstName) :");
        String name = sc.nextLine();

        Connection connection = db.geMysqlConnection();
        PreparedStatement pstmt = null;

        String sql = "delete from student where FIRST_NAME = ? ";

        try{
            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1,name); //값 입력은 execute 전에 입력해야함.

            int n = pstmt.executeUpdate();
            if(n==0)
                System.out.println("삭제할 학생이 존재하지 않습니다.");
            else{
                System.out.println("학생 정보 삭제 완료!");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            db.DbClose(pstmt,connection);
        }
    }

    public void updateStudent(){
        System.out.println("💙 학생 정보를 수정합니다.");
        System.out.printf("수정할 학생 ID :");
        int student_ID = Integer.parseInt(sc.nextLine());
        System.out.printf("수정할 이름(성) 입력 :");
        String fName = sc.nextLine();
        System.out.printf("수정할 이름 입력 :");
        String lName = sc.nextLine();
        System.out.printf("수정할 나이 입력 :");
        int age = Integer.parseInt(sc.nextLine());
        System.out.printf("수정할 생일 입력 :");
        String birthDay = sc.nextLine();


        Connection connection = db.geMysqlConnection();
        PreparedStatement pstmt = null;

        String sql = "update student set FIRST_NAME = ? ,LAST_NAME = ? , AGE= ?, BIRTH_DAY= ? where student_ID = ? ";

        try{

            pstmt = connection.prepareStatement(sql);


            pstmt.setString(1,fName);
            pstmt.setString(2,lName);
            pstmt.setInt(3,age);
            pstmt.setString(4,birthDay);
            pstmt.setInt(5,student_ID);

            int n = pstmt.executeUpdate();

            if(n==0){
                System.out.println("뭔가 잘못됨!");
            }else{
                System.out.println(student_ID + "의 학생 정보가 수정되었습니다.");
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }finally {
            db.DbClose(pstmt,connection);
        }



    }

    public int getMenu(){

        int menu = 0;
        System.out.println("1추가 | 2삭제 | 3수정 | 4전체조회 | 5종료");
        menu = Integer.parseInt(sc.nextLine());
        return menu;

    }

    public static void main(String[] args) {
        Ex7_StudentCRUD ex = new Ex7_StudentCRUD();


       while(true){
         int menu = ex.getMenu();
         switch (menu){

             case 1:
                 ex.insertStudent();
                 break;
             case 2:
                 ex.deleteStudent();
                 break;
             case 3:
                 ex.updateStudent();
                 break;
             case 4:
                 ex.selectALL();
                 break;
             case 5:
                 System.out.println("💙 시스템을 종료합니다.");
                 System.exit(0);
                 break;
         }
           System.out.println("=".repeat(30));

       }


    }
}
