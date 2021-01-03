package br.com.github.conf.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	@Autowired
	public GithubUserService githubUserService;
	
	@Autowired
	public TokenService tokenService;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.POST, "/auth").permitAll()
		
		 // swagger
		.antMatchers(HttpMethod.GET, "/").permitAll()
		.antMatchers("/swagger-ui.html/**").permitAll()
		
		.anyRequest().authenticated()
		.and().csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, githubUserService), UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(githubUserService)
			.passwordEncoder(new PasswordEncoder() {

				@Override
				public String encode(CharSequence rawPassword) {
					return String.valueOf(rawPassword);
				}

				@Override
				public boolean matches(CharSequence rawPassword, String encodedPassword) {
					return String.valueOf(rawPassword).equals(encodedPassword);
				}
				
			});
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(
				"/resources/**");
		
		// h2-console
        web.ignoring().antMatchers(
        		"/h2-console/**");
        
        // swagger
        web.ignoring().antMatchers(
        		"/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**");
    }
}
