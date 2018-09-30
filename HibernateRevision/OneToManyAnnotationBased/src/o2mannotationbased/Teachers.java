package o2mannotationbased;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TeachersAnno")
public class Teachers implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private int tID;
	
	@Column
	private String tName;
	
	@OneToMany(targetEntity=Subject.class ,cascade=CascadeType.ALL)
	@JoinColumn(name="FKtId" ,referencedColumnName="tID")
	private Set<?> subject;

	public int gettID() {
		return tID;
	}
	public void settID(int tID) {
		this.tID = tID;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public Set<?> getSubject() {
		return subject;
	}
	public void setSubject(Set<?> subject) {
		this.subject = subject;
	}
	
	
}
