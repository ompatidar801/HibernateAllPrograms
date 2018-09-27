package one2many1;

public class OrderDTO
{
	private int orderId;
	private String product;
	private int foreignCustId;
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
	public int getForeignCustId() {
		return foreignCustId;
	}
	public void setForeignCustId(int foreignCustId) {
		this.foreignCustId = foreignCustId;
	}
	
}
