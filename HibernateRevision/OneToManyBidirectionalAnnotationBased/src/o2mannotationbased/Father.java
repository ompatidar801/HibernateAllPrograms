package o2mannotationbased;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="FatherAnno")
public class Father implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="fID")
	private int fID;
	
	@Column(name="fName")
	private String fName;
	
	
	@OneToMany(mappedBy="father" ,cascade=CascadeType.ALL )
	private Set<Children> children;
	
	 
	public Set<Children> getChildren() {
		return children;
	}
	public void setChildren(Set<Children> children) {
		this.children = children;
	}
	public int getfID() {
		return fID;
	}
	public void setfID(int fID) {
		this.fID = fID;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	
}
