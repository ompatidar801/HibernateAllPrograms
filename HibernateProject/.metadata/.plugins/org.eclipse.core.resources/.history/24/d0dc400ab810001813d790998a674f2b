package hibernateTask;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SubCategories")
public class SubCategories implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="sub_cat_ID")
	private int subCatID;
	
	@Id
	@Column(name="sub_cat_Name")
	private String subCatName;
	
	@Column(name="Category_Name")
	private String Category_Name;
	
	public String getCategory_Name() {
		return Category_Name;
	}

	public void setCategory_Name(String category_Name) {
		Category_Name = category_Name;
	}

	public int getSubCatID() {
		return subCatID;
	}

	public void setSubCatID(int subCatID) {
		this.subCatID = subCatID;
	}

	public String getSubCatName() {
		return subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}
	
	//for ProductClass
	@OneToMany(targetEntity=Product.class ,cascade=CascadeType.ALL)
	@JoinColumn(name="sub_Cat_Name" ,referencedColumnName="sub_cat_Name")
	private Set<Product> product;

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	
	
}
