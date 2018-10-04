package demo111;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value="/")
public class MyController {
	@GetMapping(value="/help")
	public String method1(){
		System.out.println("help ");
		return "/help1.html";
	}
	
	@GetMapping(value="admin/m1")
	@ResponseBody
	public String m1(){
			System.out.println("in m1");
			return "<h1>In m1 </h1>";
	}
	@GetMapping(value="admin/m2")
	@ResponseBody
	public String m2(){
			System.out.println("in m2");
			return "<h1>In m2 </h1>";
	}
	
	@RequestMapping(value="/my/login")
	public String mm(){
		System.out.println("mm invoked ... ");
		return "redirect:/#/";
	}
	
}
