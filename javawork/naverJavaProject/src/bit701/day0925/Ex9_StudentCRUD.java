package bit701.day0925;

import bit701.dbsetting.DB_Connect;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ex9_StudentCRUD {
    DB_Connect db=new DB_Connect();
    Scanner sc=new Scanner(System.in);
    LocalDateTime currentDate = LocalDateTime .now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
    String formatDate = currentDate.format(formatter);

    public int getMenu()
    {
        System.out.println("1.추가  2.삭제  3.수정  4.전체출력  5.검색  6.종료");
        int menu=Integer.parseInt(sc.nextLine());
        return menu;
    }

    //insert
    public void insertStudent()
    {
        System.out.println("** 학생 정보 등록");


        System.out.printf("이름 입력 > ");
        String name = sc.nextLine();
        System.out.printf("나이 입력 > ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.printf("전화번호 입력 > ");
        String phone = sc.nextLine();
        System.out.printf("MBTI 입력 > ");
        String mbti = sc.nextLine();


        Connection connection = db.geMysqlConnection();
        PreparedStatement pstmt = null;

       // String sql = "insert into student values (null,?,?,?,?,now())";

        String sql = """
                        INSERT INTO student (
                              ID
                            , NAME
                            , AGE
                            , PHONE_NUMBER
                            , MBTI
                            , DATE_OF_CREATION
                            )
                             VALUES (null,?,?,?,?,now())
                        """;

        try{
            pstmt = connection.prepareStatement(sql);//이때 Sql문을 검사한다 !!

            //물음표(?) 갯수만큼 값을 넣어준다.
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, phone);
            pstmt.setString(4, mbti.toUpperCase());
            pstmt.execute();
            System.out.println("학생 정보를 추가하였습니다.");

        }
        catch (SQLException e){
            e.getStackTrace();
        }
        finally {
            db.DbClose(pstmt,connection);
        }
    }

    //delete
    public void deleteStudent()
    {
        System.out.println("** 학생 정보 삭제");
        System.out.printf("삭제할 학생 이름을 입력하세요 > ");
        String name  = sc.nextLine();


    }

    //update
    public void updateStudent()
    {
        System.out.println("** 학생 정보 수정");
        System.out.printf("수정할 학생 이름를 입력하세요 > ");

    }

    //전체 출력
    public void selectAllStudent()
    {
        System.out.println("** 전체 학생 목록");
    }

    //검색-번호 끝 4자리로 검색
    public void searchStudent()
    {
        System.out.println("** 학생 조회");
        System.out.printf("검색할 학생 이름을 입력하세요 > ");

        String searchName = sc.nextLine();

        Connection connection = db.geMysqlConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM student WHERE NAME like ? ";

        try{
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, "%" + searchName);
            rs = pstmt.executeQuery();

            System.out.println("[" + searchName + "] 검색 결과");
            System.out.println("번호\t이름\t나이\t전화\t\tMBTI");
            System.out.println("-".repeat(50));

            while (rs.next()){

                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                int age = rs.getInt("AGE");
                String phoneNumber = rs.getString("PHONE_NUMBER");
                String mbti = rs.getString("MBTI");

                System.out.println(id+ "\t" +name+ "\t" +age + "\t" + phoneNumber+ "\t\t" +mbti );

            }


        }
        catch(SQLException e){
            e.getStackTrace();
        }finally {
            db.DbClose(rs,pstmt,connection);
        }



    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Ex9_StudentCRUD ex=new Ex9_StudentCRUD();

        while(true)
        {
            System.out.println("-".repeat(40));
            int menu=ex.getMenu();
            System.out.println("-".repeat(40));
            switch(menu)
            {
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
                    ex.selectAllStudent();
                    break;
                case 5:
                    ex.searchStudent();
                    break;
                default:
                    System.out.println("** 프로그램을 종료합니다 **");
                    System.exit(0);
            }
        }

    }

}
