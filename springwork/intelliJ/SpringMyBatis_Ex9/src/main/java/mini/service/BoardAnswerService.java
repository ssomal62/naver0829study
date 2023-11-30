package mini.service;

import lombok.AllArgsConstructor;
import mini.dao.BoardAnswerDao;
import mini.dto.BoardAnswerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardAnswerService {

    private BoardAnswerDao boardAnswerDao;

    public List<BoardAnswerDto> getAnswerBoard(int num) {
        return boardAnswerDao.selectAnswer(num);
    }

    public void insertAnswer(BoardAnswerDto dto) {
        boardAnswerDao.insertAnswer(dto);
    }

    public void deleteAnswer(int ansidx) {
        boardAnswerDao.deleteAnswer(ansidx);
    }

}
