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

	/*
	 * @Autowired public void configAuthentication(AuthenticationManagerBuilder
	 * auth) throws Exception {
	 * //auth.inMemoryAuthentication().withUser("prodecon").password(
	 * "prodecon1984").roles("USER"); auth.lo }
	 */

	// Override Default configuration in WebSecurityConfigurerAdapter for custom
	// login form and authorize requests
	// We specified multiple URL patterns that any user can access like
	// "/resources/", "/scripts/", "/css/" etc.
	// Any URL that starts with "/admin/" will be restricted to users who have
	// the role "ROLE_ADMIN".
	// Any URL that starts with "/db/" requires the user to have both
	// "ROLE_ADMIN" and "ROLE_DBA".
	// Any URL that has not already been matched on only requires that the user
	// be authenticated
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/resources/**", "/signup", "/about").permitAll()
		.antMatchers("/admin/**").hasRole("ADMIN").anyRequest()
				.authenticated().and().formLogin().permitAll()
				.and()
				.logout()
				.invalidateHttpSession(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout")
				.permitAll();
	}*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

	  http.authorizeRequests()
	  .antMatchers("/logout", "/login").permitAll()
	  .antMatchers("/admin/**").hasAuthority("ADMIN")	
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

	/*@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**"); // #3
	}*/

	// JDBC Authentication
	// Provides default queries
	// – SELECT username, password, enabled FROM users WHERE username = ?
	// – SELECT username, authority FROM authorities WHERE username = ?
	// We can customize the default queries by using following methods
	// usersByUsernameQuery()
	// authoritiesByUsernameQuery()
	// groupAuthoritiesByUsername()
	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication()				
				.usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")				
				.authoritiesByUsernameQuery("SELECT username, authority FROM users WHERE username = ?")
				.dataSource(dataSource);
	}*/
	
	
	
	
	@Bean(name="passwordEncoder")
	public PasswordEncoder passwordencoder()
	{
		return new BCryptPasswordEncoder();
	}

}
