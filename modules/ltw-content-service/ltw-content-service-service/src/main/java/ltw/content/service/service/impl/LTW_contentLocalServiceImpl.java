/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ltw.content.service.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.Validator;
import ltw.content.service.model.LTW_content;
import ltw.content.service.service.base.LTW_contentLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

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
	public LTW_content addLTW_content(String motorcycleName, String motorcycleManufacturing, int motorcycleYear) {
		// Fetch the current service context
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		// Generate a unique ID for the new content
		long contentId = counterLocalService.increment(LTW_content.class.getName());

		// Fazer um create antes de fazre um update
		LTW_content ltw_content = ltw_contentPersistence.create(contentId);

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

			return ltw_content;

        } catch (PortalException e) {
            throw new RuntimeException(e);
        }
	}

	@Override
	public LTW_content getLTW_content(long ltwId) throws PortalException {
		return super.getLTW_content(ltwId);
	}

	@Override
	public BaseModelSearchResult<LTW_content> searchLtwContent(
			long companyId, String className, long classPK, String keywords,
			LinkedHashMap<String, Object> params, int start, int end, Sort sort) throws PortalException {

		SearchContext searchContext = buildSearchContext(
				companyId,className, classPK, keywords, params, start, end, sort);
		return searchLtwContent(searchContext);
	}

	protected SearchContext buildSearchContext(
			long companyId, String className, long classPK, String keywords,
			LinkedHashMap<String, Object> params, int start, int end, Sort sort
	) {
		SearchContext searchContext = new SearchContext();

		searchContext.setAttributes(
			HashMapBuilder.<String, Serializable>put(
					Field.CLASS_NAME_ID,
					ClassNameLocalServiceUtil.getClassNameId(className)
			).put(
					Field.CLASS_PK, classPK
			).put(
					Field.NAME, keywords
			).put(
					"motocycle", keywords
			).put(
					"manufacturing", keywords
			).put(
					"year", keywords
			).build()
		);

		searchContext.setCompanyId(companyId);
		searchContext.setEnd(end);

		if (Validator.isNotNull(keywords)) {
			searchContext.setKeywords(keywords);
		}

		if (sort != null) {
			searchContext.setSorts(sort);
		}

		searchContext.setStart(start);

		QueryConfig queryConfig = searchContext.getQueryConfig();

		queryConfig.setHighlightEnabled(false);
		queryConfig.setScoreEnabled(false);

		return searchContext;
	}

	protected BaseModelSearchResult<LTW_content> searchLtwContent(SearchContext searchContext) throws PortalException {
		Indexer<LTW_content> indexer = IndexerRegistryUtil.nullSafeGetIndexer(
				LTW_content.class);

		for (int i = 0; i < 10; i++) {
			Hits hits = indexer.search(searchContext);

			List<LTW_content> ltw_content = getLtwContents(hits);

			if (ltw_content != null) {
				return new BaseModelSearchResult<>(ltw_content, hits.getLength());
			}
		}

		throw new SearchException(
				"Unable to fix the search index after 10 attempts");
	}


	protected List<LTW_content> getLtwContents(Hits hits) throws  PortalException {
		List<Document> documents = hits.toList();

		List<LTW_content> ltwcontents = new ArrayList<>(documents.size());

		for (Document document : documents) {
			long addressId = GetterUtil.getLong(
					document.get(Field.ENTRY_CLASS_PK));

			LTW_content ltwcontent = fetchLTW_content(addressId);

			if (ltwcontent == null) {
				ltwcontents = null;

				Indexer<LTW_content> indexer = IndexerRegistryUtil.getIndexer(
						LTW_content.class);

				long companyId = GetterUtil.getLong(
						document.get(Field.COMPANY_ID));

				indexer.delete(companyId, document.getUID());
			}
			else if (ltwcontents != null) {
				ltwcontents.add(ltwcontent);
			}
		}

		return ltwcontents;
	}



	@Override
	public List<LTW_content> getAllLTW_Contents() {
			return ltw_contentPersistence.findAll();
	}

	@Override
	public LTW_content updateLTW_content(long ltwId, LTW_content ltw_content) throws PortalException {

		LTW_content ltwContentById = ltw_contentPersistence.findByPrimaryKey(ltwId);

		ltwContentById.setMotorcycleYear(ltw_content.getMotorcycleYear());
		ltwContentById.setMotorcycleName(ltw_content.getMotorcycleName());
		ltwContentById.setMotorcycleManufacturing(ltw_content.getMotorcycleManufacturing());

		ltwContentById = ltw_contentPersistence.update(ltwContentById);

		return ltwContentById;
	}

	@Override
	public LTW_content updateLTW_content(LTW_content ltw_content) {
		return null;
	}

	@Override
	public LTW_content deleteLTW_content(long ltwId) throws PortalException {
		LTW_content ltwContent = ltw_contentPersistence.findByPrimaryKey(ltwId);

		if (ltwContent == null) {
			throw new PortalException("Content not found.");
		}

		return ltw_contentPersistence.remove(ltwId);
	}

	@Reference
	private ResourceLocalService _resourceLocalService;
}