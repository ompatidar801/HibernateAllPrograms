package oneToOne6;

import java.util.Set;

public class CoursesDTO
{
	private int courseID;
	private String courseName;
	private SchoolDTO school;
	
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
	public SchoolDTO getSchool() {
		return school;
	}
	public void setSchool(SchoolDTO school) {
		this.school = school;
	}
	
	
}
