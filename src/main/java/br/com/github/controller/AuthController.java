package br.com.github.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.github.conf.security.TokenService;
import br.com.github.model.GithubUser;
import br.com.github.model.Token;

@RestController
@RequestMapping("auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public Token login(@RequestBody @Valid GithubUser githubUser) {
		try {
			Authentication authentication = authManager.authenticate(githubUser.authenticate());
			String token = tokenService.gerarToken(authentication);
			Token tokenDto = new Token(token, "Bearer");
			
			return tokenDto;
		} catch (AuthenticationException e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "unauthorized user");
		}
	}
}
