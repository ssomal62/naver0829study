package board.controller;

import board.data.AnswerDao;
import board.data.AnswerDto;
import board.data.BoardDao;
import board.data.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Controller
@AllArgsConstructor
public class BoardContentController {

    private BoardDao boardDao;
    private AnswerDao answerDao;

    @GetMapping("/simple/content")
    public String content(Model model, @RequestParam int num) {

        //조회수 증가 시키기
        boardDao.updateReadCount(num);

        //dto 얻기
        BoardDto dto = boardDao.getData(num);

        //해당 글에 대한 댓글 가져오기
        List<AnswerDto> alist = answerDao.getAnswers(num);

        //model 저장
        model.addAttribute("dto",dto);

        model.addAttribute("alist",alist);
        model.addAttribute("acount",alist.size());

        return "content";
    }

    @GetMapping("/simple/delete")
    public String delete(@RequestParam int num){
        boardDao.deleteData(num);
        return "redirect:./list";
    }

    @GetMapping("/simple/updateform")
    public String update(@RequestParam int num, Model model){

        //num에 해당하는 dto를 얻어서
        BoardDto dto = boardDao.getData(num);

        //dto를 모델에 저장
        model.addAttribute("dto",dto);

        return "updateform";
    }

    @PostMapping("/simple/updateprocess")
    public String update(@ModelAttribute BoardDto dto,
                         @RequestParam MultipartFile upload,
                         HttpServletRequest request){

        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
        String photo = "";

        if (upload.getOriginalFilename().equals("")){
            dto.setPhoto(null); //BoardMapper의 if문에서 photo!=null 이라는 조건을 맞추기 위함
        }else{
            photo = UUID.randomUUID().toString();
            dto.setPhoto(photo);
        }

        //업로드

        try {
            upload.transferTo(new File(path + "/" + photo));
        } catch (IllegalStateException e) {
            e.getStackTrace();
        }catch (IOException e) {
            e.getStackTrace();
        }

        //db수정
        boardDao.updateData(dto);

        return "redirect:./content?num=" + dto.getNum();
    }

    //댓글 추가
    @PostMapping("/simple/addanswer")
    public String addAnswer(@ModelAttribute AnswerDto dto){

        //댓글 추가
        answerDao.insertAnswer(dto);

        return "redirect:./content?num=" + dto.getNum();
    }

    @GetMapping("/simple/answerdel")
    public String deleteAnswer(@RequestParam int num, @RequestParam int idx){

        answerDao.deleteAnswer(idx);
        return "redirect:./content?num=" + num;
    }



}
