package one2many4;

import java.util.Set;

public class CountryDTO
{
	private int countryCode;
	private String countryName;
	private Set<?> cities;
	
	public int getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public Set<?> getCities() {
		return cities;
	}
	public void setCities(Set<?> cities) {
		this.cities = cities;
	}
	
	
}
