package data.controller;


import data.dto.ShopDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {


    @GetMapping("/")
    public String root() {
        return "start";
    }

    @GetMapping("/hello")
    public String hello(Model model) {

        ShopDto dto = ShopDto.builder()
                .name("체크남방")
                .color("orange")
                .ea(5)
                .price(23000)
                .build();

        model.addAttribute("dto", dto);

        return "hello";
    }

    @GetMapping("/list")
    public String list(Model model) {

        List<ShopDto> list = new ArrayList<>();

        list.add(new ShopDto("그레이 후드", "gray", 5, 54000));
        list.add(new ShopDto("블랙 슬랙스", "black", 4, 43000));
        list.add(new ShopDto("모노톤 리무버블 스티커", "black", 3, 32000));
        list.add(new ShopDto("2024 다이어리", "green", 2, 21000));
        list.add(new ShopDto("플랫 슈즈", "white", 1, 19000));

        model.addAttribute("list",list);

        return "list";
    }
}
