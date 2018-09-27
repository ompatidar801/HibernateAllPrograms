package many2one10;

public class EmployeeTableDTO
{
	private int empid;
	private String empName;
	private String empAddress;
	private DepartmentsDTO parentObject;
	
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
	public DepartmentsDTO getParentObject() {
		return parentObject;
	}
	public void setParentObject(DepartmentsDTO parentObject) {
		this.parentObject = parentObject;
	}
	
}
