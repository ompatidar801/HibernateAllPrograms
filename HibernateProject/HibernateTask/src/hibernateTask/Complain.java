package hibernateTask;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Complain")
public class Complain implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ComplainSNo")
	private int complainSNo;
	
	@Column(name="UserID")
	private int userID;

	public int getComplainSNo() {
		return complainSNo;
	}

	public void setComplainSNo(int complainSNo) {
		this.complainSNo = complainSNo;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	
}
