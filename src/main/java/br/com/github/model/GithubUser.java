package br.com.github.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.validation.constraints.NotBlank;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GithubUser implements UserDetails, Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(position = 1, required = true)
	@NotBlank(message = "password required")
	private String password;

	@ApiModelProperty(position = 2, required = true)
	@NotBlank(message = "username required")
	private String username;

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}

	public UsernamePasswordAuthenticationToken authenticate() {
		return new UsernamePasswordAuthenticationToken(username, password);
	}
}
