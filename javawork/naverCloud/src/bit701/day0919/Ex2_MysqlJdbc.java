package bit701.day0919;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex2_MysqlJdbc {
	static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL= "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";

	public Ex2_MysqlJdbc() {
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("mysql 드라이버 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("mysql 드라이버 실패 " + e.getMessage());
		}
	}
	
	public void employeeAllDatas() {
		
		Statement stmt=null;
		Connection conn = null;
		
		ResultSet rs = null;//select 일경우에만 필요
		String sql="select buseo,count(*) count, max(score) maxscore, min(score) minscore, avg(score) avgscore\r\n"
				+ "from employee group by buseo";
		
		try {
			conn = DriverManager.getConnection(MYSQL_URL, "root","1234");
			System.out.println("mysql 연결 성공");
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("buseo\tcount\tmaxscore\tminscore\tavgscore");
			System.out.println("=".repeat(60));
			int total=0;
			
			while(rs.next())
			{
	
				String buseo=rs.getString("buseo");
				String count=rs.getString("count");
				int maxscore=rs.getInt("maxscore");
				int minscore=rs.getInt("minscore");
				int avgscore=rs.getInt("avgscore");
				
			
				
				System.out.println(buseo+"\t"+count+"\t\t"+maxscore+"\t\t"+minscore+"\t\t"+avgscore);
			}
		} catch (SQLException e) {
			System.out.println("mysql 실패 : " + e.getMessage());
			// TODO: handle exception
		}

	}

	public static void main(String[] args) {
		Ex2_MysqlJdbc ex = new Ex2_MysqlJdbc();
		ex.employeeAllDatas();
		
		
		
		
	}
}
