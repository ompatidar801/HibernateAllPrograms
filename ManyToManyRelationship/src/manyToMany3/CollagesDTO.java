package manyToMany3;

import java.util.Set;

public class CollagesDTO 
{
	private int collageId;
	private String collageName;
	private Set univercity;
	
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
	public Set getUnivercity() {
		return univercity;
	}
	public void setUnivercity(Set univercity) {
		this.univercity = univercity;
	}
	
	
	
}
