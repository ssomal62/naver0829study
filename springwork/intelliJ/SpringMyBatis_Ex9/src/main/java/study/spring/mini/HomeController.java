package study.spring.mini;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.swing.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "layout/home";
    }

    @GetMapping("/map")
    public String map(){
        return "layout/map";
    }

}
