package manyToMany6;

import java.util.Set;

public class SchoolDTO 
{
	private int schoolID;
	private String schoolName;
	private Set courses;
	
	public int getSchoolID() {
		return schoolID;
	}
	public void setSchoolID(int schoolID) {
		this.schoolID = schoolID;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public Set getcourses() {
		return courses;
	}
	public void setcourses(Set courses) {
		this.courses = courses;
	}
	
	
}
