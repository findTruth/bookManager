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
	<title></title>
	<link href="<%=basePath %>moban/css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath %>moban/js/jquery.js"></script>
	<script src="jquery.autoSearchText.js" type="text/javascript"></script> 
<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>

	
	</head> 

	
	<body > 
	<div class="lefttop"><span></span>员工管理</div>
    <dl class="leftmenu">
   <% Emp emp = (Emp)session.getAttribute("emp"); %>
	

   <%
   	if(emp.getQUAN()>=0){
   %>
    <dd><div class="title"><span><img src="" /></span>
    <a href="">书籍借阅与归还 </a>
    </div>   
     <ul class="menuson">
        <li><cite></cite><a href="<%=basePath%>user/userJieShu.do" target="rightFrame">书籍借阅</a><i></i></li>
        <li><cite></cite><a href="<%=basePath%>emp/return.do" target="rightFrame">书籍归还</a><i></i></li>
        </ul>     
    </dd>  
    <%}else if(emp.getQUAN()>=1){%>
    <dd>

    <div class="title">
    <span></span><a href="<%=basePath %>emp/userlist.do" target="rightFrame">用户管理</a>
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=basePath %>emp/usechange.do" target="rightFrame">修改用户信息</a><i></i></li>
        <li><cite></cite><a href="<%=basePath %>emp/usedelete.do" target="rightFrame">删除用户信息</a><i></i></li>
        </ul>     
    </dd> 
    <%}else if(emp.getQUAN()>=2){%>
	    <dd>
	    <div class="title">
	    <span><img src="" /></span>
	   <a href="<%=basePath %>book/bookmanager.do" target="rightFrame">图书管理 </a>
	    </div>
	    </dd>
	    <%} %>
    </dl>

	
	</body> 
	
	</html>