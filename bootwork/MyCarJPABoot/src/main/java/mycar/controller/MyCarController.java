package mycar.controller;

import lombok.RequiredArgsConstructor;
import mycar.data.MyCarDto;
import mycar.repository.MyCarCommentDao;
import mycar.repository.MyCarDao;
import naver.storage.NcpObjectStorageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyCarController {

    private final MyCarDao myCarDao;

    private final MyCarCommentDao myCarCommentDao;

    private final NcpObjectStorageService storageService;
    private String bucketName = "bitcamp701aiur";
    private String folderName = "bootmyshop";

    int pageSize;

    @GetMapping("/")
    public String list(Model model,@RequestParam(value = "more", defaultValue = "0") int more) {

        //more가 0이면 기본 3개만 출력
        //0이 아니면 기본사이즈에 more 값 추가해서 목록 가져오기
        if(more == 0) {
            pageSize = 3;
        } else {
            pageSize += more;
        }

        //페이징처리를 위한 클래스
        Pageable pageable = PageRequest.of(0, pageSize, Sort.by("num").ascending());


        Long totalCount = myCarDao.getTotalCount();
        //List<MyCarDto> result = myCarDao.getAllCars();

        //페이지에 필요한 만큼만 가져오기
        Page<MyCarDto> result = myCarDao.getAllCars(pageable);

        List<MyCarDto> list = result.getContent();
        for(MyCarDto dto:list){
            int acount = myCarCommentDao.getMyCarCommentList(dto.getNum()).size();
            dto.setCommentcount(acount);
        }

        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalCount", result.getTotalElements());
        model.addAttribute("totalPage", result.getTotalPages());
        model.addAttribute("list", result);

        return "mycar/mycar-list";
    }

//    @GetMapping("/")
//    public String list(Model model) {
//
//        Long totalCount = myCarDao.getTotalCount();
//        List<MyCarDto> list = myCarDao.getAllCars();
//
//        model.addAttribute("totalCount", totalCount);
//        model.addAttribute("list", list);
//
//        return "mycar/mycar-list";
//    }

    @GetMapping("/addcar")
    public String addform() {
        return "mycar/mycar-form";
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute MyCarDto dto, @RequestParam("upload")MultipartFile upload) {

        //이미지를 스토리지에 저장 후 저장된 파일명을 반환
        String carphoto = storageService.uploadFile(bucketName, folderName, upload);
        //dto에 사진 파일명 저장
        dto.setCarphoto(carphoto);
        //DB insert
        myCarDao.insert(dto);

        return "redirect:./";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("num") Long num, Model model) {

        MyCarDto myCarDto =  myCarDao.getData(num);

        model.addAttribute("dto", myCarDto);

        return "mycar/mycar-detail";  //mycar-detail.html 파일 반환
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("num") Long num) {

        String carphoto = myCarDao.getData(num).getCarphoto();

        myCarDao.delete(num);
        storageService.deleteFile(bucketName,folderName,carphoto);
        return "redirect:./";
    }

    @GetMapping("/carupdate")
    public String updateForm(@RequestParam("num") Long num, Model model) {

        MyCarDto dto = myCarDao.getData(num);

        model.addAttribute("dto", dto);

        return "mycar/mycar-updateform";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute MyCarDto dto, @RequestParam("upload")MultipartFile upload) {

        if(upload.getOriginalFilename().equals("")) {
            myCarDao.updateMyCarNoPhoto(dto);
        } else {

            String carphoto = myCarDao.getData(dto.getNum()).getCarphoto();
            storageService.deleteFile(bucketName, folderName, carphoto);

            String newcarphoto = storageService.uploadFile(bucketName, folderName, upload);
            dto.setCarphoto(newcarphoto);

            myCarDao.update(dto);
        }
        return "redirect:./detail?num="+ dto.getNum();
    }
}
