package custom;

import java.io.Serializable;
import java.util.Date;

public class CustomerOrders implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	private int cust_orderID;
	private int fkcustID;
	private Date createdBy;
	private Date updatedBy;
	
	public int getCust_orderID() {
		return cust_orderID;
	}
	public void setCust_orderID(int cust_orderID) {
		this.cust_orderID = cust_orderID;
	}
	public int getFkcustID() {
		return fkcustID;
	}
	public void setFkcustID(int fkcustID) {
		this.fkcustID = fkcustID;
	}
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
	
}
