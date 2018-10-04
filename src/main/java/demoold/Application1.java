package demoold;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication()
@RestController
public class Application1 {

	public static void main(String[] args) {
		SpringApplication.run(Application1.class, args);
	}
	

	 @RequestMapping("admin/user")
	  public Principal user(Principal principal) {
	    return principal;
	  }

	@RequestMapping("/admin/login")
	public String dashboard() {
		return "redirect:/#/";
	}

	@Component
	@EnableOAuth2Sso
	public static class LoginConfigurer extends WebSecurityConfigurerAdapter {

		@Override
		public void configure(HttpSecurity http) throws Exception {
			http.antMatcher("/admin/**").authorizeRequests()
			.anyRequest()	.authenticated().and()
					.logout().logoutUrl("/admin/logout").permitAll()
					.logoutSuccessUrl("/");
		}
	}
}
