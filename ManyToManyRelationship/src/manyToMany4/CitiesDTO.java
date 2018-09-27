package manyToMany4;

import java.util.Set;

public class CitiesDTO
{
	private int cityCode;
	private String cityName;
	private Set country;
	
	public int getCityCode() {
		return cityCode;
	}
	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Set getCountry() {
		return country;
	}
	public void setCountry(Set country) {
		this.country = country;
	}
	
}
