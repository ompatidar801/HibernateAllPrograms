package tablePerSubClassAnnotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="FourWheeler")
@PrimaryKeyJoinColumn(name="ID")
public class FourWheeler extends Vehicle
{
	private static final long serialVersionUID = 1L;
	
	@Column(name="steering")
	private String steering;
	
	@Column(name="price")
	private float price;

	public String getSteering() {
		return steering;
	}

	public void setSteering(String steering) {
		this.steering = steering;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
}
