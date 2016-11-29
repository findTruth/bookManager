
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
<title></title>
<link href="<%=basePath %>moban/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>moban/js/jquery.js"></script>

</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="../user/index.do">首页</a></li>
    </ul>
    </div></br>
    
    <div class="mainindex">
    
    
    <div class="welinfo">
    <span><img src="<%=basePath %>moban/images/sun.png" alt="天气" /></span>
    <b><%=request.getSession().getAttribute("User") %>早上好，欢迎使用图书管理系统</b>
    <a href="<%=basePath %>user/userGeRen.do"">账号设置</a>
    </div>
    
    <div class="welinfo">
    <span><img src="<%=basePath %>moban/images/time.png" alt="时间" /></span>
    <i>您上次登录的时间：<%= request.getAttribute("LoginTime")%></i>（不是您登录的？<a href="#">请点这里</a>）
    </div>
    
    <div class="xline"></div>
    
   <!--  <ul class="iconlist">
    
    <li><img src="<%=basePath %>moban/images/ico01.png" /><p><a href="#">图书管理</a></p></li>
    <li><img src="<%=basePath %>moban/images/ico02.png" /><p><a href="#">员工管理</a></p></li>
    <li><img src="<%=basePath %>moban/images/ico03.png" /><p><a href="#">用户管理</a></p></li>
   
            
    </ul>
     -->
    <!-- <div class="ibox"><a class="ibtn"><img src="<%=basePath %>moban/images/iadd.png" />æ·»å æ°çå¿«æ·åè½</a></div> -->
    
    <!-- <div class="xline"></div>
    <div class="box"></div>
    
    <div class="welinfo">
    <span><img src="<%=basePath %>moban/images/dp.png" alt="æé" /></span>
    <b>Uimakerä¿¡æ¯ç®¡çç³»ç»ä½¿ç¨æå</b>
    </div>
    
    <ul class="infolist">
    
    </ul>
    
    <div class="xline"></div>
    
    <div class="uimakerinfo">
    </div> -->
    
    

</body>

</html>
