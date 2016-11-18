<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<title>欢迎登录图书馆管理系统</title>
<link href="<%=basePath %>moban/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=basePath %>moban/js/jquery.js"></script>
<script src="<%=basePath %>moban/js/cloud.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/bootstrap.min.js"></script>
<script language="javascript">
	$(function(){
    $('.adminloginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.adminloginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 
<script type="text/javascript">
	
</script>
<script type="text/javascript">
    $(function(){
    	$("input[name=Name]").click(function(){
            $("#nameTop").html("");
        });
        $("input[name=Pwd]").click(function(){
            $("#pwdTop").html("");
        });
        $("input[name=Yzm]").click(function(){
            $("#yzmTop").html("");
        });
        $("#sub").click(function(){
            if ($("input[name=Name]").val()=="") {
            $("#nameTop").html("用户名为空");
            $("#nameTop").css("color","red");
            return false;
            }
            if ($("input[name=Pwd]").val()=="") {
                $("#pwdTop").html("密码为空");
                $("#pwdTop").css("color","red");
                return false;
            }
            if ($("input[name=Yzm]").val()=="") {
                $("#yzmTop").html("验证码为空");
                $("#yzmTop").css("color","red");
                return false;
            }

            $.ajax({
                type:'POST',
                dataType: 'json',
                url:'<%=basePath%>tool/adminLogin.do?Name='+$("input[name=Name]").val()+'&Pwd='+$("input[name=Pwd]").val()+'&Yzm='+$("input[name=Yzm]").val(),
                success:function(data,textStatus){
                    var objs = eval(data);
                    $("#resultTop").html(objs.msg);
                }
            });
        });
        $("#yzm").click(function(){
            $.ajax({
                type:'GET',
                url: '<%=basePath%>tool/VerifyImage.do',
                success:function(data){
                    $("#yzm").attr("src","<%=basePath%>tool/VerifyImage.do");
                }
            });
        });
    });
</script>
</head>

<body style="background-color:#1c77ac; background-image:url(<%=basePath %>moban/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录图书馆管理系统</span>    
    <ul>
    <li><a href="<%=basePath %>jsp/user/login.jsp">用户通道</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="adminsystemlogo"></span> 
       
    <div class="adminloginbox">
    
    <ul>
    <form method="post"  id="Form">
    <li><input name="Name" type="text" class="loginuser" value="" onclick="JavaScript:this.value=''" placeholder="请输入手机号或者邮箱"/><div style="position: absolute; left: 270px;"><label id="nameTop"></label></div></li>
    <li><input name="Pwd" type="text" class="loginpwd" value="" onclick="JavaScript:this.value=''" placeholder="请输入您的密码"/><div style="position: absolute; left: 270px;"><label id="pwdTop"></label></div></li>
    <li>验证码：<input type="text" name="Yzm" class="LoginYzm">
	    <img src="${pageContext.request.contextPath }/tool/VerifyImage.do" id="yzm" title="看不清，点击刷新"/>
	    &nbsp;&nbsp;<input name="" id="sub" type="button" class="loginbtn" value="登录"   />
	    <label><a href="#">忘记密码？</a></label>
	    <div style="position: absolute; left: 270px;"><label id="yzmTop"></label></div>
	    <div style="position: absolute; left: 270px;"><label id="resultTop"></label></div></li>
    </form>
    </ul>
    
    
    </div>
    
    </div>
    
    
    
    <div class="loginbm"></div>
	
    
</body>

</html>
