﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎使用个人图书管理平台</title>
<link href="<%=basePath %>moban/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=basePath %>moban/js/jquery.js"></script>
<script src="<%=basePath %>moban/js/cloud.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/bootstrap.min.js"></script>
<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 
<script type="text/javascript">
	function sub() {
        if ($("input[name=user]").val()==""||$("input[name=user]").val()=="admin") {
            $("#userTop").html("用户名为空");
            $("#userTop").css("color","red");
            $("#userTop").css("font-size","5");
            return false;
        }else if(){}
        if ($("input[name=pwd]").val()==""||$("input[name=pwd]").val()=="密码") {
            $("#pwdTop").html("密码为空");
            $("#pwdTop").css("color","red");
            $("#pwdTop").css("font-size","5");
            return false;
        }

        $("#Form").submit();
    }
</script>
</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎使用个人图书管理平台</span>    
    <ul>
    <li><a href="<%=basePath %>jsp/sys/login.jsp">员工通道</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox">
    
    <ul>
    <form method="post" action="user/login" id="Form">
    <li><input name="user" type="text" class="loginuser" value="admin" onclick="JavaScript:this.value=''"/><label id="userTop"></label></li>
    <li><input name="pwd" type="text" class="loginpwd" value="密码" onclick="JavaScript:this.value=''"/><label id="pwdTop"></label></li>
    <li><input name="" type="button" class="loginbtn" value="登录"  onclick="sub()"  /><label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label></li>
    </form>
    </ul>
    
    
    </div>
    
    </div>
    
    
    
    <div class="loginbm"></div>
	
    
</body>

</html>
