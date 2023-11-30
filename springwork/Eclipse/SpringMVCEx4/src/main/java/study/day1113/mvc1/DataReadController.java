package study.day1113.mvc1;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpServerErrorException;

@Controller
public class DataReadController {
	

	@GetMapping("/process1")
	//@RequestParam("폼태그의 name") String 변수명 : 폼태그의 name과 변수명이 같을 경우 name은 생략가능
	//@RequestParam 자체가 사실 생략이 가능하다. (하지만 다른 어노테이션으로 잘못 인식하는 경우를 방지하기 위해 생략하는 것을 지양
	
		public String process1(Model model, 
				@RequestParam("name") String irum,
				@RequestParam String addr, 
				@RequestParam int age) {
		model.addAttribute("name",irum);
		model.addAttribute("addr",addr);
		model.addAttribute("age",age + "세는 " + (age>=20?"성인" : "미성년자")+"입니다");
		return "result1";
		
	}
	
//	@GetMapping("/process1")
//	public String process1(HttpServletRequest request, Model model) {
//		
//		String name = request.getParameter("name");
//		String addr = request.getParameter("addr");
//		int age = Integer.parseInt(request.getParameter("age"));
//		
//		model.addAttribute("name",name);
//		model.addAttribute("addr",addr);
//		model.addAttribute("age",age+"세는 " + (age>20? "성인":"미성년자") + "입니다.");
//		return "result1";
//	}
	
	@PostMapping("/process2")
	public String process2(Model model, 
			@RequestParam String message, 
			@RequestParam String product,
			@RequestParam(defaultValue = "aiur", required =false) String name) {
		//null 값이 들어오더라도 에러가 안나게 할 경우 (에러코드 400) required = false
		//null 일 경우 기본값을 "aiur"로 ..
		
		
		//System.out.println(name);
		model.addAttribute("message",message);
		model.addAttribute("product",product);
		model.addAttribute("name",name);  //"name" form에 없는 태그
		
		return "result2";
	}
	
	
	
	//@ModelArrtibute : dto와 같은 이름의 폼태그를 읽어서 모델에 저장한다. @ModelAttribute 생략 가능하다 가능하면 생략 안하기.
	@PostMapping("/process3")
	public String process3(@ModelAttribute ShopDto dto, @RequestParam String today, Model model) { //model 에 shopDto라는 이름으로 저장됨.
		model.addAttribute("today",today);
		
		return "result3";
	}
	
	
	@PostMapping("/process4")
	public String process4(Model model, @RequestParam Map<String, String> map) {  //폼태그의 name이 key로, 입력값이 value로 저장
		model.addAttribute("sang",map.get("sang"));
		model.addAttribute("su",map.get("su"));
		model.addAttribute("dan",map.get("dan"));
		model.addAttribute("color",map.get("color"));
		model.addAttribute("photo",map.get("photo"));
		model.addAttribute("today",map.get("today"));
		
		return "result4";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
