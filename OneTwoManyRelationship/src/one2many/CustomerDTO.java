package one2many;

public class CustomerDTO 
{
	private int cid;
	private String cname;
	private int foreignvid;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getForeignvid() {
		return foreignvid;
	}
	public void setForeignvid(int foreignvid) {
		this.foreignvid = foreignvid;
	}
	
}
