package study.spring.project01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class HomeController {


    @GetMapping("/")
    public String start(){
        return "start";
    }


    @GetMapping("/form1")
    public String form1(){
        return "form1";
    }

    @GetMapping("/form2")
    public String form2(){
        return "form2";
    }

    @GetMapping("/form3")
    public String form3(){
        return "form3";
    }

    @GetMapping("/form4")
    public String form4(){
        return "form4";
    }


    @GetMapping("/shop")
    public String form() {
        return "shopform";
    }

    @PostMapping("/addshop")
    public String add(
            @ModelAttribute("dto") MyshopDto dto,  //myshopDto가 너무 길기 때문에 "dto"로 지정해 줌.
            HttpServletRequest request)
    {

        //파일을 업로드할 경로
        String path = request.getSession().getServletContext().getRealPath("/resources/photo");

        //파일 타입

        MultipartFile file = dto.getPhoto();

        //파일명 저장
        dto.setFilename(file.getOriginalFilename());

        //파일 업로드
        try {
            file.transferTo(new File(path + "/" + file.getOriginalFilename()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "shopresult";
    }




}
