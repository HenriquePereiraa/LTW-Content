/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ltw.content.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;LTW_LTW_content&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see LTW_content
 * @generated
 */
public class LTW_contentTable extends BaseTable<LTW_contentTable> {

	public static final LTW_contentTable INSTANCE = new LTW_contentTable();

	public final Column<LTW_contentTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LTW_contentTable, Long> ltwId = createColumn(
		"ltwId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LTW_contentTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LTW_contentTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LTW_contentTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LTW_contentTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LTW_contentTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LTW_contentTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LTW_contentTable, String> motorcycleName = createColumn(
		"motorcycleName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LTW_contentTable, String> motorcycleManufacturing =
		createColumn(
			"motorcycleManufacturing", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<LTW_contentTable, Integer> motorcycleYear =
		createColumn(
			"motorcycleYear", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);

	private LTW_contentTable() {
		super("LTW_LTW_content", LTW_contentTable::new);
	}

}