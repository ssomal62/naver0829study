package study.day1109.mvc2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShopController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/shop/{path}")
	public String list(@PathVariable("path") String path, Model model) {
		System.out.println(path);
		
		String shopinfo="";
		if(path.equals("list1")) {
			shopinfo = "���� ��ǰ ���";
		} else if(path.equals("list2")) {
			shopinfo = "���� ��ǰ ���";
		} else {
			shopinfo = "�׼����� ��ǰ ���";
		}
		
		
		//��ǰ ��� ���
		List<ShopDto> list = new ArrayList<ShopDto>();
		
		if(path.equals("list1")) {
			list.add(new ShopDto("���ö���", "3.jpg", 45000));
			list.add(new ShopDto("������Ʈ��", "7.jpg", 178000));
			list.add(new ShopDto("����Ƽ��", "10.jpg", 68000));
			list.add(new ShopDto("����", "28.jpg", 190000));
		} else if(path.equals("list2")) {
			list.add(new ShopDto("�÷�����", "5.jpg", 98000));
			list.add(new ShopDto("�׸����¹�", "13.jpg", 133000));
			list.add(new ShopDto("���", "22.jpg", 150000));
			list.add(new ShopDto("Ÿ�̰�", "26.jpg", 270000));
		} {
			list.add(new ShopDto("��ĸ", "6.jpg", 68000));
			list.add(new ShopDto("������Ű��", "15.jpg", 28000));
			list.add(new ShopDto("��ũ��ġ", "2.jpg", 18000));
			list.add(new ShopDto("������", "29.jpg", 37000));
		}
		
		model.addAttribute("list",list);	
		model.addAttribute("shopinfo", shopinfo);
		model.addAttribute("count",list.size());
		
		return "list1";
	}
	
	
	@GetMapping("/market/morning/brunch")
	public String list2(Model model) {
		
		String message = "������ ��ü��ĳ���� �Ұ�";
		
		List<String> photoList1 = new  ArrayList<String>(Arrays.asList("002.png","003.png","004.png"));

		System.out.println(photoList1.get(0));
		model.addAttribute("message", message);
		model.addAttribute("today",new Date());
		model.addAttribute("photoList1", photoList1); 
		
		return "list2";
	}
	
	
	@GetMapping("/market/photo/detail")
	public ModelAndView list3(Model model) {
		
		ModelAndView mview = new ModelAndView();
		
		mview.setViewName("list3");
		
		List<String> photoList2 = new  ArrayList<String>(Arrays.asList("12.jpg","25.jpg","28.jpg"));
		
	
		model.addAttribute("name", "Aiur");
		model.addAttribute("addr", "������");
		model.addAttribute("photoList2", photoList2); 

		return mview;
	}
		
}