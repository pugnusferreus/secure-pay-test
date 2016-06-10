package au.edu.esa.securePay;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by pugnusferreus on 10/06/2016.
 */
public class Txn {

	@XmlAttribute(name="ID")
	private String id;

	@XmlElement(name="txnType")
	private String txnType;

	@XmlElement(name="txnSource")
	private String txnSource;

	@XmlElement(name="amount")
	private int amount;

	@XmlElement(name="currency")
	private String currency;

	@XmlElement(name="purchaseOrderNo")
	private String purchaseOrderNo;

	@XmlElement(name="CreditCardInfo")
	private CreditCardInfo creditCardInfo;


	public Txn(String id,String txnType, String txnSource, int amount, String currency, String purchaseOrderNo, String cardNumber, String expiryDate, String cvv ) {
		this.id = id;
		this.txnType = txnType;
		this.txnSource = txnSource;
		this.amount = amount;
		this.currency = currency;
		this.purchaseOrderNo = purchaseOrderNo;
		this.creditCardInfo = new CreditCardInfo(cardNumber, expiryDate, cvv);

	}

	public String getId() {
		return id;
	}

	public String getTxnType() {
		return txnType;
	}

	public String getTxnSource() {
		return txnSource;
	}

	public int getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public String getPurchaseOrderNo() {
		return purchaseOrderNo;
	}

	public CreditCardInfo getCreditCardInfo() {
		return creditCardInfo;
	}


}
