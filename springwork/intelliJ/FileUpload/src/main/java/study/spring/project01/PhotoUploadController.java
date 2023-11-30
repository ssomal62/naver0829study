package study.spring.project01;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class PhotoUploadController {

    @GetMapping("/uploadform1")
    public String upload1(){
        return "uploadform1";
    }

    @GetMapping("/uploadform2")
    public String upload2(){
        return "uploadform2";
    }

    @PostMapping("/upload1")
    public String photoUpload1(
            Model model, @RequestParam String title,
            @RequestParam MultipartFile upload,
            HttpServletRequest request) {


        String path = request.getSession().getServletContext().getRealPath("/resources/upload");

        String filename = upload.getOriginalFilename();

        int dotIdx =filename.lastIndexOf(".");

        String extName = filename.substring(dotIdx);

        String filename2 = UUID.randomUUID().toString() + extName;


        try {
            upload.transferTo(new File(path + "/"+ filename2));
            model.addAttribute("path",path);
            model.addAttribute("photo",filename2);
            model.addAttribute("title",title);
        } catch (IllegalStateException e) {
            e.getMessage();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "uploadresult1";
    }


    @PostMapping("/upload2")
    public String photoUpload2(Model model, @RequestParam String title, @RequestParam ArrayList<MultipartFile> upload, HttpServletRequest request){

        model.addAttribute("title",title);

        String path = request.getSession().getServletContext().getRealPath("/resources/upload");

        List<String> files = new ArrayList<>();

        for(MultipartFile multi : upload){
            String f = multi.getOriginalFilename();
            int extIdx = f.lastIndexOf(".");
            String ext = f.substring(extIdx);

            String filename = UUID.randomUUID().toString() + ext;

            files.add(filename);

            try {
                multi.transferTo(new File(path + "/" + filename));

            } catch(IllegalStateException e){
               e.getMessage();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        model.addAttribute("files",files);

        return "uploadresult2";
    }
}
