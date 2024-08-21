package ltw.content.rest.internal.graphql.servlet.v1_0;

import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import ltw.content.rest.internal.graphql.mutation.v1_0.Mutation;
import ltw.content.rest.internal.graphql.query.v1_0.Query;
import ltw.content.rest.internal.resource.v1_0.LTW_contentResourceImpl;
import ltw.content.rest.resource.v1_0.LTW_contentResource;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author Henrique Pereira
 * @generated
 */
@Component(service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setLTW_contentResourceComponentServiceObjects(
			_ltw_contentResourceComponentServiceObjects);

		Query.setLTW_contentResourceComponentServiceObjects(
			_ltw_contentResourceComponentServiceObjects);
	}

	public String getApplicationName() {
		return "LtwContentRest";
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/ltw-content-rest-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	public ObjectValuePair<Class<?>, String> getResourceMethodObjectValuePair(
		String methodName, boolean mutation) {

		if (mutation) {
			return _resourceMethodObjectValuePairs.get(
				"mutation#" + methodName);
		}

		return _resourceMethodObjectValuePairs.get("query#" + methodName);
	}

	private static final Map<String, ObjectValuePair<Class<?>, String>>
		_resourceMethodObjectValuePairs =
			new HashMap<String, ObjectValuePair<Class<?>, String>>() {
				{
					put(
						"mutation#addLTW_content",
						new ObjectValuePair<>(
							LTW_contentResourceImpl.class, "addLTW_content"));

					put(
						"query#lTW_content",
						new ObjectValuePair<>(
							LTW_contentResourceImpl.class, "getLTW_content"));
				}
			};

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<LTW_contentResource>
		_ltw_contentResourceComponentServiceObjects;

}