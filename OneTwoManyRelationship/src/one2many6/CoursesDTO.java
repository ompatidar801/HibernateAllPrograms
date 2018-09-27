package one2many6;

public class CoursesDTO
{
	private int courseID;
	private String courseName;
	private int foreignCorID;
	
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
	public int getForeignCorID() {
		return foreignCorID;
	}
	public void setForeignCorID(int foreignCorID) {
		this.foreignCorID = foreignCorID;
	}
	
	
}
