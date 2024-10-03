<%@ include file="/init.jsp" %>

<portlet:renderURL var="addNewMotocycleRequestURL">
	<portlet:param name="mvcPath" value="/ltwContent/add-new-motocycle.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewLtwContentRequestURL">
	<portlet:param name="mvcRenderCommandName" value="/ltwContent/view-ltwcontent-detail" />
</portlet:renderURL>

<section class="ltw-container">
	<div class="ltw-left">
		<h1 class="typing-animation">Life on Two Wheels Portal!</h1>
<%--		<img src="http://localhost:8080/documents/d/guest/royal-enfield-wallpaper-11f5f3f4117d7eab7ca93efc47ad30dd" alt="Royal Enfield Wallpaper" />--%>
	</div>

	<div class="ltw-right">
		<aui:form action="<%= addNewMotocycleRequestURL %>" method="post" name="fm">
			<div class="button-group">
				<aui:button-row>
					<aui:button type="submit" value="Add New Motorcycles" />
				</aui:button-row>
			</div>
		</aui:form>

		<aui:form action="<%= viewLtwContentRequestURL %>" method="post" name="fm">
			<div class="button-group">
				<aui:button-row>
					<aui:button type="submit" value="View Motorcycles" />
				</aui:button-row>
			</div>
		</aui:form>
	</div>
</section>
