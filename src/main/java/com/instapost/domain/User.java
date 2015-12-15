package com.instapost.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="USER")
public class User {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private boolean enabled;
	
	@NotEmpty
	@Size(min=6, message="{Size.email.validation}")
	private String email;
	
	@NotEmpty
	@Size(min=6, message="{Size.password.validation}")
	private String password;
	
	@NotEmpty
	@Size(min=6, message="{Size.firstName.validation}")
	private String firstName;

	@NotEmpty
	@Size(min=6, message="{Size.lastName.validation}")
	private String lastName;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Role role; 

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
