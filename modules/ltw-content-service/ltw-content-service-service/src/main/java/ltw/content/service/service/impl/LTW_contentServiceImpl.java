/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ltw.content.service.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import ltw.content.service.model.LTW_content;
import ltw.content.service.service.LTW_contentLocalService;
import ltw.content.service.service.base.LTW_contentServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=ltw_content",
		"json.web.service.context.path=LTW_content"
	},
	service = AopService.class
)
public class LTW_contentServiceImpl extends LTW_contentServiceBaseImpl {

	public LTW_content addLTW_content(String motorcycleName, String motorcycleManufacturing, int motorcycleYear) throws PortalException {
		_modelResourcePermission.check(
				getPermissionChecker(), null, ActionKeys.ADD_ENTRY
		);

		return _ltwContentLocalService.addLTW_content(motorcycleName, motorcycleManufacturing, motorcycleYear);
	}

	@Reference
	LTW_contentLocalService _ltwContentLocalService;

	ModelResourcePermission<LTW_content>
		_modelResourcePermission;

}