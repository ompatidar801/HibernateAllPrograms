package m2oannotationbased;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Courses")
public class Courses implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="couID")
	private int couID;
	
	@Column(name="couName")
	private String couName;
	
	@ManyToOne(targetEntity=Coaching.class ,cascade=CascadeType.ALL)
	@JoinColumn(name="coID" ,referencedColumnName="coID")
	private Coaching coaching;

	public int getCouID() {
		return couID;
	}

	public void setCouID(int couID) {
		this.couID = couID;
	}

	public String getCouName() {
		return couName;
	}

	public void setCouName(String couName) {
		this.couName = couName;
	}

	public Coaching getCoaching() {
		return coaching;
	}

	public void setCoaching(Coaching coaching) {
		this.coaching = coaching;
	}
	
	
}
