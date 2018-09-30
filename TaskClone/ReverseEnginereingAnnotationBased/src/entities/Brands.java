package entities;
// Generated Feb 20, 2018 6:52:46 PM by Hibernate Tools 5.1.0.Alpha1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Brands generated by hbm2java
 */
@Entity
@Table(name = "brands", catalog = "HibernateTask")
public class Brands implements java.io.Serializable {

	private String brandName;
	private Integer brandId;
	private String subCategories;

	public Brands() {
	}

	public Brands(String brandName) {
		this.brandName = brandName;
	}

	public Brands(String brandName, Integer brandId, String subCategories) {
		this.brandName = brandName;
		this.brandId = brandId;
		this.subCategories = subCategories;
	}

	@Id

	@Column(name = "BrandName", unique = true, nullable = false)
	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	@Column(name = "BrandID")
	public Integer getBrandId() {
		return this.brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	@Column(name = "subCategories")
	public String getSubCategories() {
		return this.subCategories;
	}

	public void setSubCategories(String subCategories) {
		this.subCategories = subCategories;
	}

}
