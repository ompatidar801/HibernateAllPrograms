package entities;
// Generated Feb 20, 2018 6:52:46 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ordersdetails generated by hbm2java
 */
@Entity
@Table(name = "ordersdetails", catalog = "HibernateTask")
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

	@Id

	@Column(name = "OrderID", unique = true, nullable = false)
	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Column(name = "User_ID")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "Country")
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "Location")
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "orderDate", length = 19)
	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Column(name = "ProductName")
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "State")
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}