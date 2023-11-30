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
	
	//@RequestMapping("/") // �ʱ� �������� ��� ������ ������̼�
	@GetMapping("/")  //������ ���� 5���� ������ ������̼�
	public String home(Model model)
	{
		model.addAttribute("message","Have a Good Time!!!!!"); //request �� ����
		model.addAttribute("today", new Date());
		return "result1";
	}
	
	
//	@GetMapping("/shop/list.do")   //  /shop/list.do �� ȣ�Ⱑ��
//	public String go(Model model)
//	{
//		model.addAttribute("path","/shop/list");
//		return "list";
//	}
	
	@GetMapping("/shop/list")   //  /shop/list.* ��� ȣ�Ⱑ��
	public String go(Model model)
	{
		model.addAttribute("path","/shop/list");
		return "list";
	}
	
	
//	@GetMapping("/shop/{path1}/")   // GetMapping ��ο� @PathVariable ���� ������ ���� ����
//	public String go(Model model, @PathVariable("path1") String p1)
//	{
//		System.out.println(p1);
//		model.addAttribute("path","/shop/" + p1);
//		return "list";
//	}
	
	@GetMapping("/board/update")
	public ModelAndView hello() {
		ModelAndView mview = new ModelAndView();
		mview.addObject("message","�����ּҷ� ������ ��Ÿ������");
		mview.setViewName("result2");
		return mview;
	}
	
	
	@GetMapping({"/board/update","/stu/form/test1"})
	public ModelAndView hello(HttpServletRequest request) {
		
		String root = request.getContextPath();
		System.out.println(root);
		
		ModelAndView mview = new ModelAndView();
		mview.addObject("message","�����ּҷ� ������ ��Ÿ������");
		
		mview.addObject("root",root);
		
		mview.setViewName("result2");
		return mview;
	}
	
}
