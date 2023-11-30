package com.example.kahki.dao;

import com.example.kahki.dto.MemberDto;
import com.example.kahki.mysqlDB.DbConnect_Local;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MemberDao {

    private final DbConnect_Local db = new DbConnect_Local();


    public List<MemberDto> getAllMembers() {
        List<MemberDto> members = new ArrayList<>();
        String sql = "SELECT * FROM member";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                MemberDto member = new MemberDto();
                member.setUser_id(resultSet.getString("user_id"));
                member.setUser_pw(resultSet.getString("user_pw"));
                member.setProfile_img_url(resultSet.getString("profile_img_url"));
                members.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }

    // Create (Insert) a new member
    public void createMember(MemberDto member) {
        String sql = "INSERT INTO member (member_id,user_id, user_pw, profile_img_url) VALUES (null, ?, ?, ?)";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, member.getUser_id());
            statement.setString(2, member.getUser_pw());
            statement.setString(3, member.getProfile_img_url());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read (Retrieve) a member by user_id
    public MemberDto getMemberById(String user_id) {
        String sql = "SELECT * FROM member WHERE user_id = ?";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, user_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                MemberDto member = new MemberDto();
                member.setUser_id(resultSet.getString("user_id"));
                member.setUser_pw(resultSet.getString("user_pw"));
                member.setProfile_img_url(resultSet.getString("profile_img_url"));
                return member;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update a member's information
    public void updateMember(MemberDto member) {
        String sql = "UPDATE member SET user_pw = ?, profile_img_url = ? WHERE user_id = ?";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, member.getUser_pw());
            statement.setString(2, member.getProfile_img_url());
            statement.setString(3, member.getUser_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a member by user_id
    public void deleteMember(String userId) {
        String sql = "DELETE FROM member WHERE user_id = ?";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

