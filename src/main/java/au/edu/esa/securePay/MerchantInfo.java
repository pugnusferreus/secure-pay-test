package au.edu.esa.securePay;

/**
 * Created by pugnusferreus on 10/06/2016.
 */
public class MerchantInfo {

	private String merchantID;
	private String password;

	public String getMerchantID() {
		return merchantID;
	}

	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
