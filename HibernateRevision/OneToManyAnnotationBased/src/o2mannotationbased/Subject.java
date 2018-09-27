package o2mannotationbased;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SubjectAnno")
public class Subject implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	private int subID;
	
	@Column
	private String subName;
	
	@Column
	private int FKtId;
	
	public int getSubID() {
		return subID;
	}
	public void setSubID(int subID) {
		this.subID = subID;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public int getFKtId() {
		return FKtId;
	}
	public void setFKtId(int fKtId) {
		FKtId = fKtId;
	}
	
	

}
