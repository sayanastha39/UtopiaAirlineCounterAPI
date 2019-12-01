package com.ss.utopia.utopiaAirline.Security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import com.ss.utopia.utopiaAirline.DAO.UserDAO;
import com.ss.utopia.utopiaAirline.Service.CustomUserDetailsService;


//global for preauthorize annotation

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@EnableJpaRepositories (basePackageClasses = UserDAO.class)
@Configuration 

public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	//use this class for authorizing 
	@Autowired
	 private CustomUserDetailsService userDetailsService;

	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(getPasswordEncoder());
	}
	
	
	//if using custom login page .and().formLogin().loginPage("/loginpage").permitAll();
	//if not authenticated will go to login page
	//.antMatchers("**/users/**").authenticated() only authenticate but not authorized so to authorize use preauthorize
	@Override
    public void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable();
    	http
    		.authorizeRequests()
        	.antMatchers("**/users/**").authenticated()
        	.anyRequest().authenticated()
        	.and()
        	.httpBasic().and().formLogin().permitAll();
    }
	//.formLogin().permitAll();
	
	public PasswordEncoder getPasswordEncoder(){
		return new PasswordEncoder(){
			
			@Override
			public String encode(CharSequence charSequence) {
				return charSequence.toString();
			}
		
			@Override
			public boolean matches(CharSequence charSequence, String s) {
				return encode(charSequence).equals(s);
			}
		};
	}
}

