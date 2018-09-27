package one2many3;

public class CollagesDTO 
{
	private int collageId;
	private String collageName;
	private UnivercityDTO parentObject;
	
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

	public UnivercityDTO getParentObject() {
		return parentObject;
	}
	public void setParentObject(UnivercityDTO parentObject) {
		this.parentObject = parentObject;
	}
	
	
}
