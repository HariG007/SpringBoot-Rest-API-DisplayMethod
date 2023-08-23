package com.harig.user.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //define class can be mapped to the table
@Table 
public class User {
	@Id //act as an primary key
	@GeneratedValue(strategy = GenerationType.AUTO) //auto-increment value
	private int id;
	private String Firstname;
	private String Lastname;
	private String email;
	private String password;
//	@Column(name = "desc") // To change the attribute/column name
//	private String description;
   public User() {
		super();
	}
   public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
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
	
	public User(int id, String firstname, String lastname, String email, String password) {
		super();
		this.id = id;
		Firstname = firstname;
		Lastname = lastname;
		this.email = email;
		this.password = password;
	}
	
	

}
