package data.controller;


import naver.storage.NcpObjectStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PhotoStorageController {

    @Autowired
    private NcpObjectStorageService storageService;

    //private String bucketName = "bitcamp701aiur";
    private String bucketName = "bitcamp-lmh";
    private String bucketFolder = "photo";

    @GetMapping("/storage/form")
    public String form(){
        return "storage/testform";
    }

    @PostMapping("/storage/upload")
    public String upload(Model model, @RequestParam MultipartFile upload){

        String fileName = storageService.uploadFile(bucketName,bucketFolder,upload);

        String photo = "https://kr.object.ncloudstorage.com/bitcamp701aiur/photo/" + fileName;
        String photo150 = "https://9oeebhfl1647.edge.naverncp.com/d9GVC7yhi3/photo/" + fileName + "?type=f&w=150&h=150&faceopt=true&ttype=jpg";
        String photo80 = "https://9oeebhfl1647.edge.naverncp.com/d9GVC7yhi3/photo/" + fileName + "?type=f&w=80&h=80&faceopt=true&ttype=jpg";

        model.addAttribute("photo", photo);
        model.addAttribute("photo80", photo80);
        model.addAttribute("photo150", photo150);

        return "storage/testresult";
    }

    @GetMapping("/storage/common")
    public String common(){
        return "storage/commondb";
    }
}
