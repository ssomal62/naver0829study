package board.controller;


import board.data.AnswerDao;
import board.data.BoardDao;
import board.data.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
//@AllArgsConstructor

public class BoardListController {

    @Autowired
    private BoardDao boardDao;

    @Autowired
    private AnswerDao answerDao;

    @GetMapping("/simple/list")
    public String list(Model model) {
        //전체 갯수 가져오기
        int totalCount = boardDao.getTotalCount();

        List<BoardDto> list = boardDao.getAllDatas();

        for(BoardDto dto : list){
            dto.setAcount(answerDao.getAnswers(dto.getNum()).size());
        }

        //model에 저장
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("list", list);

        return "list";
    }

}
