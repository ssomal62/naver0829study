package myshop.data;

import mysql.db.dbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class myshopDAO {

    dbConnect db = new dbConnect();

    public List<myShopDTO> getAllProduct(){
        Connection conn = db.getConnetcion();
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        String sql = "select * from myshop order by num";

        List<myShopDTO> list = new ArrayList<>();

        try{
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                myShopDTO dto = new myShopDTO();//반드시 while문 안에 선언
                dto.setNum(rs.getInt("num"));
                dto.setProductName(rs.getString("productName"));
                dto.setPrice(rs.getInt("price"));
                dto.setPhoto(rs.getInt("photo"));
                dto.setColor(rs.getString("color"));
                dto.setWriteDay(rs.getTimestamp("writeDay"));

                list.add(dto);

            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            db.dbClose(rs,pstmt,conn);
        }


        return list;
    }

    //insert
    public void insertShop(myShopDTO dto){
        String sql = "insert into myshop (productName, color, price, photo, writeDay) values (?,?,?,?,now())";

        Connection conn= db.getConnetcion();
        PreparedStatement pstmt = null;

        try{
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, dto.getProductName());
            pstmt.setString(2, dto.getColor());
            pstmt.setInt(3, dto.getPrice());
            pstmt.setInt(4, dto.getPhoto());



            pstmt.execute();

        }catch (SQLException e){
            e.getMessage();
        }finally {
            db.dbClose(pstmt,conn);
        }
    }


    public void deleteShop(String num){
        String sql = "delete from myshop where num = ? ";
        Connection conn = db.getConnetcion();
        PreparedStatement pstmt = null;

        try{
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,num);
            pstmt.execute();


        }catch (SQLException e) {
            e.getMessage();
        } finally {
            db.dbClose(pstmt,conn);
        }
    }


    public myShopDTO getProduct(String num){
        myShopDTO dto = new myShopDTO();
        Connection conn = db.getConnetcion();
        PreparedStatement pstmt = null;
        ResultSet rs =null;

        String sql = "select * from myshop where num = ?";


        try{
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,num);
            rs=pstmt.executeQuery();

           if(rs.next()){
                dto.setNum(rs.getInt("num"));
                dto.setProductName(rs.getString("productName"));
                dto.setPrice(rs.getInt("price"));
                dto.setPhoto(rs.getInt("photo"));
                dto.setColor(rs.getString("color"));
                dto.setWriteDay(rs.getTimestamp("writeDay"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            db.dbClose(rs,pstmt,conn);
        }

        return dto;
    }

    public void updateProduct(myShopDTO dto){

        Connection conn = db.getConnetcion();
        PreparedStatement pstmt = null;

        String sql = "update myshop set productName = ?, color = ?, price = ? , photo = ? where num = ?";

        try{
            pstmt = conn.prepareStatement(sql);


            pstmt.setString(1,dto.getProductName());
            pstmt.setString(2,dto.getColor());
            pstmt.setInt(3,dto.getPrice());
            pstmt.setInt(4,dto.getPhoto());
            pstmt.setString(5,String.valueOf(dto.getNum()));


            pstmt.executeUpdate();

        } catch (SQLException e){
            System.out.println("에러발생!!");
            e.printStackTrace();
        } finally {
            db.dbClose(pstmt,conn);
        }
    }

}
