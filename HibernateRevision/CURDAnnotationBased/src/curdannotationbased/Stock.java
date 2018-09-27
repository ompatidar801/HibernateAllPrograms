package curdannotationbased;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Stock implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private String stockID;
	
	@Column
	private String stockProduct;

	public String getStockID() {
		return stockID;
	}

	public void setStockID(String stockID) {
		this.stockID = stockID;
	}

	public String getStockProduct() {
		return stockProduct;
	}

	public void setStockProduct(String stockProduct) {
		this.stockProduct = stockProduct;
	}
	
	 
}
