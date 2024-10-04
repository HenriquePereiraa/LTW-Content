package ltw.content.web.display;

import aQute.libg.generics.Create;
import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.*;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.permission.UserPermissionUtil;
import com.liferay.portal.kernel.service.persistence.PortletUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import ltw.content.service.service.LTW_contentLocalService;
import ltw.content.web.constants.LtwContentWebPortletKeys;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

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

    @Override
    protected String getOrderByType() {
        if (Validator.isNotNull(_orderByType)) {
            return _orderByType;
        }

        _orderByType = ParamUtil.getString(_request, "orderByType", "asc");

        return _orderByType;
    }

    public String getKeywords() {
        if (_keywords != null) {
            return _keywords;
        }

        _keywords = ParamUtil.getString(_request, "keywords");

        return _keywords;
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

//    @Override
//    public String getSortingURL() {
//        PortletURL sortingURL = getPortletURL();
//
//        sortingURL.setParameter(
//                "orderByType",
//                Objects.equals(getOrderByType(), "asc") ? "desc" : "asc");
//
//        return sortingURL.toString();
//    }

    public String getRedirect() {
        if (liferayPortletRequest != null) {
            return _redirect;
        }

        _redirect = PortalUtil.escapeRedirect(
                ParamUtil.getString(_request, "redirect"));

        return _redirect;
    }

    public long getGroupId() {
        if (_groupId != null) {
            return _groupId;
        }

        _groupId = ParamUtil.getLong(_request, "groupId");

        return _groupId;
    }

    public String getEventName() {
        if (_eventName != null) {
            return _eventName;
        }

        _eventName = ParamUtil.getString(
                _request, "eventName",
                _renderResponse.getNamespace() + "selectUser");

        return _eventName;
    }

//    @Override
//    public List<DropdownItem> getFilterDropdownItems() {
//        return new DropdownItemList() {
//            {
//                addGroup(
//                        dropdownGroupItem -> {
//                            dropdownGroupItem.setDropdownItems(
//                                    _getFilterNavigationDropdownItems()
//                            );
//                            dropdownGroupItem.setLabel(
//                                    "filter by navigation"
//                            );
//                        }
//                );
//            }
//        };
//    }

    private List<DropdownItem> _getFilterNavigationDropdownItems() {
        return new DropdownItemList() {
            {
                add(
                        dropdownItem -> {
                            dropdownItem.setActive(true);
                            dropdownItem.setHref(getPortletURL());
                            dropdownItem.setLabel("all");
                        }
                );
            }
        };
    }


    public List<DropdownItem> getActionDropdownItems(long motocycleId)  {
        boolean hasDeletePermission = UserPermissionUtil.contains(
                _themeDisplay.getPermissionChecker(), PortalUtil.getUserId(httpServletRequest),
                ActionKeys.DELETE);

        return DropdownItemListBuilder.addGroup(
                dropdownGroupItem -> {
                    dropdownGroupItem.setDropdownItems(
                            DropdownItemListBuilder.add(
                                    () -> hasDeletePermission,
                                    _getDeleteMotocycleInfo(motocycleId)
                            ).build()
                    );
                }
        ).build();
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
            dropdownItem.setLabel("delete Motocycle info");
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
    private Long _groupId;
    private String _keywords;
    private String _orderByType;
    private String _eventName;

    private final SearchContainer<?> searchContainer;
}
