package one2many8;

import java.util.Set;

public class PersonsDTO 
{
	private int pid;
	private String pname;
	private Set mno;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Set getMno() {
		return mno;
	}
	public void setMno(Set mno) {
		this.mno = mno;
	}
	
	
}
