package board.data;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //bean 등록
public class AnswerDao {

    @Autowired
    private BoardDao boardDao;

    @Autowired //자동으로 세터 주입
    private SqlSession session;

    private String nameSpace = "board.data.AnswerDao.";
    
    public void insertAnswer(AnswerDto dto) {
        session.insert(nameSpace + "insertAnswer", dto);
    }

    public List<AnswerDto> getAnswers(int num) {
        return session.selectList(nameSpace + "selectAnswerByNum",num);
    }

    public void deleteAnswer(int num) {
        session.delete(nameSpace + "deleteAnswer",num);
    }
}
