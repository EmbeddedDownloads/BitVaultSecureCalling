package org.linphone.purchase;


import java.util.ArrayList;


public interface InAppPurchaseListener {
	/**
	 * Callback called when the in-app purchase listener is connected and available for queries
	 */
	void onServiceAvailableForQueries();
	
	/**
	 * Callback called when the query for items available for purchase is done
	 * @param items the list of items that can be purchased (also contains the ones already bought)
	 */
	void onAvailableItemsForPurchaseQueryFinished(ArrayList<Purchasable> items);
	
	/**
	 * Callback called when the query for items bought by the user is done
	 * @param items the list of items already purchased by the user
	 */
	void onPurchasedItemsQueryFinished(ArrayList<Purchasable> items);
	
	/**
	 * Callback called when the purchase has been validated by our external server
	 * @param success true if ok, false otherwise
	 */
	void onPurchasedItemConfirmationQueryFinished(boolean success);

	/**
	 * Callback called when the account has been recovered (or not)
	 * @param success true if the recover has been successful, false otherwise
	 */
	void onRecoverAccountSuccessful(boolean success);
	
	/**
	 * Callback called when the account has been activated (or not)
	 * @param success true if the activation has been successful, false otherwise
	 */
	void onActivateAccountSuccessful(boolean success);
	
	/**
	 * Callback called when an error occurred.
	 * @param error the error that occurred
	 */
	void onError(String error);
}
