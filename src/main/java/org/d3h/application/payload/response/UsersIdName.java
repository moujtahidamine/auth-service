package org.d3h.application.payload.response;

public class UsersIdName {

	private long id;
	private String name;
	
	public UsersIdName() {
		super();
	}
	
	public UsersIdName(long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	@Override
	public String toString() {
		return "CustomersIdName [id=" + id + ", name=" + name + "]";
	}
	
}
