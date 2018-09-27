package manyToMany1;

import java.util.Set;

public class CustomerDTO2 {

	private int cstid;
	private String custname;
	private int phoneno;
	private Set order;
	
	public int getCstid() {
		return cstid;
	}
	public void setCstid(int cstid) {
		this.cstid = cstid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public int getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}
	public Set getOrder() {
		return order;
	}
	public void setOrder(Set order) {
		this.order = order;
	}
	
	
}
