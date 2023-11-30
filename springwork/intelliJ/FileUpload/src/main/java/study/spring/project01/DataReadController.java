package study.spring.project01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class DataReadController {


    @GetMapping("/process1")
    public String form1(HttpServletRequest request, Model model){

        String name = request.getParameter("name");
        String addr = request.getParameter("addr");
        int age = Integer.parseInt(request.getParameter("age"));

        model.addAttribute("name",name);
        model.addAttribute("addr",addr);
        model.addAttribute("age", age + "세는" + (age > 20 ?"성인":"미성년자") + "입니다.");
        return "result1";
    }


    @PostMapping("/process2")
    public String form2(@RequestParam String message, @RequestParam String product, @RequestParam(defaultValue = "aiur", required = false)  String name, Model model) {

        model.addAttribute("message", message);
        model.addAttribute("product", product);
        model.addAttribute("name", name);

        return "result2";
    }

    @PostMapping("/process3")
    public String form3(@ModelAttribute ShopDto dto, Model model) {
        //model.addAttribute("today",today);

        return "result3";
    }

    @PostMapping("/process4")
    public String form4(Model model,@RequestParam Map<String, String> map) {

        model.addAttribute("sang",map.get("sang"));
        model.addAttribute("su",map.get("su"));
        model.addAttribute("dan",map.get("dan"));
        model.addAttribute("color",map.get("color"));
        model.addAttribute("photo",map.get("photo"));
        model.addAttribute("today",map.get("today"));
        return "result4";
    }


}
