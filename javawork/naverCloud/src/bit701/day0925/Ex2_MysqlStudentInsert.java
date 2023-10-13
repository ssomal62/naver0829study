package bit701.day0925;

import bit701.dbsetting.DB_Connect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex2_MysqlStudentInsert {
	
	DB_Connect db = new DB_Connect();
	
	public void studentInsert() {
		
		 Scanner sc = new Scanner(System.in);
		 
	        System.out.println("넘버 입력");
	        String stuNum = sc.nextLine();
	        System.out.println("성 입력");
	        String fName = sc.nextLine();
	        System.out.println("이름 입력");
	        String lName = sc.nextLine();
	        System.out.println("나이");
	        String age = sc.nextLine();
	        System.out.println("생일");
	        String birth = sc.nextLine();

	        String sql = "insert into student values ("+ stuNum + ",'" + fName  + "', '" + lName + "',"+ age + ",'"+ birth + "')";
	        
	        System.out.println(sql);
	        
	        Connection connection = null;
	        Statement statement = null;
	        connection = db.geMysqlConnection();
	        try{
	            statement = connection.createStatement(); 
	            statement.execute(sql);
	            System.out.println("학생DB에 데이터 추가됨");
	            
	        }catch (SQLException e){
	            System.out.println("insrt sql문 오류  : " + e.getMessage());
	        }finally {
				db.DbClose(statement, connection);
			}

	        
	}
	
	public static void main(String[] args) {
		Ex2_MysqlStudentInsert ex = new Ex2_MysqlStudentInsert();
		ex.studentInsert();
	}

}
