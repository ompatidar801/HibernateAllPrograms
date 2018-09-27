package one2manyAnnotation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="players")
public class Players implements Serializable
{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="pid")
	private int pid;
	
	@Column(name="Players_name")
	private String pname;
	
	@Column(name="Team_name")
	private String fktname;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getFktname() {
		return fktname;
	}

	public void setFktname(String fktname) {
		this.fktname = fktname;
	}
	
	
	
}
