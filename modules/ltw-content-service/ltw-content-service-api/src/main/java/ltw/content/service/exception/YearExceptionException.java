/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package ltw.content.service.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class YearExceptionException extends PortalException {

	public YearExceptionException() {
	}

	public YearExceptionException(String msg) {
		super(msg);
	}

	public YearExceptionException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public YearExceptionException(Throwable throwable) {
		super(throwable);
	}

}