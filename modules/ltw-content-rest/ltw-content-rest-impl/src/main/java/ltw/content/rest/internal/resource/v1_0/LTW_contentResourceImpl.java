package ltw.content.rest.internal.resource.v1_0;

import com.liferay.portal.kernel.exception.PortalException;
import ltw.content.rest.dto.v1_0.LTW_content;
import ltw.content.rest.resource.v1_0.LTW_contentResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;
import ltw.content.service.service.LTW_contentLocalService;

import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.Optional;

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

	@Override
	public LTW_content getLTW_content(@NotNull Long ltwContentId) throws PortalException {

		ltw.content.service.model.LTW_content content = _ltw_contentLocalService.getLTW_content(ltwContentId);
		if(content != null) {
			return _toLTWContent(content);
		}
		return null;
	}

	@Override
	public LTW_content putLTW_Content(Long ltwContentId, Object object) throws Exception {

		ltw.content.service.model.LTW_content ltwContent = _ltw_contentLocalService.fetchLTW_content(ltwContentId);

		if(ltwContent == null) {
			throw new Exception();
		}

		Map<String, Object> data = (Map<String, Object>) object;

		String motorcycleName = (String) data.get("motorcycleName");
		String motorcycleManufacturing =  (String) data.get("motorcycleManufacturing");
		int motorcycleYear = (Integer) data.get("motorcycleYear");

        ltwContent.setMotorcycleName(motorcycleName);
		ltwContent.setMotorcycleYear(motorcycleYear);
		ltwContent.setMotorcycleManufacturing(motorcycleManufacturing);

		ltw.content.service.model.LTW_content content = _ltw_contentLocalService.updateLTW_content(ltwContentId, ltwContent);

		return _toLTWContent(content);
	}

	private LTW_content _toLTWContent(ltw.content.service.model.LTW_content content) {

		return new LTW_content() {{
			contentId = content.getLtwId();
			motorcycleName = content.getMotorcycleName();
			motorcycleManufacturing = content.getMotorcycleManufacturing();
			motorcycleYear = content.getMotorcycleYear();
		}};
	}



	@Reference
	LTW_contentLocalService _ltw_contentLocalService;
}



