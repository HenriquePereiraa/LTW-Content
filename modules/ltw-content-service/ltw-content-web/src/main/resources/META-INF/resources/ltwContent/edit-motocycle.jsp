<%@ include file="/init.jsp" %>

<%
    String backURL = ParamUtil.getString(request, "backURL", String.valueOf(renderResponse.createRenderURL()));
    LtwContentDisplay ltwContentDisplay = (LtwContentDisplay) request.getAttribute("LtwContentDisplay");
    String motorcycleId = String.valueOf(ltwContentDisplay.getContentId());
%>

<portlet:actionURL name="/ltwContent/add-new-motocycle" var="actionURL">
    <portlet:param name="mvcActionCommandName" value="/ltwContent/add-new-motocycle"/>
    <portlet:param name="<%= Constants.CMD %>" value="<%= Constants.UPDATE %>" />
    <portlet:param name="motorcycleId" value="<%= motorcycleId %>"/>`
</portlet:actionURL>

<aui:form action="<%= actionURL %>" method="post" name="fm">
    <clay:sheet>
        <clay:sheet-header>
            <h2>Edit Motorcycle - <%= ltwContentDisplay.get_motorcycleName() %></h2>
        </clay:sheet-header>

        <clay:sheet-section>
            <aui:input
                name="motocycleName"
                label="Motocycle name"
                required="<%= true %>"
                value="<%= ltwContentDisplay.get_motorcycleName() %>"
            />
            <aui:input
                name="motorcycleManufacturing"
                label="Motorcycle Manufacturing"
                required="<%= true %>"
                value="<%= ltwContentDisplay.get_motorcycleManufacturing() %>"
            />
            <aui:input
                name="motorcycleYear"
                label="Motocycle Year"
                required="<%= true %>"
                type="number"
                value="<%= ltwContentDisplay.get_motorcycleYear() %>"
            />
        </clay:sheet-section>
        <clay:sheet-footer
                cssClass="sheet-footer-btn-block-sm-down"
        >
            <div class="btn-group">
                <div class="btn-group-item">
                    <clay:button
                            displayType="primary"
                            label='Update'
                            type="submit"
                    />
                </div>

                <div class="btn-group-item">
                    <clay:link
                            cssClass="btn btn-secondary"
                            displayType="null"
                            href="<%= backURL %>"
                            label='Cancel'
                            role="button"
                    />
                </div>
            </div>
        </clay:sheet-footer>
    </clay:sheet>
</aui:form>