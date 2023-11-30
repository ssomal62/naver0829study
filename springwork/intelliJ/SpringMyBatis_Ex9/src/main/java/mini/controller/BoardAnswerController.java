package mini.controller;

import mini.dto.BoardAnswerDto;
import mini.service.BoardAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class BoardAnswerController {

    @Autowired
    private BoardAnswerService answerService;

    private String fileName; //댓글에서 업로드되는 사진 파일명

    @PostMapping("/answer/upload")
    public Map<String, String> photoUpload(HttpServletRequest request, @RequestParam("upload") MultipartFile upload){

        String path = request.getSession().getServletContext().getRealPath("/resources/upload");

        fileName = UUID.randomUUID().toString();

        try {
            upload.transferTo(new File(path + "/" + fileName));
        }catch (IllegalStateException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map<String, String> map = new HashMap<>();

        map.put("photoname", fileName);

        return map;
    }

    @PostMapping("/answer/insert")
    public void insertAnswer(@RequestParam int num, @RequestParam String msg, HttpSession session){
        //로그인한 정보

         String myname = (String)session.getAttribute("myname");
         String myid = (String)session.getAttribute("myid");

        BoardAnswerDto dto = new BoardAnswerDto();

        dto.setNum(num);
        dto.setAnsname(myname);
        dto.setAnsid(myid);
        dto.setAnsmsg(myname);
        dto.setAnsphoto(fileName);
        dto.setAnsmsg(msg);

        //db insert
        answerService.insertAnswer(dto);

        fileName = null;
    }

    @GetMapping("/answer/list")
    public List<BoardAnswerDto> answerList(@RequestParam int num){
        return answerService.getAnswerBoard(num);
    }

    @PostMapping("/answer/delete")
    public void deleteAnswer(@RequestParam int ansidx){
        answerService.deleteAnswer(ansidx);
    }
}
