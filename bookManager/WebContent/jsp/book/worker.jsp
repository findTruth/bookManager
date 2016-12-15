<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>图书管理</title>
<link href="<%=basePath %>moban/css/style.css" rel="stylesheet"
	type="text/css" />
<script language="JavaScript" src="<%=basePath %>moban/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=basePath %>js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/bootstrap.min.js"></script>
<script language="javascript">
</script>
<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
  });
});
</script>
</head>

<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">图书中心</a></li>
		</ul>
	</div>
	<div class="rightinfo">

		<div class="tools">

			<ul class="toolbar" style="margin-left:25px;">
				<li>

					<div class="stylesheet">
						<select class="select3" style="width: 110px; height: 30px;"id="Kindtype">
							<option value="请选择图书类别">请选择图书类别</option>
	            <option value="1">文学类</option>
	           <option value="10">法律类</option>
	           <option value="2">历史类</option>
	           <option value="3">哲学类</option>
	           <option value="4">文化、教育类</option>
	           <option value="5">艺术、美学类</option>
	           <option value="6">经济类</option>
	           <option value="7">社会学类</option>
	           <option value="8">心理学类</option>
	           <option value="9">政治类</option>
	           <option value="11">其他</option>	  
			</select>
				</li>
				<li><span onclick="findByKind()">
				<img src="<%=basePath %>moban/images/确定按钮1.png"></span>确定</li>

				<li><input name="scinput" type="text" class="scinput" placeholder="请输入书籍名称或作者" /></li>
				<li><span onclick="findByName()"><img src="<%=basePath %>moban/images/ico06.png"></span>查询</li>
						
		</div>
	</div>
	</div>
	<div class="imglist" id="list"style="height: 500px; width: 1000px; margin-left: 35px;"></div>
	<div class="pagin">
		<div class="message">
			共<i class="blue page-count"></i>条纪录，当前显示第&nbsp;<i
				class="blue current-page"></i>&nbsp;页
		</div>
		<ul class="paginList">

		</ul>
	</div>
	<div class="tip">
		<div class="tiptop">
			<span>提示信息</span><a></a>
		</div>

		<div class="tipinfo">
			<span><img src="<%=basePath %>moban/images/ticon.png" /></span>
			<div class="tipright">
				<p>是否确认对信息的修改 ？</p>
				<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
			</div>
		</div>

		<div class="tipbtn">
			<input name="" type="button" class="sure" value="确定" />&nbsp; <input
				name="" type="button" class="cancel" value="取消" />
		</div>

	</div>

</body>
</html>
<script>
function getJSONData(pn, url) {
		// alert(pn);  
		$.post(url, function(data) {
			var totalCount = data.totalCount; // 总记录数  
			var pageSize = 10; // 每页显示几条记录  
			var pageTotal = Math.ceil(totalCount / pageSize); // 总页数  
			var startPage = pageSize * (pn - 1);
			var endPage = startPage + pageSize - 1;
			var $ul = $("#list");
			$ul.empty();
			for(var i = 0; i < pageSize; i++) {
				$ul.append('<li class="li-tag"></li>');
				
			}
			var dataRoot = data.jsonRoot;
			if(pageTotal == 1) { // 当只有一页时  
				for(var j = 0; j < totalCount; j++) {
					$(".li-tag").eq(j).append("<span><img src='<%=basePath %>"+dataRoot[j].ADDRESS+"' /></span>&nbsp;&nbsp;&nbsp;&nbsp;<h2><a href='#'>"+dataRoot[j].NAME+"</a></h2><p><a class='Addbookkeep' style='cursor:pointer' name="+dataRoot[j].BUID+">收藏</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class='Addbookrecord' style='cursor:pointer'; name="+dataRoot[j].BUID+">借阅</a></p>");
				}
			} else {
				for(var j = startPage, k = 0; j < endPage, k < pageSize; j++, k++) {
					if(j == totalCount) {
						break; // 当遍历到最后一条记录时，跳出循环  
					}
					$(".li-tag").eq(k).append("<span><img src='<%=basePath %>"+dataRoot[j].ADDRESS+"' /></span>&nbsp;&nbsp;&nbsp;&nbsp;<h2><a href='#'>"+dataRoot[j].NAME+"</a></h2><p><a  class='Addbookkeep' style='cursor:pointer' name="+dataRoot[j].BUID+">收藏</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class='Addbookrecord' style='cursor:pointer'; name="+dataRoot[j].BUID+">借阅</a></p>");
				}
			}
			$(".page-count").text(totalCount);
			$(".Addbookkeep").click(function(){
				var id = $(this).attr("name");
				Addbookkeep(id);
			});
			$(".Addbookrecord").click(function(){
				var id = $(this).attr("name");
				Addbookrecord(id);
			});
		},"json");	
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
		getPage("<%=basePath%>book/list.do");
	});

	function flushPage() {
		getPage("<%=basePath%>book/list.do");
	}
	function findByName(){
		var type="名字查找";
		var content =$("input[name='scinput']").val();
		$.ajax({
			type: "GET",
			url: "<%=basePath%>book/list.do?Content=" + content +"&type=" + type,
			async: true,
			dataType: 'json',
			success: function(data) {
				alert(data.msg);
				getPage("<%=basePath%>book/list.do?Content=" + content +"&type=" + type+"");
			},
			error: function() {
				alert("网络连接异常，请检查网络设置");
			}
		});
	}
	function findByKind(){
		var type =$("#Kindtype").val();
		var content="类别查找";
		$.ajax({
			type: "GET",
			url: "<%=basePath%>book/list.do?Content=" + content +"&type=" + type,
			async: true,
			dataType: 'json',
			success: function(data) {
				alert(data.msg);
				getPage("<%=basePath%>book/list.do?Content=" + content +"&type=" + type+"");
			},
			error: function() {
				alert("网络连接异常，请检查网络设置");
			}
		});
	}
	function Addbookkeep(id) {
		$.ajax({
			type: "GET",
			url: "<%=basePath%>user/Addbookkeep.do?BUID=" + id,
			async: false,
			dataType: 'json',
			success: function(data) {
				alert(data.msg);
			}
		});
	}
	
	function Addbookrecord(id) {
		$.ajax({
			type: "GET",
			url: "<%=basePath%>user/Addborrow.do?BUID=" + id,
			async: false,
			dataType: 'json',
			success: function(data) {
				alert(data.msg);
			}
		});
	}
</script>