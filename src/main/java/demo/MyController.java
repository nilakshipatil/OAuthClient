package demo;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/")
@Controller
public class MyController {

	@GetMapping(value = "help")
	public String help() {
		return "/help1.html";
	}
	
	@GetMapping(value = "admin/m1")
	@ResponseBody
	public String m1() {
		return "<h1>m1 of admin invoked .... </h1><h2><a href='/app'>Back to index page</a></h2>";
	}

	@GetMapping(value = "admin/m2")
	@ResponseBody
	public String m2() {
		return "<h1>m2 of admin invoked .... </h1><h2><a href='/app'>Back to index page</a></h2>";
	}
	 @RequestMapping("admin/user")
	 @ResponseBody
	  public Principal user(Principal principal) {
	    return principal;
	  }

	@RequestMapping("/admin/login")
	public String dashboard() {
		return "redirect:/#/";
	}

}
