package org.iley.app.conf;

import org.iley.app.security.UrlUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static String PWD_KEYS = "24729138";

	@Autowired
	private UrlUserService urlUserService;

	@Autowired
	SessionRegistry sessionRegistry;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/boopstrap/**").permitAll().antMatchers("/login").permitAll().antMatchers("/logout").permitAll()
				.antMatchers("/images/**").permitAll().antMatchers("/js/**").permitAll().antMatchers("/css/**")
				.permitAll().antMatchers("/fonts/**").permitAll().antMatchers("/favicon.ico").permitAll()
				.antMatchers("/").permitAll().anyRequest().authenticated().and().sessionManagement().maximumSessions(1)
				.sessionRegistry(sessionRegistry).and().and().logout().invalidateHttpSession(true)
				.clearAuthentication(true).and().httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(urlUserService).passwordEncoder(new PasswordEncoder() {

			@Override
			public String encode(CharSequence rawPassword) {
				return encoding().encode((String) rawPassword);
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return encodedPassword.equals(encoding().encode((String) rawPassword));
			}
		});
	}

	@Bean
	StandardPasswordEncoder encoding() {
		StandardPasswordEncoder encoder = new StandardPasswordEncoder(PWD_KEYS);
		return encoder;
	}

	@Bean
	public SessionRegistry getSessionRegistry() {
		SessionRegistry sessionRegistry = new SessionRegistryImpl();
		return sessionRegistry;
	}
}