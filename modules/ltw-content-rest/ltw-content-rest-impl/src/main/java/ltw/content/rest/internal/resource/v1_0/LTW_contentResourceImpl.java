package ltw.content.rest.internal.resource.v1_0;

import jdk.nashorn.internal.parser.JSONParser;
import ltw.content.rest.dto.v1_0.LTW_content;
import ltw.content.rest.resource.v1_0.LTW_contentResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;
import ltw.content.service.service.LTW_contentLocalService;

import java.util.Map;

/**
 * @author Henrique Pereira
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/ltw_content.properties",
	scope = ServiceScope.PROTOTYPE, service = LTW_contentResource.class
)
public class LTW_contentResourceImpl extends BaseLTW_contentResourceImpl {

	@Override
	public LTW_content addLTW_content(Object object) throws Exception {
		if(object instanceof  Map) {

			Map<String, Object> data = (Map<String, Object>) object;

			String motorcycleName = (String) data.get("motorcycleName");
			String motorcycleManufacturing =  (String) data.get("motorcycleManufacturing");
			int motorcycleYear = (Integer) data.get("motorcycleYear");

			ltw.content.service.model.LTW_content content = _ltw_contentLocalService.addLTW_content(motorcycleName, motorcycleManufacturing, motorcycleYear);
			return _toLTWContent(content);
		} else {
			throw new Exception();
		}
	}

	private LTW_content _toLTWContent(ltw.content.service.model.LTW_content content) {
		return new LTW_content() {{
			motorcycleName = content.getMotorcycleName();
			motorcycleManufacturing = content.getMotorcycleManufacturing();
			motorcycleYear = content.getMotorcycleYear();
		}};
	}



	@Reference
	LTW_contentLocalService _ltw_contentLocalService;
}



