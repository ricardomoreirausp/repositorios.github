package br.com.github.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.github.model.GithubUser;
import br.com.github.model.RepositorySummary;
import br.com.github.service.GitHubService;

@RestController
@RequestMapping("list")
public class GitHubController {

	@Autowired
	private GitHubService service;
	
	@PostMapping
	public List<RepositorySummary> post(
			@RequestHeader("Authorization") String authorization, // ver se eh esse
			@RequestBody @Valid GithubUser equipamentoForm
			) {
		
		return service.list(equipamentoForm);
	}
}
