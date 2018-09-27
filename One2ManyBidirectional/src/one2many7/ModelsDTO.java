package one2many7;

public class ModelsDTO 
{
	private int modelNO;
	private String modelName;
	private MobileCompanyDTO company;
	
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
	public MobileCompanyDTO getCompany() {
		return company;
	}
	public void setCompany(MobileCompanyDTO company) {
		this.company = company;
	}
	
}
