package study.spring.day1114;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import study.spring.data.dto.MemberDTO;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class PhotoUploadController {


    @PostMapping("/member/upload1")
    public String upload1(@ModelAttribute("mdto") MemberDTO dto, @RequestParam MultipartFile upload, HttpServletRequest request) {

        //업로드 할 프로젝트 내의 경로 구하기
        String path = request.getSession().getServletContext().getRealPath("WEB-INF/photo/");
        System.out.println(path);

        //파일명을 dto에 저장 - (파일명 : 랜덤)
        String photo = UUID.randomUUID().toString();
        dto.setPhoto(photo);

        //업로드
        try {
            upload.transferTo(new File(path + "/" + photo));
        } catch(IOException e) {
            e.printStackTrace();
        } catch(IllegalStateException e) {
            e.printStackTrace();
        }

        return "member/result1";
    }


    @PostMapping("/member/upload2")
    public String upload2(@ModelAttribute("mdto") MemberDTO dto, HttpServletRequest request, @RequestParam ArrayList<MultipartFile> upload) {

        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/photo");
        String photo = "";

        for(MultipartFile m : upload){
            String fname = UUID.randomUUID().toString();
            photo += fname + ",";
            //업로드
            try {
                m.transferTo(new File(path + "/" + fname));
               // photo += fname + ",";
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        //마지막 컴마 제거
        photo = photo.substring(0, photo.length() - 1);

        //dto에 넣기
        dto.setPhoto(photo);

        return "member/result2";
    }

    @PostMapping("/member/upload3")
    public String upload3(@ModelAttribute("mdto") MemberDTO dto,
                          HttpServletRequest request,
                          @RequestParam MultipartFile upload1,
                          @RequestParam MultipartFile upload2) {


        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/photo");

        String photo1 = UUID.randomUUID().toString();
        String photo2 = UUID.randomUUID().toString();

        dto.setPhoto(photo1);
        dto.setPhoto2(photo2);

        try {
            upload1.transferTo(new File(path + "/" + photo1));
            upload2.transferTo(new File(path + "/" + photo2));

        } catch (IllegalStateException e) {
            e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "member/result3";
    }


}
