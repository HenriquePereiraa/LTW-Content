<%@ page import="javax.portlet.RenderResponse" %>
<%@ page import="ltw.content.web.constants.MotorcycleFDSNames" %>
<%@ include file="/init.jsp" %>

<%

    LtwContentDisplayContext ltwContentDisplayContext = (LtwContentDisplayContext) request.getAttribute("ltwContentDisplayContext");

%>

<clay:container-fluid>

    <liferay-ui:header
        title="View Motorcycle"
    />

<frontend-data-set:classic-display
    dataProviderKey="<%= MotorcycleFDSNames.Motocycle %>"
    id="<%= MotorcycleFDSNames.Motocycle %>"
    itemsPerPage="<%= 10 %>"
/>

</clay:container-fluid>