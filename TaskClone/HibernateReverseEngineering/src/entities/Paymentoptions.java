package entities;
// Generated Feb 20, 2018 6:22:04 PM by Hibernate Tools 5.1.0.Alpha1

/**
 * Paymentoptions generated by hbm2java
 */
public class Paymentoptions implements java.io.Serializable {

	private int payOptionsId;
	private Integer cvvno;
	private Integer payId;
	private String bank;
	private String checkNo;
	private String creaditCardNo;

	public Paymentoptions() {
	}

	public Paymentoptions(int payOptionsId) {
		this.payOptionsId = payOptionsId;
	}

	public Paymentoptions(int payOptionsId, Integer cvvno, Integer payId, String bank, String checkNo,
			String creaditCardNo) {
		this.payOptionsId = payOptionsId;
		this.cvvno = cvvno;
		this.payId = payId;
		this.bank = bank;
		this.checkNo = checkNo;
		this.creaditCardNo = creaditCardNo;
	}

	public int getPayOptionsId() {
		return this.payOptionsId;
	}

	public void setPayOptionsId(int payOptionsId) {
		this.payOptionsId = payOptionsId;
	}

	public Integer getCvvno() {
		return this.cvvno;
	}

	public void setCvvno(Integer cvvno) {
		this.cvvno = cvvno;
	}

	public Integer getPayId() {
		return this.payId;
	}

	public void setPayId(Integer payId) {
		this.payId = payId;
	}

	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getCheckNo() {
		return this.checkNo;
	}

	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	}

	public String getCreaditCardNo() {
		return this.creaditCardNo;
	}

	public void setCreaditCardNo(String creaditCardNo) {
		this.creaditCardNo = creaditCardNo;
	}

}
