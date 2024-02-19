package com.vasy.security.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean 
	public SecurityFilterChain secuityFilterChain(HttpSecurity http) throws Exception{
		http 	
				.authorizeHttpRequests(
						requests -> requests
							.requestMatchers("/admin/**").hasRole("ADMIN")
							.requestMatchers("/user/**").hasRole("USER")
							.anyRequest().authenticated())
				.formLogin(
						formLogin -> formLogin
							.successHandler(new CustomSuccessHandler()))
				
				.logout(logout->logout.permitAll());
				
		return http.build();		
	}
	
	@Bean
	public InMemoryUserDetailsManager userManger(
			@Value("${security.users.user1.name}") String userName,
			@Value("${security.users.user1.password}") String userPassword,
			@Value("${security.users.user1.roles}") String userRole,
			@Value("${security.users.admin1.name}") String adminName,
			@Value("${security.users.admin1.password}") String adminPassword,
			@Value("${security.users.admin1.roles}") String adminRole
			) {
		
		UserDetails user = User.withUsername(userName)
				.password(passwordEncoder().encode(userPassword))
				.roles(userRole)
				.build();
		UserDetails admin = User.withUsername(adminName)
				.password(passwordEncoder().encode(adminPassword))
				.roles(adminRole.split(","))
				.build();
		System.out.println(admin);
		System.out.println(user);
		return new InMemoryUserDetailsManager(user,admin);
	}
}
