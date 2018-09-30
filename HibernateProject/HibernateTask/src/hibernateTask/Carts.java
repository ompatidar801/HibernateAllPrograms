package hibernateTask;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Carts")
public class Carts implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="cartID")
	private int cartID;
	
	@Column(name="SavedProduct")
	private String savedProduct;
	
	@Column(name="ProductPrice")
	private float productPrice;

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public String getSavedProduct() {
		return savedProduct;
	}

	public void setSavedProduct(String savedProduct) {
		this.savedProduct = savedProduct;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	
	

}
