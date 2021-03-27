<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">
			<i class="fa fa-language"></i> Foreign languages <a class="edit-block" href="/edit/languages">Edit</a>
		</h3>
	</div>
	<div class="panel-body">
	<c:forEach var="lang" items="${profile.languages }">
	<strong>${lang.name }:</strong> ${lang.level }<span style="float:right;"> ${lang.type }</span> <br>
	</c:forEach>
	</div>
</div>
