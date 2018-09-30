package entities;
// Generated Feb 20, 2018 6:52:46 PM by Hibernate Tools 5.1.0.Alpha1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Offers generated by hbm2java
 */
@Entity
@Table(name = "offers", catalog = "HibernateTask")
public class Offers implements java.io.Serializable {

	private int offerId;
	private Double basePrice;
	private Double offersPrice;
	private Integer prodId;

	public Offers() {
	}

	public Offers(int offerId) {
		this.offerId = offerId;
	}

	public Offers(int offerId, Double basePrice, Double offersPrice, Integer prodId) {
		this.offerId = offerId;
		this.basePrice = basePrice;
		this.offersPrice = offersPrice;
		this.prodId = prodId;
	}

	@Id

	@Column(name = "offerID", unique = true, nullable = false)
	public int getOfferId() {
		return this.offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	@Column(name = "BasePrice", precision = 22, scale = 0)
	public Double getBasePrice() {
		return this.basePrice;
	}

	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}

	@Column(name = "offersPrice", precision = 22, scale = 0)
	public Double getOffersPrice() {
		return this.offersPrice;
	}

	public void setOffersPrice(Double offersPrice) {
		this.offersPrice = offersPrice;
	}

	@Column(name = "prod_ID")
	public Integer getProdId() {
		return this.prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

}