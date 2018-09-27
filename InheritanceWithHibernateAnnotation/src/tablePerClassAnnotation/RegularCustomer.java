package tablePerClassAnnotation;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="RegularCustomer")
@DiscriminatorValue("Regu_Cust")
public class RegularCustomer extends Customer
{
	private static final long serialVersionUID = 1L;
	
	@Column(name="Reg_Cust_Payment")
	private float repay;

	public float getRepay() {
		return repay;
	}

	public void setRepay(float repay) {
		this.repay = repay;
	}

	
	
	
}
