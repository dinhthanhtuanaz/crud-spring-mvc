<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="wrapper">
		<div class="row">
			<div class="col-xl-6">
				<form:form
					action="${pageContext.request.contextPath}/admin/categories/update"
					method="POST" modelAttribute="category"
					autocomplete="off">
					<form:hidden  path="id" />
					<div class="form-group">
						<label for="name" class="form-label">Tên</label>
						<form:input path="name" class="form-control" />
						<form:errors path="name" cssStyle="color:red;display:block"></form:errors>
					</div>
					<div class="form-group">
						<label for="shortDescription" class="form-label">Mô tả ngắn</label>
						<form:input path="shortDescription" class="form-control" />
						<form:errors path="shortDescription" cssStyle="color:red;display:block"></form:errors>
					</div>
					<div class="form-group">
						<a href="" class="btn btn-danger width-100">Xóa</a>
						<a href="${pageContext.request.contextPath }/admin/categories" class="btn btn-info width-100">Danh sách</a>
						<button type="submit" class="btn btn-primary width-100">Lưu</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>