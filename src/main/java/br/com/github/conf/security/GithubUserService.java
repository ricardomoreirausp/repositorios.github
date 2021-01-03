package br.com.github.conf.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.github.model.GithubUser;

@Component
public class GithubUserService implements UserDetailsService {
	
	@Override
	public GithubUser loadUserByUsername(String nome) throws UsernameNotFoundException {
		return new GithubUser("1234", nome);
	}
}
