package simpleBoard;

import mysql.db.dbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimpleBoardDao {
    dbConnect db = new dbConnect();

    public List<SimpleBoardDto> getAllList() {

        List<SimpleBoardDto> list = new ArrayList<>();
        String sql = "select * from simpleboard order by num desc";

        Connection conn = db.getConnetcion();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            pstmt = conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next()){
                SimpleBoardDto dto = new SimpleBoardDto();
                dto.setNum(rs.getString("num"));
                dto.setWriter(rs.getString("writer"));
                dto.setContent(rs.getString("content"));
                dto.setSubject(rs.getString("subject"));
                dto.setPhoto(rs.getString("photo"));
                dto.setReadcount(rs.getInt("readcont"));
                dto.setWriteday(rs.getTimestamp("wirteday"));



            }
        }catch (SQLException e){
            e.getStackTrace();
        }finally {
            db.dbClose(rs,pstmt,conn);
        }

        return list;
    }

    public void insertBoard(SimpleBoardDto dto) {

        String sql = "inset into simpleboard (writer, subject, content, photo, writeday)"
                + " values (?,?,?,?,now())";
//        String sql = """
//                 insert into simpleboard (writer, subject, content, photo, writeday)
//                 values (?,?,?,?,now())
//                """;
        Connection conn = db.getConnetcion();
        PreparedStatement pstmt = null;

        try{
            pstmt = conn. prepareStatement(sql);

            pstmt.setString(1, dto.getWriter());
            pstmt.setString(2, dto.getSubject());
            pstmt.setString(3, dto.getContent());
            pstmt.setString(4, dto.getPhoto());

            pstmt.execute();

        }catch (SQLException e){
            e.getStackTrace();
        }finally {
            db.dbClose(pstmt,conn);
        }


    }

    public SimpleBoardDto getData(String num) {
        SimpleBoardDto dto = new SimpleBoardDto();

        String sql = "select * from simpleboard where num =?";

        Connection conn = db.getConnetcion();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,num);
            rs=pstmt.executeQuery();
            while (rs.next()){

                dto.setNum(rs.getString("num"));
                dto.setWriter(rs.getString("writer"));
                dto.setContent(rs.getString("content"));
                dto.setSubject(rs.getString("subject"));
                dto.setPhoto(rs.getString("photo"));
                dto.setReadcount(rs.getInt("readcont"));
                dto.setWriteday(rs.getTimestamp("wirteday"));



            }
        }catch (SQLException e){
            e.getStackTrace();
        }finally {
            db.dbClose(rs,pstmt,conn);
        }


        return dto;
    }

    //조회수 증가
    public void updateReadcount(String num){
        String sql = "update simpleboard set readcount = readcount +1 where num =?";

        Connection conn = db.getConnetcion();
        PreparedStatement pstmt = null;

        try{
            pstmt = conn. prepareStatement(sql);

            pstmt.setString(1, num);

            pstmt.execute();

        }catch (SQLException e){
            e.getStackTrace();
        }finally {
            db.dbClose(pstmt,conn);
        }
    }

    public void deleteBoard(String num)
    {
        Connection conn = db.getConnetcion();
        PreparedStatement pstmt = null;

        String sql = "delete from simple_board where num = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1,num);
            //실행
            int n =  pstmt.executeUpdate();

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            db.dbClose(pstmt, conn);
        }

    }

}
