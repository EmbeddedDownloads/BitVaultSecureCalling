package org.linphone;

/**********************************************************************
 * VVDN Technologies
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * VVDN Technologies. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with VVDN.
 ********************************************************************/
@SuppressWarnings("serial")
public class LinphoneException extends Exception {

	public LinphoneException() {}

	public LinphoneException(String detailMessage) {
		super(detailMessage);
	}

	public LinphoneException(Throwable throwable) {
		super(throwable);
	}

	public LinphoneException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}
}
