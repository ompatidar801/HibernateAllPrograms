package entities;
// Generated Feb 20, 2018 6:52:46 PM by Hibernate Tools 5.1.0.Alpha1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Userdetails generated by hbm2java
 */
@Entity
@Table(name = "userdetails", catalog = "HibernateTask")
public class Userdetails implements java.io.Serializable {

	private int userId;
	private String password;
	private String userName;

	public Userdetails() {
	}

	public Userdetails(int userId) {
		this.userId = userId;
	}

	public Userdetails(int userId, String password, String userName) {
		this.userId = userId;
		this.password = password;
		this.userName = userName;
	}

	@Id

	@Column(name = "userID", unique = true, nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "Password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "userName")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}