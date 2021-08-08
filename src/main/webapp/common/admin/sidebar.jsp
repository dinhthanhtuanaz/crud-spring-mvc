<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="sidebar">
	<nav class="sidebar-nav">
		<ul class="sidebar-tree list-inline">
			<li class="tree-view  tree-view--active"><a
				href="https://www.google.com/"> <i class="fas fa-tachometer-alt"></i><span>Dashboard</span>
			</a></li>
			<li class="tree-view tree-view-root"><a href=""> <i
					class="fab fa-cuttlefish"></i><span>Danh mục</span><i
					class="fas fa-chevron-right toggle-rotate"></i>
			</a>
				<ul class="tree-view-menu list-inline" style="">
					<li><a href="${pageContext.request.contextPath}/admin/categories">Danh sách</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/categories/create">Thêm</a></li>
				</ul></li>
			<li class="tree-view tree-view-root"><a href=""> <i
					class="fab fa-product-hunt"></i><span>Sản phẩm</span><i
					class="fas fa-chevron-right toggle-rotate"></i>
			</a>
				<ul class="tree-view-menu list-inline" style="">
					<li><a href="${pageContext.request.contextPath}/admin/products">Danh sách</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/products/create">Thêm</a></li>
				</ul></li>
		</ul>
	</nav>
</div>