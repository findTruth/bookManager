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
   
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="<%=basePath %>moban/images/t01.png" onclick="location.href='<%=basePath %>jsp/book/add.jsp'"/></span>添加</li>
        <li class="click"><span><img src="<%=basePath %>moban/images/t02.png" onclick="location.href='<%=basePath %>jsp/book/add.jsp'"/></span>修改</li>
        <li class="click"><span><img src="<%=basePath %>moban/images/t03.png" onclick="location.href='<%=basePath %>jsp/book/add.jsp'"/></span>删除</li>    
        <li>
        
        <div class="uew-select">
	        <select class="select3" style="width:110px;height:30px;">
	        <option>请选择图书类别</option>
	        <option>文学类</option>
	        <option>法律类</option>
	        <option>历史类</option>
	        <option>哲学类</option>
	        <option>文化、教育类</option>
	        <option>经济类</option>
	        <option>社会学类</option>
	        <option>心理学类</option>
	        <option>政治类</option>
	        <option>其他</option>	        
	        </select>
       </li>
       <li class="click"><span><img src="<%=basePath %>moban/images/确定按钮1.png"></span>确定</li>
       
        <li><input name="" type="text" class="scinput" placeholder="请输入图书名称"/></li>
        <li class="click"><span><img src="<%=basePath %>moban/images/ico06.png" onclick=""></span>查询</li>          
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
       
</body>
</html>
<script>
function getJSONData(pn, url) {
		// alert(pn);  
		$.getJSON(url, function(data) {
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
					$(".li-tag").eq(j).append("<span><img src='<%=basePath %>"+dataRoot[j].ADDRESS+"'/></span>&nbsp;&nbsp;&nbsp;&nbsp;<h2><a href='#'>"+dataRoot[j].NAME+"</a></h2><p><a href='#'>编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#'>删除</a></p>");
				}
			} else {

				for(var j = startPage, k = 0; j < endPage, k < pageSize; j++, k++) {
					if(j == totalCount) {
						break; // 当遍历到最后一条记录时，跳出循环  
					}
					$(".li-tag").eq(k).append("<span><img src='<%=basePath %>"+dataRoot[j].ADDRESS+"'/></span>&nbsp;&nbsp;&nbsp;&nbsp;<h2><a href='#'>"+dataRoot[j].NAME+"</a></h2><p><a href='#'>编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#'>删除</a></p>");
				}
			}
			$(".page-count").text(totalCount);
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
	getPage("<%=basePath%>book/list.do");

	});

	function flushPage() {
		getPage("<%=basePath%>book/list.do");
	}

</script>