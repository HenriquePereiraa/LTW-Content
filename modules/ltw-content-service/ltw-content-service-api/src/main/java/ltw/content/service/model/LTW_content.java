/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ltw.content.service.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the LTW_content service. Represents a row in the &quot;LTW_LTW_content&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see LTW_contentModel
 * @generated
 */
@ImplementationClassName("ltw.content.service.model.impl.LTW_contentImpl")
@ProviderType
public interface LTW_content extends LTW_contentModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>ltw.content.service.model.impl.LTW_contentImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<LTW_content, Long> LTW_ID_ACCESSOR =
		new Accessor<LTW_content, Long>() {

			@Override
			public Long get(LTW_content ltw_content) {
				return ltw_content.getLtwId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<LTW_content> getTypeClass() {
				return LTW_content.class;
			}

		};

}