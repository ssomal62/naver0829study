package bit701.day0925;

import bit701.dbsetting.DB_Connect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EX1_OracleShopInsert {

    DB_Connect db = new DB_Connect();

    public void shopInset(){

        Scanner sc = new Scanner(System.in);

        System.out.println("상품명 입력");
        String product = sc.nextLine();
        System.out.println("가격 입력");
        String price = sc.nextLine();
        System.out.println("색상 입력");
        String color = sc.nextLine();

        String sql = "insert into shop values (seq_shop.nextval" + ",'" + product  + "', " + price + ",'"+ color + "');";

        System.out.println(sql);

        Connection connection = null;
        Statement statement = null;
        connection = db.getOracleConnection();
        //statement 생성
        try{
            statement = connection.createStatement(); //반환타입이 boolean, false
            

//            boolean b = statement.execute(sql); //반환타입이 int:sql문을 성공한 갯수
//            int n = statement.executeUpdate(sql);// 반환타입어 int
//            System.out.println(b+","+n);
//            System.out.println("데이터 두번 insrt 됨");
            
          
            statement.execute(sql);
            System.out.println("shop에 데이터 추가됨");
            
        }catch (SQLException e){
            System.out.println("insrt sql문 오류  : " + e.getMessage());
        }finally {
			db.DbClose(statement, connection);
		}


    }

    public static void main(String[] args) {

        EX1_OracleShopInsert ex = new EX1_OracleShopInsert();
        ex.shopInset();
    }
}
