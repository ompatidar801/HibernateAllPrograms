package one2many8;

public class MobileNoDTO
{
	private int mobno;
	private int AdharNo;
	private PersonsDTO person;
	
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
	public PersonsDTO getPerson() {
		return person;
	}
	public void setPerson(PersonsDTO person) {
		this.person = person;
	}
	
}
