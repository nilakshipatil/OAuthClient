package demoold;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/my")
public class MyController {
	@GetMapping(value="/m1")
    public String m1() {
		return "<h1>In  /  of my - MyController   ...</h1>";
    }
	@GetMapping(value="/m2")
    public String m2() {
		return "<h1>In m2 of MyController  ...</h1>";
    }
	
	
}
