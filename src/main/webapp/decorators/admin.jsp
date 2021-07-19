<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<link rel="stylesheet" href="<c:url value='/assets/admin/css/style.css' />">
</head>
<body class="header-fixed sidebar-fixed">
	<div class="app">
		<%@include file="/common/admin/header.jsp"%>
		<div class="app-body">
			<%@include file="/common/admin/sidebar.jsp"%>
			<main class="main">
				<div>
					<ol class="breadcrumb">
						<!-- react-empty: 49 -->
						<li class="breadcrumb-item"><a href="/user">Home</a></li>
						<li class="active breadcrumb-item">Dashboard</li>
					</ol>
				</div>
				<div class="container-fluid">
					<dec:body />
				</div>
			</main>
		</div>
		<%@include file="/common/admin/footer.jsp"%>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
		<script src="<c:url value='/assets/admin/js/script.js' />"></script>
</body>
</html>