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
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Tên danh mục</th>
					<th scope="col">Mô tả ngắn</th>
					<th scope="col">Ngày tạo</th>
					<th scope="col">Ngày cập nhật</th>
					<th scope="col" class="last-col">Xử lý</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="category" items="${categories}" varStatus="loop">
					<tr>
						<th scope="row">${loop.getIndex()+1}</th>
						<td>${category.name}</td>
						<td>${category.shortDescription }</td>
						<td><fmt:formatDate value="${category.createdAt}" pattern="HH:mm dd/MM/yyyy"/></td>
						<td><fmt:formatDate value="${category.updatedAt}" pattern="HH:mm dd/MM/yyyy"/></td>
						<td>
							<a class="btn btn-info mr-1" href="${pageContext.request.contextPath}/admin/categories/${category.id}/edit">Sửa</button>
							<a class="btn btn-danger" href="">Xóa</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>