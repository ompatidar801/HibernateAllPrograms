package entities;
// Generated Feb 20, 2018 6:52:46 PM by Hibernate Tools 5.1.0.Alpha1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product", catalog = "HibernateTask")
public class Product implements java.io.Serializable {

	private int prodId;
	private String brandName;
	private String prodName;
	private Float prodPrice;

	public Product() {
	}

	public Product(int prodId) {
		this.prodId = prodId;
	}

	public Product(int prodId, String brandName, String prodName, Float prodPrice) {
		this.prodId = prodId;
		this.brandName = brandName;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
	}

	@Id

	@Column(name = "prod_ID", unique = true, nullable = false)
	public int getProdId() {
		return this.prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	@Column(name = "BrandName")
	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	@Column(name = "prod_Name")
	public String getProdName() {
		return this.prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	@Column(name = "prod_Price", precision = 12, scale = 0)
	public Float getProdPrice() {
		return this.prodPrice;
	}

	public void setProdPrice(Float prodPrice) {
		this.prodPrice = prodPrice;
	}

}
