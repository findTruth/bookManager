<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>添加图书</title>
		<link href="<%=basePath%>moban/css/style.css" rel="stylesheet" type="text/css" />
		<script language="JavaScript" src="<%=basePath%>moban/js/jquery.js"></script>
		<script src="<%=basePath%>moban/js/cloud.js" type="text/javascript"></script>
		<script type="text/javascript" src="<%=basePath%>js/jquery-3.1.0.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
		<script language="javascript">
		</script>
		<script type="text/javascript">
			$(document).ready(function() {
				$(".click").click(function() {
					$(".tip").fadeIn(200);
				});

				$(".tiptop a").click(function() {
					$(".tip").fadeOut(200);
				});

				$(".sure").click(function() {
					$(".tip").fadeOut(100);
				});

				$(".cancel").click(function() {
					$(".tip").fadeOut(100);
				});

			});
		</script>
	</head>

	<body>
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li>
					<a href="#">图书管理</a>
				</li>
				<li>
					<a href="#">图书添加</a>
				</li>
			</ul>
		</div>
		<center>
			<form id="form" action="<%=basePath%>book/add.do" method="post" onSubmit="return check();">
				<div class="add-group">
					<br>
					<div class="add-lx">
						图书类型:
						<select name="BKINDNO" id="add1" disable=true>
							<option selected="selected" value="0">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<div class="imglist" id="list" style="height: 500px; width: 1000px; margin-left: 35px;">

								</div>
								<div class="imglist" id="list" style="height: 500px; width: 1000px; margin-left: 35px;">

								</div>
								<div class="imglist" id="list" style="height: 500px; width: 1000px; margin-left: 35px;">

								</div>请选择图书类型
							</option>
							</br>
							<option value="1">文学类</option>
							<option value="2">历史类</option>
							<option value="3">哲学类</option>
							<option value="4">文化、教育类</option>
							<option value="5">艺术、美学类</option>
							<option value="6">经济类</option>
							<option value="7">社会学类</option>
							<option value="8">心理学类</option>
							<option value="9">政治类</option>
							<option value="10">法律类</option>
							<option value="11">其他</option>

						</select>
						</br>
					</div>
				</div>

				<br>
				<div class="add-mc">
					图书名称:
					<spqn>
						<class="add-group" id="tushu-mc">
					</spqn>
					&nbsp;&nbsp;<input type="text" name="BNAME" id="BNAME" style="border: 1px solid blue; height: 25px; width: 150px" onblur="checkmc('mc');"></br>
				</div>

				<br>
				<div class="add-cb">
					出版社:
					<spqn>
						<class="add-group" id="tushu-cb">
					</spqn>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="BPRESS" name="BPRESS" id="addtext" style="border: 1px solid blue; height: 25px; width: 150px" onblur="checkcb('cb');"></br>
				</div>
				<br>
				<div class="add-zz">
					图书作者:
					<spqn>
						<class="add-group" id="tushu-zz">
					</spqn>
					&nbsp;&nbsp;<input type="text" name="BAUTHOR" id="BAUTHOR" style="border: 1px solid blue; height: 25px; width: 150px" onblur="checkzz('zz');"></br>
				</div>
				<br>
				<div class="add-jg">
					图书价格:
					<spqn>
						<class="add-group" id="tushu-jg">
					</spqn>
					&nbsp;&nbsp;<input type="text" name="BVALUE" id="BVALUE" style="border: 1px solid blue; height: 25px; width: 150px" onblur="checkjg('jg');"></br>
				</div>
				<br>
				<div class="add-cb">
					图书封面:
					<spqn>
						<class="add-group" id="tushu-cb">
					</spqn>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="file" name="BADDRESS" id="BADDRESS" style="border: 1px solid blue; height: 25px; width: 150px" onblur="checkcb('cb');"></br>
				</div>
				</div>
				&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
				<div class='add-button'>
					<input id="submit" type="submit" class="sure" value="确定" /> <input id="submit" type="reset" class="sure" value="重置" /> <input id="submit" type="button" class="sure" value="返回" onclick="location.href='<%=basePath%>jsp/book/work.jsp'" />
				</div>

			</form>
		</center>
		<script type="text/javascript">
			function checkbh(bh) {

			}
		</script>
	</body>

	</html>