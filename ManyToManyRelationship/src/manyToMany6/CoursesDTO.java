package manyToMany6;

import java.util.Set;

public class CoursesDTO
{
	private int courseID;
	private String courseName;
	private Set school;
	
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Set getSchool() {
		return school;
	}
	public void setSchool(Set school) {
		this.school = school;
	}
	
	
}
