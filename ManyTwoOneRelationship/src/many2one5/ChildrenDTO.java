package many2one5;

public class ChildrenDTO 
{
	private int cdid;
	private String cdname;
	private String cdaddress;
	private FatherDTO parentObject;
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
	public FatherDTO getParentObject() {
		return parentObject;
	}
	public void setParentObject(FatherDTO parentObject) {
		this.parentObject = parentObject;
	}
	
	
	
}
