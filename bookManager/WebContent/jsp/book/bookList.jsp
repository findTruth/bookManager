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
<link href="<%=basePath%>moban/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>moban/js/jquery.js"></script>
<script type="text/javascript">
    function getJSONData(pn,url) {  
    // alert(pn);  
    $.getJSON(url, function(data) {  
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

            for (var j = 0; j < totalCount; j++) {  
                $(".tr-tag").eq(j).append("<td class='col1'><input type='checkbox' value='"+parseInt(j + 1)+"'/></td>")  
                .append("<td class='col2'>" + parseInt(j + 1)  
                        + "</td>").append("<td class='col3'>" + dataRoot[j].NAME + "<p>" + dataRoot[j].DATE + "</p>"
                        + "</td>").append("<td class='col4'>" + "图片"  
                        + "</td>").append("<td class='col5'>" + dataRoot[j].PRESS  
                        + "</td>").append("<td class='col6'>" + dataRoot[j].AUTHOR  
                        + "</td>").append("<td class='col7'>" + dataRoot[j].VALUE  
                        + "</td>").append("<td class='col8'>" + dataRoot[j].KINDNO  
                        + "</td>").append("<td class='col9'>" + "修改"  
                        + "</td>");
            }  
        } else {  

            for (var j = startPage, k = 0; j < endPage, k < pageSize; j++, k++) {  
                if( j == totalCount){  
                    break;       // 当遍历到最后一条记录时，跳出循环  
                }  
                 $(".tr-tag").eq(k).append("<td class='col1'><input type='checkbox' value='"+parseInt(j + 1)+"'/></td>")  
                .append("<td class='col2'>" + parseInt(j + 1)  
                        + "</td>").append("<td class='col3'>" + dataRoot[j].NAME + "<p>" + dataRoot[j].DATE + "</p>"
                        + "</td>").append("<td class='col4'>" + "图片"  
                        + "</td>").append("<td class='col5'>" + dataRoot[j].PRESS  
                        + "</td>").append("<td class='col6'>" + dataRoot[j].AUTHOR  
                        + "</td>").append("<td class='col7'>" + dataRoot[j].VALUE  
                        + "</td>").append("<td class='col8'>" + dataRoot[j].KINDNO  
                        + "</td>").append("<td class='col9'>" + "修改"  
                        + "</td>");
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
                  
            })  
}  
function gotoPage(pn,url) {  
    //alert(pn);  
    $(".current-page").text(pn);  
    
    getJSONData(pn,url);  
}  

 $(function(){
    getPage("<%=basePath%>book/list.do"); 
 })
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
    <li><a href="#">图片列表</a></li>
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
    <th style="width:30px">序号</th>
    <th style="width:100px">书名</th>
    <th width="100px;">缩略图</th>
    <th style="width:50px">出版社</th>
    <th style="width:60px">作者</th>
    <th style="width:60px">价格</th>
    <th style="width:60px">类型</th>
    <th style="width:60px">操作</th>
    </tr>
    </thead>
    
    <tbody id="list">
        <!-- <%
        	List<Book> list = (List<Book>)request.getAttribute("list");
        	if(list!=null){
        		int i = 0;
        		for(Book b : list){
        %>
    <tr>
    <td><%=++i %></td>
    <td><a href="#"><%=b.getNAME() %></a><p><%=b.getDATE() %></p></td>
    <td class="imgtd"><img src="<%=basePath %><%=b.getAUTHOR() %>" title="图片" alt="暂无数据"/></td>
    <td><%=b.getPRESS() %></td>
    <td><%=b.getAUTHOR() %></td>
    <td><%=b.getVALUE() %></td>
    <td>已审核</td>
    </tr>
    <%
    		}
    	}else{
    %>
    <tr>
    <td colspan="8">暂无数据</td>
    </tr>
    <%
    	}
    %> -->
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
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="<%=basePath%>moban/images/ticon.png" /></span>
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
    
    
    
    
    </div>
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="<%=basePath%>moban/images/ticon.png" /></span>
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
    
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
    
</body>




</html>
