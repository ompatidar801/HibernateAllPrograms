package tablePerConcreteClassAnnotation;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Prnt_Teacher")
@AttributeOverrides({
					@AttributeOverride(name="t_id",column=@Column(name="teacherID")),
					@AttributeOverride(name="t_name",column=@Column(name="teacherName"))
		})
public class PermanentTeachers extends Teachers
{
	private static final long serialVersionUID = 1L;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="salary")
	private float salary;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	
	
	
}
