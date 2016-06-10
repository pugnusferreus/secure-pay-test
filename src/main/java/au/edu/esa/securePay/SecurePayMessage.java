package au.edu.esa.securePay;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by pugnusferreus on 10/06/2016.
 */
@XmlRootElement(name="SecurePayMessage")
public class SecurePayMessage {

	@XmlElement(name="MessageInfo")
	private MessageInfo messageInfo;

	@XmlElement(name="MerchantInfo")
	private MerchantInfo merchantInfo;

	@XmlElement(name="RequestType")
	private String requestType;

	@XmlElement(name="Payment")
	private Payment payment;

	public SecurePayMessage() {
		this.merchantInfo = new MerchantInfo();
		this.messageInfo = new MessageInfo();
		this.requestType = "Payment";
		this.payment = new Payment();
	}

	public SecurePayMessage(MessageInfo messageInfo, MerchantInfo merchantInfo, String requestType, Payment payment) {
		this.messageInfo = messageInfo;
		this.merchantInfo = merchantInfo;
		this.requestType = requestType;
		this.payment = payment;
	}

	public MessageInfo getMessageInfo() {
		return messageInfo;
	}

	public MerchantInfo getMerchantInfo() {
		return merchantInfo;
	}

	public String getRequestType() {
		return requestType;
	}

	public Payment getPayment() {
		return payment;
	}
}
