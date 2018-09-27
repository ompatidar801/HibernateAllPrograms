package custom;

import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	private int orderID;
	private String product;
	private CustomerOrders custord;
	private Date createdBy;
	private Date updatedBy;
	
	
	public CustomerOrders getCustord() {
		return custord;
	}
	public void setCustord(CustomerOrders custord) {
		this.custord = custord;
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
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	
	
}
