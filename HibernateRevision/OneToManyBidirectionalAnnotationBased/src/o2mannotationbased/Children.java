package o2mannotationbased;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ChildrenAnno")
public class Children implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="chId")
	private int chId;
	
	@Column(name="chName")
	private String chName;
	
	@ManyToOne(cascade=CascadeType.ALL ,optional=false)
	@JoinColumn(name="f_ID")
	private Father father;
	
	public Father getFather() {
		return father;
	} 
	public void setFather(Father father) {
		this.father = father;
	}
	public int getChId() {
		return chId;
	}
	public void setChId(int chId) {
		this.chId = chId;
	}
	public String getChName() {
		return chName;
	}
	public void setChName(String chName) {
		this.chName = chName;
	}
	
	
}
