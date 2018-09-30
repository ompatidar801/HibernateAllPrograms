package hibernateTask;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SellerInformation")
public class SellerInformation implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SellerID")
	private int sellerID;
	
	@Column(name="SellerName")
	private String sellerName;
	
	
	
}
