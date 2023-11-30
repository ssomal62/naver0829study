package com.example.kahki.dao;

import com.example.kahki.dto.CommentDto;
import com.example.kahki.mysqlDB.DbConnect_Local;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {
    private final DbConnect_Local db = new DbConnect_Local();


    // 댓글 생성 (Insert)
    public void createComment(CommentDto comment) {
        String sql = "INSERT INTO comments (comment_id, user_id, event_id, comment_date, content) VALUES (null, ?, ?, now(), ?)";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, comment.getUser_id());
            statement.setString(2, comment.getEvent_id());
            statement.setString(3, comment.getContent());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 댓글 조회 (Select) - 특정 이벤트에 대한 모든 댓글을 가져오기
    public List<CommentDto> getCommentsByEvent(String eventId) {
        List<CommentDto> comments = new ArrayList<>();
        String sql = "SELECT * FROM comments WHERE event_id = ?";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, eventId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CommentDto comment = new CommentDto();
                comment.setUser_id(resultSet.getString("user_id"));
                comment.setEvent_id(resultSet.getString("event_id"));
                comment.setComment_date(resultSet.getTimestamp("comment_date"));
                comment.setContent(resultSet.getString("content"));
                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }


    public void updateComment(CommentDto comment) {
        String sql = "UPDATE comments SET content = ? WHERE user_id = ? AND event_id = ? AND comment_date = ?";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, comment.getContent());
            statement.setString(2, comment.getUser_id());
            statement.setString(3, comment.getEvent_id());
            statement.setTimestamp(4, comment.getComment_date());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 댓글 삭제 (Delete)
    public void deleteComment(String comment_id) {
        String sql = "DELETE FROM comments WHERE comment_id = ?";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, comment_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 모든 댓글 가져오기
    public List<CommentDto> getAllComments() {
        List<CommentDto> comments = new ArrayList<>();
        String sql = "SELECT * FROM comments";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CommentDto comment = new CommentDto();
                comment.setUser_id(resultSet.getString("user_id"));
                comment.setEvent_id(resultSet.getString("event_id"));
                comment.setComment_date(resultSet.getTimestamp("comment_date"));
                comment.setContent(resultSet.getString("content"));
                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }
}
