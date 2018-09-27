package many2one7;

public class ModelsDTO 
{
	private int modelNO;
	private String modelName;
	private MobileCompanyDTO parentObject;
	
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
	public MobileCompanyDTO getParentObject() {
		return parentObject;
	}
	public void setParentObject(MobileCompanyDTO parentObject) {
		this.parentObject = parentObject;
	}
	
	
	
}
