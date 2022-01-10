package academy.it.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;


@Entity
@Table(name ="USER_TBL")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private  String password;
	private String emailString;
	
	
	public User() {
		super();
	}

	public User(String username, String password, String emailString) {
		this.username = username;
		this.password = password;
		this.emailString = emailString;
	}

	public User(int id, String username, String password, String emailString) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.emailString = emailString;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
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


	public String getEmailString() {
		return emailString;
	}


	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", emailString=" + emailString
				+ "]";
	}
	
	
	
	
}
