package manyToMany7;

import java.util.Set;

public class ModelsDTO 
{
	private int modelNO;
	private String modelName;
	private Set<?> mobCompany;
	
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
	public Set<?> getMobCompany() {
		return mobCompany;
	}
	public void setMobCompany(Set<?> mobCompany) {
		this.mobCompany = mobCompany;
	}
			
}
