package hibernateTask;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RefoundOrReplace")
public class RefundOrReplace implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="reID")
	private int reID;
	
	@Column(name="ReplaceProduct")
	private String replaceProduct;
	
	@Column(name="RefoundAmount")
	private String refoundAmount;

	public int getReID() {
		return reID;
	}

	public void setReID(int reID) {
		this.reID = reID;
	}

	public String getReplaceProduct() {
		return replaceProduct;
	}

	public void setReplaceProduct(String replaceProduct) {
		this.replaceProduct = replaceProduct;
	}

	public String getRefoundAmount() {
		return refoundAmount;
	}

	public void setRefoundAmount(String refoundAmount) {
		this.refoundAmount = refoundAmount;
	}
	
	
}
