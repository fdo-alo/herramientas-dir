package gob.imss.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    auth
	      .inMemoryAuthentication()
	        .withUser("prodecon").password("prodecon1984").roles("USER");
	  }
	
	@Override
	  public void configure(WebSecurity web) throws Exception {
	    web
	      .ignoring()
	         .antMatchers("/resources/**"); // #3
	  }
	
	

}
