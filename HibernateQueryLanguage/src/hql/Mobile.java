package hql;

import java.io.Serializable;

public class Mobile implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	private Integer mobID;
	private String company_Name;
	private String model_Name;
	private Double mobile_price;
	
	public Integer getMobID() {
		return mobID;
	}
	public void setMobID(Integer mobID) {
		this.mobID = mobID;
	}
	public String getCompany_Name() {
		return company_Name;
	}
	public void setCompany_Name(String company_Name) {
		this.company_Name = company_Name;
	}
	public Double getMobile_price() {
		return mobile_price;
	}
	public void setMobile_price(Double mobile_price) {
		this.mobile_price = mobile_price;
	}
	public String getModel_Name() {
		return model_Name;
	}
	public void setModel_Name(String model_Name) {
		this.model_Name = model_Name;
	}
	
	
	
} 
