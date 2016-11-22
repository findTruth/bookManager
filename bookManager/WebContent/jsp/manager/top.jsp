﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
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
    <a href="<%=basePath %>manager/home.do" target="_parent"><img src="<%=basePath %>moban/images/logo.png" title="系统首页" /></a>
    </div>
      <!--   
    <ul class="nav">
    <li><a href="home.jsp" target="rightFrame" class="selected"><img src="<%=basePath %>moban/images/icon01.png" title="首页" /><h2>首页</h2></a></li>
    <li><a href="imgtable.html" target="rightFrame"><img src="<%=basePath %>moban/images/icon02.png" title="管理员信息" /><h2>管理员信息</h2></a></li>
    </ul>
        -->     
    <div class="topright">    
    <ul>
    <li><span><img src="<%=basePath %>moban/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="<%=basePath %>tool/clear.do" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span>${manager.UNAME }</span>
    </div>    
    
    </div>

</body>
</html>
