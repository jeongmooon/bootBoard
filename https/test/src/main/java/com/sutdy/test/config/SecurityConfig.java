package com.sutdy.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity						//스프링 시큐리티 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable() // csrf토큰 해제
				.authorizeRequests() // URL 별 관리 설정
				.antMatchers("/","/auth/**","/js/**","/css/**","/image/**").permitAll() // 관리대상지정
			.and()
				.formLogin() // 권한이 없는 사람이 페이지를 이동하려하면 로그인으로 이동
				.loginPage("/auth/user/login") // 해당 페이지로 이동
				//.loginProcessingUrl("/auth/api/v1/user/login") // 시큐리티가 해당 주소로 요청하느 ㄴ로그인 낚아채고 로그인
				.defaultSuccessUrl("/");
				
	}
}
