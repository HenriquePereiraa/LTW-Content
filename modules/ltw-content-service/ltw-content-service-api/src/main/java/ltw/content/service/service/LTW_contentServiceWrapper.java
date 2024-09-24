/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ltw.content.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LTW_contentService}.
 *
 * @author Brian Wing Shun Chan
 * @see LTW_contentService
 * @generated
 */
public class LTW_contentServiceWrapper
	implements LTW_contentService, ServiceWrapper<LTW_contentService> {

	public LTW_contentServiceWrapper() {
		this(null);
	}

	public LTW_contentServiceWrapper(LTW_contentService ltw_contentService) {
		_ltw_contentService = ltw_contentService;
	}

	@Override
	public ltw.content.service.model.LTW_content addLTW_content(
			String motorcycleName, String motorcycleManufacturing,
			int motorcycleYear)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ltw_contentService.addLTW_content(
			motorcycleName, motorcycleManufacturing, motorcycleYear);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ltw_contentService.getOSGiServiceIdentifier();
	}

	@Override
	public LTW_contentService getWrappedService() {
		return _ltw_contentService;
	}

	@Override
	public void setWrappedService(LTW_contentService ltw_contentService) {
		_ltw_contentService = ltw_contentService;
	}

	private LTW_contentService _ltw_contentService;

}