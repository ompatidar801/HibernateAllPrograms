package one2many9;

import java.util.Set;

public class BankDTO
{
	private int branchCode;
	private String bankName;
	private Set bkCust;
	
	public int getBranchCode() 
	{
		return branchCode;
	}
	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Set getBkCust() {
		return bkCust;
	}
	public void setBkCust(Set bkCust) {
		this.bkCust = bkCust;
	}
	
	
	
}
