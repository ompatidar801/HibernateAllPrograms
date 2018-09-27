package many2one6;

public class CoursesDTO
{
	private int courseID;
	private String courseName;
	private SchoolDTO parentObject;
	
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
	public SchoolDTO getParentObject() {
		return parentObject;
	}
	public void setParentObject(SchoolDTO parentObject) {
		this.parentObject = parentObject;
	}
	
	
}
