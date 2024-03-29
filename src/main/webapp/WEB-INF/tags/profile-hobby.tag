<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">
			<i class="fa fa-heart"></i> Hobby <a class="edit-block" href="/edit/hobby">Edit</a>
		</h3>
	</div>
	<div class="panel-body">
		<div class="hobbies">
			<table class="table table-bordered">
				<tbody>
					<c:forEach var="hobby" items="${profile.hobbies }">
						<tr>
							<td><i class="fa fa-heart"></i></td>
							<td>${hobby.name }</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
</div>