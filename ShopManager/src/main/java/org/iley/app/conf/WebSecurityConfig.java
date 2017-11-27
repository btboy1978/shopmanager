package org.iley.app.conf;

import org.iley.app.security.UrlFilterSecurityInterceptor;
import org.iley.app.security.UrlUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static String PWD_KEYS = "btboy1978";

	@Autowired
	private UrlFilterSecurityInterceptor urlFilterSecurityInterceptor;

	@Bean
	UserDetailsService customUserService() { // 注册UserDetailsService 的bean
		return new UrlUserService();
	}

	@Bean
	StandardPasswordEncoder passwordEncoder() {
		return new StandardPasswordEncoder(PWD_KEYS);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserService()).passwordEncoder(new PasswordEncoder() {

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				// TODO Auto-generated method stub
				return encodedPassword.equals(passwordEncoder().encode(rawPassword));
			}

			@Override
			public String encode(CharSequence rawPassword) {
				// TODO Auto-generated method stub
				return passwordEncoder().encode((String) rawPassword);
			}

		});

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated() // 任何请求,登录后可以访问
				.and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll() // 登录页面用户任意访问
				.and().logout().permitAll(); // 注销行为任意访问
		http.addFilterBefore(urlFilterSecurityInterceptor, FilterSecurityInterceptor.class).csrf().disable();

	}
}
