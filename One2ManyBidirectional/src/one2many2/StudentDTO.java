package one2many2;

public class StudentDTO 
{
	private int sid;
	private String sname;
	private String subject;
	/*private int foreignsid;*/
	private TeachersDTO parentObject;
	
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
	/*public int getForeignsid() {
		return foreignsid;
	}
	public void setForeignsid(int foreignsid) {
		this.foreignsid = foreignsid;
	}
	*/
	public TeachersDTO getParentObject() {
		return parentObject;
	}
	public void setParentObject(TeachersDTO parentObject) {
		this.parentObject = parentObject;
	}
	
}
