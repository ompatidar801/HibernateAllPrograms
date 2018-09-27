
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="UserDetails")
public class UserDetails implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="userID")
	private int userId;
	
	@Column(name="userName")
	private String username;
	
	@Column(name="Password")
	private String password;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@ManyToMany(targetEntity=Product.class ,mappedBy="users")
	private Set<?> product;

	public Set<?> getProduct() {
		return product;
	}

	public void setProduct(Set<?> product) {
		this.product = product;
	}
	
}
