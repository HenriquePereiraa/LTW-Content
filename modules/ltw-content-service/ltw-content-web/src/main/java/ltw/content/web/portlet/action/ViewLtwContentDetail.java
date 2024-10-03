package ltw.content.web.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import ltw.content.web.constants.LtwContentWebPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;


@Component(
        property = {
                "javax.portlet.name=" + LtwContentWebPortletKeys.LTWCONTENTWEB,
                "mvc.command.name=/ltwContent/view-ltwcontent-detail"
        },
        service =  MVCRenderCommand.class
)
public class ViewLtwContentDetail implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        return "/ltwContent/view-ltwcontent-detail.jsp";
    }
}
