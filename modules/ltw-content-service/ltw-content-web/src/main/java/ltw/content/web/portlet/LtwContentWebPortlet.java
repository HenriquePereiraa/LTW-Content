package ltw.content.web.portlet;


import com.liferay.portal.kernel.util.PortalUtil;
import ltw.content.service.service.LTW_contentLocalService;
import ltw.content.web.constants.LtwContentWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;

import ltw.content.web.display.context.LtwContentDisplayContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;


/**
 * @author me
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=LtwContentWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + LtwContentWebPortletKeys.LTWCONTENTWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class LtwContentWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);

		LtwContentDisplayContext ltwContentDisplayContext = new LtwContentDisplayContext(
				request,  renderRequest, renderResponse, _ltwContentLocalService);

		request.setAttribute("ltwContentDisplayContext", ltwContentDisplayContext);

		super.render(renderRequest, renderResponse);
	}

	private PortletURL createPortletURL(RenderResponse renderResponse) {
		return renderResponse.createRenderURL();
	}

	@Reference
	private LTW_contentLocalService _ltwContentLocalService;
}