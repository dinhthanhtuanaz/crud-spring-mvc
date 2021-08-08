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
					action="${pageContext.request.contextPath}/admin/products"
					modelAttribute="product"
					method="POST"
					autocomplete="off">
					<form:input path="name" placeholder="Ten san pham"/> <form:errors path="name" cssClass="error"/> <br/><br/>
					
					<button type="submit" class="btn btn-primary width-100">Lưu</button>
				</form:form>
				<hr />
			
				<form
					action="${pageContext.request.contextPath}/admin/categories"
					method="POST"
					autocomplete="off">
					<div class="form-group">
						<label for="name" class="form-label">Tên sản phẩm</label>
						<input type="text" class="form-control"/>
					</div>
					<div class="form-group">
					  <label for="" class="form-label">Danh mục</label>
					  <select class="form-control" name="" id="">
						<option>1</option>
						<option>2</option>
						<option>3</option>
					  </select>
					</div>
					<div class="form-group d-flex justify-content-between">
						<div class="form-group">
							<label for="name" class="form-label">Giá gốc</label>
							<input type="number" class="form-control"/>
						</div>
						<div class="form-group">
							<label for="name" class="form-label">Giá khuyến mại</label>
							<input type="number" class="form-control"/>
						</div>
						<div class="form-group">
							<label for="name" class="form-label">Giảm giá (%)</label>
							<input type="number" class="form-control"/>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="form-label">Sản phẩm</label>
						<table class="table border price-table">
							<thead>
								<tr>
									<th>Màu sắc</th>
									<th>Size</th>
									<th>Số lượng</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td rowspan="2">Màu trắng</td>
									<td>36</td>
									<td>
										<div class="last-column">
											<input type="number" class="form-control"/>
											<button class="btn btn-primary btn-add-size" type="button">+</button>
										</div>
									</td>
								</tr>
								<tr>
									<td>36</td>
									<td>
										<div class="last-column">
											<input type="number" class="form-control"/>
											<button class="btn btn-primary btn-add-size" type="button">+</button>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="form-group">
					  <label for="" class="form-label">Mô tả ngắn</label>
					  <textarea class="form-control" name="" id="" rows="3"></textarea>
					</div>
					<div class="form-group">
						<label for="" class="form-label">Nội dung</label>
						<textarea class="form-control" name="" id="" rows="3"></textarea>
					  </div>
				</form>
			</div>
		</div>
	</div>
	<content tag="js_current_page">
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/admin/js/products/create.js"></script>
	</content>
</body>
</html>