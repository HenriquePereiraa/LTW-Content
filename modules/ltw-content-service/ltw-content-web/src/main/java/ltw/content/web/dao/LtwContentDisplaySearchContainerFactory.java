package ltw.content.web.dao;

import com.liferay.petra.function.transform.TransformUtil;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.SearchOrderByUtil;
import com.liferay.portal.kernel.search.BaseModelSearchResult;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import ltw.content.service.model.LTW_content;
import ltw.content.service.service.LTW_contentLocalServiceUtil;
import ltw.content.web.constants.LtwContentWebPortletKeys;
import ltw.content.web.display.LtwContentDisplay;
import ltw.content.web.display.context.LtwContentListTypeConstants;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

public class LtwContentDisplaySearchContainerFactory {
    public static SearchContainer<LtwContentDisplay> create(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse
    ) throws Throwable {
        SearchContainer searchContainer = new SearchContainer(
                liferayPortletRequest,
                PortletURLUtil.getCurrent(
                        liferayPortletRequest, liferayPortletResponse),
                null, "no-ltw_content-were-found");

        searchContainer.setId("ltwContentId");
        searchContainer.setOrderByCol(SearchOrderByUtil.getOrderByType(
                liferayPortletRequest, LtwContentWebPortletKeys.LTWCONTENTWEB, "order-by-col", "name"));

        searchContainer.setOrderByType(
                SearchOrderByUtil.getOrderByType(
                        liferayPortletRequest, LtwContentWebPortletKeys.LTWCONTENTWEB, "order-by-type", "name"));

        String keywords = ParamUtil.getString(liferayPortletRequest, "keywords");
        String type = ParamUtil.getString(liferayPortletRequest, "type");

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
                (ThemeDisplay)liferayPortletRequest.getAttribute(
                        WebKeys.THEME_DISPLAY);

        BaseModelSearchResult<LTW_content> baseModelSearchResult =
                LTW_contentLocalServiceUtil.searchLtwContent(
                        themeDisplay.getCompanyId(), LTW_content.class.getName(),
                        ParamUtil.getLong(liferayPortletRequest, "ltwContent"),
                        keywords, params, searchContainer.getStart(),
                        searchContainer.getEnd(),
                        _getSort(
                                searchContainer.getOrderByCol(),
                                searchContainer.getOrderByType()
                        )
                );
            searchContainer.setResultsAndTotal(
                    () -> TransformUtil.transform(
                            baseModelSearchResult.getBaseModels(), LtwContentDisplay::of),
                    baseModelSearchResult.getLength());

            searchContainer.setRowChecker(
                    new EmptyOnClickRowChecker(liferayPortletResponse)
            );

//        List<LTW_content> items = _ltwContentLocalService.getLTW_contents(
//                searchContainer.getStart(), searchContainer.getEnd());
//
//        searchContainer.setResultsAndTotal(items);

        return searchContainer;
    }

    private static Sort _getSort(String orderByCol, String orderByType) {
        return SortFactoryUtil.create(
                orderByCol, Objects.equals(orderByType, "desc"));
    }

}
