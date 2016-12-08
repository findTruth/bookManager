<%@page import="main.entity.Emp"%>
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
<title>Insert title here</title>
<link href="<%=basePath %>moban/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=basePath %>moban/js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>

</head>
<body style="background:url(<%=basePath %>moban/images/topbg.gif) repeat-x;">
    <div class="topleft">
    <a href="<%=basePath %>emp/home.do" target="_parent"><img src="<%=basePath %>moban/images/logo.png" title="系统首页" /></a>
    </div>
    
    <div class="topright">    
    <ul>
    <li><span><img src="<%=basePath %>moban/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="<%=basePath %>tool/clear.do" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span><%=((Emp)session.getAttribute("emp")).getNAME()%></span>
    </div>    
    
    </div>

</body>
</html>