package org.linphone.iclasses;

/**
 * Web API Response Helper
 */
public interface WebAPIResponseListener {
	/**
	 * On Success of API Call
	 * 
	 * @param arguments
	 */
	void onSuccessOfResponse(String arguments);

	/**
	 * on Fail of API Call
	 * 
	 * @param arguments
	 */
	void onFailOfResponse(String arguments);

}
