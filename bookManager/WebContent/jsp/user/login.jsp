<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<script language='javascript' src="<%=basePath %>js/userreg.js"></script>
<script src="<%=basePath %>moban/js/cloud.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style.css">
<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
    $("#Yzm").click(function(){
        $.ajax({
            type:'GET',
            url: '<%=basePath%>tool/VerifyImage.do',
            success:function(data){
                $("#Yzm").attr("src","<%=basePath%>tool/VerifyImage.do");
            }
        });
    });
});  
</script> 
<script type="text/javascript">
	function sub() {
			if ($("input[name=user]").val()=="") {
				showTooltips('nameTop','密码不能为空',2000);
	            $("#nameTop").css("color","red");
	            return false;
	        }
	        if ($("input[name=pwd]").val()=="") {
	        	showTooltips('pwdTop','密码不能为空',2000);
	        	$("#pwdTop").css("color","red");
	            return false;
	        }
	        if ($("input[name=yzm]").val()=="") {
	        	alert('验证码不能为空');
	        	return false;
			}
	        $("#Form").submit();	
    }
	window.onload = function(){
		$("#drTop").css("color","red");
	}
	function CheckUser() {
		 $.ajax({
             type:'POST',
             dataType: 'json',
             url:'<%=basePath%>user/CheckUser.do?user='+$("input[name=user]").val(),
             success:function(data,textStatus){
                 var objs = eval(data);
                 if (objs.Usermsg='没有该账户，请注册一个新用户') {
                 showTooltips('nameTop',objs.Usermsg,4000);
                 $("#nameTop").css("color","red");
				}
             }
         });	 
	}
</script>
</head>

<body style="background-color:#1c77ac; background-image:url(<%=basePath %>moban/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



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
    <form method="post" action="<%=basePath %>user/login.do" id="Form">
    <li><input name="user" type="text" class="loginuser" value=""  placeholder="请输入手机号或者邮箱" onblur="CheckUser()"/> <div style="position: absolute; left: 270px;"><label id="nameTop"></label></div></li>
    <li><input name="pwd" type="password" class="loginpwd" value=""  placeholder="请输入您的密码"/><div style="position: absolute; left: 270px;"><label id="pwdTop"></label></div></li>
    <li id="yzm">验证码：<input type="text" name="yzm" class="LoginYzm" onkeyup="this.value=this.value.toUpperCase()"><img src="${pageContext.request.contextPath }/tool/VerifyImage.do" id="Yzm" title="看不清，点击刷新"/></li>
    <li id="yzm">&nbsp;&nbsp;<div style="position: absolute; left: 270px ;" class="Top"><label id="drTop" class="drtop">${loginmessage}</label></div><input  type="button" class="loginbtn" value="登录"  onclick="sub()"  />&nbsp;&nbsp;<input name="" type="button" class="loginbtn" value="注册"  onclick="location.href='<%=basePath %>jsp/user/Regist.jsp'" /><label><a href="<%=basePath %>jsp/user/find.jsp" id="mima">忘记密码？</a></label></li>
    </form>
    </ul>
    
    
    </div>
    
    </div>
    
    
    
    <div class="loginbm"></div>
	
    
</body>
</html>
