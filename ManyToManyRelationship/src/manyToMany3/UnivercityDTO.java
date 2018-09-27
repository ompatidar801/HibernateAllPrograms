package manyToMany3;

import java.util.Set;

public class UnivercityDTO 
{
	private int universityId;
	private String univerName;
	private Set<?> college;
	
	public int getUniversityId() {
		return universityId;
	}
	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}
	public String getUniverName() {
		return univerName;
	}
	public void setUniverName(String univerName) {
		this.univerName = univerName;
	}
	public Set<?> getCollege() {
		return college;
	}
	public void setCollege(Set<?> college) {
		this.college = college;
	}
	
	
}
