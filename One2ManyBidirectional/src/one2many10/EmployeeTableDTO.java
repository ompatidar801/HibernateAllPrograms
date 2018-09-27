package one2many10;

public class EmployeeTableDTO
{
	private int empid;
	private String empName;
	private String empAddress;
	private DepartmentsDTO dept;
	
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
	public DepartmentsDTO getDept() {
		return dept;
	}
	public void setDept(DepartmentsDTO dept) {
		this.dept = dept;
	}
	
}
