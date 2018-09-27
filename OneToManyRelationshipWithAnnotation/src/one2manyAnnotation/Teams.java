package one2manyAnnotation;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Teams")
public class Teams implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="team_ID")
	private int t_id;
	
	@Column(name="Team_Name")
	private String t_name;
	
	@OneToMany(targetEntity=Players.class ,cascade=CascadeType.ALL)
	@JoinColumn(name="Team_Name" ,referencedColumnName="Team_Name")
	private Set<?> players;

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public Set<?> getPlayers() {
		return players;
	}

	public void setPlayers(Set<?> players) {
		this.players = players;
	}

	
}
