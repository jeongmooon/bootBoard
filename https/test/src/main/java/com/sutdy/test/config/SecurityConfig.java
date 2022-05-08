package com.sutdy.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity						//������ ��ť��Ƽ ���� Ȱ��ȭ
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable() // csrf��ū ����
				.authorizeRequests() // URL �� ���� ����
				.antMatchers("/","/auth/**","/js/**","/css/**","/image/**").permitAll() // �����������
			.and()
				.formLogin() // ������ ���� ����� �������� �̵��Ϸ��ϸ� �α������� �̵�
				.loginPage("/auth/user/login") // �ش� �������� �̵�
				//.loginProcessingUrl("/auth/api/v1/user/login") // ��ť��Ƽ�� �ش� �ּҷ� ��û�ϴ� ���α��� ����ä�� �α���
				.defaultSuccessUrl("/");
				
	}
}
