package gob.imss.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan("gob.imss")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
	    auth
	      .inMemoryAuthentication()
	        .withUser("user").password("password").roles("USER");
	  }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		  .authorizeRequests()
		   .anyRequest().authenticated()
		   .and()
		  .formLogin()
		   .loginPage("/login") //specifies the location of the log in page
		   .permitAll(); //allows granting access to all users for all URLs
	}

}
