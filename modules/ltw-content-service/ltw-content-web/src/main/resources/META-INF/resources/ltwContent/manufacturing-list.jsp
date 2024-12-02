<%@ page import="javax.portlet.RenderResponse" %>
<%@ page import="ltw.content.web.constants.MotorcycleFDSNames" %>
<%@ include file="/init.jsp" %>

<%
  LtwContentDisplayContext ltwContentDisplayContext = (LtwContentDisplayContext) request.getAttribute("ltwContentDisplayContext");
%>

<clay:container-fluid>

  <liferay-ui:header
          title="View Manufacturing"
  />

  <frontend-data-set:headless-display
    apiURL="<%= ltwContentDisplayContext.getApiUrl() %>"
    fdsSortItemList="<%= ltwContentDisplayContext.getFDSSortItemList() %>"
    showSearch="<%= false %>"
    id="<%= MotorcycleFDSNames.MOTORCYCLE_MANUFACTURING %>"
  />

</clay:container-fluid>