package o2mxmlbased;

import java.io.Serializable;
import java.util.Set;

public class Teachers implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	private int tID;
	private String tName;
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
