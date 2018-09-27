package many2manyAnnotation;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="mobiles")
public class Mobiles implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mobID")
	private int modid;
	
	@Column(name="mobName")
	private String mobname;
	
	@Column(name="models")
	private String models;

	@ManyToMany(targetEntity=Persons.class ,mappedBy="mobile")
	private Set<?> person;
	
	
	public Set<?> getPerson() {
		return person;
	}

	public void setPerson(Set<?> person) {
		this.person = person;
	}

	public int getModid() {
		return modid;
	}

	public void setModid(int modid) {
		this.modid = modid;
	}

	public String getMobname() {
		return mobname;
	}

	public void setMobname(String mobname) {
		this.mobname = mobname;
	}

	public String getModels() {
		return models;
	}

	public void setModels(String models) {
		this.models = models;
	}
	
	
}
