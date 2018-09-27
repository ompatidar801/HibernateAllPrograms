package oneToOne9;

public class BankCustomerDTO 
{
	private int cstid;
	private String custname;
	private int phoneno;
	private BankDTO bank;
	
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
	public BankDTO getBank() {
		return bank;
	}
	public void setBank(BankDTO bank) {
		this.bank = bank;
	}
	
	
}
