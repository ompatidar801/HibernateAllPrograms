package one2many1;

public class OrderDTO
{
	private int orderId;
	private String product;
	/*private int foreignCustId;*/
	private CustomerDTO2 parentObject;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	/*public int getForeignCustId() {
		return foreignCustId;
	}
	public void setForeignCustId(int foreignCustId) {
		this.foreignCustId = foreignCustId;
	}*/
	public CustomerDTO2 getParentObject() {
		return parentObject;
	}
	public void setParentObject(CustomerDTO2 parentObject) {
		this.parentObject = parentObject;
	}
	
	
}
