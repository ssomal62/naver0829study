package bit701.day0919;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex1_OracleJdbc {
	static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String ORACLE_URL= "jdbc:oracle:thin:@localhost:1521:xe";
	
	public  Ex1_OracleJdbc () {
		try {
			Class.forName(ORACLE_DRIVER);
			System.out.println("오라클 드리어버 성공!~");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("오라클 드라이버 오류 " + e.getMessage());
		}
	}
	
	public void shopAllDatas() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(ORACLE_URL, "aiur","1234");
			System.out.println("오라클 연결 성공!");
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패!" + e.getMessage());
			// TODO: handle exception
		}
		
		
	}
	public static void main(String[] args) {
		
		 Ex1_OracleJdbc ex = new  Ex1_OracleJdbc();
		 ex.shopAllDatas();
		 
	}
}
