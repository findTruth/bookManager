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
	$.post(url, function(data) {
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
				var status = "";
				var handle="";
				if (dataRoot[j].STATUS==0) {
					status="未归还";
					handle="还书";
				}else if (dataRoot[j].STATUS==1) {
					status="归还";
				}else {
					status="预定";
				}
				var overtime="";
				if (dataRoot[j].OVERTIME==null) {
					overtime="无数据";
				}else {
					overtime=dataRoot[j].OVERTIME;
				}	
				$(".tr-tag").eq(j).append("<td class='col1'><input type='checkbox' value='" + parseInt(j + 1) + "'/></td>")
					.append("<td class='col2'>" + parseInt(j + 1) +
						"</td>").append("<td class='col3'>" + dataRoot[j].Bname +
						"</td>").append("<td class='col4'>" + dataRoot[j].STARTTIME +
						"</td>").append("<td class='col5'>" + overtime +
						"</td>").append("<td class='col6'>" + status +
						"</td>").append("<td class='col7'>" + "<a class='returnButton' style='cursor:pointer'; name="+dataRoot[j].RUID+">"+handle+"</a>" +
						"</td>");
			}
		} else {
			for(var j = startPage, k = 0; j < endPage, k < pageSize; j++, k++) {
				if(j == totalCount) {
					break; // 当遍历到最后一条记录时，跳出循环  
				}
				var status = "";
				var handle="";
				if (dataRoot[j].STATUS==0) {
					status="未归还";
					handle="还书";
				}else if (dataRoot[j].STATUS==1) {
					status="归还";
				}else {
					status="预定";
				}
				var overtime="";
				if (dataRoot[j].OVERTIME==null) {
					overtime="无数据";
				}else {
					overtime=dataRoot[j].OVERTIME;
				}
				
				$(".tr-tag").eq(k).append("<td class='col1'><input type='checkbox' value='" + parseInt(j + 1) + "'/></td>")
					.append("<td class='col2'>" + parseInt(j + 1) +
					"</td>").append("<td class='col3'>" + dataRoot[j].Bname +
					"</td>").append("<td class='col4'>" + dataRoot[j].STARTTIME +
					"</td>").append("<td class='col5'>" + overtime +
					"</td>").append("<td class='col6'>" + status +
					"</td>").append("<td class='col7'>" + "<a class='returnButton' style='cursor:pointer'; name="+dataRoot[j].RUID+">"+handle+"</a>" +
					"</td>");
			}
		}
		$(".page-count").text(totalCount);
		$(".returnButton").click(function(){			
			var id = $(this).attr("name");
			var tr_tag = $(this).parent().parent();
			var bname = tr_tag.children('td.col3').html();
			openHuanshuTop(id,bname);
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
	getPage("<%=basePath%>employee/HuanShu.do");
});

function flushPage() {
	getPage("<%=basePath%>employee/HuanShu.do");
}

function openHuanshuTop(id,name){
	$("#RUID").val(id);
	$("#returnBname").html('是否归还《'+name+'》?');
	$("#return").fadeIn(200);
}
function ensure(){
	var RUID = $("#RUID").val();
	$.ajax({
		type:'post',
	    dataType:'json',
	    async: true,
	    url:"<%=basePath%>employee/HuanShuAction.do?RUID="+RUID,
	    success: function(data) {
			alert(data.msg);
			flushPage();
		}
	});
}
function findByName(){
	var bname = $("input[name='Search']").val();
	getPage("<%=basePath%>employee/HuanShu.do?type=2&keyword="+bname);
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
    <li><a href="#">归还业务</a></li>
    </ul>
    </div>
    
    <div class="rightinfo"> 
     <div class="tools">
    	<center style="font-size: 15px;">搜索:&nbsp;&nbsp;<input type="text" value="" name="Search" placeholder="请输入书名" style="width: 200px;height: 40px"/>&nbsp;&nbsp;<input type="button" value="搜索" class="Search" style="background:url(../moban/images/buttonbg.png) repeat-x;width:96px; height:35px;" onclick="findByName()"/></center>
    </div></br>   
    <table class="imgtable">
    
    <thead>
    <tr>
    <th><input type="checkbox" name="" value="全选"></th>
    <th>序号</th>
    <th>书名</th>
    <th>借书开始时间</th>
    <th>借书归还时间</th>
    <th>书籍状态</th>
    <th style="width:200px">操作</th>
    </tr>
    </thead>
    
    <tbody id="list">
       
    </tbody>
    
    </table>
    
    

<div class="pagin">
				<div class="message" style="font-size: 15px">共&nbsp;&nbsp;<i class="blue page-count" style="font-size: 15px"></i>&nbsp;&nbsp;条纪录，当前显示第&nbsp;&nbsp;<i class="blue current-page" style="font-size: 15px"></i>&nbsp;&nbsp;页</div>
				<ul class="paginList"></ul>
</div>
 
 <div class="tip" id="return">
	
    	<div class="tiptop"><span>还书提示信息</span><a></a></div>        
      <div class="tipinfo">
        <span><img src="<%=basePath%>moban/images/ticon.png" /></span>
        <div class="tipright">
        <p id="returnBname"></p>
        <input type="hidden" name="RUID" id="RUID"/>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>      
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" onclick="ensure()"/>&nbsp;
        <input name="" type="button"   class="cancel" value="取消"/>
        </div>   
</div>     
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
    
</body>




</html>
