package one2many10;

public class EmployeeTableDTO
{
	private int empid;
	private String empName;
	private String empAddress;
	private int foreignEmpID;
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public int getForeignEmpID() {
		return foreignEmpID;
	}
	public void setForeignEmpID(int foreignEmpID) {
		this.foreignEmpID = foreignEmpID;
	}
	
	
}
