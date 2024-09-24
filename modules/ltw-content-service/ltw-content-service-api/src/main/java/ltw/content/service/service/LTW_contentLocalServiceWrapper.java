/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ltw.content.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link LTW_contentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LTW_contentLocalService
 * @generated
 */
public class LTW_contentLocalServiceWrapper
	implements LTW_contentLocalService,
			   ServiceWrapper<LTW_contentLocalService> {

	public LTW_contentLocalServiceWrapper() {
		this(null);
	}

	public LTW_contentLocalServiceWrapper(
		LTW_contentLocalService ltw_contentLocalService) {

		_ltw_contentLocalService = ltw_contentLocalService;
	}

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
	@Override
	public ltw.content.service.model.LTW_content addLTW_content(
		ltw.content.service.model.LTW_content ltw_content) {

		return _ltw_contentLocalService.addLTW_content(ltw_content);
	}

	@Override
	public ltw.content.service.model.LTW_content addLTW_content(
		String motorcycleName, String motorcycleManufacturing,
		int motorcycleYear) {

		return _ltw_contentLocalService.addLTW_content(
			motorcycleName, motorcycleManufacturing, motorcycleYear);
	}

	/**
	 * Creates a new ltw_content with the primary key. Does not add the ltw_content to the database.
	 *
	 * @param ltwId the primary key for the new ltw_content
	 * @return the new ltw_content
	 */
	@Override
	public ltw.content.service.model.LTW_content createLTW_content(long ltwId) {
		return _ltw_contentLocalService.createLTW_content(ltwId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ltw_contentLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public ltw.content.service.model.LTW_content deleteLTW_content(long ltwId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ltw_contentLocalService.deleteLTW_content(ltwId);
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
	@Override
	public ltw.content.service.model.LTW_content deleteLTW_content(
		ltw.content.service.model.LTW_content ltw_content) {

		return _ltw_contentLocalService.deleteLTW_content(ltw_content);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ltw_contentLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _ltw_contentLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _ltw_contentLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ltw_contentLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _ltw_contentLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _ltw_contentLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _ltw_contentLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _ltw_contentLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _ltw_contentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public ltw.content.service.model.LTW_content fetchLTW_content(long ltwId) {
		return _ltw_contentLocalService.fetchLTW_content(ltwId);
	}

	/**
	 * Returns the ltw_content matching the UUID and group.
	 *
	 * @param uuid the ltw_content's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	@Override
	public ltw.content.service.model.LTW_content
		fetchLTW_contentByUuidAndGroupId(String uuid, long groupId) {

		return _ltw_contentLocalService.fetchLTW_contentByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ltw_contentLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<ltw.content.service.model.LTW_content>
		getAllLTW_Contents() {

		return _ltw_contentLocalService.getAllLTW_Contents();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _ltw_contentLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ltw_contentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the ltw_content with the primary key.
	 *
	 * @param ltwId the primary key of the ltw_content
	 * @return the ltw_content
	 * @throws PortalException if a ltw_content with the primary key could not be found
	 */
	@Override
	public ltw.content.service.model.LTW_content getLTW_content(long ltwId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ltw_contentLocalService.getLTW_content(ltwId);
	}

	/**
	 * Returns the ltw_content matching the UUID and group.
	 *
	 * @param uuid the ltw_content's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ltw_content
	 * @throws PortalException if a matching ltw_content could not be found
	 */
	@Override
	public ltw.content.service.model.LTW_content getLTW_contentByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ltw_contentLocalService.getLTW_contentByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<ltw.content.service.model.LTW_content>
		getLTW_contents(int start, int end) {

		return _ltw_contentLocalService.getLTW_contents(start, end);
	}

	/**
	 * Returns all the ltw_contents matching the UUID and company.
	 *
	 * @param uuid the UUID of the ltw_contents
	 * @param companyId the primary key of the company
	 * @return the matching ltw_contents, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<ltw.content.service.model.LTW_content>
		getLTW_contentsByUuidAndCompanyId(String uuid, long companyId) {

		return _ltw_contentLocalService.getLTW_contentsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<ltw.content.service.model.LTW_content>
		getLTW_contentsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<ltw.content.service.model.LTW_content> orderByComparator) {

		return _ltw_contentLocalService.getLTW_contentsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of ltw_contents.
	 *
	 * @return the number of ltw_contents
	 */
	@Override
	public int getLTW_contentsCount() {
		return _ltw_contentLocalService.getLTW_contentsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ltw_contentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ltw_contentLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public ltw.content.service.model.LTW_content updateLTW_content(
			long ltwId, ltw.content.service.model.LTW_content ltw_content)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ltw_contentLocalService.updateLTW_content(ltwId, ltw_content);
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
	@Override
	public ltw.content.service.model.LTW_content updateLTW_content(
		ltw.content.service.model.LTW_content ltw_content) {

		return _ltw_contentLocalService.updateLTW_content(ltw_content);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _ltw_contentLocalService.getBasePersistence();
	}

	@Override
	public LTW_contentLocalService getWrappedService() {
		return _ltw_contentLocalService;
	}

	@Override
	public void setWrappedService(
		LTW_contentLocalService ltw_contentLocalService) {

		_ltw_contentLocalService = ltw_contentLocalService;
	}

	private LTW_contentLocalService _ltw_contentLocalService;

}