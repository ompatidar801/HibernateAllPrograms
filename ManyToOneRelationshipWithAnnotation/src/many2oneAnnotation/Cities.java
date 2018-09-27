package many2oneAnnotation;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cities")
public class Cities 
{
	@Id
	@Column(name="cityID")
	private int cID;
	
	@Column(name="cityName")
	private String cName;
	
	@ManyToOne(targetEntity=States.class,cascade=CascadeType.ALL)
	@JoinColumn(name="state_ID",referencedColumnName="state_id")
	private States state;

	public int getcID() {
		return cID;
	}

	public void setcID(int cID) {
		this.cID = cID;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}
	
	
}
