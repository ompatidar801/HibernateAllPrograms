package o2mxmlbased;

import java.io.Serializable;
import java.util.Set;

public class Father implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int fID;
	private String fName;
	private Set<?> children;
	
	public Set<?> getChildren() {
		return children;
	}
	public void setChildren(Set<?> children) {
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
