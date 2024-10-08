/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ltw.content.service.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import ltw.content.service.exception.NoSuch_contentException;
import ltw.content.service.model.LTW_content;
import ltw.content.service.model.LTW_contentTable;
import ltw.content.service.model.impl.LTW_contentImpl;
import ltw.content.service.model.impl.LTW_contentModelImpl;
import ltw.content.service.service.persistence.LTW_contentPersistence;
import ltw.content.service.service.persistence.LTW_contentUtil;
import ltw.content.service.service.persistence.impl.constants.LTWPersistenceConstants;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the ltw_content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LTW_contentPersistence.class)
public class LTW_contentPersistenceImpl
	extends BasePersistenceImpl<LTW_content> implements LTW_contentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LTW_contentUtil</code> to access the ltw_content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LTW_contentImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the ltw_contents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ltw_contents
	 */
	@Override
	public List<LTW_content> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LTW_content> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<LTW_content> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LTW_content> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<LTW_content> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LTW_content> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<LTW_content> list = null;

		if (useFinderCache) {
			list = (List<LTW_content>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LTW_content ltw_content : list) {
					if (!uuid.equals(ltw_content.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_LTW_CONTENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LTW_contentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<LTW_content>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ltw_content in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content findByUuid_First(
			String uuid, OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		LTW_content ltw_content = fetchByUuid_First(uuid, orderByComparator);

		if (ltw_content != null) {
			return ltw_content;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuch_contentException(sb.toString());
	}

	/**
	 * Returns the first ltw_content in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content fetchByUuid_First(
		String uuid, OrderByComparator<LTW_content> orderByComparator) {

		List<LTW_content> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ltw_content in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content findByUuid_Last(
			String uuid, OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		LTW_content ltw_content = fetchByUuid_Last(uuid, orderByComparator);

		if (ltw_content != null) {
			return ltw_content;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuch_contentException(sb.toString());
	}

	/**
	 * Returns the last ltw_content in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content fetchByUuid_Last(
		String uuid, OrderByComparator<LTW_content> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<LTW_content> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LTW_content[] findByUuid_PrevAndNext(
			long ltwId, String uuid,
			OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		uuid = Objects.toString(uuid, "");

		LTW_content ltw_content = findByPrimaryKey(ltwId);

		Session session = null;

		try {
			session = openSession();

			LTW_content[] array = new LTW_contentImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, ltw_content, uuid, orderByComparator, true);

			array[1] = ltw_content;

			array[2] = getByUuid_PrevAndNext(
				session, ltw_content, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LTW_content getByUuid_PrevAndNext(
		Session session, LTW_content ltw_content, String uuid,
		OrderByComparator<LTW_content> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LTW_CONTENT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(LTW_contentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ltw_content)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LTW_content> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ltw_contents where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (LTW_content ltw_content :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ltw_content);
		}
	}

	/**
	 * Returns the number of ltw_contents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ltw_contents
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LTW_CONTENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"ltw_content.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(ltw_content.uuid IS NULL OR ltw_content.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the ltw_content where uuid = &#63; and groupId = &#63; or throws a <code>NoSuch_contentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content findByUUID_G(String uuid, long groupId)
		throws NoSuch_contentException {

		LTW_content ltw_content = fetchByUUID_G(uuid, groupId);

		if (ltw_content == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuch_contentException(sb.toString());
		}

		return ltw_content;
	}

	/**
	 * Returns the ltw_content where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the ltw_content where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof LTW_content) {
			LTW_content ltw_content = (LTW_content)result;

			if (!Objects.equals(uuid, ltw_content.getUuid()) ||
				(groupId != ltw_content.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_LTW_CONTENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<LTW_content> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					LTW_content ltw_content = list.get(0);

					result = ltw_content;

					cacheResult(ltw_content);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (LTW_content)result;
		}
	}

	/**
	 * Removes the ltw_content where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ltw_content that was removed
	 */
	@Override
	public LTW_content removeByUUID_G(String uuid, long groupId)
		throws NoSuch_contentException {

		LTW_content ltw_content = findByUUID_G(uuid, groupId);

		return remove(ltw_content);
	}

	/**
	 * Returns the number of ltw_contents where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ltw_contents
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LTW_CONTENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"ltw_content.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(ltw_content.uuid IS NULL OR ltw_content.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"ltw_content.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the ltw_contents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ltw_contents
	 */
	@Override
	public List<LTW_content> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LTW_content> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<LTW_content> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LTW_content> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<LTW_content> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<LTW_content> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<LTW_content> list = null;

		if (useFinderCache) {
			list = (List<LTW_content>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LTW_content ltw_content : list) {
					if (!uuid.equals(ltw_content.getUuid()) ||
						(companyId != ltw_content.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_LTW_CONTENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LTW_contentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<LTW_content>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public LTW_content findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		LTW_content ltw_content = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (ltw_content != null) {
			return ltw_content;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuch_contentException(sb.toString());
	}

	/**
	 * Returns the first ltw_content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<LTW_content> orderByComparator) {

		List<LTW_content> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LTW_content findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		LTW_content ltw_content = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (ltw_content != null) {
			return ltw_content;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuch_contentException(sb.toString());
	}

	/**
	 * Returns the last ltw_content in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<LTW_content> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<LTW_content> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LTW_content[] findByUuid_C_PrevAndNext(
			long ltwId, String uuid, long companyId,
			OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		uuid = Objects.toString(uuid, "");

		LTW_content ltw_content = findByPrimaryKey(ltwId);

		Session session = null;

		try {
			session = openSession();

			LTW_content[] array = new LTW_contentImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, ltw_content, uuid, companyId, orderByComparator, true);

			array[1] = ltw_content;

			array[2] = getByUuid_C_PrevAndNext(
				session, ltw_content, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LTW_content getByUuid_C_PrevAndNext(
		Session session, LTW_content ltw_content, String uuid, long companyId,
		OrderByComparator<LTW_content> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LTW_CONTENT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(LTW_contentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ltw_content)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LTW_content> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ltw_contents where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (LTW_content ltw_content :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ltw_content);
		}
	}

	/**
	 * Returns the number of ltw_contents where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ltw_contents
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LTW_CONTENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"ltw_content.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(ltw_content.uuid IS NULL OR ltw_content.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"ltw_content.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the ltw_contents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching ltw_contents
	 */
	@Override
	public List<LTW_content> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LTW_content> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<LTW_content> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LTW_content> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<LTW_content> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LTW_content> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<LTW_content> list = null;

		if (useFinderCache) {
			list = (List<LTW_content>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LTW_content ltw_content : list) {
					if (groupId != ltw_content.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_LTW_CONTENT_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LTW_contentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<LTW_content>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ltw_content in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content findByGroupId_First(
			long groupId, OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		LTW_content ltw_content = fetchByGroupId_First(
			groupId, orderByComparator);

		if (ltw_content != null) {
			return ltw_content;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuch_contentException(sb.toString());
	}

	/**
	 * Returns the first ltw_content in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content fetchByGroupId_First(
		long groupId, OrderByComparator<LTW_content> orderByComparator) {

		List<LTW_content> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ltw_content in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content findByGroupId_Last(
			long groupId, OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		LTW_content ltw_content = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (ltw_content != null) {
			return ltw_content;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuch_contentException(sb.toString());
	}

	/**
	 * Returns the last ltw_content in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content fetchByGroupId_Last(
		long groupId, OrderByComparator<LTW_content> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<LTW_content> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LTW_content[] findByGroupId_PrevAndNext(
			long ltwId, long groupId,
			OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		LTW_content ltw_content = findByPrimaryKey(ltwId);

		Session session = null;

		try {
			session = openSession();

			LTW_content[] array = new LTW_contentImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, ltw_content, groupId, orderByComparator, true);

			array[1] = ltw_content;

			array[2] = getByGroupId_PrevAndNext(
				session, ltw_content, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LTW_content getByGroupId_PrevAndNext(
		Session session, LTW_content ltw_content, long groupId,
		OrderByComparator<LTW_content> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LTW_CONTENT_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(LTW_contentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ltw_content)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LTW_content> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ltw_contents where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (LTW_content ltw_content :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ltw_content);
		}
	}

	/**
	 * Returns the number of ltw_contents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching ltw_contents
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LTW_CONTENT_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"ltw_content.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByCompanyId;
	private FinderPath _finderPathWithoutPaginationFindByCompanyId;
	private FinderPath _finderPathCountByCompanyId;

	/**
	 * Returns all the ltw_contents where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching ltw_contents
	 */
	@Override
	public List<LTW_content> findByCompanyId(long companyId) {
		return findByCompanyId(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LTW_content> findByCompanyId(
		long companyId, int start, int end) {

		return findByCompanyId(companyId, start, end, null);
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
	@Override
	public List<LTW_content> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<LTW_content> orderByComparator) {

		return findByCompanyId(companyId, start, end, orderByComparator, true);
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
	@Override
	public List<LTW_content> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<LTW_content> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCompanyId;
				finderArgs = new Object[] {companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCompanyId;
			finderArgs = new Object[] {
				companyId, start, end, orderByComparator
			};
		}

		List<LTW_content> list = null;

		if (useFinderCache) {
			list = (List<LTW_content>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LTW_content ltw_content : list) {
					if (companyId != ltw_content.getCompanyId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_LTW_CONTENT_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LTW_contentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				list = (List<LTW_content>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ltw_content in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content findByCompanyId_First(
			long companyId, OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		LTW_content ltw_content = fetchByCompanyId_First(
			companyId, orderByComparator);

		if (ltw_content != null) {
			return ltw_content;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuch_contentException(sb.toString());
	}

	/**
	 * Returns the first ltw_content in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content fetchByCompanyId_First(
		long companyId, OrderByComparator<LTW_content> orderByComparator) {

		List<LTW_content> list = findByCompanyId(
			companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ltw_content in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content findByCompanyId_Last(
			long companyId, OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		LTW_content ltw_content = fetchByCompanyId_Last(
			companyId, orderByComparator);

		if (ltw_content != null) {
			return ltw_content;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuch_contentException(sb.toString());
	}

	/**
	 * Returns the last ltw_content in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content fetchByCompanyId_Last(
		long companyId, OrderByComparator<LTW_content> orderByComparator) {

		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<LTW_content> list = findByCompanyId(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LTW_content[] findByCompanyId_PrevAndNext(
			long ltwId, long companyId,
			OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		LTW_content ltw_content = findByPrimaryKey(ltwId);

		Session session = null;

		try {
			session = openSession();

			LTW_content[] array = new LTW_contentImpl[3];

			array[0] = getByCompanyId_PrevAndNext(
				session, ltw_content, companyId, orderByComparator, true);

			array[1] = ltw_content;

			array[2] = getByCompanyId_PrevAndNext(
				session, ltw_content, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LTW_content getByCompanyId_PrevAndNext(
		Session session, LTW_content ltw_content, long companyId,
		OrderByComparator<LTW_content> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LTW_CONTENT_WHERE);

		sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(LTW_contentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ltw_content)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LTW_content> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ltw_contents where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyId(long companyId) {
		for (LTW_content ltw_content :
				findByCompanyId(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ltw_content);
		}
	}

	/**
	 * Returns the number of ltw_contents where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching ltw_contents
	 */
	@Override
	public int countByCompanyId(long companyId) {
		FinderPath finderPath = _finderPathCountByCompanyId;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LTW_CONTENT_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 =
		"ltw_content.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByC_U;
	private FinderPath _finderPathWithoutPaginationFindByC_U;
	private FinderPath _finderPathCountByC_U;

	/**
	 * Returns all the ltw_contents where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the matching ltw_contents
	 */
	@Override
	public List<LTW_content> findByC_U(long companyId, long userId) {
		return findByC_U(
			companyId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<LTW_content> findByC_U(
		long companyId, long userId, int start, int end) {

		return findByC_U(companyId, userId, start, end, null);
	}

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
	@Override
	public List<LTW_content> findByC_U(
		long companyId, long userId, int start, int end,
		OrderByComparator<LTW_content> orderByComparator) {

		return findByC_U(
			companyId, userId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<LTW_content> findByC_U(
		long companyId, long userId, int start, int end,
		OrderByComparator<LTW_content> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_U;
				finderArgs = new Object[] {companyId, userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_U;
			finderArgs = new Object[] {
				companyId, userId, start, end, orderByComparator
			};
		}

		List<LTW_content> list = null;

		if (useFinderCache) {
			list = (List<LTW_content>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LTW_content ltw_content : list) {
					if ((companyId != ltw_content.getCompanyId()) ||
						(userId != ltw_content.getUserId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_LTW_CONTENT_WHERE);

			sb.append(_FINDER_COLUMN_C_U_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LTW_contentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(userId);

				list = (List<LTW_content>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ltw_content in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content findByC_U_First(
			long companyId, long userId,
			OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		LTW_content ltw_content = fetchByC_U_First(
			companyId, userId, orderByComparator);

		if (ltw_content != null) {
			return ltw_content;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuch_contentException(sb.toString());
	}

	/**
	 * Returns the first ltw_content in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content fetchByC_U_First(
		long companyId, long userId,
		OrderByComparator<LTW_content> orderByComparator) {

		List<LTW_content> list = findByC_U(
			companyId, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ltw_content in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content findByC_U_Last(
			long companyId, long userId,
			OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		LTW_content ltw_content = fetchByC_U_Last(
			companyId, userId, orderByComparator);

		if (ltw_content != null) {
			return ltw_content;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuch_contentException(sb.toString());
	}

	/**
	 * Returns the last ltw_content in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content fetchByC_U_Last(
		long companyId, long userId,
		OrderByComparator<LTW_content> orderByComparator) {

		int count = countByC_U(companyId, userId);

		if (count == 0) {
			return null;
		}

		List<LTW_content> list = findByC_U(
			companyId, userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public LTW_content[] findByC_U_PrevAndNext(
			long ltwId, long companyId, long userId,
			OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		LTW_content ltw_content = findByPrimaryKey(ltwId);

		Session session = null;

		try {
			session = openSession();

			LTW_content[] array = new LTW_contentImpl[3];

			array[0] = getByC_U_PrevAndNext(
				session, ltw_content, companyId, userId, orderByComparator,
				true);

			array[1] = ltw_content;

			array[2] = getByC_U_PrevAndNext(
				session, ltw_content, companyId, userId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LTW_content getByC_U_PrevAndNext(
		Session session, LTW_content ltw_content, long companyId, long userId,
		OrderByComparator<LTW_content> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LTW_CONTENT_WHERE);

		sb.append(_FINDER_COLUMN_C_U_COMPANYID_2);

		sb.append(_FINDER_COLUMN_C_U_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(LTW_contentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ltw_content)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LTW_content> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ltw_contents where companyId = &#63; and userId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 */
	@Override
	public void removeByC_U(long companyId, long userId) {
		for (LTW_content ltw_content :
				findByC_U(
					companyId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ltw_content);
		}
	}

	/**
	 * Returns the number of ltw_contents where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the number of matching ltw_contents
	 */
	@Override
	public int countByC_U(long companyId, long userId) {
		FinderPath finderPath = _finderPathCountByC_U;

		Object[] finderArgs = new Object[] {companyId, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LTW_CONTENT_WHERE);

			sb.append(_FINDER_COLUMN_C_U_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_U_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_U_COMPANYID_2 =
		"ltw_content.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_U_USERID_2 =
		"ltw_content.userId = ?";

	private FinderPath _finderPathWithPaginationFindByU;
	private FinderPath _finderPathWithoutPaginationFindByU;
	private FinderPath _finderPathCountByU;

	/**
	 * Returns all the ltw_contents where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the matching ltw_contents
	 */
	@Override
	public List<LTW_content> findByU(String userName) {
		return findByU(userName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LTW_content> findByU(String userName, int start, int end) {
		return findByU(userName, start, end, null);
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
	@Override
	public List<LTW_content> findByU(
		String userName, int start, int end,
		OrderByComparator<LTW_content> orderByComparator) {

		return findByU(userName, start, end, orderByComparator, true);
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
	@Override
	public List<LTW_content> findByU(
		String userName, int start, int end,
		OrderByComparator<LTW_content> orderByComparator,
		boolean useFinderCache) {

		userName = Objects.toString(userName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByU;
				finderArgs = new Object[] {userName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByU;
			finderArgs = new Object[] {userName, start, end, orderByComparator};
		}

		List<LTW_content> list = null;

		if (useFinderCache) {
			list = (List<LTW_content>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LTW_content ltw_content : list) {
					if (!userName.equals(ltw_content.getUserName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_LTW_CONTENT_WHERE);

			boolean bindUserName = false;

			if (userName.isEmpty()) {
				sb.append(_FINDER_COLUMN_U_USERNAME_3);
			}
			else {
				bindUserName = true;

				sb.append(_FINDER_COLUMN_U_USERNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LTW_contentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUserName) {
					queryPos.add(userName);
				}

				list = (List<LTW_content>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ltw_content in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content findByU_First(
			String userName, OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		LTW_content ltw_content = fetchByU_First(userName, orderByComparator);

		if (ltw_content != null) {
			return ltw_content;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userName=");
		sb.append(userName);

		sb.append("}");

		throw new NoSuch_contentException(sb.toString());
	}

	/**
	 * Returns the first ltw_content in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content fetchByU_First(
		String userName, OrderByComparator<LTW_content> orderByComparator) {

		List<LTW_content> list = findByU(userName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ltw_content in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content findByU_Last(
			String userName, OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		LTW_content ltw_content = fetchByU_Last(userName, orderByComparator);

		if (ltw_content != null) {
			return ltw_content;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userName=");
		sb.append(userName);

		sb.append("}");

		throw new NoSuch_contentException(sb.toString());
	}

	/**
	 * Returns the last ltw_content in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content fetchByU_Last(
		String userName, OrderByComparator<LTW_content> orderByComparator) {

		int count = countByU(userName);

		if (count == 0) {
			return null;
		}

		List<LTW_content> list = findByU(
			userName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LTW_content[] findByU_PrevAndNext(
			long ltwId, String userName,
			OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		userName = Objects.toString(userName, "");

		LTW_content ltw_content = findByPrimaryKey(ltwId);

		Session session = null;

		try {
			session = openSession();

			LTW_content[] array = new LTW_contentImpl[3];

			array[0] = getByU_PrevAndNext(
				session, ltw_content, userName, orderByComparator, true);

			array[1] = ltw_content;

			array[2] = getByU_PrevAndNext(
				session, ltw_content, userName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LTW_content getByU_PrevAndNext(
		Session session, LTW_content ltw_content, String userName,
		OrderByComparator<LTW_content> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LTW_CONTENT_WHERE);

		boolean bindUserName = false;

		if (userName.isEmpty()) {
			sb.append(_FINDER_COLUMN_U_USERNAME_3);
		}
		else {
			bindUserName = true;

			sb.append(_FINDER_COLUMN_U_USERNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(LTW_contentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUserName) {
			queryPos.add(userName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ltw_content)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LTW_content> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ltw_contents where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 */
	@Override
	public void removeByU(String userName) {
		for (LTW_content ltw_content :
				findByU(userName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ltw_content);
		}
	}

	/**
	 * Returns the number of ltw_contents where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching ltw_contents
	 */
	@Override
	public int countByU(String userName) {
		userName = Objects.toString(userName, "");

		FinderPath finderPath = _finderPathCountByU;

		Object[] finderArgs = new Object[] {userName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LTW_CONTENT_WHERE);

			boolean bindUserName = false;

			if (userName.isEmpty()) {
				sb.append(_FINDER_COLUMN_U_USERNAME_3);
			}
			else {
				bindUserName = true;

				sb.append(_FINDER_COLUMN_U_USERNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUserName) {
					queryPos.add(userName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_U_USERNAME_2 =
		"ltw_content.userName = ?";

	private static final String _FINDER_COLUMN_U_USERNAME_3 =
		"(ltw_content.userName IS NULL OR ltw_content.userName = '')";

	private FinderPath _finderPathWithPaginationFindByC_M;
	private FinderPath _finderPathWithoutPaginationFindByC_M;
	private FinderPath _finderPathCountByC_M;

	/**
	 * Returns all the ltw_contents where companyId = &#63; and motorcycleName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param motorcycleName the motorcycle name
	 * @return the matching ltw_contents
	 */
	@Override
	public List<LTW_content> findByC_M(long companyId, String motorcycleName) {
		return findByC_M(
			companyId, motorcycleName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<LTW_content> findByC_M(
		long companyId, String motorcycleName, int start, int end) {

		return findByC_M(companyId, motorcycleName, start, end, null);
	}

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
	@Override
	public List<LTW_content> findByC_M(
		long companyId, String motorcycleName, int start, int end,
		OrderByComparator<LTW_content> orderByComparator) {

		return findByC_M(
			companyId, motorcycleName, start, end, orderByComparator, true);
	}

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
	@Override
	public List<LTW_content> findByC_M(
		long companyId, String motorcycleName, int start, int end,
		OrderByComparator<LTW_content> orderByComparator,
		boolean useFinderCache) {

		motorcycleName = Objects.toString(motorcycleName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_M;
				finderArgs = new Object[] {companyId, motorcycleName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_M;
			finderArgs = new Object[] {
				companyId, motorcycleName, start, end, orderByComparator
			};
		}

		List<LTW_content> list = null;

		if (useFinderCache) {
			list = (List<LTW_content>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LTW_content ltw_content : list) {
					if ((companyId != ltw_content.getCompanyId()) ||
						!motorcycleName.equals(
							ltw_content.getMotorcycleName())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_LTW_CONTENT_WHERE);

			sb.append(_FINDER_COLUMN_C_M_COMPANYID_2);

			boolean bindMotorcycleName = false;

			if (motorcycleName.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_M_MOTORCYCLENAME_3);
			}
			else {
				bindMotorcycleName = true;

				sb.append(_FINDER_COLUMN_C_M_MOTORCYCLENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LTW_contentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				if (bindMotorcycleName) {
					queryPos.add(motorcycleName);
				}

				list = (List<LTW_content>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ltw_content in the ordered set where companyId = &#63; and motorcycleName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param motorcycleName the motorcycle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content findByC_M_First(
			long companyId, String motorcycleName,
			OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		LTW_content ltw_content = fetchByC_M_First(
			companyId, motorcycleName, orderByComparator);

		if (ltw_content != null) {
			return ltw_content;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", motorcycleName=");
		sb.append(motorcycleName);

		sb.append("}");

		throw new NoSuch_contentException(sb.toString());
	}

	/**
	 * Returns the first ltw_content in the ordered set where companyId = &#63; and motorcycleName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param motorcycleName the motorcycle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content fetchByC_M_First(
		long companyId, String motorcycleName,
		OrderByComparator<LTW_content> orderByComparator) {

		List<LTW_content> list = findByC_M(
			companyId, motorcycleName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ltw_content in the ordered set where companyId = &#63; and motorcycleName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param motorcycleName the motorcycle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content findByC_M_Last(
			long companyId, String motorcycleName,
			OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		LTW_content ltw_content = fetchByC_M_Last(
			companyId, motorcycleName, orderByComparator);

		if (ltw_content != null) {
			return ltw_content;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append(", motorcycleName=");
		sb.append(motorcycleName);

		sb.append("}");

		throw new NoSuch_contentException(sb.toString());
	}

	/**
	 * Returns the last ltw_content in the ordered set where companyId = &#63; and motorcycleName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param motorcycleName the motorcycle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content fetchByC_M_Last(
		long companyId, String motorcycleName,
		OrderByComparator<LTW_content> orderByComparator) {

		int count = countByC_M(companyId, motorcycleName);

		if (count == 0) {
			return null;
		}

		List<LTW_content> list = findByC_M(
			companyId, motorcycleName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public LTW_content[] findByC_M_PrevAndNext(
			long ltwId, long companyId, String motorcycleName,
			OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		motorcycleName = Objects.toString(motorcycleName, "");

		LTW_content ltw_content = findByPrimaryKey(ltwId);

		Session session = null;

		try {
			session = openSession();

			LTW_content[] array = new LTW_contentImpl[3];

			array[0] = getByC_M_PrevAndNext(
				session, ltw_content, companyId, motorcycleName,
				orderByComparator, true);

			array[1] = ltw_content;

			array[2] = getByC_M_PrevAndNext(
				session, ltw_content, companyId, motorcycleName,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LTW_content getByC_M_PrevAndNext(
		Session session, LTW_content ltw_content, long companyId,
		String motorcycleName, OrderByComparator<LTW_content> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LTW_CONTENT_WHERE);

		sb.append(_FINDER_COLUMN_C_M_COMPANYID_2);

		boolean bindMotorcycleName = false;

		if (motorcycleName.isEmpty()) {
			sb.append(_FINDER_COLUMN_C_M_MOTORCYCLENAME_3);
		}
		else {
			bindMotorcycleName = true;

			sb.append(_FINDER_COLUMN_C_M_MOTORCYCLENAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(LTW_contentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (bindMotorcycleName) {
			queryPos.add(motorcycleName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ltw_content)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LTW_content> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ltw_contents where companyId = &#63; and motorcycleName = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param motorcycleName the motorcycle name
	 */
	@Override
	public void removeByC_M(long companyId, String motorcycleName) {
		for (LTW_content ltw_content :
				findByC_M(
					companyId, motorcycleName, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(ltw_content);
		}
	}

	/**
	 * Returns the number of ltw_contents where companyId = &#63; and motorcycleName = &#63;.
	 *
	 * @param companyId the company ID
	 * @param motorcycleName the motorcycle name
	 * @return the number of matching ltw_contents
	 */
	@Override
	public int countByC_M(long companyId, String motorcycleName) {
		motorcycleName = Objects.toString(motorcycleName, "");

		FinderPath finderPath = _finderPathCountByC_M;

		Object[] finderArgs = new Object[] {companyId, motorcycleName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LTW_CONTENT_WHERE);

			sb.append(_FINDER_COLUMN_C_M_COMPANYID_2);

			boolean bindMotorcycleName = false;

			if (motorcycleName.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_M_MOTORCYCLENAME_3);
			}
			else {
				bindMotorcycleName = true;

				sb.append(_FINDER_COLUMN_C_M_MOTORCYCLENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				if (bindMotorcycleName) {
					queryPos.add(motorcycleName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_M_COMPANYID_2 =
		"ltw_content.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_M_MOTORCYCLENAME_2 =
		"ltw_content.motorcycleName = ?";

	private static final String _FINDER_COLUMN_C_M_MOTORCYCLENAME_3 =
		"(ltw_content.motorcycleName IS NULL OR ltw_content.motorcycleName = '')";

	private FinderPath _finderPathWithPaginationFindByG_M;
	private FinderPath _finderPathWithoutPaginationFindByG_M;
	private FinderPath _finderPathCountByG_M;

	/**
	 * Returns all the ltw_contents where groupId = &#63; and motorcycleManufacturing = &#63;.
	 *
	 * @param groupId the group ID
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @return the matching ltw_contents
	 */
	@Override
	public List<LTW_content> findByG_M(
		long groupId, String motorcycleManufacturing) {

		return findByG_M(
			groupId, motorcycleManufacturing, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<LTW_content> findByG_M(
		long groupId, String motorcycleManufacturing, int start, int end) {

		return findByG_M(groupId, motorcycleManufacturing, start, end, null);
	}

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
	@Override
	public List<LTW_content> findByG_M(
		long groupId, String motorcycleManufacturing, int start, int end,
		OrderByComparator<LTW_content> orderByComparator) {

		return findByG_M(
			groupId, motorcycleManufacturing, start, end, orderByComparator,
			true);
	}

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
	@Override
	public List<LTW_content> findByG_M(
		long groupId, String motorcycleManufacturing, int start, int end,
		OrderByComparator<LTW_content> orderByComparator,
		boolean useFinderCache) {

		motorcycleManufacturing = Objects.toString(motorcycleManufacturing, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_M;
				finderArgs = new Object[] {groupId, motorcycleManufacturing};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_M;
			finderArgs = new Object[] {
				groupId, motorcycleManufacturing, start, end, orderByComparator
			};
		}

		List<LTW_content> list = null;

		if (useFinderCache) {
			list = (List<LTW_content>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LTW_content ltw_content : list) {
					if ((groupId != ltw_content.getGroupId()) ||
						!motorcycleManufacturing.equals(
							ltw_content.getMotorcycleManufacturing())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_LTW_CONTENT_WHERE);

			sb.append(_FINDER_COLUMN_G_M_GROUPID_2);

			boolean bindMotorcycleManufacturing = false;

			if (motorcycleManufacturing.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_M_MOTORCYCLEMANUFACTURING_3);
			}
			else {
				bindMotorcycleManufacturing = true;

				sb.append(_FINDER_COLUMN_G_M_MOTORCYCLEMANUFACTURING_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LTW_contentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindMotorcycleManufacturing) {
					queryPos.add(motorcycleManufacturing);
				}

				list = (List<LTW_content>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ltw_content in the ordered set where groupId = &#63; and motorcycleManufacturing = &#63;.
	 *
	 * @param groupId the group ID
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content findByG_M_First(
			long groupId, String motorcycleManufacturing,
			OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		LTW_content ltw_content = fetchByG_M_First(
			groupId, motorcycleManufacturing, orderByComparator);

		if (ltw_content != null) {
			return ltw_content;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", motorcycleManufacturing=");
		sb.append(motorcycleManufacturing);

		sb.append("}");

		throw new NoSuch_contentException(sb.toString());
	}

	/**
	 * Returns the first ltw_content in the ordered set where groupId = &#63; and motorcycleManufacturing = &#63;.
	 *
	 * @param groupId the group ID
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content fetchByG_M_First(
		long groupId, String motorcycleManufacturing,
		OrderByComparator<LTW_content> orderByComparator) {

		List<LTW_content> list = findByG_M(
			groupId, motorcycleManufacturing, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ltw_content in the ordered set where groupId = &#63; and motorcycleManufacturing = &#63;.
	 *
	 * @param groupId the group ID
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content findByG_M_Last(
			long groupId, String motorcycleManufacturing,
			OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		LTW_content ltw_content = fetchByG_M_Last(
			groupId, motorcycleManufacturing, orderByComparator);

		if (ltw_content != null) {
			return ltw_content;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", motorcycleManufacturing=");
		sb.append(motorcycleManufacturing);

		sb.append("}");

		throw new NoSuch_contentException(sb.toString());
	}

	/**
	 * Returns the last ltw_content in the ordered set where groupId = &#63; and motorcycleManufacturing = &#63;.
	 *
	 * @param groupId the group ID
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content fetchByG_M_Last(
		long groupId, String motorcycleManufacturing,
		OrderByComparator<LTW_content> orderByComparator) {

		int count = countByG_M(groupId, motorcycleManufacturing);

		if (count == 0) {
			return null;
		}

		List<LTW_content> list = findByG_M(
			groupId, motorcycleManufacturing, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public LTW_content[] findByG_M_PrevAndNext(
			long ltwId, long groupId, String motorcycleManufacturing,
			OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		motorcycleManufacturing = Objects.toString(motorcycleManufacturing, "");

		LTW_content ltw_content = findByPrimaryKey(ltwId);

		Session session = null;

		try {
			session = openSession();

			LTW_content[] array = new LTW_contentImpl[3];

			array[0] = getByG_M_PrevAndNext(
				session, ltw_content, groupId, motorcycleManufacturing,
				orderByComparator, true);

			array[1] = ltw_content;

			array[2] = getByG_M_PrevAndNext(
				session, ltw_content, groupId, motorcycleManufacturing,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LTW_content getByG_M_PrevAndNext(
		Session session, LTW_content ltw_content, long groupId,
		String motorcycleManufacturing,
		OrderByComparator<LTW_content> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LTW_CONTENT_WHERE);

		sb.append(_FINDER_COLUMN_G_M_GROUPID_2);

		boolean bindMotorcycleManufacturing = false;

		if (motorcycleManufacturing.isEmpty()) {
			sb.append(_FINDER_COLUMN_G_M_MOTORCYCLEMANUFACTURING_3);
		}
		else {
			bindMotorcycleManufacturing = true;

			sb.append(_FINDER_COLUMN_G_M_MOTORCYCLEMANUFACTURING_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(LTW_contentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (bindMotorcycleManufacturing) {
			queryPos.add(motorcycleManufacturing);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ltw_content)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LTW_content> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ltw_contents where groupId = &#63; and motorcycleManufacturing = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 */
	@Override
	public void removeByG_M(long groupId, String motorcycleManufacturing) {
		for (LTW_content ltw_content :
				findByG_M(
					groupId, motorcycleManufacturing, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(ltw_content);
		}
	}

	/**
	 * Returns the number of ltw_contents where groupId = &#63; and motorcycleManufacturing = &#63;.
	 *
	 * @param groupId the group ID
	 * @param motorcycleManufacturing the motorcycle manufacturing
	 * @return the number of matching ltw_contents
	 */
	@Override
	public int countByG_M(long groupId, String motorcycleManufacturing) {
		motorcycleManufacturing = Objects.toString(motorcycleManufacturing, "");

		FinderPath finderPath = _finderPathCountByG_M;

		Object[] finderArgs = new Object[] {groupId, motorcycleManufacturing};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LTW_CONTENT_WHERE);

			sb.append(_FINDER_COLUMN_G_M_GROUPID_2);

			boolean bindMotorcycleManufacturing = false;

			if (motorcycleManufacturing.isEmpty()) {
				sb.append(_FINDER_COLUMN_G_M_MOTORCYCLEMANUFACTURING_3);
			}
			else {
				bindMotorcycleManufacturing = true;

				sb.append(_FINDER_COLUMN_G_M_MOTORCYCLEMANUFACTURING_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindMotorcycleManufacturing) {
					queryPos.add(motorcycleManufacturing);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_M_GROUPID_2 =
		"ltw_content.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_M_MOTORCYCLEMANUFACTURING_2 =
		"ltw_content.motorcycleManufacturing = ?";

	private static final String _FINDER_COLUMN_G_M_MOTORCYCLEMANUFACTURING_3 =
		"(ltw_content.motorcycleManufacturing IS NULL OR ltw_content.motorcycleManufacturing = '')";

	private FinderPath _finderPathWithPaginationFindByM_L;
	private FinderPath _finderPathWithoutPaginationFindByM_L;
	private FinderPath _finderPathCountByM_L;

	/**
	 * Returns all the ltw_contents where motorcycleYear = &#63; and ltwId = &#63;.
	 *
	 * @param motorcycleYear the motorcycle year
	 * @param ltwId the ltw ID
	 * @return the matching ltw_contents
	 */
	@Override
	public List<LTW_content> findByM_L(int motorcycleYear, long ltwId) {
		return findByM_L(
			motorcycleYear, ltwId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<LTW_content> findByM_L(
		int motorcycleYear, long ltwId, int start, int end) {

		return findByM_L(motorcycleYear, ltwId, start, end, null);
	}

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
	@Override
	public List<LTW_content> findByM_L(
		int motorcycleYear, long ltwId, int start, int end,
		OrderByComparator<LTW_content> orderByComparator) {

		return findByM_L(
			motorcycleYear, ltwId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<LTW_content> findByM_L(
		int motorcycleYear, long ltwId, int start, int end,
		OrderByComparator<LTW_content> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByM_L;
				finderArgs = new Object[] {motorcycleYear, ltwId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByM_L;
			finderArgs = new Object[] {
				motorcycleYear, ltwId, start, end, orderByComparator
			};
		}

		List<LTW_content> list = null;

		if (useFinderCache) {
			list = (List<LTW_content>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LTW_content ltw_content : list) {
					if ((motorcycleYear != ltw_content.getMotorcycleYear()) ||
						(ltwId != ltw_content.getLtwId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_LTW_CONTENT_WHERE);

			sb.append(_FINDER_COLUMN_M_L_MOTORCYCLEYEAR_2);

			sb.append(_FINDER_COLUMN_M_L_LTWID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LTW_contentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(motorcycleYear);

				queryPos.add(ltwId);

				list = (List<LTW_content>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ltw_content in the ordered set where motorcycleYear = &#63; and ltwId = &#63;.
	 *
	 * @param motorcycleYear the motorcycle year
	 * @param ltwId the ltw ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content findByM_L_First(
			int motorcycleYear, long ltwId,
			OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		LTW_content ltw_content = fetchByM_L_First(
			motorcycleYear, ltwId, orderByComparator);

		if (ltw_content != null) {
			return ltw_content;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("motorcycleYear=");
		sb.append(motorcycleYear);

		sb.append(", ltwId=");
		sb.append(ltwId);

		sb.append("}");

		throw new NoSuch_contentException(sb.toString());
	}

	/**
	 * Returns the first ltw_content in the ordered set where motorcycleYear = &#63; and ltwId = &#63;.
	 *
	 * @param motorcycleYear the motorcycle year
	 * @param ltwId the ltw ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content fetchByM_L_First(
		int motorcycleYear, long ltwId,
		OrderByComparator<LTW_content> orderByComparator) {

		List<LTW_content> list = findByM_L(
			motorcycleYear, ltwId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ltw_content in the ordered set where motorcycleYear = &#63; and ltwId = &#63;.
	 *
	 * @param motorcycleYear the motorcycle year
	 * @param ltwId the ltw ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content
	 * @throws NoSuch_contentException if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content findByM_L_Last(
			int motorcycleYear, long ltwId,
			OrderByComparator<LTW_content> orderByComparator)
		throws NoSuch_contentException {

		LTW_content ltw_content = fetchByM_L_Last(
			motorcycleYear, ltwId, orderByComparator);

		if (ltw_content != null) {
			return ltw_content;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("motorcycleYear=");
		sb.append(motorcycleYear);

		sb.append(", ltwId=");
		sb.append(ltwId);

		sb.append("}");

		throw new NoSuch_contentException(sb.toString());
	}

	/**
	 * Returns the last ltw_content in the ordered set where motorcycleYear = &#63; and ltwId = &#63;.
	 *
	 * @param motorcycleYear the motorcycle year
	 * @param ltwId the ltw ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ltw_content, or <code>null</code> if a matching ltw_content could not be found
	 */
	@Override
	public LTW_content fetchByM_L_Last(
		int motorcycleYear, long ltwId,
		OrderByComparator<LTW_content> orderByComparator) {

		int count = countByM_L(motorcycleYear, ltwId);

		if (count == 0) {
			return null;
		}

		List<LTW_content> list = findByM_L(
			motorcycleYear, ltwId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the ltw_contents where motorcycleYear = &#63; and ltwId = &#63; from the database.
	 *
	 * @param motorcycleYear the motorcycle year
	 * @param ltwId the ltw ID
	 */
	@Override
	public void removeByM_L(int motorcycleYear, long ltwId) {
		for (LTW_content ltw_content :
				findByM_L(
					motorcycleYear, ltwId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ltw_content);
		}
	}

	/**
	 * Returns the number of ltw_contents where motorcycleYear = &#63; and ltwId = &#63;.
	 *
	 * @param motorcycleYear the motorcycle year
	 * @param ltwId the ltw ID
	 * @return the number of matching ltw_contents
	 */
	@Override
	public int countByM_L(int motorcycleYear, long ltwId) {
		FinderPath finderPath = _finderPathCountByM_L;

		Object[] finderArgs = new Object[] {motorcycleYear, ltwId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LTW_CONTENT_WHERE);

			sb.append(_FINDER_COLUMN_M_L_MOTORCYCLEYEAR_2);

			sb.append(_FINDER_COLUMN_M_L_LTWID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(motorcycleYear);

				queryPos.add(ltwId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_M_L_MOTORCYCLEYEAR_2 =
		"ltw_content.motorcycleYear = ? AND ";

	private static final String _FINDER_COLUMN_M_L_LTWID_2 =
		"ltw_content.ltwId = ?";

	public LTW_contentPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(LTW_content.class);

		setModelImplClass(LTW_contentImpl.class);
		setModelPKClass(long.class);

		setTable(LTW_contentTable.INSTANCE);
	}

	/**
	 * Caches the ltw_content in the entity cache if it is enabled.
	 *
	 * @param ltw_content the ltw_content
	 */
	@Override
	public void cacheResult(LTW_content ltw_content) {
		entityCache.putResult(
			LTW_contentImpl.class, ltw_content.getPrimaryKey(), ltw_content);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {ltw_content.getUuid(), ltw_content.getGroupId()},
			ltw_content);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the ltw_contents in the entity cache if it is enabled.
	 *
	 * @param ltw_contents the ltw_contents
	 */
	@Override
	public void cacheResult(List<LTW_content> ltw_contents) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (ltw_contents.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (LTW_content ltw_content : ltw_contents) {
			if (entityCache.getResult(
					LTW_contentImpl.class, ltw_content.getPrimaryKey()) ==
						null) {

				cacheResult(ltw_content);
			}
		}
	}

	/**
	 * Clears the cache for all ltw_contents.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LTW_contentImpl.class);

		finderCache.clearCache(LTW_contentImpl.class);
	}

	/**
	 * Clears the cache for the ltw_content.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LTW_content ltw_content) {
		entityCache.removeResult(LTW_contentImpl.class, ltw_content);
	}

	@Override
	public void clearCache(List<LTW_content> ltw_contents) {
		for (LTW_content ltw_content : ltw_contents) {
			entityCache.removeResult(LTW_contentImpl.class, ltw_content);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LTW_contentImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LTW_contentImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LTW_contentModelImpl ltw_contentModelImpl) {

		Object[] args = new Object[] {
			ltw_contentModelImpl.getUuid(), ltw_contentModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, ltw_contentModelImpl);
	}

	/**
	 * Creates a new ltw_content with the primary key. Does not add the ltw_content to the database.
	 *
	 * @param ltwId the primary key for the new ltw_content
	 * @return the new ltw_content
	 */
	@Override
	public LTW_content create(long ltwId) {
		LTW_content ltw_content = new LTW_contentImpl();

		ltw_content.setNew(true);
		ltw_content.setPrimaryKey(ltwId);

		String uuid = PortalUUIDUtil.generate();

		ltw_content.setUuid(uuid);

		ltw_content.setCompanyId(CompanyThreadLocal.getCompanyId());

		return ltw_content;
	}

	/**
	 * Removes the ltw_content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ltwId the primary key of the ltw_content
	 * @return the ltw_content that was removed
	 * @throws NoSuch_contentException if a ltw_content with the primary key could not be found
	 */
	@Override
	public LTW_content remove(long ltwId) throws NoSuch_contentException {
		return remove((Serializable)ltwId);
	}

	/**
	 * Removes the ltw_content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ltw_content
	 * @return the ltw_content that was removed
	 * @throws NoSuch_contentException if a ltw_content with the primary key could not be found
	 */
	@Override
	public LTW_content remove(Serializable primaryKey)
		throws NoSuch_contentException {

		Session session = null;

		try {
			session = openSession();

			LTW_content ltw_content = (LTW_content)session.get(
				LTW_contentImpl.class, primaryKey);

			if (ltw_content == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuch_contentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ltw_content);
		}
		catch (NoSuch_contentException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected LTW_content removeImpl(LTW_content ltw_content) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ltw_content)) {
				ltw_content = (LTW_content)session.get(
					LTW_contentImpl.class, ltw_content.getPrimaryKeyObj());
			}

			if (ltw_content != null) {
				session.delete(ltw_content);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (ltw_content != null) {
			clearCache(ltw_content);
		}

		return ltw_content;
	}

	@Override
	public LTW_content updateImpl(LTW_content ltw_content) {
		boolean isNew = ltw_content.isNew();

		if (!(ltw_content instanceof LTW_contentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ltw_content.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(ltw_content);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ltw_content proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LTW_content implementation " +
					ltw_content.getClass());
		}

		LTW_contentModelImpl ltw_contentModelImpl =
			(LTW_contentModelImpl)ltw_content;

		if (Validator.isNull(ltw_content.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			ltw_content.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (ltw_content.getCreateDate() == null)) {
			if (serviceContext == null) {
				ltw_content.setCreateDate(date);
			}
			else {
				ltw_content.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!ltw_contentModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ltw_content.setModifiedDate(date);
			}
			else {
				ltw_content.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(ltw_content);
			}
			else {
				ltw_content = (LTW_content)session.merge(ltw_content);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LTW_contentImpl.class, ltw_contentModelImpl, false, true);

		cacheUniqueFindersCache(ltw_contentModelImpl);

		if (isNew) {
			ltw_content.setNew(false);
		}

		ltw_content.resetOriginalValues();

		return ltw_content;
	}

	/**
	 * Returns the ltw_content with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ltw_content
	 * @return the ltw_content
	 * @throws NoSuch_contentException if a ltw_content with the primary key could not be found
	 */
	@Override
	public LTW_content findByPrimaryKey(Serializable primaryKey)
		throws NoSuch_contentException {

		LTW_content ltw_content = fetchByPrimaryKey(primaryKey);

		if (ltw_content == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuch_contentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ltw_content;
	}

	/**
	 * Returns the ltw_content with the primary key or throws a <code>NoSuch_contentException</code> if it could not be found.
	 *
	 * @param ltwId the primary key of the ltw_content
	 * @return the ltw_content
	 * @throws NoSuch_contentException if a ltw_content with the primary key could not be found
	 */
	@Override
	public LTW_content findByPrimaryKey(long ltwId)
		throws NoSuch_contentException {

		return findByPrimaryKey((Serializable)ltwId);
	}

	/**
	 * Returns the ltw_content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ltwId the primary key of the ltw_content
	 * @return the ltw_content, or <code>null</code> if a ltw_content with the primary key could not be found
	 */
	@Override
	public LTW_content fetchByPrimaryKey(long ltwId) {
		return fetchByPrimaryKey((Serializable)ltwId);
	}

	/**
	 * Returns all the ltw_contents.
	 *
	 * @return the ltw_contents
	 */
	@Override
	public List<LTW_content> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LTW_content> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<LTW_content> findAll(
		int start, int end, OrderByComparator<LTW_content> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<LTW_content> findAll(
		int start, int end, OrderByComparator<LTW_content> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<LTW_content> list = null;

		if (useFinderCache) {
			list = (List<LTW_content>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LTW_CONTENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LTW_CONTENT;

				sql = sql.concat(LTW_contentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LTW_content>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the ltw_contents from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LTW_content ltw_content : findAll()) {
			remove(ltw_content);
		}
	}

	/**
	 * Returns the number of ltw_contents.
	 *
	 * @return the number of ltw_contents
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LTW_CONTENT);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "ltwId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LTW_CONTENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LTW_contentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ltw_content persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);

		_finderPathWithPaginationFindByCompanyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"companyId"}, true);

		_finderPathWithoutPaginationFindByCompanyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] {Long.class.getName()}, new String[] {"companyId"},
			true);

		_finderPathCountByCompanyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] {Long.class.getName()}, new String[] {"companyId"},
			false);

		_finderPathWithPaginationFindByC_U = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"companyId", "userId"}, true);

		_finderPathWithoutPaginationFindByC_U = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_U",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"companyId", "userId"}, true);

		_finderPathCountByC_U = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_U",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"companyId", "userId"}, false);

		_finderPathWithPaginationFindByU = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userName"}, true);

		_finderPathWithoutPaginationFindByU = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU",
			new String[] {String.class.getName()}, new String[] {"userName"},
			true);

		_finderPathCountByU = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU",
			new String[] {String.class.getName()}, new String[] {"userName"},
			false);

		_finderPathWithPaginationFindByC_M = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_M",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"companyId", "motorcycleName"}, true);

		_finderPathWithoutPaginationFindByC_M = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_M",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "motorcycleName"}, true);

		_finderPathCountByC_M = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_M",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"companyId", "motorcycleName"}, false);

		_finderPathWithPaginationFindByG_M = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_M",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "motorcycleManufacturing"}, true);

		_finderPathWithoutPaginationFindByG_M = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_M",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"groupId", "motorcycleManufacturing"}, true);

		_finderPathCountByG_M = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_M",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"groupId", "motorcycleManufacturing"}, false);

		_finderPathWithPaginationFindByM_L = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByM_L",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"motorcycleYear", "ltwId"}, true);

		_finderPathWithoutPaginationFindByM_L = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByM_L",
			new String[] {Integer.class.getName(), Long.class.getName()},
			new String[] {"motorcycleYear", "ltwId"}, true);

		_finderPathCountByM_L = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByM_L",
			new String[] {Integer.class.getName(), Long.class.getName()},
			new String[] {"motorcycleYear", "ltwId"}, false);

		LTW_contentUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		LTW_contentUtil.setPersistence(null);

		entityCache.removeCache(LTW_contentImpl.class.getName());
	}

	@Override
	@Reference(
		target = LTWPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = LTWPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = LTWPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_LTW_CONTENT =
		"SELECT ltw_content FROM LTW_content ltw_content";

	private static final String _SQL_SELECT_LTW_CONTENT_WHERE =
		"SELECT ltw_content FROM LTW_content ltw_content WHERE ";

	private static final String _SQL_COUNT_LTW_CONTENT =
		"SELECT COUNT(ltw_content) FROM LTW_content ltw_content";

	private static final String _SQL_COUNT_LTW_CONTENT_WHERE =
		"SELECT COUNT(ltw_content) FROM LTW_content ltw_content WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ltw_content.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LTW_content exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LTW_content exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LTW_contentPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}