/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ltw.content.service.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import ltw.content.service.model.LTW_contentTable;
import ltw.content.service.model.impl.LTW_contentImpl;
import ltw.content.service.model.impl.LTW_contentModelImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from LTW_content.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=ltw.content.service.model.impl.LTW_contentImpl",
		"table.name=LTW_LTW_content"
	},
	service = ArgumentsResolver.class
)
public class LTW_contentModelArgumentsResolver implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		LTW_contentModelImpl ltw_contentModelImpl =
			(LTW_contentModelImpl)baseModel;

		long columnBitmask = ltw_contentModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(ltw_contentModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					ltw_contentModelImpl.getColumnBitmask(columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(LTW_contentPersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(ltw_contentModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return LTW_contentImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return LTW_contentTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		LTW_contentModelImpl ltw_contentModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = ltw_contentModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = ltw_contentModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

	private static final long _ORDER_BY_COLUMNS_BITMASK;

	static {
		long orderByColumnsBitmask = 0;

		orderByColumnsBitmask |= LTW_contentModelImpl.getColumnBitmask(
			"motorcycleYear");

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}