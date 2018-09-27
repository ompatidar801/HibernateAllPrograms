package custom;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Customer2 implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	private int custID;
	private String custName;
	private String custAddress;
	private Date createdBy;
	private Date updatedBy;
	private Set<?> cust_ord;
	
	public Date getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Date createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Date updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public Set<?> getCust_ord() {
		return cust_ord;
	}
	public void setCust_ord(Set<?> cust_ord) {
		this.cust_ord = cust_ord;
	}
	
	
	
}
