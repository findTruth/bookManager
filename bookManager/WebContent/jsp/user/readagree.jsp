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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=basePath %>moban/css/style.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body style="background-color:#1c77ac; background-image:url(<%=basePath %>moban/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;"> 
    <div class="loginbody2" >
     <span><center>图书馆注册借书协议</center></span> 
    <p><font size="10">本馆图书按《中图法》分类，按图书检索号组织排架，读者查找
	图书时可参照《中图法》基本大类表。</p></font>
    <p>本室图书既可阅览，也可外借。读者挑选到满意的图书后，即可
将图书和借阅证同时送至服务台，由工作人员办理外借手续。还书时，读者将书放在还书台上即可</p>
    <p> 
读者如需复印借阅室图书时，应在服务台办理复印登记手续，并在本班次工作时间内将图书归还本室。</p>
   <p>本馆图书按《中图法》分类，按图书检索号组织排架，读者查找图书时可参照《中图法》基本大类表。</p>
	<p> 
借书册数：
教职工  10册
学生  5册
各类临时借阅证  5册
其中，小说类（I类）图书与计算机类（TP类）图书实行限借规定，
教职工限借小说类（I类）图书  4本、计算机类（TP类）图书不限，
学生及各类临时借阅人员限借小说类（I类）图书  2本、计算机类（TP类）图书 2本。</p>
	<p>借书期限：
学生：28天（4周）
教职工：42天（6周）
图书逾期占用费：每册每天0.1元。</p>
	<p>图书续借：
全体读者可续借一次：
教职工  14天（2周）
学生  7天（1周）包括临时证）
续借手续应在读者借书以后的第25天到第28天之间办理，续借期自
首次借书的到期之日算起，
读者可在检索查询机上自行办理；
未到续借期限或逾期图书不提供续借服务。
	</p>
    </div>
    <div class="loginbm"></div>
</body>
</html>