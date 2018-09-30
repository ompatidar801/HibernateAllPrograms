package entities;
// Generated Feb 20, 2018 6:52:46 PM by Hibernate Tools 5.1.0.Alpha1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Categories generated by hbm2java
 */
@Entity
@Table(name = "categories", catalog = "HibernateTask")
public class Categories implements java.io.Serializable {

	private String catName;
	private Integer catId;

	public Categories() {
	}

	public Categories(String catName) {
		this.catName = catName;
	}

	public Categories(String catName, Integer catId) {
		this.catName = catName;
		this.catId = catId;
	}

	@Id

	@Column(name = "cat_Name", unique = true, nullable = false)
	public String getCatName() {
		return this.catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	@Column(name = "cat_ID")
	public Integer getCatId() {
		return this.catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

}