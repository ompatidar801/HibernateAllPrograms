package tablePerConcreteClassAnnotation;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="GuestTeachers")
@AttributeOverrides({
	@AttributeOverride(name="t_id",column=@Column(name="teacherID")),
	@AttributeOverride(name="t_name",column=@Column(name="teacherName"))
})
public class GuestTeachers extends Teachers
{
	private static final long serialVersionUID = 1L;
	
	@Column(name="gst_Subject")
	private String gst_subject;
	
	@Column(name="get_Salary")
	private int gst_salary;

	public String getGst_subject() {
		return gst_subject;
	}

	public void setGst_subject(String gst_subject) {
		this.gst_subject = gst_subject;
	}

	public int getGst_salary() {
		return gst_salary;
	}

	public void setGst_salary(int gst_salary) {
		this.gst_salary = gst_salary;
	}

	
}
