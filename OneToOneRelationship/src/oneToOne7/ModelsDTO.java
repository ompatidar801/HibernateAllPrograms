package oneToOne7;

import java.util.Date;
import java.util.Set;

public class ModelsDTO 
{
	private int modelNO;
	private String modelName;
	private MobileCompanyDTO mobCompany;
	
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
	public MobileCompanyDTO getMobCompany() {
		return mobCompany;
	}
	public void setMobCompany(MobileCompanyDTO mobCompany) {
		this.mobCompany = mobCompany;
	}
	 
	
}
