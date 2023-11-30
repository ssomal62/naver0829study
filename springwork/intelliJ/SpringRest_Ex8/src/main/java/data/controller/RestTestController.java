package data.controller;


import data.dto.MemoDto2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RestTestController {

    @GetMapping("/test/list1")
    public List<MemoDto2> list1(){

        List<MemoDto2> list = new ArrayList<>();
        list.add(new MemoDto2(1, "김나나", "1.jpg", "안녕하세요", 5, "2023-10-10"));
        list.add(new MemoDto2(1, "캔디바", "2.jpg", "히히", 2, "2023-10-13"));
        list.add(new MemoDto2(1, "비비빅", "3.jpg", "힝구", 7, "2023-11-22"));

        return list;
    }

    @GetMapping("/test/add")
    public MemoDto2 add(String nickname, String photo, String memo){

        MemoDto2 dto = new MemoDto2(1, nickname, photo, memo, 10, "2023-11-14");

        return dto;
    }

    @PostMapping("/test/list2")
    public Map<String, String> text(){
        Map<String, String> map = new HashMap<>();
        map.put("name","이것이");
        map.put("age","35");

        return map;
    }
}


//@Controller
//public class RestTestController {
//
//    @GetMapping("/test/list1")
//    @ResponseBody  public List<MemoDto2> list1(){
//
//        List<MemoDto2> list = new ArrayList<>();
//        list.add(new MemoDto2(1, "김나나", "1.jpg", "안녕하세요", 5, "2023-10-10"));
//        list.add(new MemoDto2(1, "캔디바", "2.jpg", "히히", 2, "2023-10-13"));
//        list.add(new MemoDto2(1, "비비빅", "3.jpg", "힝구", 7, "2023-11-22"));
//
//        return list;
//    }
//
//    @GetMapping("/test/add")
//    @ResponseBody public MemoDto2 add(String nickname, String photo, String memo){
//
//        MemoDto2 dto = new MemoDto2(1, nickname, photo, memo, 10, "2023-11-14");
//
//        return dto;
//    }
//}
