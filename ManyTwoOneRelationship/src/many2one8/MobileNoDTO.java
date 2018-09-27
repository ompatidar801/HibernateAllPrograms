package many2one8;

public class MobileNoDTO
{
	private int mobno;
	private int AdharNo;
	private PersonsDTO parentObject;
	public int getMobno() {
		return mobno;
	}
	public void setMobno(int mobno) {
		this.mobno = mobno;
	}
	public int getAdharNo() {
		return AdharNo;
	}
	public void setAdharNo(int adharNo) {
		AdharNo = adharNo;
	}
	public PersonsDTO getParentObject() {
		return parentObject;
	}
	public void setParentObject(PersonsDTO parentObject) {
		this.parentObject = parentObject;
	}
	
	
	
}
