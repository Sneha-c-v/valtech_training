package com.valtech.training.newspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/user","/orders/**")
		.hasAnyRole("USER","ADMIN")
		.antMatchers("/admin")
		.hasRole("ADMIN")
		.antMatchers("/anon","/login","/logout","/register","/changePassword","/employee")
		.anonymous()
		.anyRequest()
		.authenticated();
		
		//http.httpBasic();
		http.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/hello?name=valtech")
		.failureForwardUrl("/login?error=true");
		return http.build();
		
	}
	
//	@Bean 
//	public UserDetailsManager userDetailsManager() {
//		UserDetails  user=User.builder().username("root").password("root").roles("USER").build();
//		UserDetails  admin=User.builder().username("admin").password("admin123").roles("ADMIN","USER").build();
//		return new InMemoryUserDetailsManager(user,admin);
//		}
	
	  @Bean
	  public PasswordEncoder passwordEncoder() {
		//  return NoOpPasswordEncoder.getInstance();
		  return  new BCryptPasswordEncoder();
	  }
	
}

