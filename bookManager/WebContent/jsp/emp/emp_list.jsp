<%@page import="main.entity.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
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
		<script type="text/javascript" src="<%=basePath%>js/jquery-3.1.0.min.js"></script>
		<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" />
		
		<!--下拉菜单样式-->
		<script type="text/javascript" src="<%=basePath%>js/bootstrap-select.js"></script>
		<link rel="stylesheet" href="<%=basePath%>css/bootstrap-select.css" />
		
		<link href="<%=basePath%>moban/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=basePath%>moban/js/jquery.js"></script>
		<script language="javascript">
			$(function() {
				//导航切换
				$(".imglist li").click(function() {
					$(".imglist li.selected").removeClass("selected")
					$(this).addClass("selected");
				})

			})
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
		<script type="text/javascript">
		</script>
	</head>

	<body>

		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li>
					<a href="#">首页</a>
				</li>
				<li>
					<a href="#">员工列表</a>
				</li>
			</ul>
		</div>

		<div class="rightinfo">

			<div class="tools">

				<ul class="toolbar">
					<li class="click"><span><img src="<%=basePath%>moban/images/t01.png" /></span>添加</li>
					<li class="click"><span><img src="<%=basePath%>moban/images/t02.png" /></span>修改</li>
					<li><span><img src="<%=basePath%>moban/images/t03.png" /></span>删除</li>
					<li><span><img src="<%=basePath%>moban/images/t04.png" /></span>统计</li>
				</ul>

				<ul class="toolbar1">
					<li><span><img src="<%=basePath%>moban/images/t05.png" /></span>设置</li>
				</ul>

			</div>

			<table class="imgtable">

				<thead>
					<tr>
						<th style="width:30px"><input type="checkbox" name="" value="全选"></th>
						<th style="width:50px">序号</th>
						<th>用户名</th>
						<th>姓名</th>
						<th>电话</th>
						<th>QQ</th>
						<th>身份证</th>
						<th>年龄</th>
						<th>最后登录时间</th>
						<th>权限</th>
						<th>状态</th>
						<th style="width:100px">操作</th>
					</tr>
				</thead>

				<tbody id="list">
					
				</tbody>

			</table>

			<!-- <div id="loadgif" style="width:66px;height:66px;position:absolute;top:50%;left:50%;">
