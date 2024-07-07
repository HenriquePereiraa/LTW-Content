/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ltw.content.service.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import ltw.content.service.model.LTW_content;
import ltw.content.service.service.base.LTW_contentLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=ltw.content.service.model.LTW_content",
	service = AopService.class
)
public class LTW_contentLocalServiceImpl
	extends LTW_contentLocalServiceBaseImpl {

	@Override
	public LTW_content addLTW_content(LTW_content ltw_content, String motorcycleName, String motorcycleManufacturing, int motorcycleYear) {
		// Fetch the current service context
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		// Generate a unique ID for the new content
		long contentId = counterLocalService.increment(LTW_content.class.getName());

		// Set the primary key for the new content
		ltw_content.setPrimaryKey(contentId);

        try {
			long userId = serviceContext.getUserId();
            User user = UserLocalServiceUtil.getUser(userId);

			ltw_content.setUserId(userId);
			ltw_content.setUserName(user.getFullName());
			ltw_content.setCreateDate(serviceContext.getCreateDate(new Date()));
			ltw_content.setModifiedDate(serviceContext.getModifiedDate(new Date()));

			ltw_content.setNew(true);
			ltw_content.setExpandoBridgeAttributes(serviceContext);

			ltw_content.setMotorcycleName(motorcycleName);
			ltw_content.setMotorcycleManufacturing(motorcycleManufacturing);
			ltw_content.setMotorcycleYear(motorcycleYear);

			// Persist the new content
			ltw_content = ltw_contentPersistence.update(ltw_content);


			// Notify model listeners
			resourceLocalService.addResources(ltw_content.getCompanyId(),ltw_content.getGroupId(),ltw_content.getUserId(),
					LTW_content.class.getName(), ltw_content.getLtwId(), false, true, true);

			return ltw_content;

        } catch (PortalException e) {
            throw new RuntimeException(e);
        }
	}

	@Override
	public LTW_content getLTW_content(long ltwId) throws PortalException {
		return super.getLTW_content(ltwId);
	}
}