package one2many5;

public class ChildrenDTO 
{
	private int cdid;
	private String cdname;
	private String cdaddress;
	private FatherDTO father;
	
	
	public FatherDTO getFather() {
		return father;
	}
	public void setFather(FatherDTO father) {
		this.father = father;
	}
	public int getCdid() {
		return cdid;
	}
	public void setCdid(int cdid) {
		this.cdid = cdid;
	}
	public String getCdname() {
		return cdname;
	}
	public void setCdname(String cdname) {
		this.cdname = cdname;
	}
	public String getCdaddress() {
		return cdaddress;
	}
	public void setCdaddress(String cdaddress) {
		this.cdaddress = cdaddress;
	}
	
}
