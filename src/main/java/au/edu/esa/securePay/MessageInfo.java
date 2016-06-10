package au.edu.esa.securePay;

import javax.xml.bind.annotation.XmlElement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pugnusferreus on 10/06/2016.
 */
public class MessageInfo {
	private String messageID;
	private Date messageTimestamp;
	private int timeoutValue;
	private final String apiVersion = "xml-4.2";

	private final DateFormat df = new SimpleDateFormat("YYYYMMddHHmmssSS000");
	private final DateFormat tz = new SimpleDateFormat("Z");

	public String getMessageID() {
		return messageID;
	}


	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

	@XmlElement(name="messageTimestamp")
	public String getMessageTimestamp() {
		// since the api requires in minute, I cbf to do a proper conversion.
		Integer timeZoneInHour = Integer.parseInt(tz.format(messageTimestamp));
		timeZoneInHour = (timeZoneInHour / 100) * 60;
		return df.format(messageTimestamp) + "+" + timeZoneInHour;
	}

	public void setMessageTimestamp(Date messageTimestamp) {
		this.messageTimestamp = messageTimestamp;
	}

	public int getTimeoutValue() {
		return timeoutValue;
	}

	public void setTimeoutValue(int timeoutValue) {
		this.timeoutValue = timeoutValue;
	}

	@XmlElement(name="apiVersion")
	public String getApiVersion() {
		return apiVersion;
	}
}
