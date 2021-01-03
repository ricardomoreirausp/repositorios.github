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
public class Token implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(position = 1, required = true)
	private String token;

	@ApiModelProperty(position = 2, required = true)
	private String type;
}
