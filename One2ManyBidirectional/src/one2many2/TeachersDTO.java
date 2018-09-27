package one2many2;

import java.util.Set;

public class TeachersDTO 
{

	private int tid;
	private String tname ;
	private Set student ;
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Set getStudent() {
		return student;
	}
	public void setStudent(Set student) {
		this.student = student;
	}
	

}

