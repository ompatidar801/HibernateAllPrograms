package one2many;

import java.util.Set;

public class VendorDTO 
{
	private int vid;
	private String vname ;
	private Set children ;
	public int getVid() 
	{
		return vid;
	}
	public void setVid(int vid) 
	{
		this.vid = vid;
	}
	public String getVname() 
	{
		return vname;
	}
	public void setVname(String vname) 
	{
		this.vname = vname;
	}
	public Set getChildren() 
	{
		return children;
	}
	public void setChildren(Set children) 
	{
		this.children = children;
	}

}
