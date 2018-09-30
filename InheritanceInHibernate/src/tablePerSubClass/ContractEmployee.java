package tablePerSubClass;

public class ContractEmployee extends Employee
{
	private float pay_per_hours;
	private String concrate_period;
	
	public float getPay_per_hours() {
		return pay_per_hours;
	}
	public void setPay_per_hours(float pay_per_hours) {
		this.pay_per_hours = pay_per_hours;
	}
	public String getConcrate_period() {
		return concrate_period;
	}
	public void setConcrate_period(String concrate_period) {
		this.concrate_period = concrate_period;
	}
	
}
