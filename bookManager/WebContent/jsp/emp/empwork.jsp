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
    <dd><div class="title"><span><img src="" /></span>书籍借阅与归还
    </div>   
     <ul class="menuson">
        <li><cite></cite><a href="http://localhost:8080/bookManager/jsp/emp/borrow.jsp">书籍借阅</a><i></i></li>
        <li><cite></cite><a href="http://localhost:8080/bookManager/jsp/emp/return.jsp">书籍归还</a><i></i></li>
        </ul>     
    </dd>  
    
    <dd>
    <div class="title">
    <span><img src="" /></span>
   <a href="http://localhost:8080/bookManager/jsp/book/bookList.jsp">书籍管理 </a>
    </div>
    </dd>
<dd>

    <div class="title">
    <span><img src="" /></span>用户管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="#">增加用户信息</a><i></i></li>
        <li><cite></cite><a href="#">修改用户信息</a><i></i></li>
        <li><cite></cite><a href="#">查找用户信息</a><i></i></li>
        <li><cite></cite><a href="#">删除用户信息</a><i></i></li>
        </ul>     
    </dd> 
    
    <dd><div class="title"><span><img src="" /></span>员工信息管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="#">增加员工信息</a><i></i></li>
        <li><cite></cite><a href="#">删除员工信息</a><i></i></li>
        <li><cite></cite><a href="#">修改员工信息</a><i></i></li>
        <li><cite></cite><a href="#">查找员工信息</a><i></i></li>
    </ul>
    </dd>  
     <dd>
    <div class="title">
    <span><img src="" /></span>
   <a href="">退出系统 </a>
    </div>
    </dd> 
    </dl>
    

	
	</body> 
	
	</html>