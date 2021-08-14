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
				<h2>Start</h2>
				<form id="userform" action="${pageContext.request.contextPath}/admin/products/submituser" method="post"  >
            Name  :<input type="text" name="name"/><br/>
            Size: <input id="productClasses0.size" name="productClasses[0].size" type="number" value="">
            <input type="submit"/>
        </form>
        <div id="msg"></div>
        
				<form:form
					action="${pageContext.request.contextPath}/admin/products/create"
					modelAttribute="product"
					method="POST"
					autocomplete="off">
					<form:input path="name" placeholder="Ten san pham"/> <form:errors path="name" cssClass="error"/> <br/><br/>
					<%-- <form:input path="productClasses[].size" placeholder="Kich thuoc"/> <form:errors path="productClasses[].size" cssClass="error"/> <br/><br/> --%>
					<input placeholder="size giay" />
					<form:input path="productClasses[0].size" type="number"/>
					<form:errors path="productClasses[0].size" cssClass="error"/> <br/><br/>
					<form:input path="productClasses[2].size"/>
					<form:errors path="productClasses[2].size" cssClass="error"/> <br/><br/>
					<%-- <form:errors path="*" cssClass="errorblock" element="div" /> --%>
					<button type="submit" class="btn btn-primary width-100">Lưu</button>
				</form:form>
				<hr />
			
			
				<h1>Add Users using Ajax ........</h1>
		        <table>
		                <tr><td colspan="2"><div id="error" class="error"></div></td></tr>
		                <tr><td>Enter your name : </td><td> <input type="text" id="name"><br/></td></tr>
		                <tr><td>Education : </td><td> <input type="text" id="education"><br/></td></tr>
		                <tr><td colspan="2"><input type="button" value="Add Users" id="submitForm"><br/></td></tr>
		                <tr><td colspan="2"><div id="info" class="success"></div></td></tr>
		        </table>
				
				
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
									<td rowspan="1">Màu trắng</td>
									<td class="size-list-wrapper">
										<select class="size-list">
											<option value="">36</option>
											<option value="">37</option>
											<option value="">38</option>
										</select>
									</td>
									<td class="amount-wrapper">
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
	<script type="text/javascript">
    jQuery(document).ready(function(){
        jQuery("#userform").submit(function(e){
            jQuery(".formFieldError").remove();
            jQuery.ajax({
                    url: jQuery(this).attr("action"),
                    context: document.body,
                    type: 'post',
                    data:jQuery(this).serialize()
                }).done(function(res) {
                    if(res.status==="ERROR"){
                        for(var key in res.errorsMap){
                            var err="<span class=\"formFieldError\" id=\""+key+"Id\">"+res.errorsMap[key]+"</span>";
                            jQuery("[name^='"+key+"']").after(err);
                        }
                    }else{                      
                        jQuery("#msg").html("Form submitted");
                    }
                }).fail(function(data){
                    jQuery("#msg").html("<span class=\"formFieldError\">Server failed to process request</span>");
                });
            return false;
        });
    });
</script>
</body>
</html>