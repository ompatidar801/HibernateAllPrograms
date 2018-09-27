package manyToMany2;

import java.util.Set;

public class StudentDTO 
{
	private int sid;
	private String sname;
	private String subject;
	private Set teacher;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public Set getTeacher() {
		return teacher;
	}
	public void setTeacher(Set teacher) {
		this.teacher = teacher;
	}
	
}
