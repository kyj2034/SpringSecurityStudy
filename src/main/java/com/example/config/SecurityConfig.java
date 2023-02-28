package com.example.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import io.micrometer.common.lang.NonNull;
import lombok.AllArgsConstructor;

@EnableWebSecurity
@Configuration //스프링에게 이 클래스는 환경구성 설정파일임을 알려준다.
@AllArgsConstructor
public class SecurityConfig {
	private final Logger log = LoggerFactory.getLogger(getClass());

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.csrf().disable().authorizeHttpRequests((authz) -> authz.anyRequest().authenticated()).httpBasic();

        return http.build();
    }
	
    
    //bean 으로 생성
	@Bean
	public InMemoryUserDetailsManager userDetailsServices() {
		
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("kangyejin")
				.password("kangyejin")
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(user);
	
	}
}
