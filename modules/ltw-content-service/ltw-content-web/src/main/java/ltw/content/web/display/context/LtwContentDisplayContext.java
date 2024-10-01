package ltw.content.web.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.petra.function.transform.TransformUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.SearchOrderByUtil;
import com.liferay.portal.kernel.search.BaseModelSearchResult;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import ltw.content.service.model.LTW_content;
import ltw.content.service.service.LTW_contentLocalService;
import ltw.content.service.service.LTW_contentLocalServiceUtil;
import ltw.content.web.constants.LtwContentWebPortletKeys;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

public class LtwContentDisplayContext {

    public LtwContentDisplayContext(
            HttpServletRequest request, RenderRequest renderRequest,
            RenderResponse renderResponse, LTW_contentLocalService ltw_contentLocalService) {

        _request = request;
        _renderRequest = renderRequest;
        _renderResponse = renderResponse;
        _themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
        _ltwContentLocalService = ltw_contentLocalService;
    }


    public String getDisplayStyle() {
        if (_displayStyle == null) {
            _displayStyle = ParamUtil.getString(_renderRequest, "displayStyle", "list");
        }
        return _displayStyle;
    }

    public String getOrderByCol() {
        if (_orderByCol == null) {
            _orderByCol = ParamUtil.getString(_renderRequest, "orderByCol", "name");
        }
        return _orderByCol;
    }

    public String getOrderByType() {
        if (_orderByType == null) {
            _orderByType = ParamUtil.getString(_renderRequest, "orderByType", "asc");
        }
        return _orderByType;
    }

    public PortletURL getPortletURL() {
        PortletURL portletURL = _renderResponse.createRenderURL();
        portletURL.setParameter("mvcRenderCommandName", "viewItems");
        portletURL.setParameter("displayStyle", getDisplayStyle());
        portletURL.setParameter("orderByCol", getOrderByCol());
        portletURL.setParameter("orderByType", getOrderByType());
        return portletURL;
    }

    public List<DropdownItem> getActionDropdownItems() {
        return new DropdownItemList() {
            {
                add(dropdownItem -> {
                    dropdownItem.setHref("#");
                    dropdownItem.setLabel(LanguageUtil.get(_request, "add-item"));
                });

                add(dropdownItem -> {
                    dropdownItem.setHref("#");
                    dropdownItem.setLabel(LanguageUtil.get(_request, "delete"));
                });
            }
        };
    }

    public SearchContainer getSearchContainer() throws PortalException {
        if (_searchContainer == null) {
            _searchContainer = new SearchContainer(
                    _renderRequest, null, null, "cur", 20, getPortletURL(), null,
                    "no-items-were-found");

            _searchContainer.setId("ltwContentId");
            _searchContainer.setOrderByCol(SearchOrderByUtil.getOrderByType(
                    _request, LtwContentWebPortletKeys.LTWCONTENTWEB, "order-by-col", "name"));

            _searchContainer.setOrderByType(
                    SearchOrderByUtil.getOrderByType(
                            _request, LtwContentWebPortletKeys.LTWCONTENTWEB, "order-by-type", "name"));

            String keywords = ParamUtil.getString(_renderRequest, "keywords");
            String type = ParamUtil.getString(_renderRequest, "type");

            LinkedHashMap<String, Object> params = new LinkedHashMap<>();

            if (Validator.isNotNull(type) && !type.equals("all")) {
                params.put(
                        "typeNames",
                        new String[] {
                                type,
                                LtwContentListTypeConstants.LTW_CONTENT_MOTOCYCLE_MANUFACTURING
                        }
                );
            } else {
                params.put(
                        "typeNames",
                        new String[] {
                                LtwContentListTypeConstants.LTW_CONTENT_MOTOCYCLE_NAME,
                                LtwContentListTypeConstants.LTW_CONTENT_MOTOCYCLE_MANUFACTURING,
                                LtwContentListTypeConstants.LTW_CONTENT_MOTOCYCLE_YEAR
                        }
                );
            }

            ThemeDisplay themeDisplay =
                    (ThemeDisplay)_request.getAttribute(
                            WebKeys.THEME_DISPLAY);

            BaseModelSearchResult<LTW_content> baseModelSearchResult =
                    LTW_contentLocalServiceUtil.searchLtwContent(
                            themeDisplay.getCompanyId(), LTW_content.class.getName(),
                            ParamUtil.getLong(_request, "ltwContent"),
                            keywords, params, _searchContainer.getStart(),
                            _searchContainer.getEnd(),
                            _getSort(
                                    _searchContainer.getOrderByCol(),
                                    _searchContainer.getOrderByType()
                            )
                    );
//            _searchContainer.setResultsAndTotal(
//                    () -> TransformUtil.transform(
//                            baseModelSearchResult.getBaseModels(), LtwContentDisplayContext::of),
//                    // Criar classe ltwContestDisolay
//                    baseModelSearchResult.getLength());

            List<LTW_content> items = _ltwContentLocalService.getLTW_contents(
                    _searchContainer.getStart(), _searchContainer.getEnd());

            _searchContainer.setResultsAndTotal(items);

            return _searchContainer;
        }
        return _searchContainer;
    }

    private static Sort _getSort(String orderByCol, String orderByType) {
        return SortFactoryUtil.create(
                orderByCol, Objects.equals(orderByType, "desc"));
    }

    private final RenderRequest _renderRequest;
    private final RenderResponse _renderResponse;
    private final HttpServletRequest _request;
    private final ThemeDisplay _themeDisplay;
    private String _displayStyle;
    private String _orderByCol;
    private String _orderByType;
    private SearchContainer _searchContainer;
    private LTW_contentLocalService _ltwContentLocalService;
}

