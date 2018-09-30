package o2mxmlbased;

import java.io.Serializable;

public class Subject implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	private int subID;
	private String subName;
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
