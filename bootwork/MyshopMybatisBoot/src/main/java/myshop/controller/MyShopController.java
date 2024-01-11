package myshop.controller;


import lombok.RequiredArgsConstructor;
import myshop.data.MyShopDto;
import myshop.service.MyShopService;
import naver.storage.NcpObjectStorageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor  //final 또는 NonNull 선언된 항목만 주입됨.
public class MyShopController {

    private final MyShopService shopService;

    private final NcpObjectStorageService storageService;

    private String bucketName = "bitcamp701aiur";

    private String foldeNname = "bootmyshop";

    /**
     * 총 갯수 구하기
     */
    @GetMapping("/")
    public String list(Model model) {

        int totalCount = shopService.getTotalCount();

        //전체 목록 가져오기
        List<MyShopDto> list = shopService.getSangpumList();

        model.addAttribute("list", list);

        model.addAttribute("totalCount", totalCount);
        return "myshop/shop-list";
    }

    @GetMapping("/form")
    public String form() {
        return "myshop/shop-form";
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute MyShopDto dto,
                         @RequestParam("upload") MultipartFile upload) {

        //네이버 스토리지에 업로드 후 저장된 파일명을 리턴받아 dto의 photo에 저장
        String photo = storageService.uploadFile(bucketName, foldeNname, upload);

        dto.setPhoto(photo);
        shopService.insertShop(dto);

        return "redirect:./";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("num") int num, Model model) {

        MyShopDto dto = shopService.getData(num);
        model.addAttribute("dto", dto);
        return "myshop/shop-detail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("num") int num) {
        storageService.deleteFile(bucketName, foldeNname, shopService.getData(num).getPhoto());
        shopService.delete(num);
        return "redirect:./";
    }
}
