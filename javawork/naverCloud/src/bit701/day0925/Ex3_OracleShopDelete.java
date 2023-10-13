package bit701.day0925;

import bit701.dbsetting.DB_Connect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex3_OracleShopDelete {

    DB_Connect db = new DB_Connect();
    public void shopDelete(){

        Scanner sc= new Scanner(System.in);

        System.out.println("삭제할 상품번호 입력");
        String product_num = sc.nextLine();

        String sql = "delete from shop where sang_no = " + product_num;
        System.out.println(sql);

        Connection connection = null;
        Statement statement =null;

        connection = db.getOracleConnection();
        try{
            statement = connection.createStatement();
            int n = statement.executeUpdate(sql);

            if(n==0){
                System.out.println(product_num + "상품은 목록에 없습니다.");
            }else{
                System.out.println("총 " + n+ "개의 상품을 삭제했습니다.");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            db.DbClose(statement,connection);
        }

    }

    public static void main(String[] args) {
        Ex3_OracleShopDelete ex = new Ex3_OracleShopDelete();
        ex.shopDelete();
    }
}
