package ltw.content.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import ltw.content.service.service.LTW_contentLocalService;
import ltw.content.web.constants.LtwContentWebPortletKeys;
import ltw.content.web.display.LtwContentDisplay;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;


@Component(
        property = {
                "javax.portlet.name=" + LtwContentWebPortletKeys.LTWCONTENTWEB,
                "mvc.command.name=/ltwContent/edit-motocycle"
        },
        service =  MVCRenderCommand.class
)
public class EditLtwContentMVCRenderCommand implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        long motocycleId = ParamUtil.getLong(renderRequest, "motocycleId");

        try {
            LtwContentDisplay ltwContentDisplay = LtwContentDisplay.of(_ltwcontentLocalService.getLTW_content(motocycleId));

            renderRequest.setAttribute(
                    "LtwContentDisplay",
                    ltwContentDisplay
            );
            return "/ltwContent/edit-motocycle.jsp";
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }
    }


    @Reference
    LTW_contentLocalService _ltwcontentLocalService;
}
