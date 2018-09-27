package oneToOne2;

public class CollagesDTO 
{
	private int collageId;
	private String collageName;
	private UnivercityDTO univer;
	
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
	public UnivercityDTO getUniver() {
		return univer;
	}
	public void setUniver(UnivercityDTO univer) {
		this.univer = univer;
	}
	
}
