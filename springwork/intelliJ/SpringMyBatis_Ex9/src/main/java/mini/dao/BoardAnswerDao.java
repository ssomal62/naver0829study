package mini.dao;

import mini.dto.BoardAnswerDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardAnswerDao {

    @Autowired
    SqlSession session;

    private String nameSpace = "mini.dao.BoardAnswerDao.";


    public List<BoardAnswerDto> selectAnswer(int num) {
        return session.selectList(nameSpace + "selectAnswerOfNum", num);
    }

    public void insertAnswer(BoardAnswerDto dto) {
        session.insert(nameSpace + "insertBoardAnswer", dto);
    }

    public void deleteAnswer(int ansidx) {
        session.delete(nameSpace + "deleteAnswer", ansidx);
    }

}
