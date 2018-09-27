package manyToMany1;

import java.util.Set;

public class OrderDTO
{
	private int orderId;
	private String product;
	private Set customer;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Set getCustomer() {
		return customer;
	}
	public void setCustomer(Set customer) {
		this.customer = customer;
	}
	
	
	
}
