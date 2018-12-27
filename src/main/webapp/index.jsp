<jsp:include page="./WEB-INF/template/fragments/head.jsp" flush="true">
	<jsp:param name="page" value="Contacts" />
</jsp:include>
       	<div class="jumbotron">
		  <h1 class="display-4">Address Book</h1>
		  <p class="lead">This is an address book application written in Servlet, JSP and JDBC.</p>
		  <hr class="my-4">
		  <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/contacts" role="button"><i class="fas fa-phone"></i> Contacts</a>
		</div>
<jsp:include page="./WEB-INF/template/fragments/footer.jsp" flush="true" />