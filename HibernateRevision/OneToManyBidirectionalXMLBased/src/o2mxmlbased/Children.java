package o2mxmlbased;

import java.io.Serializable;

public class Children implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int chId;
	private String chName;
	private Father father;
	
	public Father getFather() {
		return father;
	}
	public void setFather(Father father) {
		this.father = father;
	}
	public int getChId() {
		return chId;
	}
	public void setChId(int chId) {
		this.chId = chId;
	}
	public String getChName() {
		return chName;
	}
	public void setChName(String chName) {
		this.chName = chName;
	}
	
	
}
