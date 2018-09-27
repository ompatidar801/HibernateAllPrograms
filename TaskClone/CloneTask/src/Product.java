
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	private int prod_id;
	
	@Column(name="prod_Name")
	private String prod_name;


	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	
	@ManyToMany(targetEntity=UserDetails.class ,cascade=CascadeType.ALL)
	@JoinTable(name="Product_Users" ,joinColumns=@JoinColumn(name="Product_ID" ,referencedColumnName="prod_ID") ,inverseJoinColumns=@JoinColumn(name="User_ID" ,referencedColumnName="userID"))
	private Set<?> users;

	public Set<?> getUsers() {
		return users;
	}

	public void setUsers(Set<?> users) {
		this.users = users;
	}
	
}
