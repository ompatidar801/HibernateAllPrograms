package m2oxmlbased;

import java.io.Serializable;

public class Univercity implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int uID;
	private String uName;
	
	public int getuID() {
		return uID;
	}
	public void setuID(int uID) {
		this.uID = uID;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	
	
}
