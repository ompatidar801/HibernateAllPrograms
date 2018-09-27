package manyToMany5;

import java.util.Set;

public class FatherDTO
{
	private int fid;
	private String fname;
	private String address;
	private Set son;
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set getSon() {
		return son;
	}
	public void setSon(Set son) {
		this.son = son;
	}
	
	
	

}
