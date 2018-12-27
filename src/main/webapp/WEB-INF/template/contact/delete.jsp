<jsp:include page="../fragments/head.jsp" flush="true">
	<jsp:param name="page" value="Contacts" />
</jsp:include>
			<div class="row">
				<div class="col-8 offset-2">
					<h2>Contacts - Delete</h2>
					<form class="form-group needs-validation" action="${pageContext.request.contextPath}/contacts?action=delete&id=${contact.id}" method="post" novalidate>
					    <div class="form-group">
					        <label id="id">ID</label>
					        <input type="text" id="id" class="form-control" name="id" placeholder="ID" value="${contact.id}" disabled />
					    </div>
					    <div class="form-group">
					        <label id="firstName">First Name</label>
					        <input type="text" id="firstName" class="form-control" name="firstName" placeholder="First Name" value="${contact.firstName}" disabled />
					    </div>
					    <div class="form-group">
					        <label id="lastName">Last Name</label>
					        <input type="text" id="lastName" class="form-control" name="lastName" placeholder="Last Name" value="${contact.lastName}" disabled />
					    </div>
					    <div class="form-group">
					        <label id="mobileNumber">Mobile Number</label>
					        <input type="text" id="mobileNumber" class="form-control" name="mobileNumber" placeholder="Mobile Number" value="${contact.mobileNumber}" disabled />
					    </div>
					    <div class="form-group">
					        <label id="emailAddress">Email Address</label>
					        <input type="email" id="emailAddress" class="form-control" name="emailAddress" placeholder="Enter Email Address" value="${contact.emailAddress}" disabled />
					    </div>
					    <div class="form-group">
					        <label id="address">Address</label>
					        <input type="text" id="address" class="form-control" name="address" placeholder="Address" value="${contact.address}" disabled />
					    </div>
					    <div class="form-group">
					        <button type="submit" class="btn btn-danger"><i class="far fa-trash-alt"></i> Delete</button>
					        <a href="${pageContext.request.contextPath}/contacts" class="btn btn-secondary"><i class="fas fa-chevron-left"></i> Cancel</a>
					    </div>
					</form>
				</div>
			</div>
<jsp:include page="../fragments/footer.jsp" flush="true" />