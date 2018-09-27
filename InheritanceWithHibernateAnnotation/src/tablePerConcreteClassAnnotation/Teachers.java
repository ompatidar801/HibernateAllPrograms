package tablePerConcreteClassAnnotation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="Teachers")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Teachers implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="teacherID")
	private int t_id;
	
	@Column(name="teacherName")
	private String t_name;

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	
	
}
