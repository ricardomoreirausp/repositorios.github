package br.com.github.model.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.github.model.RepositorySummary;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RepositorySummaryDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("private")
	private boolean _private;

	private String created_at;
	private String description;
	private String full_name;
	private String language;
	private String name;
	private OwnerDto owner;
	private String updated_at;

	public RepositorySummary buildRepositorySummary() {
		RepositorySummary repositorySummary = new RepositorySummary();
		repositorySummary.set_private(_private);
		repositorySummary.setCreated_at(created_at);
		repositorySummary.setDescription(description);
		repositorySummary.setFull_name(full_name);
		repositorySummary.setLanguage(language);
		repositorySummary.setName(name);
		repositorySummary.setOwner((owner != null ? owner.getLogin() : null));
		repositorySummary.setUpdated_at(updated_at);

		return repositorySummary;
	}
}
