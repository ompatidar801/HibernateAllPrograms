package one2many7;

public class ModelsDTO 
{
	private int modelNO;
	private String modelName;
	private int foreignComID;
	
	public int getModelNO() {
		return modelNO;
	}
	public void setModelNO(int modelNO) {
		this.modelNO = modelNO;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getForeignComID() {
		return foreignComID;
	}
	public void setForeignComID(int foreignComID) {
		this.foreignComID = foreignComID;
	}
		
}
