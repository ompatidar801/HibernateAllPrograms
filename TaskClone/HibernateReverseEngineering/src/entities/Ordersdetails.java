package entities;
// Generated Feb 20, 2018 6:22:04 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.Date;

/**
 * Ordersdetails generated by hbm2java
 */
public class Ordersdetails implements java.io.Serializable {

	private int orderId;
	private Integer userId;
	private String country;
	private String location;
	private Date orderDate;
	private String productName;
	private String state;

	public Ordersdetails() {
	}

	public Ordersdetails(int orderId) {
		this.orderId = orderId;
	}

	public Ordersdetails(int orderId, Integer userId, String country, String location, Date orderDate,
			String productName, String state) {
		this.orderId = orderId;
		this.userId = userId;
		this.country = country;
		this.location = location;
		this.orderDate = orderDate;
		this.productName = productName;
		this.state = state;
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}