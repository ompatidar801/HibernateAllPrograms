package one2oneAnnotation;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import one2oneAnnotation.Customers;

@Entity
@Table(name="orderOfCustomer")
public class OrdersOfCustomer 
{
	@Id
	@Column(name="odr_id")
	private int odrId;
	
	@Column(name="product")
	private String product;
	
	@OneToOne(targetEntity=Customers.class,cascade=CascadeType.ALL)
	@JoinColumn(name="cust_id" ,referencedColumnName="cust_id")
	private Customers cust;

	public int getOdrId() {
		return odrId;
	}

	public void setOdrId(int odrId) {
		this.odrId = odrId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Customers getCust() {
		return cust;
	}

	public void setCust(Customers cust) {
		this.cust = cust;
	}
	
	
}
