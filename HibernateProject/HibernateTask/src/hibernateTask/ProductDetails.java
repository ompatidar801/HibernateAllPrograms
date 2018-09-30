package hibernateTask;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ProductDetails")
public class ProductDetails implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="pr_det_Id")
	private int prDetID;
	
	@Column(name="Brand")
	private String Brand;
	
	@Column(name="Model")
	private String model;
	
	@Column(name="price")
	private float price;
	
	@Column(name="colour")
	private String colour;
	
	@Column(name="Warranty")
	private String warranty;

	public int getPrDetID() {
		return prDetID;
	}

	public void setPrDetID(int prDetID) {
		this.prDetID = prDetID;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}
	
	
}
