package many2manyAnnotation;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="persons")
public class Persons implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="perID")
	private int perid;
	
	@Column(name="perName")
	private String pername;
	
	@Column(name="perAdd")
	private String peradd;

	@ManyToMany(targetEntity=Mobiles.class,cascade=CascadeType.ALL)
	@JoinTable(name="persons_mobiles",joinColumns=@JoinColumn(name="FKperID" , referencedColumnName="perID"),inverseJoinColumns=@JoinColumn(name="FKmobID" ,referencedColumnName="mobID"))
	private Set<?> mobile;
	
	
	public Set<?> getMobile() {
		return mobile;
	}

	public void setMobile(Set<?> mobile) {
		this.mobile = mobile;
	}

	public int getPerid() {
		return perid;
	}

	public void setPerid(int perid) {
		this.perid = perid;
	}

	public String getPername() {
		return pername;
	}

	public void setPername(String pername) {
		this.pername = pername;
	}

	public String getPeradd() {
		return peradd;
	}

	public void setPeradd(String peradd) {
		this.peradd = peradd;
	}
	
	
}
