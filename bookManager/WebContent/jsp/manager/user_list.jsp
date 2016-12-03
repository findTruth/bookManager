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
					<a href="#">用户列表</a>
				</li>
			</ul>
		</div>

		<div class="rightinfo">

			<div class="tools">

				<ul class="toolbar">
					<li onclick="delUser()"><span><img src="<%=basePath%>moban/images/t03.png" /></span>删除</li>
				</ul>

				<ul class="toolbar1">
					<li><span><img src="<%=basePath%>moban/images/t05.png" /></span>设置</li>
				</ul>

			</div>

			<table class="imgtable">

				<thead>
					<tr>
						<th style="width:30px"><input type="checkbox" name="" value="全选" id="all"></th>
						<th style="width:50px">序号</th>
						<th>电话</th>
						<th>邮箱</th>
						<th>昵称</th>
						<th>性别</th>
						<th>最后登录时间</th>
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
				</ul>
			</div>

			

		


		<div class="tip" id="change" style="height: 350px;">
			<div class="tiptop"><span>用户信息修改</span>
				<a></a>
			</div>

			<div class="tipinfo">
				<table>
					<input type="hidden" name="changeuid" id="changeuid" />
					<tr>
						<td>用户昵称</td>
						<td>
							<input type="text" class="form-control" readonly="readonly" name="changenicname" id="changenicname" />
						</td>
					</tr>
					<tr>
						<td>电话</td>
						<td>
							<input type="text" class="form-control" name="changephone" id="changephone" />
						</td>
					</tr>
					<tr>
						<td>邮箱</td>
						<td>
							<input type="text" class="form-control" name="changeemail" id="changeemail" />
						</td>
					</tr>
					<tr>
						<td>性别</td>
						<td>
							<select id="changesex" name="changesex" class="show-tick form-control" style="width: 230px;">
								<option value="0">保密</option>
								<option value="1">男</option>
								<option value="2">女</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>状态</td>
						<td>
							<select id="changestatus" name="changestatus" class="show-tick form-control" style="width: 230px;">
								<option value="0">正常状态</option>
								<option value="1">封号状态</option>
							</select>
						</td>
					</tr>
				</table>
			</div>

			<div class="tipbtn" style="margin-top: 150px;">
				<input name="" type="button" class="sure" onclick="changeFunction()" value="确定" />&nbsp;
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
		$.post(url, function(data) {
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
					var sex="";
					switch (dataRoot[j].SEX){
						case 1:
						sex="男";
							break;
						case 2:
						sex="女";
							break;
						default:
						sex="保密";
							break;
					}
					var status = "";
					switch(dataRoot[j].STATUS) {
						case 0:
							status = '正常状态';
							break;
						default:
							status = '封号状态';
							break;
					}
					$(".tr-tag").eq(j).append("<td class='col1'><input type='checkbox' value='" + dataRoot[j].UUID + "'/></td>")
						.append("<td class='col2'>" + parseInt(j + 1) +
							"</td>").append("<td class='col3'>" + dataRoot[j].PHONE +
							"</td>").append("<td class='col4'>" + dataRoot[j].EMAIL +
							"</td>").append("<td class='col5'>" + dataRoot[j].NICNAME +
							"</td>").append("<td class='col6'>" + sex +
							"</td>").append("<td class='col7'>" + dataRoot[j].LOGINTIME +
							"</td>").append("<td class='col7'>" + status +
							"</td>").append("<td class='col10'>" + "<a class='changeButton' style='cursor:pointer'; name=" + dataRoot[j].UUID + ">修改</a>" +
							"</td>");
				}
			} else {

				for(var j = startPage, k = 0; j < endPage, k < pageSize; j++, k++) {
					if(j == totalCount) {
						break; // 当遍历到最后一条记录时，跳出循环  
					}
					var sex="";
					switch (dataRoot[j].SEX){
						case 1:
						sex="男";
							break;
						case 2:
						sex="女";
							break;
						default:
						sex="保密";
							break;
					}
					var status = "";
					switch(dataRoot[j].STATUS) {
						case 0:
							status = '正常状态';
							break;
						default:
							status = '封号状态';
							break;
					}
					$(".tr-tag").eq(k).append("<td class='col1'><input type='checkbox' value='" + dataRoot[j].UUID + "'/></td>")
						.append("<td class='col2'>" + parseInt(j + 1) +
							"</td>").append("<td class='col3'>" + dataRoot[j].PHONE +
							"</td>").append("<td class='col4'>" + dataRoot[j].EMAIL +
							"</td>").append("<td class='col5'>" + dataRoot[j].NICNAME +
							"</td>").append("<td class='col6'>" + sex+
							"</td>").append("<td class='col7'>" + dataRoot[j].LOGINTIME +
							"</td>").append("<td class='col7'>" + status +
							"</td>").append("<td class='col10'>" + "<a class='changeButton' style='cursor:pointer'; name=" + dataRoot[j].UUID + ">修改</a>" +
							"</td>");
				}
			}
			$(".page-count").text(totalCount);
			$(".changeButton").click(function() {
				//				alert($(this).attr("name"));
				
				var id = $(this).attr("name");
				openChange(id);
			});
			$("#all").click(function(){
//				$("#list :checkbox,#all").each(function(){
//					$(this).attr("checked", !$(this).attr("checked");
//				});
//				$("#list :checkbox,#all").attr("checked", true); 
				if(!$(this).attr("checked")){
					$("#list :checkbox").attr("checked", false); 
				}else{
					$("#list :checkbox").attr("checked", true); 
				}
			});
		},"json")
	}

	function getPage(url) {
		$.post(url, function(data) {

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

		},"json")
	}

	function gotoPage(pn, url) {
		//alert(pn);  
		$(".current-page").text(pn);
		getJSONData(pn, url)
	}

	$(function() {
		getPage("<%=basePath%>user/UserList.do");

	});

	function flushPage() {
		getPage("<%=basePath%>employee/list.do");
	}
	
	//打开新增页面
	
	
	//新增用户
	
	
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
			url: "<%=basePath%>manager/findUserById.do?UUID=" + id,
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
		$("#changeuid").val(data.UUID);
		$("#changenicname").val(data.NICNAME);
		$("#changephone").val(data.PHONE);
		$("#changeemail").val(data.EMAIL);
		$("#changesex").val(data.SEX);
		$("#changestatus").val(data.STATUS);
		$("#change").fadeIn(200);
	}
	//大量修改
	function changeFunction() {
		var UUID = $("#changeuid").val();
		var NICNAME = $("#changenicname").val();
		var PHONE = $("#changephone").val();
		var EMAIL= $("#changeemail").val();
		var SEX = $("#changesex").val();
		var STATUS = $("#changestatus").val();
		var jsondata = {
			"UUID": UUID,
			"NICNAME": NICNAME,
			"PHONE": PHONE,
			"EMAIL": EMAIL,
			"SEX": SEX,
			"STATUS": STATUS
		};
		$.ajax({
			type: "POST",
			url: "<%=basePath%>manager/changeUser.do",
			async: true,
			dataType: 'json',
			data: jsondata,
			success: function(data) {
				alert(data.msg);
				flushPage();
			}
		});
	}
	//批量删除
	function delUser() {
	    var valArr = new Array; 
	    
	    $("#list :checkbox[checked]").each(function(i){ 
	        valArr[i] = $(this).val(); 
	    }); 
	    var jsondata = {};
	    for(var i=0;i<valArr.length;i++){
	    	jsondata[i]=valArr[i];
	    }
	    jsondata['length'] = valArr.length;
	   $.ajax({
			type: "POST",
			url: "<%=basePath%>manager/delUser.do",
			async: true,
			dataType: 'json',
			data: jsondata,
			success: function(data) {
				alert(data.msg);
				flushPage();
			}
		});
	}
</script>