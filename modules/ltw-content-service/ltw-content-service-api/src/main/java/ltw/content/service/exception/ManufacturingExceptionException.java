/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package ltw.content.service.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class ManufacturingExceptionException extends PortalException {

	public ManufacturingExceptionException() {
	}

	public ManufacturingExceptionException(String msg) {
		super(msg);
	}

	public ManufacturingExceptionException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public ManufacturingExceptionException(Throwable throwable) {
		super(throwable);
	}

}