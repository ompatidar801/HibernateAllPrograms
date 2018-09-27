package one2many;

public class CustomerDTO 
{
	private int cid;
	private String cname;
	private VendorDTO parentObject;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public VendorDTO getParentObject() {
		return parentObject;
	}
	public void setParentObject(VendorDTO parentObject) {
		this.parentObject = parentObject;
	}
	
}
