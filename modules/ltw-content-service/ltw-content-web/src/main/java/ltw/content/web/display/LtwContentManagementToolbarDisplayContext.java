package ltw.content.web.display;

import aQute.libg.generics.Create;
import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.*;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.permission.UserPermissionUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import ltw.content.service.service.LTW_contentLocalService;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class LtwContentManagementToolbarDisplayContext extends SearchContainerManagementToolbarDisplayContext {

    public LtwContentManagementToolbarDisplayContext(
            HttpServletRequest httpServletRequest,
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            RenderResponse renderResponse,
            SearchContainer<?> searchContainer
    ) {
        super(httpServletRequest, liferayPortletRequest, liferayPortletResponse, searchContainer);

        this.searchContainer = searchContainer;
        _renderResponse = renderResponse;
        _request = httpServletRequest;
        _themeDisplay = (ThemeDisplay) liferayPortletRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
    }


    @Override
    public String getClearResultsURL() {
        return PortletURLBuilder.create(
                getPortletURL()
        ).setKeywords(
                StringPool.BLANK
        ).buildString();
    }

    public PortletURL getPortletURL() {
        try {
            return PortletURLUtil.clone(currentURLObj, liferayPortletResponse);
        }
        catch (Exception exception) {
            if (_log.isWarnEnabled()) {
                _log.warn(exception);
            }

            return liferayPortletResponse.createRenderURL();
        }
    }


    public List<DropdownItem> getActionDropdownItems(long motocycleId)  {
        boolean hasDeletePermission = UserPermissionUtil.contains(
                _themeDisplay.getPermissionChecker(), PortalUtil.getUserId(httpServletRequest),
                ActionKeys.DELETE);

        boolean hasEditPermission = UserPermissionUtil.contains(
                _themeDisplay.getPermissionChecker(), PortalUtil.getUserId(httpServletRequest),
                ActionKeys.UPDATE);

        return DropdownItemListBuilder.addGroup(
                dropdownGroupItem -> {
                    dropdownGroupItem.setDropdownItems(
                            DropdownItemListBuilder.add(
                                    () -> hasDeletePermission,
                                    _getDeleteMotocycleInfo(motocycleId)
                            ).add(
                                    () -> hasEditPermission,
                                    _getEditMotocycleInfo(motocycleId)
                            ).build()
                    );
                }
        ).build();
    }

    private UnsafeConsumer<DropdownItem, Exception> _getEditMotocycleInfo(long motocycleId) throws Exception {
        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createActionURL(
                            liferayPortletResponse
                    ).setMVCRenderCommandName(
                            "/ltwContent/edit-motocycle"
                    ).setParameter(
                            "motocycleId", motocycleId
                    ).buildString()
            );
            dropdownItem.setIcon("pencil");
            dropdownItem.setLabel("Edit Motocycle Info");
            dropdownItem.setQuickAction(true);
        };
    }

    private UnsafeConsumer<DropdownItem, Exception> _getDeleteMotocycleInfo(long motocycleId) throws Exception {
        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createActionURL(
                            liferayPortletResponse
                    ).setActionName(
                            "/delete"
                    ).setCMD(
                            Constants.DELETE
                    ).setRedirect(
                            _redirect
                    ).setParameter(
                            "motorcycleId", motocycleId
                    ).buildString()
            );
            dropdownItem.setIcon("trash");
            dropdownItem.setLabel("Delete Motocycle Info");
            dropdownItem.setQuickAction(true);
        };
    }

    @Override
    public String getSearchContainerId() {
        return "ltwContentSearchContainerId";
    }

    @Override
    protected String[] getNavigationKeys() {
        return new String[] {"all", "Motorcycle", "Year", "Name", "Manufacturing"};
    }

    @Override
    protected String getOrderByCol() {
        return ParamUtil.getString(
                liferayPortletRequest, getOrderByColParam(), "Motorcycle Name"
        );
    }

    @Override
    protected String[] getDisplayViews() {
        return new String[] {"views"};
    }

    private static final Log _log =  LogFactoryUtil.getLog(
            LtwContentManagementToolbarDisplayContext.class
    );

    @Reference
    private LTW_contentLocalService _ltwContentLocalService;

    private final ThemeDisplay _themeDisplay;
    private HttpServletRequest _request;
    private final RenderResponse _renderResponse;
    private String _redirect;

    private final SearchContainer<?> searchContainer;
}
