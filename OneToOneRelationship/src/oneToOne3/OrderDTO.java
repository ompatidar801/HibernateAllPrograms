package oneToOne3;

public class OrderDTO
{
	private int orderId;
	private String product;
	private CustomerDTO2 customer;
	
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
	public CustomerDTO2 getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO2 customer) {
		this.customer = customer;
	}
	
	
}
