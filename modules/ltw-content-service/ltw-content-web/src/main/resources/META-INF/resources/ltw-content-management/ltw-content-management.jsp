<%@ page import="javax.portlet.RenderResponse" %>
<%@ include file="/init.jsp" %>

<%

    LtwContentDisplayContext ltwContentDisplayContext = (LtwContentDisplayContext) request.getAttribute("ltwContentDisplayContext");
    SearchContainer<LtwContentDisplay> ltwContentDisplaySearchContainer = LtwContentDisplaySearchContainerFactory.create(liferayPortletRequest,liferayPortletResponse);
    LtwContentManagementToolbarDisplayContext ltwContentManagementToolbarDisplayContext = new LtwContentManagementToolbarDisplayContext(request, liferayPortletRequest, liferayPortletResponse, renderResponse, ltwContentDisplaySearchContainer);

%>

 <clay:management-toolbar
       managementToolbarDisplayContext="<%= ltwContentManagementToolbarDisplayContext %>"
 />


<clay:container-fluid>
    <liferay-ui:search-container
            id="ltwContentSearchContainerId"
            searchContainer="<%= ltwContentDisplaySearchContainer %>"
    >

        <liferay-ui:search-container-row
                className="ltw.content.web.display.LtwContentDisplay"
                modelVar="ltwContentDisplay">

            <liferay-ui:search-container-column-text
                    name="Motorcycle Name"
                    value="<%= ltwContentDisplay.get_motorcycleName() %>" />

            <liferay-ui:search-container-column-text
                    name="Motorcycle Manufacturing"
                    value="<%= ltwContentDisplay.get_motorcycleManufacturing() %>" />

            <liferay-ui:search-container-column-text
                    name="Motorcycle Year"
                    value="<%= String.valueOf(ltwContentDisplay.get_motorcycleYear()) %>" />
        </liferay-ui:search-container-row>

        <liferay-ui:search-iterator
        displayStyle="<%= String.valueOf(ltwContentDisplayContext.getDisplayStyle()) %>"
        markupView="lexicon"
        />
    </liferay-ui:search-container>
</clay:container-fluid>