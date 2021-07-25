<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<div class="wrapper">
		<form:form
			action="${pageContext.request.contextPath}/admin/categories"
			method="POST" modelAttribute="category">
			<div class="form-group">
				<label for="name">Tên</label>
				<form:input path="name" class="form-control" />
			</div>
			<div class="form-group">
				<label for="shortDesciption">Mô tả ngắn</label>
				<form:input path="shortDesciption" class="form-control" />
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>