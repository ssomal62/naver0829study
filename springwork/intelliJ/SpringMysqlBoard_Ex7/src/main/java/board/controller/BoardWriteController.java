package board.controller;

import board.data.BoardDao;
import board.data.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/simple") //공통된 경로를 지정, 여기 내부 코드들은 /simple 하위 경로로 들어가게 됨.
@AllArgsConstructor
public class BoardWriteController {

    private BoardDao boardDao;

    @GetMapping("/writeform")
    public String form(){
        return "writeform";
    }


    @PostMapping("/addprocess")
    public String add(HttpServletRequest request, @ModelAttribute BoardDto dto, @RequestParam MultipartFile upload){
        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");

        System.out.println(path);

        String photo = UUID.randomUUID().toString();

        //파일이 존재하지 않을 때 처리
        if(upload.getOriginalFilename().equals("")){
            dto.setPhoto("no");
        }else{
            dto.setPhoto(photo);
        }

        //업로드
        try {
            upload.transferTo(new File(path + "/" + photo));
        }catch (IllegalStateException e){
            e.getStackTrace();
        } catch (IOException e){
            e.getStackTrace();
        }

        //db insert
        boardDao.insertBoard(dto);

        return "redirect:./list";
    }

}
