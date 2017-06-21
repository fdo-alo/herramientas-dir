package gob.imss.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
	
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

	  http.authorizeRequests()
	  .antMatchers("/logout", "/login", "/admin/create").permitAll()
	  //.antMatchers("/admin/create").hasAuthority("ADMIN")	
		//.anyRequest().authenticated()		
		.antMatchers("/prodecon/agregar", "/prodecon/{numero}/modificar" ,"/prodecon/{numero}/subir",
				"/inai/agregar", "/inai/{numero}/modificar" ,"/inai/{numero}/subir").hasAnyAuthority("CAPTURE", "ADMIN")
		
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll()		
		  .usernameParameter("username").passwordParameter("password")
		.and()
		  .logout()
		  .invalidateHttpSession(true)
		  .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		  .logoutSuccessUrl("/login?logout")	
		 .and()
		 .exceptionHandling().accessDeniedPage("/403")
		.and()
		  .csrf();
	}
	
	@Bean(name="passwordEncoder")
	public PasswordEncoder passwordencoder()
	{
		return new BCryptPasswordEncoder();
	}

}
