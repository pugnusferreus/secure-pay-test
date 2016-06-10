package au.edu.esa.securePay;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.Date;

/**
 * Created by pugnusferreus on 9/06/2016.
 */
public class Test {

	public static void main(String[] args) throws Exception {

		MessageInfo messageInfo = new MessageInfo();
		messageInfo.setMessageID("some-scisid-1");
		messageInfo.setMessageTimestamp(new Date(System.currentTimeMillis()));
		messageInfo.setTimeoutValue(60);

		MerchantInfo merchantInfo = new MerchantInfo();
		merchantInfo.setMerchantID("ABC0001");
		merchantInfo.setPassword("abc123");

		TxnList txnList = new TxnList();
		txnList.add(new Txn("1", "0", "23", 200, "AUD", "po-1", "4444333322221111", "09/10", "000"));
		//txnList.add(new Txn("2", "0", "23", 300, "AUD", "po-2", "1234", "09/10", "000"));

		Payment payment = new Payment(txnList);
		SecurePayMessage securePayMessage = new SecurePayMessage(messageInfo, merchantInfo, "Payment", payment);

		JAXBContext jaxbContext = JAXBContext.newInstance(SecurePayMessage.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		StringWriter writer = new StringWriter();
		jaxbMarshaller.marshal(securePayMessage, writer);

		System.out.println(writer.toString());

		String xml = writer.toString();
//		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <SecurePayMessage>\n" +
//				"<MessageInfo> <messageID>some-scisid-1</messageID> <messageTimestamp>20162201115745000000+660</messageTimestamp> <timeoutValue>60</timeoutValue> <apiVersion>xml-4.2</apiVersion>\n" +
//				"             </MessageInfo>\n" +
//				"             <MerchantInfo>\n" +
//				"<merchantID>ABC0001</merchantID>\n" +
//				"<password>abc123</password> </MerchantInfo>\n" +
//				"<RequestType>Payment</RequestType> <Payment>\n" +
//				"                 <TxnList count=\"1\">\n" +
//				"                     <Txn ID=\"1\">\n" +
//				"<txnType>0</txnType> <txnSource>23</txnSource> <amount>200</amount> <currency>AUD</currency> <purchaseOrderNo>test</purchaseOrderNo> <CreditCardInfo>\n" +
//				"<cardNumber>4444333322221111</cardNumber> <expiryDate>09/10</expiryDate> <cvv>000</cvv>\n" +
//				"                         </CreditCardInfo>\n" +
//				"                     </Txn>\n" +
//				"                 </TxnList>\n" +
//				"             </Payment>\n" +
//				"         </SecurePayMessage>";

		String url = "https://test.securepay.com.au/xmlapi/payment";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		con.setRequestMethod("POST");


		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(xml);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'POST' request to URL : " + url);
		//System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);


		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
	}

}
