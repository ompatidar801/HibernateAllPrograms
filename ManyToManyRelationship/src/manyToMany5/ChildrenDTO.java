package manyToMany5;

import java.util.Set;

public class ChildrenDTO 
{
	private int cdid;
	private String cdname;
	private String cdaddress;
	private Set father;
	
	public int getCdid() {
		return cdid;
	}
	public void setCdid(int cdid) {
		this.cdid = cdid;
	}
	public String getCdname() {
		return cdname;
	}
	public void setCdname(String cdname) {
		this.cdname = cdname;
	}
	public String getCdaddress() {
		return cdaddress;
	}
	public void setCdaddress(String cdaddress) {
		this.cdaddress = cdaddress;
	}
	public Set getFather() {
		return father;
	}
	public void setFather(Set father) {
		this.father = father;
	}
	
	
}
