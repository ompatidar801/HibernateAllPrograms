package one2many4;

public class CitiesDTO
{
	private int cityCode;
	private String cityName;
	private int foreignCityID;
	
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
	public int getForeignCityID() {
		return foreignCityID;
	}
	public void setForeignCityID(int foreignCityID) {
		this.foreignCityID = foreignCityID;
	}
	
	
}
