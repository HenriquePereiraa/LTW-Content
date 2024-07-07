/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ltw.content.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import ltw.content.service.model.LTW_content;

/**
 * The persistence utility for the ltw_content service. This utility wraps <code>ltw.content.service.service.persistence.impl.LTW_contentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LTW_contentPersistence
 * @generated
 */
public class LTW_contentUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(LTW_content ltw_content) {
		getPersistence().clearCache(ltw_content);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, LTW_content> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LTW_content> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LTW_content> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LTW_content> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LTW_content update(LTW_content ltw_content) {
		return getPersistence().update(ltw_content);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LTW_content update(
		LTW_content ltw_content, ServiceContext serviceContext) {

		return getPersistence().update(ltw_content, serviceContext);
	}

	/**
	 * Returns all the ltw_contents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ltw_contents
	 */
	public static List<LTW_content> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the ltw_contents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @return the range of matching ltw_contents
	 */
	public static List<LTW_content> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the ltw_contents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ltw_contents
	 */
	public static List<LTW_content> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ltw_contents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ltw_contents
	 */
	public static List<LTW_content> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LTW_content> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ltw_content in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public static LTW_content findByUuid_First(
			String uuid, OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first ltw_content in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public static LTW_content fetchByUuid_First(
		String uuid, OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last ltw_content in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public static LTW_content findByUuid_Last(
			String uuid, OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last ltw_content in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public static LTW_content fetchByUuid_Last(
		String uuid, OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the ltw_contents before and after the current ltw_content in the ordered set where uuid = &#63;.
	 *
	 * @param ltwId the primary key of the current ltw_content
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ltw_content
	 * @throws NoSuch_contentException if a ltw_content with the primary key could not be found
	 */
	public static LTW_content[] findByUuid_PrevAndNext(
			long ltwId, String uuid,
			OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByUuid_PrevAndNext(
			ltwId, uuid, orderByComparator);
	}

	/**
	 * Removes all the ltw_contents where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of ltw_contents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ltw_contents
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the ltw_content where uuid = &#63; and groupId = &#63; or throws a <code>NoSuch_contentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public static LTW_content findByUUID_G(String uuid, long groupId)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ltw_content where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public static LTW_content fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ltw_content where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public static LTW_content fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the ltw_content where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ltw_content that was removed
	 */
	public static LTW_content removeByUUID_G(String uuid, long groupId)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of ltw_contents where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ltw_contents
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the ltw_contents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ltw_contents
	 */
	public static List<LTW_content> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the ltw_contents where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @return the range of matching ltw_contents
	 */
	public static List<LTW_content> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the ltw_contents where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ltw_contents
	 */
	public static List<LTW_content> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ltw_contents where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ltw_contents
	 */
	public static List<LTW_content> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LTW_content> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ltw_content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public static LTW_content findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first ltw_content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public static LTW_content fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last ltw_content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public static LTW_content findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last ltw_content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public static LTW_content fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the ltw_contents before and after the current ltw_content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param ltwId the primary key of the current ltw_content
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ltw_content
	 * @throws NoSuch_contentException if a ltw_content with the primary key could not be found
	 */
	public static LTW_content[] findByUuid_C_PrevAndNext(
			long ltwId, String uuid, long companyId,
			OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByUuid_C_PrevAndNext(
			ltwId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the ltw_contents where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of ltw_contents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ltw_contents
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the ltw_contents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching ltw_contents
	 */
	public static List<LTW_content> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the ltw_contents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @return the range of matching ltw_contents
	 */
	public static List<LTW_content> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the ltw_contents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ltw_contents
	 */
	public static List<LTW_content> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ltw_contents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ltw_contents
	 */
	public static List<LTW_content> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LTW_content> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ltw_content in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public static LTW_content findByGroupId_First(
			long groupId, OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first ltw_content in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public static LTW_content fetchByGroupId_First(
		long groupId, OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last ltw_content in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public static LTW_content findByGroupId_Last(
			long groupId, OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last ltw_content in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public static LTW_content fetchByGroupId_Last(
		long groupId, OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the ltw_contents before and after the current ltw_content in the ordered set where groupId = &#63;.
	 *
	 * @param ltwId the primary key of the current ltw_content
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ltw_content
	 * @throws NoSuch_contentException if a ltw_content with the primary key could not be found
	 */
	public static LTW_content[] findByGroupId_PrevAndNext(
			long ltwId, long groupId,
			OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByGroupId_PrevAndNext(
			ltwId, groupId, orderByComparator);
	}

	/**
	 * Removes all the ltw_contents where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of ltw_contents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching ltw_contents
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the ltw_contents where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching ltw_contents
	 */
	public static List<LTW_content> findByCompanyId(long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	 * Returns a range of all the ltw_contents where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @return the range of matching ltw_contents
	 */
	public static List<LTW_content> findByCompanyId(
		long companyId, int start, int end) {

		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the ltw_contents where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ltw_contents
	 */
	public static List<LTW_content> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ltw_contents where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ltw_contents
	 */
	public static List<LTW_content> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<LTW_content> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ltw_content in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public static LTW_content findByCompanyId_First(
			long companyId, OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first ltw_content in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public static LTW_content fetchByCompanyId_First(
		long companyId, OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().fetchByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last ltw_content in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public static LTW_content findByCompanyId_Last(
			long companyId, OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last ltw_content in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public static LTW_content fetchByCompanyId_Last(
		long companyId, OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().fetchByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the ltw_contents before and after the current ltw_content in the ordered set where companyId = &#63;.
	 *
	 * @param ltwId the primary key of the current ltw_content
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ltw_content
	 * @throws NoSuch_contentException if a ltw_content with the primary key could not be found
	 */
	public static LTW_content[] findByCompanyId_PrevAndNext(
			long ltwId, long companyId,
			OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByCompanyId_PrevAndNext(
			ltwId, companyId, orderByComparator);
	}

	/**
	 * Removes all the ltw_contents where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	 * Returns the number of ltw_contents where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching ltw_contents
	 */
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	 * Returns all the ltw_contents where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching ltw_contents
	 */
	public static List<LTW_content> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the ltw_contents where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @return the range of matching ltw_contents
	 */
	public static List<LTW_content> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the ltw_contents where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ltw_contents
	 */
	public static List<LTW_content> findByUserId(
		long userId, int start, int end,
		OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ltw_contents where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ltw_contents
	 */
	public static List<LTW_content> findByUserId(
		long userId, int start, int end,
		OrderByComparator<LTW_content> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ltw_content in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public static LTW_content findByUserId_First(
			long userId, OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first ltw_content in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public static LTW_content fetchByUserId_First(
		long userId, OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last ltw_content in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public static LTW_content findByUserId_Last(
			long userId, OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last ltw_content in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public static LTW_content fetchByUserId_Last(
		long userId, OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the ltw_contents before and after the current ltw_content in the ordered set where userId = &#63;.
	 *
	 * @param ltwId the primary key of the current ltw_content
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ltw_content
	 * @throws NoSuch_contentException if a ltw_content with the primary key could not be found
	 */
	public static LTW_content[] findByUserId_PrevAndNext(
			long ltwId, long userId,
			OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByUserId_PrevAndNext(
			ltwId, userId, orderByComparator);
	}

	/**
	 * Removes all the ltw_contents where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of ltw_contents where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching ltw_contents
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the ltw_contents where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the matching ltw_contents
	 */
	public static List<LTW_content> findByUserName(String userName) {
		return getPersistence().findByUserName(userName);
	}

	/**
	 * Returns a range of all the ltw_contents where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @return the range of matching ltw_contents
	 */
	public static List<LTW_content> findByUserName(
		String userName, int start, int end) {

		return getPersistence().findByUserName(userName, start, end);
	}

	/**
	 * Returns an ordered range of all the ltw_contents where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ltw_contents
	 */
	public static List<LTW_content> findByUserName(
		String userName, int start, int end,
		OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().findByUserName(
			userName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ltw_contents where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ltw_contents
	 */
	public static List<LTW_content> findByUserName(
		String userName, int start, int end,
		OrderByComparator<LTW_content> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserName(
			userName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ltw_content in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public static LTW_content findByUserName_First(
			String userName, OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByUserName_First(
			userName, orderByComparator);
	}

	/**
	 * Returns the first ltw_content in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public static LTW_content fetchByUserName_First(
		String userName, OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().fetchByUserName_First(
			userName, orderByComparator);
	}

	/**
	 * Returns the last ltw_content in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public static LTW_content findByUserName_Last(
			String userName, OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByUserName_Last(
			userName, orderByComparator);
	}

	/**
	 * Returns the last ltw_content in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public static LTW_content fetchByUserName_Last(
		String userName, OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().fetchByUserName_Last(
			userName, orderByComparator);
	}

	/**
	 * Returns the ltw_contents before and after the current ltw_content in the ordered set where userName = &#63;.
	 *
	 * @param ltwId the primary key of the current ltw_content
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ltw_content
	 * @throws NoSuch_contentException if a ltw_content with the primary key could not be found
	 */
	public static LTW_content[] findByUserName_PrevAndNext(
			long ltwId, String userName,
			OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByUserName_PrevAndNext(
			ltwId, userName, orderByComparator);
	}

	/**
	 * Removes all the ltw_contents where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 */
	public static void removeByUserName(String userName) {
		getPersistence().removeByUserName(userName);
	}

	/**
	 * Returns the number of ltw_contents where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching ltw_contents
	 */
	public static int countByUserName(String userName) {
		return getPersistence().countByUserName(userName);
	}

	/**
	 * Returns all the ltw_contents where motorcycleName = &#63;.
	 *
	 * @param motorcycleName the motorcycle name
	 * @return the matching ltw_contents
	 */
	public static List<LTW_content> findByMotorcycleName(
		String motorcycleName) {

		return getPersistence().findByMotorcycleName(motorcycleName);
	}

	/**
	 * Returns a range of all the ltw_contents where motorcycleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param motorcycleName the motorcycle name
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @return the range of matching ltw_contents
	 */
	public static List<LTW_content> findByMotorcycleName(
		String motorcycleName, int start, int end) {

		return getPersistence().findByMotorcycleName(
			motorcycleName, start, end);
	}

	/**
	 * Returns an ordered range of all the ltw_contents where motorcycleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param motorcycleName the motorcycle name
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ltw_contents
	 */
	public static List<LTW_content> findByMotorcycleName(
		String motorcycleName, int start, int end,
		OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().findByMotorcycleName(
			motorcycleName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ltw_contents where motorcycleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param motorcycleName the motorcycle name
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ltw_contents
	 */
	public static List<LTW_content> findByMotorcycleName(
		String motorcycleName, int start, int end,
		OrderByComparator<LTW_content> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByMotorcycleName(
			motorcycleName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ltw_content in the ordered set where motorcycleName = &#63;.
	 *
	 * @param motorcycleName the motorcycle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public static LTW_content findByMotorcycleName_First(
			String motorcycleName,
			OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByMotorcycleName_First(
			motorcycleName, orderByComparator);
	}

	/**
	 * Returns the first ltw_content in the ordered set where motorcycleName = &#63;.
	 *
	 * @param motorcycleName the motorcycle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public static LTW_content fetchByMotorcycleName_First(
		String motorcycleName,
		OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().fetchByMotorcycleName_First(
			motorcycleName, orderByComparator);
	}

	/**
	 * Returns the last ltw_content in the ordered set where motorcycleName = &#63;.
	 *
	 * @param motorcycleName the motorcycle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public static LTW_content findByMotorcycleName_Last(
			String motorcycleName,
			OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByMotorcycleName_Last(
			motorcycleName, orderByComparator);
	}

	/**
	 * Returns the last ltw_content in the ordered set where motorcycleName = &#63;.
	 *
	 * @param motorcycleName the motorcycle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public static LTW_content fetchByMotorcycleName_Last(
		String motorcycleName,
		OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().fetchByMotorcycleName_Last(
			motorcycleName, orderByComparator);
	}

	/**
	 * Returns the ltw_contents before and after the current ltw_content in the ordered set where motorcycleName = &#63;.
	 *
	 * @param ltwId the primary key of the current ltw_content
	 * @param motorcycleName the motorcycle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ltw_content
	 * @throws NoSuch_contentException if a ltw_content with the primary key could not be found
	 */
	public static LTW_content[] findByMotorcycleName_PrevAndNext(
			long ltwId, String motorcycleName,
			OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByMotorcycleName_PrevAndNext(
			ltwId, motorcycleName, orderByComparator);
	}

	/**
	 * Removes all the ltw_contents where motorcycleName = &#63; from the database.
	 *
	 * @param motorcycleName the motorcycle name
	 */
	public static void removeByMotorcycleName(String motorcycleName) {
		getPersistence().removeByMotorcycleName(motorcycleName);
	}

	/**
	 * Returns the number of ltw_contents where motorcycleName = &#63;.
	 *
	 * @param motorcycleName the motorcycle name
	 * @return the number of matching ltw_contents
	 */
	public static int countByMotorcycleName(String motorcycleName) {
		return getPersistence().countByMotorcycleName(motorcycleName);
	}

	/**
	 * Returns all the ltw_contents where motorcycleManufacturing = &#63;.
	 *
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @return the matching ltw_contents
	 */
	public static List<LTW_content> findByMotorcycleManufacturing(
		String motorcycleManufacturing) {

		return getPersistence().findByMotorcycleManufacturing(
			motorcycleManufacturing);
	}

	/**
	 * Returns a range of all the ltw_contents where motorcycleManufacturing = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @return the range of matching ltw_contents
	 */
	public static List<LTW_content> findByMotorcycleManufacturing(
		String motorcycleManufacturing, int start, int end) {

		return getPersistence().findByMotorcycleManufacturing(
			motorcycleManufacturing, start, end);
	}

	/**
	 * Returns an ordered range of all the ltw_contents where motorcycleManufacturing = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ltw_contents
	 */
	public static List<LTW_content> findByMotorcycleManufacturing(
		String motorcycleManufacturing, int start, int end,
		OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().findByMotorcycleManufacturing(
			motorcycleManufacturing, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ltw_contents where motorcycleManufacturing = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ltw_contents
	 */
	public static List<LTW_content> findByMotorcycleManufacturing(
		String motorcycleManufacturing, int start, int end,
		OrderByComparator<LTW_content> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByMotorcycleManufacturing(
			motorcycleManufacturing, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first ltw_content in the ordered set where motorcycleManufacturing = &#63;.
	 *
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public static LTW_content findByMotorcycleManufacturing_First(
			String motorcycleManufacturing,
			OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByMotorcycleManufacturing_First(
			motorcycleManufacturing, orderByComparator);
	}

	/**
	 * Returns the first ltw_content in the ordered set where motorcycleManufacturing = &#63;.
	 *
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public static LTW_content fetchByMotorcycleManufacturing_First(
		String motorcycleManufacturing,
		OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().fetchByMotorcycleManufacturing_First(
			motorcycleManufacturing, orderByComparator);
	}

	/**
	 * Returns the last ltw_content in the ordered set where motorcycleManufacturing = &#63;.
	 *
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public static LTW_content findByMotorcycleManufacturing_Last(
			String motorcycleManufacturing,
			OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByMotorcycleManufacturing_Last(
			motorcycleManufacturing, orderByComparator);
	}

	/**
	 * Returns the last ltw_content in the ordered set where motorcycleManufacturing = &#63;.
	 *
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public static LTW_content fetchByMotorcycleManufacturing_Last(
		String motorcycleManufacturing,
		OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().fetchByMotorcycleManufacturing_Last(
			motorcycleManufacturing, orderByComparator);
	}

	/**
	 * Returns the ltw_contents before and after the current ltw_content in the ordered set where motorcycleManufacturing = &#63;.
	 *
	 * @param ltwId the primary key of the current ltw_content
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ltw_content
	 * @throws NoSuch_contentException if a ltw_content with the primary key could not be found
	 */
	public static LTW_content[] findByMotorcycleManufacturing_PrevAndNext(
			long ltwId, String motorcycleManufacturing,
			OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByMotorcycleManufacturing_PrevAndNext(
			ltwId, motorcycleManufacturing, orderByComparator);
	}

	/**
	 * Removes all the ltw_contents where motorcycleManufacturing = &#63; from the database.
	 *
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 */
	public static void removeByMotorcycleManufacturing(
		String motorcycleManufacturing) {

		getPersistence().removeByMotorcycleManufacturing(
			motorcycleManufacturing);
	}

	/**
	 * Returns the number of ltw_contents where motorcycleManufacturing = &#63;.
	 *
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @return the number of matching ltw_contents
	 */
	public static int countByMotorcycleManufacturing(
		String motorcycleManufacturing) {

		return getPersistence().countByMotorcycleManufacturing(
			motorcycleManufacturing);
	}

	/**
	 * Returns all the ltw_contents where motorcycleYear = &#63;.
	 *
	 * @param motorcycleYear the motorcycle year
	 * @return the matching ltw_contents
	 */
	public static List<LTW_content> findByMotorcycleYear(int motorcycleYear) {
		return getPersistence().findByMotorcycleYear(motorcycleYear);
	}

	/**
	 * Returns a range of all the ltw_contents where motorcycleYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param motorcycleYear the motorcycle year
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @return the range of matching ltw_contents
	 */
	public static List<LTW_content> findByMotorcycleYear(
		int motorcycleYear, int start, int end) {

		return getPersistence().findByMotorcycleYear(
			motorcycleYear, start, end);
	}

	/**
	 * Returns an ordered range of all the ltw_contents where motorcycleYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param motorcycleYear the motorcycle year
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ltw_contents
	 */
	public static List<LTW_content> findByMotorcycleYear(
		int motorcycleYear, int start, int end,
		OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().findByMotorcycleYear(
			motorcycleYear, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ltw_contents where motorcycleYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param motorcycleYear the motorcycle year
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ltw_contents
	 */
	public static List<LTW_content> findByMotorcycleYear(
		int motorcycleYear, int start, int end,
		OrderByComparator<LTW_content> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByMotorcycleYear(
			motorcycleYear, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ltw_content in the ordered set where motorcycleYear = &#63;.
	 *
	 * @param motorcycleYear the motorcycle year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public static LTW_content findByMotorcycleYear_First(
			int motorcycleYear,
			OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByMotorcycleYear_First(
			motorcycleYear, orderByComparator);
	}

	/**
	 * Returns the first ltw_content in the ordered set where motorcycleYear = &#63;.
	 *
	 * @param motorcycleYear the motorcycle year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public static LTW_content fetchByMotorcycleYear_First(
		int motorcycleYear, OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().fetchByMotorcycleYear_First(
			motorcycleYear, orderByComparator);
	}

	/**
	 * Returns the last ltw_content in the ordered set where motorcycleYear = &#63;.
	 *
	 * @param motorcycleYear the motorcycle year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public static LTW_content findByMotorcycleYear_Last(
			int motorcycleYear,
			OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByMotorcycleYear_Last(
			motorcycleYear, orderByComparator);
	}

	/**
	 * Returns the last ltw_content in the ordered set where motorcycleYear = &#63;.
	 *
	 * @param motorcycleYear the motorcycle year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public static LTW_content fetchByMotorcycleYear_Last(
		int motorcycleYear, OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().fetchByMotorcycleYear_Last(
			motorcycleYear, orderByComparator);
	}

	/**
	 * Returns the ltw_contents before and after the current ltw_content in the ordered set where motorcycleYear = &#63;.
	 *
	 * @param ltwId the primary key of the current ltw_content
	 * @param motorcycleYear the motorcycle year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ltw_content
	 * @throws NoSuch_contentException if a ltw_content with the primary key could not be found
	 */
	public static LTW_content[] findByMotorcycleYear_PrevAndNext(
			long ltwId, int motorcycleYear,
			OrderByComparator<LTW_content> orderByComparator)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByMotorcycleYear_PrevAndNext(
			ltwId, motorcycleYear, orderByComparator);
	}

	/**
	 * Removes all the ltw_contents where motorcycleYear = &#63; from the database.
	 *
	 * @param motorcycleYear the motorcycle year
	 */
	public static void removeByMotorcycleYear(int motorcycleYear) {
		getPersistence().removeByMotorcycleYear(motorcycleYear);
	}

	/**
	 * Returns the number of ltw_contents where motorcycleYear = &#63;.
	 *
	 * @param motorcycleYear the motorcycle year
	 * @return the number of matching ltw_contents
	 */
	public static int countByMotorcycleYear(int motorcycleYear) {
		return getPersistence().countByMotorcycleYear(motorcycleYear);
	}

	/**
	 * Caches the ltw_content in the entity cache if it is enabled.
	 *
	 * @param ltw_content the ltw_content
	 */
	public static void cacheResult(LTW_content ltw_content) {
		getPersistence().cacheResult(ltw_content);
	}

	/**
	 * Caches the ltw_contents in the entity cache if it is enabled.
	 *
	 * @param ltw_contents the ltw_contents
	 */
	public static void cacheResult(List<LTW_content> ltw_contents) {
		getPersistence().cacheResult(ltw_contents);
	}

	/**
	 * Creates a new ltw_content with the primary key. Does not add the ltw_content to the database.
	 *
	 * @param ltwId the primary key for the new ltw_content
	 * @return the new ltw_content
	 */
	public static LTW_content create(long ltwId) {
		return getPersistence().create(ltwId);
	}

	/**
	 * Removes the ltw_content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ltwId the primary key of the ltw_content
	 * @return the ltw_content that was removed
	 * @throws NoSuch_contentException if a ltw_content with the primary key could not be found
	 */
	public static LTW_content remove(long ltwId)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().remove(ltwId);
	}

	public static LTW_content updateImpl(LTW_content ltw_content) {
		return getPersistence().updateImpl(ltw_content);
	}

	/**
	 * Returns the ltw_content with the primary key or throws a <code>NoSuch_contentException</code> if it could not be found.
	 *
	 * @param ltwId the primary key of the ltw_content
	 * @return the ltw_content
	 * @throws NoSuch_contentException if a ltw_content with the primary key could not be found
	 */
	public static LTW_content findByPrimaryKey(long ltwId)
		throws ltw.content.service.exception.NoSuch_contentException {

		return getPersistence().findByPrimaryKey(ltwId);
	}

	/**
	 * Returns the ltw_content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ltwId the primary key of the ltw_content
	 * @return the ltw_content, or <code>null</code> if a ltw_content with the primary key could not be found
	 */
	public static LTW_content fetchByPrimaryKey(long ltwId) {
		return getPersistence().fetchByPrimaryKey(ltwId);
	}

	/**
	 * Returns all the ltw_contents.
	 *
	 * @return the ltw_contents
	 */
	public static List<LTW_content> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ltw_contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @return the range of ltw_contents
	 */
	public static List<LTW_content> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ltw_contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ltw_contents
	 */
	public static List<LTW_content> findAll(
		int start, int end, OrderByComparator<LTW_content> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ltw_contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ltw_contents
	 */
	public static List<LTW_content> findAll(
		int start, int end, OrderByComparator<LTW_content> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ltw_contents from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ltw_contents.
	 *
	 * @return the number of ltw_contents
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LTW_contentPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(LTW_contentPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile LTW_contentPersistence _persistence;

}