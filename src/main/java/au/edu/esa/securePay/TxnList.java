package au.edu.esa.securePay;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pugnusferreus on 10/06/2016.
 */
public class TxnList {

	@XmlElement(name="Txn")
	private List<Txn> transactions = new ArrayList();

	public void add(Txn txn) {
		transactions.add(txn);
	}

	public List getTransactions() {
		return transactions;
	}

	@XmlAttribute(name="count")
	public int getCount() {
		return transactions.size();
	}


}
