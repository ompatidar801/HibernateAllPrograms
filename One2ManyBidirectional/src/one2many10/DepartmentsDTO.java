package one2many10;

import java.util.Set;

public class DepartmentsDTO 
{
	private int deptID;
	private String deptName;
	private Set<?> empID;
	
	public int getDeptID() {
		return deptID;
	}
	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Set<?> getEmpID() {
		return empID;
	}
	public void setEmpID(Set<?> empID) {
		this.empID = empID;
	}
	
	
}
