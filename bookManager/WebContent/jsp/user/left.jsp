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
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>首页</div>
    
    <dl class="leftmenu">
    <!-- 菜单生成 -->
    <dd1>
    <div class="title">
     <ul class="menuson">
     	<li><cite></cite><a href="<%=basePath %>user/index.do" target="rightFrame">图书中心</a><i></i></li>
        <li><cite></cite><a href="<%=basePath %>user/userGeRen.do" target="rightFrame">个人中心</a><i></i></li>
        <li><cite></cite><a href="<%=basePath %>user/userShouCang.do" target="rightFrame">用户收藏纪录</a><i></i></li>
        <li><cite></cite><a href="<%=basePath %>user/userJieShu.do" target="rightFrame">用户借书纪录</a><i></i></li>
     </ul>     
    </div>
    </dd1> 
    
   </dl>
    
</body>
</html>
