package data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemoContoller {

    @GetMapping("/memo/list")
    public String memoList(){
        return "memo/list";
    }
}
