package mini.dao;

import mini.dto.BoardFileDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardFileDao {

    @Autowired
    private SqlSession session;

    private String nameSpace = "mini.dao.BoardFileDao.";

    public void insertPhoto(BoardFileDto dto){
       session.insert(nameSpace+"insertPhotoOfFile", dto);
    }

    public List<String> getPhotoByNum(int num){
        return session.selectList(nameSpace+"selectAllPhotoByNum", num);
    }

    public List<BoardFileDto> getFileDateByNum(int num){
        return session.selectList(nameSpace+"selectAllDataByNum", num);
    }

    public void deletePhoto(int idx){
        session.delete(nameSpace + "deletePhotoByIdx",idx);
    }
}
