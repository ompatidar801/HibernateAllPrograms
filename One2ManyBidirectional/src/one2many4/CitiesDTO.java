package one2many4;

public class CitiesDTO
{
	private int cityCode;
	private String cityName;
	private CountryDTO parentObject;
	
	public CountryDTO getParentObject() {
		return parentObject;
	}
	public void setParentObject(CountryDTO parentObject) {
		this.parentObject = parentObject;
	}
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
	
}
