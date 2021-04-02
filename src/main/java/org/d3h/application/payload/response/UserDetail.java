package org.d3h.application.payload.response;

public class UserDetail {

	private long id;
	private String name;
	private String username;
	private String email;
	private boolean isOnline;
	private boolean isDisabled;
	private String role;
	private String createdAt;
	
	public UserDetail() {
		super();
	}



	public UserDetail(long id, String name, String username, String email, boolean isOnline, boolean isDisabled,
			String role, String createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.isOnline = isOnline;
		this.isDisabled = isDisabled;
		this.role = role;
		this.createdAt = createdAt;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isOnline() {
		return isOnline;
	}

	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

	public boolean isDisabled() {
		return isDisabled;
	}

	public void setDisabled(boolean isDisabled) {
		this.isDisabled = isDisabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	public String getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}



	@Override
	public String toString() {
		return "UserDetail [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email + ", isOnline="
				+ isOnline + ", isDisabled=" + isDisabled + ", role=" + role + ", createdAt=" + createdAt + "]";
	}
	
}
