<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link href="../../moban/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../moban/js/jquery.js"></script>
</head>
<body >
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="http://localhost:8080/bookManager/jsp/emp/empwork.jsp">员工管理</a></li>
    <li><a href="http://localhost:8080/bookManager/jsp/emp/borrow.jsp">书籍借阅</a></li>
    </ul>
</div>
<div>
	<input type="text" class="search dfinput">
	<input type="button" class="btn" value="搜索">
	
</div>

	
</body>
<script type="application/javascript">
	
</script>
</html>