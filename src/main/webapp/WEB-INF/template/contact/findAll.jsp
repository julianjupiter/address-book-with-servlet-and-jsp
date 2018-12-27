<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="../fragments/head.jsp" flush="true">
	<jsp:param name="page" value="Contacts" />
</jsp:include>
			<div class="row">
				<div class="col">
					<h2>Contacts - List</h2>
					<table class="table striped">
						<thead>
							<tr>
								<td>ID</td>
								<td>Name</td>
								<td>Mobile Number</td>
								<td>Email Address</td>
								<td>Address</td>
								<td>Action</td>
							</tr>
						</thead>
						<tbody>
							<c:choose>
		  						<c:when test="${fn:length(contacts) > 0}">
									<c:forEach items="${contacts}" var="contact">
										<tr>
											<td>${contact.id}</td>
											<td>${contact.firstName} ${contact.lastName}</td>
											<td>${contact.mobileNumber}</td>
											<td>${contact.emailAddress}</td>
											<td>${contact.address}</td>
											<td>
												<a href="${pageContext.request.contextPath}/contacts?action=view&id=${contact.id}" class="btn btn-info btn-sm"><i class="far fa-eye"></i></a>
												<a href="${pageContext.request.contextPath}/contacts?action=edit&id=${contact.id}" class="btn btn-success btn-sm"><i class="far fa-edit"></i></a>
												<a href="${pageContext.request.contextPath}/contacts?action=delete&id=${contact.id}" class="btn btn-danger btn-sm"><i class="far fa-edit"></i></a>
											</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="7">No contacts!</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>
			</div>
<jsp:include page="../fragments/footer.jsp" flush="true" />