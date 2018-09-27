package manyToMany7;

import java.util.Set;

public class MobileCompanyDTO 
{
	private int companyID;
	private String comName;
	private Set<?> models;
	
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
	
	public Set<?> getModels() {
		return models;
	}
	public void setModels(Set<?> models) {
		this.models = models;
	}

}
