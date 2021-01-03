package br.com.github.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
public class RepositorySummary implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(position = 1)
	private boolean _private;

	@ApiModelProperty(position = 2)
	private String created_at;

	@ApiModelProperty(position = 3)
	private String description;

	@ApiModelProperty(position = 4)
	private String full_name;

	@ApiModelProperty(position = 5)
	private String language;

	@ApiModelProperty(position = 6)
	private String name;

	@ApiModelProperty(position = 7)
	private String owner;

	@ApiModelProperty(position = 8)
	private String updated_at;
}
