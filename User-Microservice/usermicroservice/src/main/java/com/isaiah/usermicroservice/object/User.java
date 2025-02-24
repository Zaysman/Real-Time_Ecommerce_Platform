package com.isaiah.usermicroservice.object;

import jakarta.persistence.*;

@Entity //Every Persistent POJO class is an entity and is declared using the @Entity annotation at class level
@Table(name="/api/users", uniqueConstraints = @UniqueConstraint(columnNames = "username")) //Defines the table the object is supposed to use. Hibernate will use the class name as the table be default
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //This means we'll use the database to determne the ID for the object
	@Column(name = "id")
	private long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	
	public User() {
		this(-1l, "default username", "default password", "default@email.com");
	}

	public User(long id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}

}
