package study.day1109.mvc1;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	//@RequestMapping("/") // 초기 부전부터 모두 가능한 어노테이션
	@GetMapping("/")  //스프링 버전 5부터 가능한 어노테이션
	public String home(Model model)
	{
		model.addAttribute("message","Have a Good Time!!!!!"); //request 에 저장
		model.addAttribute("today", new Date());
		return "result1";
	}
	
	
//	@GetMapping("/shop/list.do")   //  /shop/list.do 만 호출가능
//	public String go(Model model)
//	{
//		model.addAttribute("path","/shop/list");
//		return "list";
//	}
	
	@GetMapping("/shop/list")   //  /shop/list.* 모두 호출가능
	public String go(Model model)
	{
		model.addAttribute("path","/shop/list");
		return "list";
	}
	
	
//	@GetMapping("/shop/{path1}/")   // GetMapping 경로와 @PathVariable 값이 같으면 생략 가능
//	public String go(Model model, @PathVariable("path1") String p1)
//	{
//		System.out.println(p1);
//		model.addAttribute("path","/shop/" + p1);
//		return "list";
//	}
	
	@GetMapping("/board/update")
	public ModelAndView hello() {
		ModelAndView mview = new ModelAndView();
		mview.addObject("message","매핑주소로 사진을 나타내보자");
		mview.setViewName("result2");
		return mview;
	}
	
	
	@GetMapping({"/board/update","/stu/form/test1"})
	public ModelAndView hello(HttpServletRequest request) {
		
		String root = request.getContextPath();
		System.out.println(root);
		
		ModelAndView mview = new ModelAndView();
		mview.addObject("message","매핑주소로 사진을 나타내보자");
		
		mview.addObject("root",root);
		
		mview.setViewName("result2");
		return mview;
	}
	
}
