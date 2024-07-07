/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package ltw.content.service.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchLTW_contentException extends NoSuchModelException {

	public NoSuchLTW_contentException() {
	}

	public NoSuchLTW_contentException(String msg) {
		super(msg);
	}

	public NoSuchLTW_contentException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchLTW_contentException(Throwable throwable) {
		super(throwable);
	}

}