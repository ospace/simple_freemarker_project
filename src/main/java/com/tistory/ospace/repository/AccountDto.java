package com.tistory.ospace.repository;

public class AccountDto {
	private String id;
	private String name;

	public static AccountDto of(String id, String name) {
		return new AccountDto(id, name);
	}
	
	public AccountDto(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "{\"id\":\""+id+"\",\"name\":\""+name+"\"}";
	}
}
