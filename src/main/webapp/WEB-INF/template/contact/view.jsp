<jsp:include page="../fragments/head.jsp" flush="true">
	<jsp:param name="page" value="Contacts" />
</jsp:include>
<div class="row">
	<div class="col-md-8 col-sm-12 offset-md-2 ">
		<h2>Contacts - View</h2>
		<div class="card text-center">
			<div class="card-header">
				<h2>${contact.lastName},${contact.firstName}</h2>
			</div>
			<div class="card-body">
				<p>
					<strong>Mobile Number:</strong> ${contact.mobileNumber}
				</p>
				<p>
					<strong>EmailAddress:</strong> ${contact.emailAddress}
				</p>
				<p>
					<strong>Address:</strong> ${contact.address}
				</p>
			</div>
			<div class="card-footer text-muted">
				<a href="${pageContext.request.contextPath}/contacts"
					class="btn btn-primary"><i class="fas fa-chevron-left"></i>
					Back</a>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../fragments/footer.jsp" flush="true" />