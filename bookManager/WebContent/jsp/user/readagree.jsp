<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <style type="text/css">
        body {
        margin:inherit;
		font-size:20px;
        }
         h1 {
            text-align:center;
        }
    h3 {color:black
        text-align:left;
       margin:auto 30px;
    }
    p {
       margin:0 30px;
   line-height:40px;
   text-indent:2em;
   color:#696969;
       }
 </style>
</head>
<body>
    <header><h1 >图书馆借阅规则</h1></header>
    <p>1. 本馆图书按《中图法》分类，按图书检索号组织排架，读者查找图书时可参照《中图法》基本大类表。</p></br>
	<p>2. 
本室实行开架借阅，读者阅览图书时，每人每次限取
1-3册，阅后请将图书放在专用书车（或专用书架）上，由工作人员统一上架。</p></br>
	<p>3. 
本室图书既可阅览，也可外借。读者挑选到满意的图书后，即可
将图书和借阅证同时送至服务台，
由工作人员办理外借手续。
还书时，
读者将书放在还书台上即可。</p></br>
	<p>4. 
读者如需复印借阅室图书时，应在服务台办理复印登记手续，并
在本班次工作时间内将图书归还本室。</p></br>
	<p>5. 
借书册数：
教职工  10 册
学生  5 册
各类临时借阅证  5 册
其中，小说类（I类）图书与计算机类（TP类）图书实行限借规定，
教职工限借小说类（I类）图书  4 本、计算机类（TP类）图书不限，
学生及各类临时借阅人员限借小说类（I类）
图书 2 本、计算机类（TP类）图书 2本。</p></br>
	<p>6.借书期限：
学生：28天（4周）
教职工：42天（6周）
图书逾期占用费：每册每天0.1元。</p></br>
	<p>7.图书续借：
全体读者可续借一次：教职工 14天（2周）学生7天（1周）（包括临时证）
续借手续应在读者借书以后的第25天到第28天之间办理，续借期自首次借书的到期之日算起，读者可在检索查询机上自行办理；未到续
借期限或逾期图书不提供续借服务。</p></br>
	<p>8. 
图书预约：
图书馆对教职工提供预约服务，
预约服务保留天数为5天，超过保留天数将自动解除预约服务。</p></br>
	<p>9. 寒暑假或法定节假日内到期的图书可在假期结束后的七天内归还，不作逾期处理。</p></br>
	<p>10.
学生外出实习期间（实习前以班级为单位凭院系证明，到图书馆
办理延期手续）到期的图书应在实习结束返校后的七天内归还，作逾期处理。</p></br>
	<p>11.
读者在借书前，须自行检查书中有无污损、缺页等情况，如发现
异常应主动向工作人员声明，交由工作人员处理，否则后果自负。</p></br>	
<center><input type="button" value="确认" onclick="location.href='<%=basePath %>jsp/user/Regist.jsp'" style="width: 100px; height: 40px;"></center>>
</body>
</html>

