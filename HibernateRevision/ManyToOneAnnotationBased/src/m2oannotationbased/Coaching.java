package m2oannotationbased;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Coaching")
public class Coaching implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="coID")
	private int coID;
	
	@Column(name="coName")
	private String coName;

	public int getCoID() {
		return coID;
	}

	public void setCoID(int coID) {
		this.coID = coID;
	}

	public String getCoName() {
		return coName;
	}

	public void setCoName(String coName) {
		this.coName = coName;
	}
	
	
}
