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
@Table(name="Categories")
public class Categories implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="cat_Name")
	private String catName;

	@Column(name="cat_ID")
	private int catID;
	
	//for SubCategoriesClass
	@OneToMany(targetEntity=SubCategories.class ,cascade=CascadeType.ALL)
	@JoinColumn(name="Category_Name" ,referencedColumnName="cat_Name")
	private Set<SubCategories> subCategaries;
	
	public Set<SubCategories> getSubCategaries() {
		return subCategaries;
	}

	public void setSubCategaries(Set<SubCategories> subCategaries) {
		this.subCategaries = subCategaries;
	}

	public int getCatID() {
		return catID;
	}

	public void setCatID(int catID) {
		this.catID = catID;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	
}
