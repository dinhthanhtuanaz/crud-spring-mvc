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
		<%@include file="/common/admin/alert_session.jsp" %>
		
		<!-- Search Form -->
		<form method="GET" action="${pageContext.request.contextPath}/admin/categories" autocomplete="off">
			<div class="form-row">
				<div class="form-group col-xl-1 pt-2">
					<label for="name" class="mr-3"><b>Tên danh mục </b></label>
				</div>
				<div class="form-group col-xl-3">
					
				    <input type="text" class="form-control" id="name" name="name" value="${param.name}">
				</div>
				<div class="col-xl-3">
					<button type="submit" class="btn btn-primary">Tìm kiếm</button>
					<a href="${pageContext.request.contextPath }/admin/categories" class="btn btn-info width-100">Danh sách</a>
					<a href="${pageContext.request.contextPath }/admin/categories/create" class="btn btn-success width-100">Tạo mới</a>
				</div>
			</div>
		</form>
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
				<c:if test="${empty categories}">
			    	<tr>
			    		<th colspan="6" class="text-center text-danger">Không có dữ liệu</th>
			    	</tr>
				</c:if>
				<c:forEach var="category" items="${categories}" varStatus="loop">
					<tr>
						<th scope="row">${loop.getIndex()+1}</th>
						<td>${category.name}</td>
						<td>${category.shortDescription }</td>
						<td><fmt:formatDate value="${category.createdAt}" pattern="HH:mm dd/MM/yyyy"/></td>
						<td><fmt:formatDate value="${category.updatedAt}" pattern="HH:mm dd/MM/yyyy"/></td>
						<td>
							<a class="btn btn-info mr-1" href="${pageContext.request.contextPath}/admin/categories/${category.id}/edit">Sửa</button>
							<a class="btn btn-danger btn-delete-question" data-id=${category.id } data-url="${pageContext.request.contextPath}/admin/categories/${category.id}/delete" data-toggle="modal" data-target="#modalDelete">Xóa</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${not empty categories}">
			${paginationTag }
		</c:if>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="modalDelete" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="modalDeleteLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="staticBackdropLabel">Thông báo</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <h5 class="text-center">Bạn chắc chắn xóa?</h5>
	      </div>
	      <div class="modal-footer d-block text-center">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
	        <button type="button" class="btn btn-primary btn-delete-agree" data-id="" data-href="">Đồng ý</button>
	      </div>
	    </div>
	  </div>
	</div>
	<content tag="js_current_page">
		<script src="<c:url value='/assets/admin/js/categories/delete.js' />"></script>
	</content>
</body>
</html>