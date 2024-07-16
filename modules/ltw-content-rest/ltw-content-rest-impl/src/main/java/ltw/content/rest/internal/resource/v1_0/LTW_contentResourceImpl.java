package ltw.content.rest.internal.resource.v1_0;

import ltw.content.rest.resource.v1_0.LTW_contentResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Henrique Pereira
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/ltw_content.properties",
	scope = ServiceScope.PROTOTYPE, service = LTW_contentResource.class
)
public class LTW_contentResourceImpl extends BaseLTW_contentResourceImpl {
}