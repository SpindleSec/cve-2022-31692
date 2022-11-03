package com.spindlesec.poc.springauthbypass;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((authz) -> authz
				.antMatchers("/").permitAll()
				.antMatchers("/forward").permitAll()
				.antMatchers("/admin").hasAuthority("ROLE_ADMIN")
				.shouldFilterAllDispatcherTypes(true)
			)
			.httpBasic().and()
			.userDetailsService(userDetailsService());
        return http.build();
    }
	
 	private UserDetailsService userDetailsService() {
 		@SuppressWarnings("deprecation")
		UserDetails user = User.withDefaultPasswordEncoder()
 			.username("user")
 			.password("pass")
 			.roles("USER")
 			.build();
 		return new InMemoryUserDetailsManager(user);
 	}


}
