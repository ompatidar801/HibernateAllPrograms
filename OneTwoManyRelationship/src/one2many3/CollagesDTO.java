package one2many3;

public class CollagesDTO 
{
	private int collageId;
	private String collageName;
	private int foreignCID;
	
	public int getCollageId() {
		return collageId;
	}
	public void setCollageId(int collageId) {
		this.collageId = collageId;
	}
	public String getCollageName() 
	{
		return collageName;
	}
	public void setCollageName(String collageName) {
		this.collageName = collageName;
	}
	public int getForeignCID() {
		return foreignCID;
	}
	public void setForeignCID(int foreignCID) {
		this.foreignCID = foreignCID;
	}
	
	
}
