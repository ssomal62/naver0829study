package mini.dao;

import mini.dto.BoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BoardDao {

    @Autowired
    private SqlSession session;

    private String nameSpace = "mini.dao.BoardDao.";

    public int getTotalCount(){
        return session.selectOne(nameSpace +"totalCountOfBoard");
    }

    public List<BoardDto> getList(Map<String, Integer> map){
        return session.selectList(nameSpace +"selectPagingOfBoard", map);
    }

    public int getMaxNum(){
        return session.selectOne(nameSpace + "selectMaxNumOfBoard");
    }

    public void updateRestep(Map<String, Integer> map){
        session.update(nameSpace + "updateRestepOfBoard", map);
    }

    public void insertBoard(BoardDto dto){
        session.insert(nameSpace + "insertBoard", dto);
    }

    public void updateReadCount(int num){
        session.update(nameSpace + "updateReadCountBoard", num);
    }

    public BoardDto getData(int num){
        return session.selectOne(nameSpace + "selectDataByNum", num);
    }

    public void updateBoard(BoardDto dto){
        session.update(nameSpace + "updateBoard", dto);
    }

    public void deleteBoard(int num){
        session.delete(nameSpace + "deleteBoard", num);
    }

}

