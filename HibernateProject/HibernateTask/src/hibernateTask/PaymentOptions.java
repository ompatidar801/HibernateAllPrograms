package hibernateTask;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PaymemtOptions")
public class PaymentOptions implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="creaditCardNo")
	private int creaditCardNo;
	
	@Column(name="CVVNO")
	private int CVVNo;
	
}
