package br.com.github.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.github.model.GithubUser;
import br.com.github.model.RepositorySummary;
import br.com.github.model.dto.RepositorySummaryDto;

@Service
public class GitHubService {

	@Autowired
	private RestTemplate client;
	
	@Value("${url.github}")
	private String url;
	
	public List<RepositorySummary> list(GithubUser equipamentoForm) {
		ResponseEntity<RepositorySummaryDto[]> responseEntity = client.exchange(url.replace("{username}", equipamentoForm.getUsername()), HttpMethod.GET, null, RepositorySummaryDto[].class);
		
		List<RepositorySummary> list = new ArrayList<>();
		for (RepositorySummaryDto dto : responseEntity.getBody()) {
			list.add(dto.buildRepositorySummary());
		}
		
		return list;
	}

}
