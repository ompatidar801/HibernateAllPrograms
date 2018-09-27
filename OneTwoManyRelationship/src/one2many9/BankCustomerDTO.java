package one2many9;

public class BankCustomerDTO 
{
	private int cstid;
	private String custname;
	private int phoneno;
	private int foreignBID;
	
	public int getCstid() {
		return cstid;
	}
	public void setCstid(int cstid) {
		this.cstid = cstid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public int getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}
	public int getForeignBID() {
		return foreignBID;
	}
	public void setForeignBID(int foreignBID) {
		this.foreignBID = foreignBID;
	}
	
	
}
