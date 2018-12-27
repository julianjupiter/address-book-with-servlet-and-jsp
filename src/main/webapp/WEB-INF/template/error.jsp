<jsp:include page="./fragments/head.jsp" flush="true">
	<jsp:param name="page" value="Contacts" />
</jsp:include>
			<div class="jumbotron">
				<h2>${errorMessage}</h2>
			  	<hr class="my-4">
			  	<a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}" role="button"><i class="fas fa-home"></i> Back to Home</a>
			</div>
<jsp:include page="./fragments/footer.jsp" flush="true" />
