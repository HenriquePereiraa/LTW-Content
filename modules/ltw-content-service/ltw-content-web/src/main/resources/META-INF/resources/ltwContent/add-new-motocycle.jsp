<%@ include file="/init.jsp" %>

<%
    String backURL = ParamUtil.getString(request, "backURL", String.valueOf(renderResponse.createRenderURL()));
%>

<portlet:actionURL name="/ltwContent/add-new-motocycle" var="actionURL">
    <portlet:param name="mvcActionCommandName" value="/ltwContent/add-new-motocycle"/>
    <portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD %>" />
</portlet:actionURL>

<aui:form action="<%= actionURL %>" method="post" name="fm">
        <clay:sheet>
            <clay:sheet-header>
                <h2>Add new motocycle</h2>
            </clay:sheet-header>

            <clay:sheet-section>
                <aui:input name="motocycleName" label="Motocycle name" required="<%= true %>"/>
                <aui:input name="motorcycleManufacturing" label="Motorcycle Manufacturing" required="<%= true %>"/>
                <aui:input name="motocycleYear" label="Motocycle Year" required="<%= true %>" type="number"/>
            </clay:sheet-section>
            <clay:sheet-footer
                cssClass="sheet-footer-btn-block-sm-down"
            >
                <div class="btn-group">
                    <div class="btn-group-item">
                        <clay:button
                                displayType="primary"
                                label='Add'
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