/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ltw.content.service.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import ltw.content.service.exception.NoSuch_contentException;
import ltw.content.service.model.LTW_content;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ltw_content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LTW_contentUtil
 * @generated
 */
@ProviderType
public interface LTW_contentPersistence extends BasePersistence<LTW_content> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LTW_contentUtil} to access the ltw_content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ltw_contents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ltw_contents
	 */
	public java.util.List<LTW_content> findByUuid(String uuid);

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
	public java.util.List<LTW_content> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<LTW_content> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

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
	public java.util.List<LTW_content> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ltw_content in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public LTW_content findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Returns the first ltw_content in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public LTW_content fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

	/**
	 * Returns the last ltw_content in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public LTW_content findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Returns the last ltw_content in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public LTW_content fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

	/**
	 * Returns the ltw_contents before and after the current ltw_content in the ordered set where uuid = &#63;.
	 *
	 * @param ltwId the primary key of the current ltw_content
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ltw_content
	 * @throws NoSuch_contentException if a ltw_content with the primary key could not be found
	 */
	public LTW_content[] findByUuid_PrevAndNext(
			long ltwId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Removes all the ltw_contents where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of ltw_contents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ltw_contents
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the ltw_content where uuid = &#63; and groupId = &#63; or throws a <code>NoSuch_contentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public LTW_content findByUUID_G(String uuid, long groupId)
		throws NoSuch_contentException;

	/**
	 * Returns the ltw_content where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public LTW_content fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the ltw_content where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public LTW_content fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the ltw_content where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ltw_content that was removed
	 */
	public LTW_content removeByUUID_G(String uuid, long groupId)
		throws NoSuch_contentException;

	/**
	 * Returns the number of ltw_contents where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ltw_contents
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the ltw_contents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ltw_contents
	 */
	public java.util.List<LTW_content> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<LTW_content> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<LTW_content> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

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
	public java.util.List<LTW_content> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ltw_content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public LTW_content findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Returns the first ltw_content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public LTW_content fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

	/**
	 * Returns the last ltw_content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public LTW_content findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Returns the last ltw_content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public LTW_content fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

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
	public LTW_content[] findByUuid_C_PrevAndNext(
			long ltwId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Removes all the ltw_contents where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of ltw_contents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ltw_contents
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the ltw_contents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching ltw_contents
	 */
	public java.util.List<LTW_content> findByGroupId(long groupId);

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
	public java.util.List<LTW_content> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<LTW_content> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

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
	public java.util.List<LTW_content> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ltw_content in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public LTW_content findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Returns the first ltw_content in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public LTW_content fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

	/**
	 * Returns the last ltw_content in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public LTW_content findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Returns the last ltw_content in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public LTW_content fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

	/**
	 * Returns the ltw_contents before and after the current ltw_content in the ordered set where groupId = &#63;.
	 *
	 * @param ltwId the primary key of the current ltw_content
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ltw_content
	 * @throws NoSuch_contentException if a ltw_content with the primary key could not be found
	 */
	public LTW_content[] findByGroupId_PrevAndNext(
			long ltwId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Removes all the ltw_contents where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of ltw_contents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching ltw_contents
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the ltw_contents where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching ltw_contents
	 */
	public java.util.List<LTW_content> findByCompanyId(long companyId);

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
	public java.util.List<LTW_content> findByCompanyId(
		long companyId, int start, int end);

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
	public java.util.List<LTW_content> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

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
	public java.util.List<LTW_content> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ltw_content in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public LTW_content findByCompanyId_First(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Returns the first ltw_content in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public LTW_content fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

	/**
	 * Returns the last ltw_content in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public LTW_content findByCompanyId_Last(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Returns the last ltw_content in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public LTW_content fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

	/**
	 * Returns the ltw_contents before and after the current ltw_content in the ordered set where companyId = &#63;.
	 *
	 * @param ltwId the primary key of the current ltw_content
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ltw_content
	 * @throws NoSuch_contentException if a ltw_content with the primary key could not be found
	 */
	public LTW_content[] findByCompanyId_PrevAndNext(
			long ltwId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Removes all the ltw_contents where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompanyId(long companyId);

	/**
	 * Returns the number of ltw_contents where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching ltw_contents
	 */
	public int countByCompanyId(long companyId);

	/**
	 * Returns all the ltw_contents where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the matching ltw_contents
	 */
	public java.util.List<LTW_content> findByC_U(long companyId, long userId);

	/**
	 * Returns a range of all the ltw_contents where companyId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @return the range of matching ltw_contents
	 */
	public java.util.List<LTW_content> findByC_U(
		long companyId, long userId, int start, int end);

	/**
	 * Returns an ordered range of all the ltw_contents where companyId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ltw_contents
	 */
	public java.util.List<LTW_content> findByC_U(
		long companyId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ltw_contents where companyId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ltw_contents
	 */
	public java.util.List<LTW_content> findByC_U(
		long companyId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ltw_content in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public LTW_content findByC_U_First(
			long companyId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Returns the first ltw_content in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public LTW_content fetchByC_U_First(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

	/**
	 * Returns the last ltw_content in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public LTW_content findByC_U_Last(
			long companyId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Returns the last ltw_content in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public LTW_content fetchByC_U_Last(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

	/**
	 * Returns the ltw_contents before and after the current ltw_content in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param ltwId the primary key of the current ltw_content
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ltw_content
	 * @throws NoSuch_contentException if a ltw_content with the primary key could not be found
	 */
	public LTW_content[] findByC_U_PrevAndNext(
			long ltwId, long companyId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Removes all the ltw_contents where companyId = &#63; and userId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 */
	public void removeByC_U(long companyId, long userId);

	/**
	 * Returns the number of ltw_contents where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the number of matching ltw_contents
	 */
	public int countByC_U(long companyId, long userId);

	/**
	 * Returns all the ltw_contents where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the matching ltw_contents
	 */
	public java.util.List<LTW_content> findByU(String userName);

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
	public java.util.List<LTW_content> findByU(
		String userName, int start, int end);

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
	public java.util.List<LTW_content> findByU(
		String userName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

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
	public java.util.List<LTW_content> findByU(
		String userName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ltw_content in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public LTW_content findByU_First(
			String userName,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Returns the first ltw_content in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public LTW_content fetchByU_First(
		String userName,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

	/**
	 * Returns the last ltw_content in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public LTW_content findByU_Last(
			String userName,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Returns the last ltw_content in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public LTW_content fetchByU_Last(
		String userName,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

	/**
	 * Returns the ltw_contents before and after the current ltw_content in the ordered set where userName = &#63;.
	 *
	 * @param ltwId the primary key of the current ltw_content
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ltw_content
	 * @throws NoSuch_contentException if a ltw_content with the primary key could not be found
	 */
	public LTW_content[] findByU_PrevAndNext(
			long ltwId, String userName,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Removes all the ltw_contents where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 */
	public void removeByU(String userName);

	/**
	 * Returns the number of ltw_contents where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching ltw_contents
	 */
	public int countByU(String userName);

	/**
	 * Returns all the ltw_contents where companyId = &#63; and motorcycleName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param motorcycleName the motorcycle name
	 * @return the matching ltw_contents
	 */
	public java.util.List<LTW_content> findByC_M(
		long companyId, String motorcycleName);

	/**
	 * Returns a range of all the ltw_contents where companyId = &#63; and motorcycleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param motorcycleName the motorcycle name
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @return the range of matching ltw_contents
	 */
	public java.util.List<LTW_content> findByC_M(
		long companyId, String motorcycleName, int start, int end);

	/**
	 * Returns an ordered range of all the ltw_contents where companyId = &#63; and motorcycleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param motorcycleName the motorcycle name
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ltw_contents
	 */
	public java.util.List<LTW_content> findByC_M(
		long companyId, String motorcycleName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ltw_contents where companyId = &#63; and motorcycleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param motorcycleName the motorcycle name
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ltw_contents
	 */
	public java.util.List<LTW_content> findByC_M(
		long companyId, String motorcycleName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ltw_content in the ordered set where companyId = &#63; and motorcycleName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param motorcycleName the motorcycle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public LTW_content findByC_M_First(
			long companyId, String motorcycleName,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Returns the first ltw_content in the ordered set where companyId = &#63; and motorcycleName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param motorcycleName the motorcycle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public LTW_content fetchByC_M_First(
		long companyId, String motorcycleName,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

	/**
	 * Returns the last ltw_content in the ordered set where companyId = &#63; and motorcycleName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param motorcycleName the motorcycle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public LTW_content findByC_M_Last(
			long companyId, String motorcycleName,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Returns the last ltw_content in the ordered set where companyId = &#63; and motorcycleName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param motorcycleName the motorcycle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public LTW_content fetchByC_M_Last(
		long companyId, String motorcycleName,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

	/**
	 * Returns the ltw_contents before and after the current ltw_content in the ordered set where companyId = &#63; and motorcycleName = &#63;.
	 *
	 * @param ltwId the primary key of the current ltw_content
	 * @param companyId the company ID
	 * @param motorcycleName the motorcycle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ltw_content
	 * @throws NoSuch_contentException if a ltw_content with the primary key could not be found
	 */
	public LTW_content[] findByC_M_PrevAndNext(
			long ltwId, long companyId, String motorcycleName,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Removes all the ltw_contents where companyId = &#63; and motorcycleName = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param motorcycleName the motorcycle name
	 */
	public void removeByC_M(long companyId, String motorcycleName);

	/**
	 * Returns the number of ltw_contents where companyId = &#63; and motorcycleName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param motorcycleName the motorcycle name
	 * @return the number of matching ltw_contents
	 */
	public int countByC_M(long companyId, String motorcycleName);

	/**
	 * Returns all the ltw_contents where groupId = &#63; and motorcycleManufacturing = &#63;.
	 *
	 * @param groupId the group ID
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @return the matching ltw_contents
	 */
	public java.util.List<LTW_content> findByG_M(
		long groupId, String motorcycleManufacturing);

	/**
	 * Returns a range of all the ltw_contents where groupId = &#63; and motorcycleManufacturing = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @return the range of matching ltw_contents
	 */
	public java.util.List<LTW_content> findByG_M(
		long groupId, String motorcycleManufacturing, int start, int end);

	/**
	 * Returns an ordered range of all the ltw_contents where groupId = &#63; and motorcycleManufacturing = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ltw_contents
	 */
	public java.util.List<LTW_content> findByG_M(
		long groupId, String motorcycleManufacturing, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ltw_contents where groupId = &#63; and motorcycleManufacturing = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ltw_contents
	 */
	public java.util.List<LTW_content> findByG_M(
		long groupId, String motorcycleManufacturing, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ltw_content in the ordered set where groupId = &#63; and motorcycleManufacturing = &#63;.
	 *
	 * @param groupId the group ID
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public LTW_content findByG_M_First(
			long groupId, String motorcycleManufacturing,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Returns the first ltw_content in the ordered set where groupId = &#63; and motorcycleManufacturing = &#63;.
	 *
	 * @param groupId the group ID
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public LTW_content fetchByG_M_First(
		long groupId, String motorcycleManufacturing,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

	/**
	 * Returns the last ltw_content in the ordered set where groupId = &#63; and motorcycleManufacturing = &#63;.
	 *
	 * @param groupId the group ID
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public LTW_content findByG_M_Last(
			long groupId, String motorcycleManufacturing,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Returns the last ltw_content in the ordered set where groupId = &#63; and motorcycleManufacturing = &#63;.
	 *
	 * @param groupId the group ID
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public LTW_content fetchByG_M_Last(
		long groupId, String motorcycleManufacturing,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

	/**
	 * Returns the ltw_contents before and after the current ltw_content in the ordered set where groupId = &#63; and motorcycleManufacturing = &#63;.
	 *
	 * @param ltwId the primary key of the current ltw_content
	 * @param groupId the group ID
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ltw_content
	 * @throws NoSuch_contentException if a ltw_content with the primary key could not be found
	 */
	public LTW_content[] findByG_M_PrevAndNext(
			long ltwId, long groupId, String motorcycleManufacturing,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Removes all the ltw_contents where groupId = &#63; and motorcycleManufacturing = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 */
	public void removeByG_M(long groupId, String motorcycleManufacturing);

	/**
	 * Returns the number of ltw_contents where groupId = &#63; and motorcycleManufacturing = &#63;.
	 *
	 * @param groupId the group ID
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @return the number of matching ltw_contents
	 */
	public int countByG_M(long groupId, String motorcycleManufacturing);

	/**
	 * Returns all the ltw_contents where motorcycleYear = &#63; and ltwId = &#63;.
	 *
	 * @param motorcycleYear the motorcycle year
	 * @param ltwId the ltw ID
	 * @return the matching ltw_contents
	 */
	public java.util.List<LTW_content> findByM_L(
		int motorcycleYear, long ltwId);

	/**
	 * Returns a range of all the ltw_contents where motorcycleYear = &#63; and ltwId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param motorcycleYear the motorcycle year
	 * @param ltwId the ltw ID
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @return the range of matching ltw_contents
	 */
	public java.util.List<LTW_content> findByM_L(
		int motorcycleYear, long ltwId, int start, int end);

	/**
	 * Returns an ordered range of all the ltw_contents where motorcycleYear = &#63; and ltwId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param motorcycleYear the motorcycle year
	 * @param ltwId the ltw ID
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ltw_contents
	 */
	public java.util.List<LTW_content> findByM_L(
		int motorcycleYear, long ltwId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ltw_contents where motorcycleYear = &#63; and ltwId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LTW_contentModelImpl</code>.
	 * </p>
	 *
	 * @param motorcycleYear the motorcycle year
	 * @param ltwId the ltw ID
	 * @param start the lower bound of the range of ltw_contents
	 * @param end the upper bound of the range of ltw_contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ltw_contents
	 */
	public java.util.List<LTW_content> findByM_L(
		int motorcycleYear, long ltwId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ltw_content in the ordered set where motorcycleYear = &#63; and ltwId = &#63;.
	 *
	 * @param motorcycleYear the motorcycle year
	 * @param ltwId the ltw ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public LTW_content findByM_L_First(
			int motorcycleYear, long ltwId,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Returns the first ltw_content in the ordered set where motorcycleYear = &#63; and ltwId = &#63;.
	 *
	 * @param motorcycleYear the motorcycle year
	 * @param ltwId the ltw ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public LTW_content fetchByM_L_First(
		int motorcycleYear, long ltwId,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

	/**
	 * Returns the last ltw_content in the ordered set where motorcycleYear = &#63; and ltwId = &#63;.
	 *
	 * @param motorcycleYear the motorcycle year
	 * @param ltwId the ltw ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	public LTW_content findByM_L_Last(
			int motorcycleYear, long ltwId,
			com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
				orderByComparator)
		throws NoSuch_contentException;

	/**
	 * Returns the last ltw_content in the ordered set where motorcycleYear = &#63; and ltwId = &#63;.
	 *
	 * @param motorcycleYear the motorcycle year
	 * @param ltwId the ltw ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	public LTW_content fetchByM_L_Last(
		int motorcycleYear, long ltwId,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

	/**
	 * Removes all the ltw_contents where motorcycleYear = &#63; and ltwId = &#63; from the database.
	 *
	 * @param motorcycleYear the motorcycle year
	 * @param ltwId the ltw ID
	 */
	public void removeByM_L(int motorcycleYear, long ltwId);

	/**
	 * Returns the number of ltw_contents where motorcycleYear = &#63; and ltwId = &#63;.
	 *
	 * @param motorcycleYear the motorcycle year
	 * @param ltwId the ltw ID
	 * @return the number of matching ltw_contents
	 */
	public int countByM_L(int motorcycleYear, long ltwId);

	/**
	 * Caches the ltw_content in the entity cache if it is enabled.
	 *
	 * @param ltw_content the ltw_content
	 */
	public void cacheResult(LTW_content ltw_content);

	/**
	 * Caches the ltw_contents in the entity cache if it is enabled.
	 *
	 * @param ltw_contents the ltw_contents
	 */
	public void cacheResult(java.util.List<LTW_content> ltw_contents);

	/**
	 * Creates a new ltw_content with the primary key. Does not add the ltw_content to the database.
	 *
	 * @param ltwId the primary key for the new ltw_content
	 * @return the new ltw_content
	 */
	public LTW_content create(long ltwId);

	/**
	 * Removes the ltw_content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ltwId the primary key of the ltw_content
	 * @return the ltw_content that was removed
	 * @throws NoSuch_contentException if a ltw_content with the primary key could not be found
	 */
	public LTW_content remove(long ltwId) throws NoSuch_contentException;

	public LTW_content updateImpl(LTW_content ltw_content);

	/**
	 * Returns the ltw_content with the primary key or throws a <code>NoSuch_contentException</code> if it could not be found.
	 *
	 * @param ltwId the primary key of the ltw_content
	 * @return the ltw_content
	 * @throws NoSuch_contentException if a ltw_content with the primary key could not be found
	 */
	public LTW_content findByPrimaryKey(long ltwId)
		throws NoSuch_contentException;

	/**
	 * Returns the ltw_content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ltwId the primary key of the ltw_content
	 * @return the ltw_content, or <code>null</code> if a ltw_content with the primary key could not be found
	 */
	public LTW_content fetchByPrimaryKey(long ltwId);

	/**
	 * Returns all the ltw_contents.
	 *
	 * @return the ltw_contents
	 */
	public java.util.List<LTW_content> findAll();

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
	public java.util.List<LTW_content> findAll(int start, int end);

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
	public java.util.List<LTW_content> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator);

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
	public java.util.List<LTW_content> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LTW_content>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ltw_contents from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ltw_contents.
	 *
	 * @return the number of ltw_contents
	 */
	public int countAll();

}