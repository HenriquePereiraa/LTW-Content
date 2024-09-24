/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ltw.content.service.service;

import com.liferay.portal.kernel.exception.PortalException;

import ltw.content.service.model.LTW_content;

/**
 * Provides the remote service utility for LTW_content. This utility wraps
 * <code>ltw.content.service.service.impl.LTW_contentServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see LTW_contentService
 * @generated
 */
public class LTW_contentServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>ltw.content.service.service.impl.LTW_contentServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static LTW_content addLTW_content(
			String motorcycleName, String motorcycleManufacturing,
			int motorcycleYear)
		throws PortalException {

		return getService().addLTW_content(
			motorcycleName, motorcycleManufacturing, motorcycleYear);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static LTW_contentService getService() {
		return _service;
	}

	public static void setService(LTW_contentService service) {
		_service = service;
	}

	private static volatile LTW_contentService _service;

}