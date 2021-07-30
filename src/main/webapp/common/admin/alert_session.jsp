<c:if test="${alertSession != null}">
	<div class="alert alert-primary alert-dismissible fade show"
		role="alert">
		<strong>Thông báo: </strong> ${alertSession }
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
</c:if>