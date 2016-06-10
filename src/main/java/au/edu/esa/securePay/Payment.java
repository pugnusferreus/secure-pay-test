package au.edu.esa.securePay;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by pugnusferreus on 10/06/2016.
 */
public class Payment {

	@XmlElement(name="TxnList")
	private TxnList txnList;


	public Payment() {
		this.txnList = new TxnList();
	}

	public Payment(TxnList txnList) {
		this.txnList = txnList;
	}


	public TxnList getTxnList() {
		return txnList;
	}
}
