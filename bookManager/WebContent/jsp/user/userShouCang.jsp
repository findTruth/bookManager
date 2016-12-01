<%@page import="main.javaBean.Bookrecord"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=basePath%>moban/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>moban/js/jquery.js"></script>
<script type="text/javascript">
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
			
			$tbody.append('<tr class="tr-tag" style="height:50px"></tr>');
		}
		var dataRoot = data.jsonRoot;
		if(pageTotal == 1) { // 当只有一页时  
			for(var j = 0; j < totalCount; j++) {
				$(".tr-tag").eq(j).append("<td class='col1' ><input type='checkbox' value='" + parseInt(j + 1) + "'/></td>")
					.append("<td class='col2'>" + parseInt(j + 1) +
						"</td>").append("<td class='col3'>" + dataRoot[j].NAME +
						"</td>").append("<td class='col4'>" + dataRoot[j].PRESS +
						"</td>").append("<td class='col5'>" + dataRoot[j].AUTHOR +
						"</td>").append("<td class='col6'>" + dataRoot[j].TIME +
						"</td>").append("<td class='col7'>" + "<a class='deleteButton' style='cursor:pointer'; name="+dataRoot[j].KUID+">删除</a>&nbsp;&nbsp;<a class='addButton' style='cursor:pointer'; name="+dataRoot[j].KUID+">借阅</a>" +
						"</td>");
			}
		} else {

			for(var j = startPage, k = 0; j < endPage, k < pageSize; j++, k++) {
				if(j == totalCount) {
					break; // 当遍历到最后一条记录时，跳出循环  
				}
				$(".tr-tag").eq(j).append("<td class='col1'><input type='checkbox' value='" + parseInt(j + 1) + "'/></td>")
					.append("<td class='col2'>" + parseInt(j + 1) +
					"</td>").append("<td class='col3'>" + dataRoot[j].NAME +
					"</td>").append("<td class='col4'>" + dataRoot[j].PRESS +
					"</td>").append("<td class='col5'>" + dataRoot[j].AUTHOR +
					"</td>").append("<td class='col6'>" + dataRoot[j].TIME +
					"</td>").append("<td class='col7'>" + "<a class='deleteButton' style='cursor:pointer'; name="+dataRoot[j].KUID+">删除</a>&nbsp;&nbsp;<a class='addButton' style='cursor:pointer'; name="+dataRoot[j].KUID+">借阅</a>" +
					"</td>");
			}
		}
		$(".page-count").text(totalCount);
		$(".deleteButton").click(function(){
			var id = $(this).attr("name");
			openDelete(id);
		});
		$(".addButton").click(function(){
			var id = $(this).attr("name");
			openAdd(id);
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
	getPage("<%=basePath%>user/userShouCang2.do");
});

function flushPage() {
	getPage("<%=basePath%>user/userShouCang2.do");
}
function findflushPage() {
	var content = $("input[name='Search']").val();
	getPage("<%=basePath%>user/userShouCang2.do?Content=" + content +"&NUMBER=" + 0);
}
function openDelete(id) {
	$("#KUID").val(id);
	$("#delete").fadeIn(200);
}
function openAdd(id) {
	$("#KUID").val(id);
	$("#add").fadeIn(200);
}
function deleteensure(){
	var KUID = $("input[name='KUID']").val();
	$.ajax({
		type: "POST",
		url: "<%=basePath%>user/deletebookkeep.do?KUID=" + KUID,
		async: true,
		dataType: 'json',
		success: function(data) {
			alert(data.msg);
			flushPage();
			$("#delete").fadeOut(200);
		},
		error: function() {
			alert("网络连接异常，请检查网络设置");
		}
	});
}

function deletecancle(){	
	$("#delete").fadeOut(200);
}

function addensure(){
	var KUID = $("input[name='KUID']").val();
	$.ajax({
		type: "POST",
		url: "<%=basePath%>user/borrowbookkeep.do?KUID=" + KUID,
		async: true,
		dataType: 'json',
		success: function(data) {
			alert(data.msg);
			flushPage();
			$("#add").fadeOut(200);
		},
		error: function() {
			alert("网络连接异常，请检查网络设置");
		}
	});
}

function addcancle(){	
	$("#add").fadeOut(200);
}
function Findbookkeep(){
	var content = $("input[name='Search']").val();
	$.ajax({
		type: "GET",
		url: "<%=basePath%>user/userShouCang2.do?Content=" + content +"&NUMBER=" + 0,
		async: true,
		dataType: 'json',
		success: function(data) {
			alert(data.msg);
			findflushPage();
		},
		error: function() {
			alert("网络连接异常，请检查网络设置");
		}
	});
}
function returnbookkeep(){
	$("input[name='Search']").attr("value","");
	flushPage();
}
</script>
<script language="javascript">
$(function(){	
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
    
});	
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


<body style="background:#edf6fa;">

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="../user/index.do">首页</a></li>
    <li><a href="#">收藏记录</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    	<center style="font-size: 15px;">搜索:&nbsp;&nbsp;<input type="text" name="Search" placeholder="请输入书名或者作者" style="width: 200px;height: 40px"/>&nbsp;&nbsp;<input type="button" value="确定" class="Search" style="background:url(../moban/images/buttonbg.png) repeat-x;width:96px; height:35px;" onclick="Findbookkeep()"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="取消" style="background:url(../moban/images/buttonbg.png) repeat-x;width:96px; height:35px;" onclick="returnbookkeep()"/></center>
    </div></br>
    
    
    <table class="imgtable">
    
    <thead>
    <tr>
    <th><input type="checkbox" name="" value="全选"></th>
    <th>序号</th>
    <th>书名</th>
    <th>出版社</th>
    <th>作者</th>
    <th>时间</th>
    <th style="width:200px">操作</th>
    </tr>
    </thead>
    
    <tbody id="list">
    
    </tbody>
    
    </table>
 
<div class="pagin">
				<div class="message" style="font-size: 15px">共&nbsp;&nbsp;<i class="blue page-count" style="font-size: 15px"></i>&nbsp;&nbsp;条纪录，当前显示第&nbsp;&nbsp;<i class="blue current-page" style="font-size: 15px"></i>&nbsp;&nbsp;页</div>
				<ul class="paginList">
 
 </div>   
    
<div class="tip" id="delete">
	
    	<div class="tiptop"><span>删除提示信息</span><a></a></div>        
      <div class="tipinfo">
        <span><img src="<%=basePath%>moban/images/ticon.png" /></span>
        <div class="tipright">
        <p>是否取消该图书的收藏？</p>
        <input type="hidden" name="KUID" id="KUID"/>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>      
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" onclick="deleteensure()"/>&nbsp;
        <input name="" type="button"   class="cancel" value="取消" onclick="deletecancle()"/>
        </div>   
</div>    
  
  <div class="tip" id="add">
	
    	<div class="tiptop"><span>借阅提示信息</span><a></a></div>        
      <div class="tipinfo">
        <span><img src="<%=basePath%>moban/images/ticon.png" /></span>
        <div class="tipright">
        <p>是否借阅该图书？</p>
        <input type="hidden" name="KUID" id="KUID"/>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>      
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" onclick="addensure()"/>&nbsp;
        <input name="" type="button"   class="cancel" value="取消" onclick="daddcancle()"/>
        </div>   
</div>   
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
    
</body>




</html>
