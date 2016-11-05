<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎光临</title>
<script type="text/javascript" src="<%=basePath %>js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="<%=basePath %>css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/bootstrap-button.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style.css">

<script type="text/javascript">
	function Form() {
		$("#Id").val($("#Sel").val());
		if ($("#Name").val()=="") {
			$("#NameTop").html("用户名为空");
			return false;
		}
		if ($("#Password").val()=="") {
			$("#PwdTop").html("密码为空");
			return false;
		}

		$("#From1").submit();
	}
</script>

</head>
<body>
	<div class="LoginFormBody">
		<form id="From1">
			<table>
				<tr>
					<td style="width: 100px"></td>
					<td style="width: 200px"></td>
					<td style="width: 100px"></td>
				</tr>
				<tr>
					<td colspan="3"><h2>登陆界面</h2></td>
				</tr>
				<tr>
					<td colspan="3">&nbsp;</td>
				</tr>
				<tr>
					<td>
						<span class="glyphicon glyphicon-send"></span>
						<label class="control-label" for="inputType">身份：</label>
					</td>
					<td>
						<select id="Sel" style="width:100%;height:100%">
							<option value="0">读者</option>
							<option value="1">员工</option>
							<option value="2">管理员</option>
						</select>
						<input type="hidden" name="Id" id="Id">
					</td>
				</tr>
				<tr>
					<td colspan="3">&nbsp;</td>
				</tr>
				<tr>
					<td>
						 <span class="glyphicon glyphicon-user"></span>
						<label class="control-label" for="inputEmail">账号：</label>
					</td>
					<td><input id="Name" name="Name" type="text" style="width:100%;margin-top: -8px"/></td>
					<td><label id="NameTop"></label></td>
				</tr>
				<tr>
					<td colspan="3">&nbsp;</td>
				</tr>
				<tr>
					<td>
						<span class="glyphicon glyphicon-briefcase"></span>
						<label class="control-label" for="inputPassword">密码：</label>
					</td>
					<td><input id="Password"  name="Password" type="password" style="width:100%;margin-top: -8px"/></td>
					<td><label id="PwdTop"></label></td>
				</tr>
				<tr>
					<td colspan="3">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="3">
						<a class="button button-primary button-rounded button-small" onclick="Form()">登陆</a>
						&nbsp;
						<a class="button button-caution button-rounded button-small" href="#">注册</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div class="hiddenDiv"></div>
<div style="position:absolute; width:100%; height:100%; z-index:-2; left:0; top:0;">      
<img src="<%=basePath %>res/LoginBack.jpg" height="100%" width="100%" style="left:0; top:0;">      
</div>  
</body>
</html>