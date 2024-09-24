package ltw.content.rest.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import ltw.content.rest.dto.v1_0.LTW_content;
import ltw.content.rest.resource.v1_0.LTW_contentResource;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Henrique Pereira
 * @generated
 */
@Generated("")
public class Query {

	public static void setLTW_contentResourceComponentServiceObjects(
		ComponentServiceObjects<LTW_contentResource>
			ltw_contentResourceComponentServiceObjects) {

		_ltw_contentResourceComponentServiceObjects =
			ltw_contentResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {allLTW_contents{items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public LTW_contentPage allLTW_contents() throws Exception {
		return _applyComponentServiceObjects(
			_ltw_contentResourceComponentServiceObjects,
			this::_populateResourceContext,
			ltw_contentResource -> new LTW_contentPage(
				ltw_contentResource.getAllLTW_contents()));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {lTW_content(ltwContentId: ___){contentId, motorcycleName, motorcycleManufacturing, motorcycleYear, userId, userName, createDate, modifiedDate}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public LTW_content lTW_content(
			@GraphQLName("ltwContentId") Long ltwContentId)
		throws Exception {

		return _applyComponentServiceObjects(
			_ltw_contentResourceComponentServiceObjects,
			this::_populateResourceContext,
			ltw_contentResource -> ltw_contentResource.getLTW_content(
				ltwContentId));
	}

	@GraphQLName("LTW_contentPage")
	public class LTW_contentPage {

		public LTW_contentPage(Page ltw_contentPage) {
			actions = ltw_contentPage.getActions();

			items = ltw_contentPage.getItems();
			lastPage = ltw_contentPage.getLastPage();
			page = ltw_contentPage.getPage();
			pageSize = ltw_contentPage.getPageSize();
			totalCount = ltw_contentPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map<String, String>> actions;

		@GraphQLField
		protected java.util.Collection<LTW_content> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(
			LTW_contentResource ltw_contentResource)
		throws Exception {

		ltw_contentResource.setContextAcceptLanguage(_acceptLanguage);
		ltw_contentResource.setContextCompany(_company);
		ltw_contentResource.setContextHttpServletRequest(_httpServletRequest);
		ltw_contentResource.setContextHttpServletResponse(_httpServletResponse);
		ltw_contentResource.setContextUriInfo(_uriInfo);
		ltw_contentResource.setContextUser(_user);
		ltw_contentResource.setGroupLocalService(_groupLocalService);
		ltw_contentResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<LTW_contentResource>
		_ltw_contentResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}