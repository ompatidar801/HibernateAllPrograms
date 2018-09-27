package one2many7;

import java.util.Set;

public class MobileCompanyDTO 
{
	private int companyID;
	private String comName;
	private Set model;
	
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public Set getModel() {
		return model;
	}
	public void setModel(Set model) {
		this.model = model;
	}
	
	
}
