package gob.imss.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="\"users\"")
public class Usuario {
	
	@Id
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	private boolean enabled;
	@NotEmpty
	private String authority;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	@Override
	public String toString() {
		return "Usuario [username=" + username + ", password=" + password + ", enabled=" + enabled + ", authority="
				+ authority + "]";
	}
	
	
	
	

}
