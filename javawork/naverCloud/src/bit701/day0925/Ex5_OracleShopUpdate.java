package bit701.day0925;

import bit701.dbsetting.DB_Connect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex5_OracleShopUpdate {

    bit701.dbsetting.DB_Connect db= new DB_Connect();

    public void shopUpdate(){

        Scanner sc = new Scanner(System.in);
        System.out.println("수정할 상품 번호는?");
        String no = sc.nextLine();

        System.out.println("수정할 가격은?");
        int price = Integer.parseInt(sc.nextLine());
        System.out.println("수정할 색상은?");
        String color = sc.nextLine();

        String sql = "update shop set sang_price = " + price  + ", sang_color = '" + color + "' where sang_no = " + no;
        System.out.println(sql);

        Connection connection = null;
        Statement statement = null;

        connection = db.getOracleConnection();
        try{
            statement = connection.createStatement();

            int n = statement.executeUpdate(sql);

            if(n==0){
                System.out.println("해당 상품이 없습니다.");
            }else{
                System.out.println("상품정보 수정 완료!");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            db.DbClose(statement,connection);
        }

    }



    public static void main(String[] args) {
        Ex5_OracleShopUpdate ex = new Ex5_OracleShopUpdate();
        ex.shopUpdate();
    }
}
