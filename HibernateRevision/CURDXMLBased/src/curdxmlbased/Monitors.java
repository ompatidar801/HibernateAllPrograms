package curdxmlbased;

import java.io.Serializable;

public class Monitors implements Serializable
{
	private int monitorSerialNo;
	private String monitorCompanyName;
	private double monitorPrice;
	
	public int getMonitorSerialNo() {
		return monitorSerialNo;
	}
	public void setMonitorSerialNo(int monitorSerialNo) {
		this.monitorSerialNo = monitorSerialNo;
	}
	public String getMonitorCompanyName() {
		return monitorCompanyName;
	}
	public void setMonitorCompanyName(String monitorCompanyName) {
		this.monitorCompanyName = monitorCompanyName;
	}
	public double getMonitorPrice() {
		return monitorPrice;
	}
	public void setMonitorPrice(double monitorPrice) {
		this.monitorPrice = monitorPrice;
	}
	
	
	
}
