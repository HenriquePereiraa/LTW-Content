/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ltw.content.service.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import ltw.content.service.model.LTW_content;

/**
 * Provides the local service utility for LTW_content. This utility wraps
 * <code>ltw.content.service.service.impl.LTW_contentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LTW_contentLocalService
 * @generated
 */
public class LTW_contentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>ltw.content.service.service.impl.LTW_contentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the ltw_content to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LTW_contentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ltw_content the ltw_content
	 * @return the ltw_content that was added
	 */
	public static LTW_content addLTW_content(LTW_content ltw_content) {
		return getService().addLTW_content(ltw_content);
	}

	public static LTW_content addLTW_content(
		String motorcycleName, String motorcycleManufacturing,
		int motorcycleYear) {

		return getService().addLTW_content(
			motorcycleName, motorcycleManufacturing, motorcycleYear);
	}

	/**
	 * Creates a new ltw_content with the primary key. Does not add the ltw_content to the database.
	 *
	 * @param ltwId the primary key for the new ltw_content
	 * @return the new ltw_content
	 */
	public static LTW_content createLTW_content(long ltwId) {
		return getService().createLTW_content(ltwId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the ltw_content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LTW_contentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ltwId the primary key of the ltw_content
	 * @return the ltw_content that was removed
	 * @throws PortalException if a ltw_content with the primary key could not be found
	 */
	public static LTW_content deleteLTW_content(long ltwId)
		throws PortalException {

		return getService().deleteLTW_content(ltwId);
	}

	/**
	 * Deletes the ltw_content from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LTW_contentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ltw_content the ltw_content
	 * @return the ltw_content that was removed
	 */
	public static LTW_content deleteLTW_content(LTW_content ltw_content) {
		return getService().deleteLTW_content(ltw_content);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ltw.content.service.model.impl.LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ltw.content.service.model.impl.LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static LTW_content fetchLTW_content(long ltwId) {
		return getService().fetchLTW_content(ltwId);
	}

	/**
	 * Returns the ltw_content matching the UUID and group.
	 *
	 * @param uuid the ltw_content's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public static LTW_content fetchLTW_contentByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchLTW_contentByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<LTW_content> getAllLTW_Contents() {
		return getService().getAllLTW_Contents();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the ltw_content with the primary key.
	 *
	 * @param ltwId the primary key of the ltw_content
	 * @return the ltw_content
	 * @throws PortalException if a ltw_content with the primary key could not be found
	 */
	public static LTW_content getLTW_content(long ltwId)
		throws PortalException {

		return getService().getLTW_content(ltwId);
	}

	/**
	 * Returns the ltw_content matching the UUID and group.
	 *
	 * @param uuid the ltw_content's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ltw_content
	 * @throws PortalException if a matching ltw_content could not be found
	 */
	public static LTW_content getLTW_contentByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getLTW_contentByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the ltw_contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ltw.content.service.model.impl.LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @return the range of ltw_contents
	 */
	public static List<LTW_content> getLTW_contents(int start, int end) {
		return getService().getLTW_contents(start, end);
	}

	/**
	 * Returns all the ltw_contents matching the UUID and company.
	 *
	 * @param uuid the UUID of the ltw_contents
	 * @param companyId the primary key of the company
	 * @return the matching ltw_contents, or an empty list if no matches were found
	 */
	public static List<LTW_content> getLTW_contentsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getLTW_contentsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of ltw_contents matching the UUID and company.
	 *
	 * @param uuid the UUID of the ltw_contents
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching ltw_contents, or an empty list if no matches were found
	 */
	public static List<LTW_content> getLTW_contentsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LTW_content> orderByComparator) {

		return getService().getLTW_contentsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of ltw_contents.
	 *
	 * @return the number of ltw_contents
	 */
	public static int getLTW_contentsCount() {
		return getService().getLTW_contentsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static LTW_content updateLTW_content(
			long ltwId, LTW_content ltw_content)
		throws PortalException {

		return getService().updateLTW_content(ltwId, ltw_content);
	}

	/**
	 * Updates the ltw_content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LTW_contentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ltw_content the ltw_content
	 * @return the ltw_content that was updated
	 */
	public static LTW_content updateLTW_content(LTW_content ltw_content) {
		return getService().updateLTW_content(ltw_content);
	}

	public static LTW_contentLocalService getService() {
		return _service;
	}

	public static void setService(LTW_contentLocalService service) {
		_service = service;
	}

	private static volatile LTW_contentLocalService _service;

}