package tablePerSubClassAnnotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="TwoWheeler")
@PrimaryKeyJoinColumn(name="ID")
public class TwoWheeler extends Vehicle
{
	private static final long serialVersionUID = 1L;
	
	@Column(name="steering")
	private String steering;
	
	@Column(name="price")
	private String price;

	
	public String getSteering() {
		return steering;
	}

	public void setSteering(String steering) {
		this.steering = steering;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
	

}
