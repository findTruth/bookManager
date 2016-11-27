<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=basePath %>moban/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=basePath %>moban/js/jquery.js"></script>

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

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>功能菜单</div>
    
    <dl class="leftmenu">
    <!-- 菜单生成 -->
    <dd>
    <div class="title">
    <span><img src="<%=basePath %>moban/images/leftico01.png" /></span>图书管理
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="<%=basePath %>book/bookmanager.do" target="rightFrame">图书管理</a><i></i></li>
        <li><cite></cite><a href="<%=basePath %>book/bookkindmanager.do" target="rightFrame">图书类型管理</a><i></i></li>
        <li><cite></cite><a href="<%=basePath %>book/bookrecordmanager.do" target="rightFrame">图书借阅纪录</a><i></i></li>
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="<%=basePath %>moban/images/leftico02.png" /></span>用户管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=basePath %>user/usermanager.do" target="rightFrame">用户信息管理</a><i></i></li>
        <li><cite></cite><a href="<%=basePath %>user/userkeep.do" target="rightFrame">用户收藏纪录</a><i></i></li>
        </ul>     
    </dd> 
    
    
    <dd><div class="title"><span><img src="<%=basePath %>moban/images/leftico03.png" /></span>员工管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=basePath %>employee/employeemanager.do" target="rightFrame">员工信息管理</a><i></i></li>
        <li><cite></cite><a href="<%=basePath %>employee/employeeworklist.do" target="rightFrame">员工上班纪录</a><i></i></li>
        <li><cite></cite><a href="<%=basePath %>employee/employeeworktime.do" target="rightFrame">实时员工工作情况</a><i></i></li>
        <li><cite></cite><a href="<%=basePath %>employee/employeeworktongji.do" target="rightFrame">员工工作统计</a><i></i></li>
    </ul>    
    </dd>  
    
    
      
    
    </dl>
    
</body>
</html>
