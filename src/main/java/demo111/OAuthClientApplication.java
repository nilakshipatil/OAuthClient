package demo111;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.stereotype.Component;

@SpringBootApplication
public class OAuthClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuthClientApplication.class, args);
	}
	@Component
	@EnableOAuth2Sso
	public static  class LoginConfigurer extends WebSecurityConfigurerAdapter{
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			System.out.println("in configure");
			http.antMatcher("/admin/**").authorizeRequests().anyRequest().authenticated()
			.and().logout().logoutUrl("/my/logout").permitAll()
			.logoutSuccessUrl("/");
			
		}
	}
	
	
}
