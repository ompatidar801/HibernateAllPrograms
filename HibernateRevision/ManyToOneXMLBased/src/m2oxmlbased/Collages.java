package m2oxmlbased;

import java.io.Serializable;

public class Collages implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int cID;
	private String cName;
	private Univercity univercity;
	
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
	public Univercity getUnivercity() {
		return univercity;
	}
	public void setUnivercity(Univercity univercity) {
		this.univercity = univercity;
	}
	
	

}
