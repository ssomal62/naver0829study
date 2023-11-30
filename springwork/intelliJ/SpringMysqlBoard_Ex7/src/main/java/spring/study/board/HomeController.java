package spring.study.board;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)

    //"/" 루트가 바로 호출되는데 호출되자마자 아래 경로로 이동해라,
    public String home(){
        return "redirect:./simple/list";
    }

}
