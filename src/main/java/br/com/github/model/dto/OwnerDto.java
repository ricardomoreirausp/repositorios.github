package br.com.github.model.dto;

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
public class OwnerDto {
	private String login;
}
