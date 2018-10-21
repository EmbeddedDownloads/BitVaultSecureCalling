/**********************************************************************
 * VVDN Technologies
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * VVDN Technologies. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with VVDN.
 ********************************************************************/

package org.linphone;

import java.io.Serializable;

public class LinphoneNumberOrAddress implements Serializable, Comparable<LinphoneNumberOrAddress> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2301689469730072896L;
	
	private boolean isSIPAddress;
	private String value, oldValueForUpdatePurpose;
	
	public LinphoneNumberOrAddress(String v, boolean isSIP) {
		value = v;
		isSIPAddress = isSIP;
		oldValueForUpdatePurpose = null;
	}
	
	public LinphoneNumberOrAddress(String v, boolean isSip, String old) {
		this(v, isSip);
		oldValueForUpdatePurpose = old;
	}
	
	@Override
	public int compareTo(LinphoneNumberOrAddress noa) {
		if (noa.isSIPAddress() == isSIPAddress()) {
			return noa.getValue().compareTo(getValue());
		} else {
			return isSIPAddress() ? -1 : 1;
		}
	}

	public boolean isSIPAddress() {
		return isSIPAddress;
	}
	
	public String getOldValue() {
		return oldValueForUpdatePurpose;
	}

	public void setOldValue(String v) {
		oldValueForUpdatePurpose = v;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String v) {
		value = v;
	}
}
