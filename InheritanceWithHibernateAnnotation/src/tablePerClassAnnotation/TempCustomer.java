package tablePerClassAnnotation;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="temp_Customer")
@DiscriminatorValue(value="Temp_Customer")
public class TempCustomer extends Customer
{
	private static final long serialVersionUID = 1L;
	
	@Column(name="Temp_Cust_payment")
	private float tcpay;

	public float getTcpay() {
		return tcpay;
	}

	public void setTcpay(float tcpay) {
		this.tcpay = tcpay;
	}
	
	
	
}
