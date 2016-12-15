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
<title>图书列表</title>
<link href="<%=basePath%>moban/css/style.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" />



<script type="text/javascript" src="<%=basePath%>moban/js/jquery.js"></script>
<script type="text/javascript">
    function getJSONData(pn,url) {  
    	
    // alert(pn);  
    $.post(url, function(data) {  
        var totalCount = data.totalCount; // 总记录数  
        var pageSize = 10; // 每页显示几条记录  
        var pageTotal = Math.ceil(totalCount / pageSize); // 总页数  
        var startPage = pageSize * (pn - 1);  
        var endPage = startPage + pageSize - 1;  
        var $tbody = $("#list");
        $tbody.empty();  
        for (var i = 0; i < pageSize; i++) {  
            $tbody.append('<tr class="tr-tag"></tr>');  
        }  
        var dataRoot = data.jsonRoot;  
        if (pageTotal == 1) {     // 当只有一页时  
        	var kind = "";
        	if(dataRoot[j].KINDNO==1){
        		kind = "文学类";
        	}else if(dataRoot[j].KINDNO==2){
        		kind = "历史类";
        	}else if(dataRoot[j].KINDNO==3){
        		kind = "哲学类";
        	}else if(dataRoot[j].KINDNO==4){
        		kind = "文化、教育类";
        	}else if(dataRoot[j].KINDNO==5){
        		kind = "艺术、美学类";
        	}else if(dataRoot[j].KINDNO==6){
        		kind = "经济类";
        	}else if(dataRoot[j].KINDNO==6){
        		kind = "社会学类";
        	}else if(dataRoot[j].KINDNO==6){
        		kind = "心理学类";
        	}else if(dataRoot[j].KINDNO==6){
        		kind = "政治类";
        	}else if(dataRoot[j].KINDNO==6){
        		kind = "法律类";
        	}else if(dataRoot[j].KINDNO==6){
        		kind = "其他";
        	}
            for (var j = 0; j < totalCount; j++) {  
                $(".tr-tag").eq(j).append("<td class='col1'><input type='checkbox' value='"+parseInt(j + 1)+"'/></td>")  
                .append("<td class='col2'>" + parseInt(j + 1)  
                        + "</td>").append("<td class='col3'>" + dataRoot[j].NAME + "<p>" + dataRoot[j].DATE + "</p>"
                        + "</td>").append("<td class='col4'>" + "<img src='<%=basePath %>"+dataRoot[j].PICTURE+"'>" 
                        + "</td>").append("<td class='col5'>" + dataRoot[j].PRESS  
                        + "</td>").append("<td class='col6'>" + dataRoot[j].AUTHOR  
                        + "</td>").append("<td class='col7'>" + dataRoot[j].VALUE  
                        + "</td>").append("<td class='col8'>" +   kind
                        + "</td>").append("<td class='col9'>" + "<a class='updateButton' style='cursor:pointer'; name="+dataRoot[j].BUID+">修改</a>"  
                        + "</td>");
            }  
        } else {  

            for (var j = startPage, k = 0; j < endPage, k < pageSize; j++, k++) {  
                if( j == totalCount){  
                    break;       // 当遍历到最后一条记录时，跳出循环  
                }  
                var kind = "";
	        	if(dataRoot[j].KINDNO==1){
	        		kind = "文学类";
	        	}else if(dataRoot[j].KINDNO==2){
	        		kind = "历史类";
	        	}else if(dataRoot[j].KINDNO==3){
	        		kind = "哲学类";
	        	}else if(dataRoot[j].KINDNO==4){
	        		kind = "文化、教育类";
	        	}else if(dataRoot[j].KINDNO==5){
	        		kind = "艺术、美学类";
	        	}else if(dataRoot[j].KINDNO==6){
	        		kind = "经济类";
	        	}else if(dataRoot[j].KINDNO==6){
	        		kind = "社会学类";
	        	}else if(dataRoot[j].KINDNO==6){
	        		kind = "心理学类";
	        	}else if(dataRoot[j].KINDNO==6){
	        		kind = "政治类";
	        	}else if(dataRoot[j].KINDNO==6){
	        		kind = "法律类";
	        	}else if(dataRoot[j].KINDNO==6){
	        		kind = "其他";
	        	}
                 $(".tr-tag").eq(k).append("<td class='col1'><input type='checkbox' value='"+parseInt(j + 1)+"'/></td>")  
                .append("<td class='col2'>" + parseInt(j + 1)  
                        + "</td>").append("<td class='col3'>" + dataRoot[j].NAME + "<p>" + dataRoot[j].DATE + "</p>"
                        + "</td>").append("<td class='col4'>" + "<img src='<%=basePath %>"+dataRoot[j].PICTURE+"'>"
                        + "</td>").append("<td class='col5'>" + dataRoot[j].PRESS  
                        + "</td>").append("<td class='col6'>" + dataRoot[j].AUTHOR  
                        + "</td>").append("<td class='col7'>" + dataRoot[j].VALUE  
                        + "</td>").append("<td class='col8'>" + kind 
                        + "</td>").append("<td class='col9'>" + "<a class='updateButton' style='cursor:pointer'; name="+dataRoot[j].BUID+">修改</a>"  
                        + "</td>");
            }  
        }  
        $(".page-count").text(totalCount); 
		$(".updateButton").click(function(){
			var id = $(this).attr("name");
			openUpdate(id);
			
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
                for (var i = 1; i <= pageTotal; i++) {
                    if (i == 1) {
                        $(".paginList").append("<li class='paginItem'><a id='firstPage' name='"+i+"' class='paginItemb'>"+i+"</a></li>");
                    }else if(i == pageTotal){
                        $(".paginList").append("<li class='paginItem'><a id='lastPage' name='"+i+"' class='paginItema'>"+i+"</a></li>");
                    }else{
                        $(".paginList").append("<li class='paginItem'><a name='"+i+"' class='paginItema'>"+i+"</a></li>");
                    }
                    
                }
                $(".paginList").append("<li class='paginItem'><a id='next'><span class='pagenxt'></span></a></li>");
                $("#next").click(function() {  
                            if (pn == pageTotal) {  
                                alert("后面没有了");  
                                pn = pageTotal;  
                            } else {  
                                pn++;  
                                $(".paginItem").attr("class","paginItem");
                                $(".paginItem").eq(pn).addClass("current");
                                gotoPage(pn,url);  
                            }  
                        });  
                $("#prev").click(function() {  
                            if (pn == 1) {  
                                alert("前面没有了");  
                                pn = 1;  
                            } else {  
                                pn--;  
                                $(".paginItem").attr("class","paginItem");
                                $(".paginItem").eq(pn).addClass("current");
                                gotoPage(pn,url);  
                            }  
                        })  
                $("#firstPage").click(function() {  
                            pn = 1;  
                            $(".paginItem").attr("class","paginItem");
                            $(".paginItem").eq(pn).addClass("current");
                            gotoPage(pn,url);  
                        });  
                $("#lastPage").click(function() {  
                            pn = pageTotal;  
                            gotoPage(pn,url);  
                        });  
                $("#page-jump").click(function(){  
                    if($(".page-num").val()  <= pageTotal && $(".page-num").val() != ''){  
                        pn = $(".page-num").val();  
                        gotoPage(pn,url);  
                    }else{  
                        alert("您输入的页码有误！");  
                        $(".page-num").val('').focus();  
                    }  
                });
                $(".paginItema").click(function(){
                    var pn = $(this).attr('name');
                    $(".paginItem").attr("class","paginItem");
                    $(".paginItem").eq(pn).addClass("current");
                    gotoPage(pn,url);  
                });
                $("#firstPage").trigger("click");  
                  
            },"json")  
}  
function gotoPage(pn,url) {  
    //alert(pn);  
    $(".current-page").text(pn);  
    
    getJSONData(pn,url);  
}  

 $(function(){
    getPage("<%=basePath%>book/list.do"); 
    
 });
 
 function flushPage() {
		getPage("<%=basePath%>book/list.do");
	}

//通过id查找员工信息
	function findById(id) {
		var data1 = "";
		$.ajax({
			type: "POST",
			url: "<%=basePath%>book/findById.do?BUID=" + id,
			async: false,
			dataType: 'json',
			success: function(data) {
				 data1 = data;
			}
		});
		return data1;
	}

	//跳转修改界面
	function openUpdate(id) {
//		var id = $(this).attr("name");
		var data = findById(id);

		$("#updatebuid").val(id);
		$("#updatename").val(data.NAME);
		$("#updatepress").val(data.PRESS);
		$("#updateauthor").val(data.AUTHOR);
		$("#updatevalue").val(data.VALUE);
		$("#updatekindno").val(data.KINDNO);
		$("updatestatus").val(data.STATUS);
		$("#updatedate").val(data.DATE);
		$("#update").fadeIn(200);
	}
	//大量修改
	function updateFunction(){
		var BUID = $("#updatebuid").val();
		var NAME = $("#updatename").val();
		var PRESS = $("#updatepress").val();
		var AUTHOR = $("#updateauthor").val();
		var VALUE = $("#updatevalue").val();
		var KINDNO = $("#updatekindno").val();
		var STATUS = $("#updatestatus").val();
		var DATE = $("#updatedate").val();
		var jsondata = {"BUID":BUID,"NAME":NAME,"PRESS":PRESS,"AUTHOR":AUTHOR,"VALUE":VALUE,"KINDNO":KINDNO,"STATUS":STATUS,"DATE":DATE};
		$.ajax({
			type: "POST",
			url: "<%=basePath%>manager/changeBook.do",
			async: true,
			dataType: 'json',
			data:jsondata,
			success: function(data) {
				alert(data.msg);
				flushPage();
			}
		});
	}
</script>
<script type="text/javascript">
    // $(document).ready(function () { $("#loadgif").hide();});
    // $(".wait").click(function () { $("#loadgif").show();});
</script>
<script language="javascript">
 $(function(){	
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
    
 })	
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
			<li><a href="#">书籍列表</a></li>
		</ul>
	</div>

	<div class="rightinfo">

		<div class="tools">

			<ul class="toolbar">
				<li class="click"><span><img
						src="<%=basePath%>moban/images/t01.png"
						onclick="location.href='<%=basePath%>jsp/book/add.jsp'" /></span>添加</li>
				<li><span><img src="<%=basePath%>moban/images/t03.png" /></span>删除</li>
			</ul>

		</div>


		<table class="imgtable">

			<thead>
				<tr>
					<th style="width: 30px"><input type="checkbox" name=""
						value="全选"></th>
					<th style="width: 30px">序号</th>
					<th style="width: 100px">书名</th>
					<th width="100px;">缩略图</th>
					<th style="width: 50px">出版社</th>
					<th style="width: 60px">作者</th>
					<th style="width: 60px">价格(元)</th>
					<th style="width: 60px">类型</th>
					<th style="width: 60px">操作</th>
				</tr>
			</thead>

			<tbody id="list">
				
			</tbody>

		</table>

		<!-- <div id="loadgif" style="width:66px;height:66px;position:absolute;top:50%;left:50%;">
　　  <img  alt="加载中..." src="<%=basePath%>res/sys/wait.gif"/>
    </div> -->




		<div class="pagin">
			<div class="message">
				共<i class="blue page-count"></i>条纪录，当前显示第&nbsp;<i
					class="blue current-page"></i>&nbsp;页
			</div>
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
		



		<div class="tip" id="update" style="height: 400px;">
			<div class="tiptop">
				<span>图书信息修改</span> <a></a>
			</div>
			<div class="tipinfo">
				<table>
					<tr>
						<td>图书编号</td>
						<td><input type="text" class="form-control"
							readonly="readonly" name="updatebuid" id="updatebuid" /></td>
					</tr>
					<tr>
						<td>图书名称</td>
						<td><input type="text" class="form-control" name="updatename"
							id="updatename" /></td>
					</tr>
					<tr>
						<td>出版社</td>
						<td><input type="text" class="form-control"
							name="updatepress" id="updatepress" /></td>
					</tr>
					<tr>
						<td>作者</td>
						<td><input type="text" class="form-control"
							name="updateauthor" id="updateauthor" /></td>
					</tr>
					<tr>
						<td>价格(元)</td>
						<td><input type="text" class="form-control"
							name="updatevalue" id="updatevalue" /></td>
					</tr>
					<tr>
						<td>类型</td>
						<td><select name="updatekindno" id="updatekindno" class="show-tick form-control" style="width: 230px;">
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

						</select></td>
					</tr>
				</table>
			</div>
			<div class="tipbtn" style="margin-top: 200px;">
				<input name="" type="button" class="sure" onclick="updateFunction()"
					value="确定" />&nbsp; <input name="" type="button" class="cancel"
					value="取消" />
			</div>

		</div>
		
		
		<div class="tip" id="add" style="height: 400px;">
			<div class="tiptop">
				<span>图书信息新增</span> <a></a>
			</div>
			<div class="tipinfo">
				<table>
					
					<tr>
						<td>图书名称</td>
						<td><input type="text" class="form-control" name="addname"
							id="addname" /></td>
					</tr>
					<tr>
						<td>出版社</td>
						<td><input type="text" class="form-control"
							name="addpress" id="addpress" /></td>
					</tr>
					<tr>
						<td>作者</td>
						<td><input type="text" class="form-control"
							name="addauthor" id="addauthor" /></td>
					</tr>
					<tr>
						<td>价格(元)</td>
						<td><input type="text" class="form-control"
							name="addvalue" id="addvalue" /></td>
					</tr>
					<tr>
						<td>类型</td>
						<td><input type="text" class="form-control"
							name="addkindno" id="addkindno" /></td>
					</tr>
					<tr><td colspan="2"><p id="addmsg"></p></td></tr>
				</table>
			</div>
			<div class="tipbtn" style="margin-top: 200px;">
				<input name="" type="button" class="sure" onclick="updateFunction()"
					value="确定" />&nbsp; <input name="" type="button" class="cancel"
					value="取消" />
			</div>

		</div>


		

	<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>

</body>




</html>
