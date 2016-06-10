package au.edu.esa.securePay;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by pugnusferreus on 10/06/2016.
 */
public class CreditCardInfo {
	@XmlElement(name="cardNumber")
	private String cardNumber;
	@XmlElement(name="expiryDate")
	private String expiryDate;
	@XmlElement(name="cvv")
	private String cvv;

	public CreditCardInfo(String cardNumber, String expiryDate, String cvv) {
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public String getCvv() {
		return cvv;
	}
}