　　  <img  alt="加载中..." src="<%=basePath%>res/sys/wait.gif"/>
    </div> -->

			<div class="pagin">
				<div class="message">共<i class="blue page-count"></i>条纪录，当前显示第&nbsp;<i class="blue current-page"></i>&nbsp;页</div>
				<ul class="paginList">
					<!-- <li class="paginItem"><a id="prev"><span class="pagepre"></span></a></li>
        
        <li class="paginItem"><a id="firstPage">1</a></li>
        
        <li class="paginItem current"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li> 
        <li class="paginItem"><a id="next"><span class="pagenxt"></span></a></li> -->
				</ul>
			</div>

			<div class="tip">
				<div class="tiptop"><span>提示信息</span>
					<a></a>
				</div>

				<div class="tipinfo">
					<span><img src="<%=basePath%>moban/images/ticon.png" /></span>
					<div class="tipright">
						<p>是否确认对信息的修改 ？</p>
						<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
					</div>
				</div>

				<div class="tipbtn">
					<input name="" type="button" class="sure" value="确定" />&nbsp;
					<input name="" type="button" class="cancel" value="取消" />
				</div>

			</div>

		</div>

		<div class="tip">
			<div class="tiptop"><span>提示信息</span>
				<a></a>
			</div>

			<div class="tipinfo">
				<span><img src="<%=basePath%>moban/images/ticon.png" /></span>
				<div class="tipright">
					<p>是否确认对信息的修改 ？</p>
					<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
				</div>
			</div>

			<div class="tipbtn">
				<input name="" type="button" class="sure" value="确定" />&nbsp;
				<input name="" type="button" class="cancel" value="取消" />
			</div>

		</div>

		<div class="tip" id="changeEmpQuanTop">
			<div class="tiptop"><span>员工权限修改</span>
				<a></a>
			</div>

			<div class="tipinfo">
				<form id="changeEmpQuanForm">
					<input type="hidden" id="changeEmpQuanTopEUID" name="EUID"> 权限等级：
					<select id="changeEmpQuanTopQUAN" name="QUAN" class="show-tick form-control" style="width: 230px;">
						<option value="0">普通权限</option>
						<option value="1">图书录入和修改权限</option>
						<option value="2">图书管理权限</option>
						<option value="3">用户修改权限</option>
						<option value="4">用户管理权限</option>
					</select>
				</form>

			</div>

			<div class="tipbtn">
				<input name="changeEmpQuanTopYes" type="button" onclick="changeEmpQuanFunction()" class="sure" value="确定" />&nbsp;
				<input name="" type="button" class="cancel" value="取消" />
			</div>

		</div>

		<div class="tip" id="change" style="height: 400px;">
			<div class="tiptop"><span>员工信息修改</span>
				<a></a>
			</div>

			<div class="tipinfo">
				<table>
					<input type="hidden" name="changeuid" id="changeuid" />
					<tr>
						<td>用户名</td>
						<td>
							<input type="text" class="form-control" readonly="readonly" name="changeuname" id="changeuname" />
						</td>
					</tr>
					<tr>
						<td>姓名</td>
						<td>
							<input type="text" class="form-control" name="changename" id="changename" />
						</td>
					</tr>
					<tr>
						<td>电话</td>
						<td>
							<input type="text" class="form-control" name="changephone" id="changephone" />
						</td>
					</tr>
					<tr>
						<td>QQ</td>
						<td>
							<input type="text" class="form-control" name="changeqq" id="changeqq" />
						</td>
					</tr>
					<tr>
						<td>身份证号</td>
						<td>
							<input type="text" class="form-control" name="changeid" id="changeid" />
						</td>
					</tr>
					<tr>
						<td>年龄</td>
						<td>
							<input type="text" class="form-control" name="changeage" id="changeage" />
						</td>
					</tr>
					<tr>
						<td>权限</td>
						<td>
							<select id="changequan" name="changequan" class="show-tick form-control" style="width: 230px;">
								<option value="0">普通权限</option>
								<option value="1">图书录入和修改权限</option>
								<option value="2">图书管理权限</option>
								<option value="3">用户修改权限</option>
								<option value="4">用户管理权限</option>
							</select>
						</td>
					</tr>
				</table>
			</div>

			<div class="tipbtn" style="margin-top: 200px;">
				<input name="" type="button" class="sure" value="确定" />&nbsp;
				<input name="" type="button" class="cancel" value="取消" />
			</div>

		</div>
		<script type="text/javascript">
			$('.imgtable tbody tr:odd').addClass('odd');
		</script>

	</body>

