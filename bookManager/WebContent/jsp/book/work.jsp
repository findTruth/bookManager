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
<title>图书管理</title>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" />
<link href="<%=basePath %>moban/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=basePath %>moban/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery-3.1.0.min.js"></script>
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
    <li><a href="#">图书管理</a></li>
    <li><a href="#">基本内容</a></li>
    </ul>
    </div>
    <div class="rightinfo">
   
    <div class="tools" style="margin-left:25px;">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="<%=basePath %>moban/images/t01.png" onclick="openaddbook()"/></span>添加</li>
        <li class="click"><span><img src="<%=basePath %>moban/images/t02.png" onclick="location.href='<%=basePath %>jsp/book/bookList.jsp'"/></span>修改</li>
        <li class="click"><span><img src="<%=basePath %>moban/images/t03.png" onclick="location.href='<%=basePath %>jsp/book/bookList.jsp'"/></span>删除</li>    
        <li>
        
        <div class="uew-select">
	        <select class="select3" style="width:110px;height:30px;" id="Kindtype">
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
       <li><span onclick="findByKind()"><img src="<%=basePath %>moban/images/确定按钮1.png" ></span>确定</li>
       
        <li><input name="scinput" type="text" class="scinput" placeholder="请输入图书名称或作者"/></li>
        <li><span onclick="findByName()"><img src="<%=basePath %>moban/images/ico06.png" ></span>查询</li>          
         </div>
         </div>
          </div>
        </div>
     
     <div class="imglist" id="list" style="height:500px;width:1000px;margin-left:35px;">
     
     </div>
    <div class="pagin">
	<div class="message">共<i class="blue page-count"></i>条纪录，当前显示第&nbsp;<i class="blue current-page"></i>&nbsp;页</div>
	<ul class="paginList">
		
	</ul>
</div>
 <div class="tip" id="delete">
	
    	<div class="tiptop"><span>删除提示信息</span><a></a></div>        
      <div class="tipinfo">
        <span><img src="<%=basePath%>moban/images/ticon.png" /></span>
        <div class="tipright">
        <p>是否要删除图书？</p>
        <input type="hidden" name="BUID" id="BUID"/>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>      
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" onclick="deleteensure()"/>&nbsp;
        <input name="" type="button"   class="cancel" value="取消" onclick="deletecancle()"/>
        </div>   
</div>    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="<%=basePath %>moban/images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    <div class="tip" id="add" style="height: 400px;">
			<div class="tiptop"><span>图书添加</span>
				<a></a>
			</div>
			
			<form id="form" action="<%=basePath%>book/add.do" method="post" onSubmit="return check();">							
					<div class="tipinfo">
					<table>
					<tr>
						<td>图书类型:</td>
						<td>
						<select id="addlei" name="addlei" class="show-tick form-control" style="width: 230px;">
							<option value="请选择图书类型">请选择图书类型</option>				
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
						</td>
						</tr>
						<tr>
						<td>图书名称:</td>
						<td>
						<input type="text" class="form-control"  name="BNAME" id="BNAME" />
						</td>
					</tr>
					<tr>
						<td>出版社:</td>
						<td>
						<input type="text" class="form-control"  name="BPRESS" id="BPRESS" />
						</td>
					</tr>
					<tr>
						<td>图书作者:</td>
						<td>
						<input type="text" class="form-control"  name="BAUTHOR" id="BAUTHOR" />
						</td>
					</tr>
					<tr>
						<td>图书价格(元):</td>
						<td>
						<input type="text" class="form-control"  name="VALUE" id="VALUE" />
						</td>
					</tr>
					<tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td>图书封面:</td>
						<td>
						<input type="file" name="BADDRESS" id="BADDRESS" style="border: 1px solid white; height: 25px; width: 200px" onblur="checkcb('cb');">
						</td>
					</tr>
					</table>						
				<div class="addbutton" style="margin-top:70px;margin-left:70px">
					<input id="submit" type="submit" class="sure" value="确定"  onclick="addBook()"/>
					<input id="submit" type="button" class="sure" value="返回" onclick="location.href='<%=basePath%>jsp/book/work.jsp'" />
				</div>
</form>
       
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
					$(".li-tag").eq(j).append("<span><img src='<%=basePath %>"+dataRoot[j].ADDRESS+"'/></span><h2><a href='#'>"+dataRoot[j].NAME+"</a></h2><p><a href='#'>编辑</a>&nbsp;&nbsp;<a class='deleteButton' style='cursor:pointer'; name="+dataRoot[j].BUID+">删除</a></p>");
				}
			} else {

				for(var j = startPage, k = 0; j < endPage, k < pageSize; j++, k++) {
					if(j == totalCount) {
						break; // 当遍历到最后一条记录时，跳出循环  
					}
					$(".li-tag").eq(k).append("<span><img src='<%=basePath %>"+dataRoot[j].ADDRESS+"'/></span><h2><a href='#'>"+dataRoot[j].NAME+"</a></h2><p><a href='#'>编辑</a>&nbsp;&nbsp;<a class='deleteButton' style='cursor:pointer'; name="+dataRoot[j].BUID+">删除</a></p>");
				}
			}
			$(".page-count").text(totalCount);
			$(".deleteButton").click(function(){
				var id = $(this).attr("name");
				openDelete(id);
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
	getPage("<%=basePath%>book/list.do");

	});

	function flushPage() {
		getPage("<%=basePath%>book/list.do");
	}
	
	function openDelete(id) {
		$("#BUID").val(id);
		$("#delete").fadeIn(200);
	}
	function openaddbook(){
		$("#addbook").fadeIn(200);
	}
	//新增图书
	function addBook(){
		var jsondata = {
			"KINDNO":$("#addkindno").val(),
			"NAME": $("#addname").val(),
			"PRESS": $("#addpress").val(),
			"AUTHOR": $("#addauthor").val(),
			"VALUE": $("#addvalue").val(),
			"ADDRESS":$("#addaddress").val(),
		};
		$.ajax({
			type: "POST",
			url: "<%=basePath%>book/add.do",
			async: true,
			dataType: 'json',
			data: jsondata,
			success: function(data) {
				alert(data.msg);
				flushPage();
			}
		});
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
 function deleteensure(){
		var BUID = $("input[name='BUID']").val();
		$.ajax({
			type: "POST",
			url: "<%=basePath%>book/deletebookhelp.do?BUID=" + BUID,
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

</script>