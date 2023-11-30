package student.data;

import mysql.db.DbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    DbConnect db = new DbConnect();


    public List<StudentDto> getAllStudent(){

        List<StudentDto> list = new ArrayList<>();

        Connection conn = db.getConnetcion();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from student order by id";

        try{

            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();

            while (rs.next()){
                StudentDto dto = new StudentDto();

                dto.setId(rs.getInt("id"));
                dto.setName(rs.getString("name"));
                dto.setAge(rs.getInt("age"));
                dto.setPhone(rs.getString("phone"));
                dto.setMbti(rs.getString("mbti"));
                dto.setDate(rs.getTimestamp("date"));

                list.add(dto);
            }
        }catch (SQLException e){
                e.printStackTrace();
        }finally {
            db.dbClose(rs,pstmt,conn);
        }
        return list;
    }

    public void deleteStudent(int id){

        Connection conn = db.getConnetcion();
        PreparedStatement pstmt = null;

        String sql = "delete from student where id = ?";

        try{

            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.execute();

        }catch (SQLException e){
            e.getMessage();
        }finally {
            db.dbClose(pstmt,conn);
        }

    }


    public List<StudentDto> searchStudent(String search){

        List<StudentDto> list = new ArrayList<>();

        Connection conn = db.getConnetcion();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from student where name like ? order by id";

        try{

            pstmt=conn.prepareStatement(sql);

            pstmt.setString(1, "%" + search.trim()+ "%");
            rs=pstmt.executeQuery();

            while (rs.next()){
                StudentDto dto = new StudentDto();

                dto.setId(rs.getInt("id"));
                dto.setName(rs.getString("name"));
                dto.setAge(rs.getInt("age"));
                dto.setPhone(rs.getString("phone"));
                dto.setMbti(rs.getString("mbti"));
                dto.setDate(rs.getTimestamp("date"));

                list.add(dto);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            db.dbClose(rs,pstmt,conn);
        }
        return list;
    }




    }


