package ltw.content.rest.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.batch.engine.resource.VulcanBatchEngineImportTaskResource;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import ltw.content.rest.dto.v1_0.LTW_content;
import ltw.content.rest.resource.v1_0.LTW_contentResource;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Henrique Pereira
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setLTW_contentResourceComponentServiceObjects(
		ComponentServiceObjects<LTW_contentResource>
			ltw_contentResourceComponentServiceObjects) {

		_ltw_contentResourceComponentServiceObjects =
			ltw_contentResourceComponentServiceObjects;
	}

	@GraphQLField
	public LTW_content addLTW_content(@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_ltw_contentResourceComponentServiceObjects,
			this::_populateResourceContext,
			ltw_contentResource -> ltw_contentResource.addLTW_content(object));
	}

	@GraphQLField
	public boolean deleteLTW_content(
			@GraphQLName("ltwContentId") Long ltwContentId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_ltw_contentResourceComponentServiceObjects,
			this::_populateResourceContext,
			ltw_contentResource -> ltw_contentResource.deleteLTW_content(
				ltwContentId));

		return true;
	}

	@GraphQLField
	public Response deleteLTW_contentBatch(
			@GraphQLName("ltwContentId") Long ltwContentId,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_ltw_contentResourceComponentServiceObjects,
			this::_populateResourceContext,
			ltw_contentResource -> ltw_contentResource.deleteLTW_contentBatch(
				ltwContentId, callbackURL, object));
	}

	@GraphQLField
	public LTW_content updateLTW_Content(
			@GraphQLName("ltwContentId") Long ltwContentId,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_ltw_contentResourceComponentServiceObjects,
			this::_populateResourceContext,
			ltw_contentResource -> ltw_contentResource.putLTW_Content(
				ltwContentId, object));
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

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
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

		ltw_contentResource.setVulcanBatchEngineImportTaskResource(
			_vulcanBatchEngineImportTaskResource);
	}

	private static ComponentServiceObjects<LTW_contentResource>
		_ltw_contentResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;
	private VulcanBatchEngineImportTaskResource
		_vulcanBatchEngineImportTaskResource;

}