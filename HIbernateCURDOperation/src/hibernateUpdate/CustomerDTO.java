package hibernateUpdate;

public class CustomerDTO
{
	private int cstId=0;
	private String cstName=null;
	private String cstAddress=null;
	private int cstAge=0;
	public int getCstId() {
		return cstId;
	}
	public void setCstId(int cstId) {
		this.cstId = cstId;
	}
	public String getCstName() {
		return cstName;
	}
	public void setCstName(String cstName) {
		this.cstName = cstName;
	}
	public String getCstAddress() {
		return cstAddress;
	}
	public void setCstAddress(String cstAddress) {
		this.cstAddress = cstAddress;
	}
	public int getCstAge() {
		return cstAge;
	}
	public void setCstAge(int cstAge) {
		this.cstAge = cstAge;
	}
	
}
