<jsp:include page="../fragments/head.jsp" flush="true">
	<jsp:param name="page" value="Contacts" />
</jsp:include>
			<div class="row">
				<div class="col-8 offset-2">
					<h2>Contacts - Edit</h2>
					<form class="form-group needs-validation" action="${pageContext.request.contextPath}/contacts?action=update&id=${contact.id}" method="post" novalidate>
					    <div class="form-group">
					        <label id="id">ID</label>
					        <input type="text" id="id" class="form-control" name="id" placeholder="ID" value="${contact.id}" disabled />
					    </div>
					    <div class="form-group">
					        <label id="firstName">First Name</label>
					        <input type="text" id="firstName" ${empty errors['firstName'] ? 'class="form-control"' : 'class="form-control is-invalid"'} name="firstName" placeholder="First Name" value="${contact.firstName}" />
					        <div class="invalid-feedback">${errors['firstName']}</div>
					    </div>
					    <div class="form-group">
					        <label id="lastName">Last Name</label>
					        <input type="text" id="lastName" ${empty errors['lastName'] ? 'class="form-control"' : 'class="form-control is-invalid"'} name="lastName" placeholder="Last Name" value="${contact.lastName}" />
					        <div class="invalid-feedback">${errors['lastName']}</div>
					    </div>
					    <div class="form-group">
					        <label id="mobileNumber">Mobile Number</label>
					        <input type="text" id="mobileNumber" ${empty errors['mobileNumber'] ? 'class="form-control"' : 'class="form-control is-invalid"'} name="mobileNumber" placeholder="Mobile Number" value="${contact.mobileNumber}" />
					        <div class="invalid-feedback">${errors['mobileNumber']}</div>
					    </div>
					    <div class="form-group">
					        <label id="emailAddress">Email Address</label>
					        <input type="email" id="emailAddress" ${empty errors['emailAddress'] ? 'class="form-control"' : 'class="form-control is-invalid"'} name="emailAddress" placeholder="Enter Email Address" value="${contact.emailAddress}" />
					        <small class="text-muted">We'll never share your email address with anyone else.</small>
					        <div class="invalid-feedback">${errors['emailAddress']}</div>
					    </div>
					    <div class="form-group">
					        <label id="address">Address</label>
					        <input type="text" id="address" ${empty errors['address'] ? 'class="form-control"' : 'class="form-control is-invalid"'} name="address" placeholder="Address" value="${contact.address}" />
					        <div class="invalid-feedback">${errors['address']}</div>
					    </div>
					    <div class="form-group">
					        <button type="submit" class="btn btn-primary"><i class="far fa-save"></i> Save</button>
					        <a href="${pageContext.request.contextPath}/contacts" class="btn btn-secondary"><i class="fas fa-chevron-left"></i> Cancel</a>
					    </div>
					</form>
				</div>
			</div>
<jsp:include page="../fragments/footer.jsp" flush="true" />