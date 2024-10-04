package ltw.content.web.portlet.action;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import ltw.content.service.model.LTW_content;
import ltw.content.service.service.LTW_contentLocalService;
import ltw.content.web.constants.LtwContentWebPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

@Component(
        property = {
                "javax.portlet.name=" + LtwContentWebPortletKeys.LTWCONTENTWEB,
                "mvc.command.name=/ltwContent/add-new-motocycle", "mvc.command.name=/delete"
        },
        service = MVCActionCommand.class
)
public class LtwContentDetailMVCActionCommand extends BaseMVCActionCommand {
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

        try {
            LTW_content ltwContent = null;
            String redirect = ParamUtil.getString(actionRequest, "redirect");

            if(cmd.equals(Constants.ADD)) {
                ltwContent = _addLtwContent(actionRequest);
                sendRedirect(actionRequest, actionResponse, redirect);
            } else if (cmd.equals(Constants.DELETE)) {
                ltwContent = _deleteLtwContent(actionRequest);
                sendRedirect(actionRequest, actionResponse, redirect);
            } else if (cmd.equals(Constants.UPDATE)) {
                ltwContent = _updateLtwContent(actionRequest);
                sendRedirect(actionRequest, actionResponse, "redirect");
            }

        } catch (Exception exception) {
           if ((exception instanceof ModelListenerException) &&
                   (exception.getCause() instanceof PortalException)) {

               throw (PortalException)exception.getCause();
           }

           throw exception;
       }

    }

    private LTW_content _addLtwContent(
            ActionRequest actionRequest
    ) throws Exception {
        String motocycleName = ParamUtil.getString(actionRequest, "motocycleName");
        String motorcycleManufacturing = ParamUtil.getString(actionRequest, "motorcycleManufacturing");
        int motocycleYear = ParamUtil.getInteger(actionRequest, "motocycleYear");

       return _ltwcontentLocalService.addLTW_content(
               motocycleName, motorcycleManufacturing, motocycleYear
       );
    }

    private LTW_content _updateLtwContent(
            ActionRequest actionRequest
    ) throws Exception {
        long motocycleId = ParamUtil.getLong(actionRequest, "motorcycleId");
        String motocycleName = ParamUtil.getString(actionRequest, "motocycleName");
        String motorcycleManufacturing = ParamUtil.getString(actionRequest, "motorcycleManufacturing");
        int motorcycleYear = ParamUtil.getInteger(actionRequest, "motorcycleYear");

        LTW_content ltw_content = _ltwcontentLocalService.fetchLTW_content(motocycleId);

        ltw_content.setMotorcycleName(motocycleName);
        ltw_content.setMotorcycleManufacturing(motorcycleManufacturing);
        ltw_content.setMotorcycleYear(motorcycleYear);

        return _ltwcontentLocalService.updateLTW_content(
                motocycleId, ltw_content
        );
    }

    private LTW_content _deleteLtwContent(ActionRequest actionRequest) throws Exception {
        Long motocycleId = ParamUtil.getLong(actionRequest, "motorcycleId");

        if(Validator.isNull(motocycleId)) {
            throw new PortletException("motocycleId is required");
        }

        return _ltwcontentLocalService.deleteLTW_content(motocycleId);
    }

    @Reference
    LTW_contentLocalService _ltwcontentLocalService;
}


