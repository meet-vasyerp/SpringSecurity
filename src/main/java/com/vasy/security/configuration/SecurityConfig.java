package com.vasy.security.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
		.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(
						requests -> requests
							.requestMatchers("/admin/**").hasAuthority("ADMIN")
							.requestMatchers("/user/**").hasAnyAuthority("USER","ADMIN")
							.anyRequest().permitAll())
				
				.formLogin(
						formLogin->formLogin
						.successHandler(new CustomSuccessHandler()))
				
				
				.logout(logout->logout.permitAll());
				
		return http.build();		
	}
	
}