</html>
<script>
	//业务处理
	//分页
	function getJSONData(pn, url) {
		// alert(pn);  
		$.getJSON(url, function(data) {
			var totalCount = data.totalCount; // 总记录数  
			var pageSize = 10; // 每页显示几条记录  
			var pageTotal = Math.ceil(totalCount / pageSize); // 总页数  
			var startPage = pageSize * (pn - 1);
			var endPage = startPage + pageSize - 1;
			var $tbody = $("#list");
			$tbody.empty();
			for(var i = 0; i < pageSize; i++) {
				$tbody.append('<tr class="tr-tag"></tr>');
			}
			var dataRoot = data.jsonRoot;
			if(pageTotal == 1) { // 当只有一页时  

				for(var j = 0; j < totalCount; j++) {
					$(".tr-tag").eq(j).append("<td class='col1'><input type='checkbox' value='" + parseInt(j + 1) + "'/></td>")
						.append("<td class='col2'>" + parseInt(j + 1) +
							"</td>").append("<td class='col3'>" + dataRoot[j].UNAME +
							"</td>").append("<td class='col4'>" + dataRoot[j].NAME +
							"</td>").append("<td class='col5'>" + dataRoot[j].PHONE +
							"</td>").append("<td class='col6'>" + dataRoot[j].QQ +
							"</td>").append("<td class='col7'>" + dataRoot[j].ID +
							"</td>").append("<td class='col8'>" + dataRoot[j].AGE +
							"</td>").append("<td class='col9'>" + dataRoot[j].LASTLOGIN +
							"</td>").append("<td class='col10'>" +
							"<a class='changeEmpQuanButton' name=" + dataRoot[j].QUANNUM + " id=" + dataRoot[j].EUID + " style='cursor:pointer;'>" + dataRoot[j].QUAN + "</a>" +
							"</td>").append("<td class='col11'>" + dataRoot[j].STATUS +
							"</td>").append("<td class='col12'>" + "<a class='changeButton' style='cursor:pointer'; name="+dataRoot[j].EUID+">修改</a>" +
							"</td>");
				}
			} else {

				for(var j = startPage, k = 0; j < endPage, k < pageSize; j++, k++) {
					if(j == totalCount) {
						break; // 当遍历到最后一条记录时，跳出循环  
					}
					$(".tr-tag").eq(k).append("<td class='col1'><input type='checkbox' value='" + parseInt(j + 1) + "'/></td>")
						.append("<td class='col2'>" + parseInt(j + 1) +
							"</td>").append("<td class='col3'>" + dataRoot[j].UNAME +
							"</td>").append("<td class='col4'>" + dataRoot[j].NAME +
							"</td>").append("<td class='col5'>" + dataRoot[j].PHONE +
							"</td>").append("<td class='col6'>" + dataRoot[j].QQ +
							"</td>").append("<td class='col7'>" + dataRoot[j].ID +
							"</td>").append("<td class='col8'>" + dataRoot[j].AGE +
							"</td>").append("<td class='col9'>" + dataRoot[j].LASTLOGIN +
							"</td>").append("<td class='col10'>" + dataRoot[j].QUAN +
							"</td>").append("<td class='col11'>" + dataRoot[j].STATUS +
							"</td>").append("<td class='col12'>" + "12312" +
							"</td>");
				}
			}
			$(".page-count").text(totalCount);
			$(".changeEmpQuanButton").click(function() {
				var QUANNUM = $(this).attr("name");
				var EUID = $(this).attr("id");
				$("#changeEmpQuanTopEUID").val(EUID);
				$("#changeEmpQuanTopQUAN").val(QUANNUM);
				$("#changeEmpQuanTop").fadeIn(200);
			});
			$(".changeButton").click(function(){
//				alert($(this).attr("name"));
				var id = $(this).attr("name");
				openChange(id);
			});
		})
	}

	function getPage(url) {
		$.getJSON(url, function(data) {

			pn = 1;
			var totalCount = data.totalCount; // 总记录数  
			var pageSize = 10; // 每页显示几条记录  
			var pageTotal = Math.ceil(totalCount / pageSize); // 总页数  
			$(".paginList").empty();
			$(".paginList").append("<li class='paginItem'><a id='prev'><span class='pagepre'></span></a></li>");
			for(var i = 1; i <= pageTotal; i++) {
				if(i == 1) {
					$(".paginList").append("<li class='paginItem'><a id='firstPage' name='" + i + "' class='paginItemb'>" + i + "</a></li>");
				} else if(i == pageTotal) {
					$(".paginList").append("<li class='paginItem'><a id='lastPage' name='" + i + "' class='paginItema'>" + i + "</a></li>");
				} else {
					$(".paginList").append("<li class='paginItem'><a name='" + i + "' class='paginItema'>" + i + "</a></li>");
				}

			}
			$(".paginList").append("<li class='paginItem'><a id='next'><span class='pagenxt'></span></a></li>");
			$("#next").click(function() {
				if(pn == pageTotal) {
					alert("后面没有了");
					pn = pageTotal;
				} else {
					pn++;
					$(".paginItem").attr("class", "paginItem");
					$(".paginItem").eq(pn).addClass("current");
					gotoPage(pn, url);
				}
			});
			$("#prev").click(function() {
				if(pn == 1) {
					alert("前面没有了");
					pn = 1;
				} else {
					pn--;
					$(".paginItem").attr("class", "paginItem");
					$(".paginItem").eq(pn).addClass("current");
					gotoPage(pn, url);
				}
			})
			$("#firstPage").click(function() {
				pn = 1;
				$(".paginItem").attr("class", "paginItem");
				$(".paginItem").eq(pn).addClass("current");
				gotoPage(pn, url);
			});
			$("#lastPage").click(function() {
				pn = pageTotal;
				gotoPage(pn, url);
			});
			$("#page-jump").click(function() {
				if($(".page-num").val() <= pageTotal && $(".page-num").val() != '') {
					pn = $(".page-num").val();
					gotoPage(pn, url);
				} else {
					alert("您输入的页码有误！");
					$(".page-num").val('').focus();
				}
			});
			$(".paginItema").click(function() {
				var pn = $(this).attr('name');
				$(".paginItem").attr("class", "paginItem");
				$(".paginItem").eq(pn).addClass("current");
				gotoPage(pn, url);
			});
			$("#firstPage").trigger("click");

		})
	}

	function gotoPage(pn, url) {
		//alert(pn);  
		$(".current-page").text(pn);
		getJSONData(pn, url)
	}

	$(function() {
		getPage("<%=basePath%>employee/list.do");

	});

	function flushPage() {
		getPage("<%=basePath%>employee/list.do");
	}

	//权限修改
	function changeEmpQuanFunction() {
		var EUID = $("#changeEmpQuanTopEUID").val();
		var QUAN = $("#changeEmpQuanTopQUAN").val();
		$.ajax({
			type: "POST",
			url: "<%=basePath%>manager/changeEmpQuan.do?EUID=" + EUID + "&QUAN=" + QUAN,
			async: true,
			dataType: 'json',
			success: function(data) {
				alert(data.msg);
				flushPage();
			},
			error: function() {
				alert("网络连接异常，请检查网络设置");
			}
		});
	}

	//状态修改
	function changeEmpStatusFunction() {
		var EUID = $("#changeEmpStatusTopEUID").val();
		var STATUS = $("#changeEmpStatusTopSTATUS").val();
		$.ajax({
			type: "POST",
			url: "<%=basePath%>manager/changeEmpStatus.do?EUID=" + EUID + "&STATUS=" + STATUS,
			async: true,
			dataType: 'json',
			success: function(data) {
				alert(data.msg);
				flushPage();
			},
			error: function() {
				alert("网络连接异常，请检查网络设置");
			}
		});
	}

	//通过id查找员工信息
	function findById(id) {
		var data1 = "";
		$.ajax({
			type: "POST",
			url: "<%=basePath%>employee/findById.do?EUID=" + id,
			async: false,
			dataType: 'json',
			success: function(data) {
				 data1 = data;
			}
		});
		return data1;
	}

	//跳转修改界面
	function openChange(id) {
//		var id = $(this).attr("name");
		var data = findById(id);
		//alert();
		$("#changeuid").val(data.EUID);
		$("#changeuname").val(data.UNAME);
		$("#changename").val(data.NAME);
		$("#changephone").val(data.PHONE);
		$("#changeqq").val(data.QQ);
		$("#changeid").val(data.ID);
		$("#changeage").val(data.AGE);
		alert(data.QUAN);
		$("#changequan").val(data.QUAN);
		$("#change").fadeIn(200);
	}
	//大量修改
	//批量删除
</script>