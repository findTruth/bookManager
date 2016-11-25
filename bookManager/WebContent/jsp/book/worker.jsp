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
<title>图书首页</title>
<link href="<%=basePath %>moban/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=basePath %>moban/js/jquery.js"></script>
<script src="<%=basePath %>moban/js/cloud.js" type="text/javascript"></script>
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
        <li>
        <div class="vocation">
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
        </div>
        </div>
       </li>
       <li class="click"><span><img src="<%=basePath %>moban/images/确定按钮1.png"></span>确定</li>
        <ul class="seachfrom">
        <li><input name="" type="text" class="scinput" value="按照图书编号或书名查询"/></li>
        <li class="click"><span><img src="<%=basePath %>moban/images/ico06.png"></span>查询</li>          
         </div>
         </div>
    </ul>
    <div>
    <ul class="imglist">
    <li class="selected">
    <span><img src="<%=basePath %>res/book/三国演义.png" /></span>
   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <h2><a href="#">三国演义</a></h2>
    <p><a href="#">收藏</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">借阅</a></p>
    </li>
     <li>
    <span><img src="<%=basePath %>res/book/红楼梦.png" /></span>
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <h2><a href="#">红楼梦</a></h2>
    <p><a href="#">收藏</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">借阅</a></p>
    </li>
     <li>
    <span><img src="<%=basePath %>res/book/哲学的故事.png" /></span>
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <h2><a href="#">哲学的故事</a></h2>
    <p><a href="#">收藏</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">借阅</a></p>
    </li>
     <li>
    <span><img src="<%=basePath %>res/book/论语.png" /></span>
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <h2><a href="#">论语</a></h2>
    <p><a href="#">收藏</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">借阅</a></p>
    </li>
     <li>
    <span><img src="<%=basePath %>res/book/格律诗词.png" /></span>
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <h2><a href="#">格律诗词</a></h2>
    <p><a href="#">收藏</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">借阅</a></p>
    </li>
     <li>
    <span><img src="<%=basePath %>res/book/计算机应用基础.png" /></span>
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <h2><a href="#">计算机应用基础</a></h2>
    <p><a href="#">收藏</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">借阅</a></p>
    </li>
     <li>
    <span><img src="<%=basePath %>res/book/老人与海.png" /></span>
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <h2><a href="#">老人与海</a></h2>
    <p><a href="#">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">借阅</a></p>
    </li>
     <li>
    <span><img src="<%=basePath %>res/book/毛泽东选集.png" /></span>
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <h2><a href="#">毛泽东选集</a></h2>
    <p><a href="#">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">借阅</a></p>
    </li>
     <li>
    <span><img src="<%=basePath %>res/book/矛盾杂文集.png" /></span>
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <h2><a href="#">矛盾杂文集</a></h2>
    <p><a href="#">收藏</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">借阅</a></p>
    </li>
     <li>
    <span><img src="<%=basePath %>res/book/你的孤独虽败犹荣.png" /></span>
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <h2><a href="#">你的孤独虽败犹荣</a></h2>
    <p><a href="#">收藏</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">借阅</a></p>
    </li>
     <li>
    <span><img src="<%=basePath %>res/book/西游记.png" /></span>
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <h2><a href="#">西游记</a></h2>
    <p><a href="#">收藏</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">借阅</a></p>
    </li>
     <li>
    <span><img src="<%=basePath %>res/book/新视野大学英语.png" /></span>
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <h2><a href="#">新视野英语</a></h2>
    <p><a href="#">收藏</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">借阅</a></p>
    </li>
     <li>
    <span><img src="<%=basePath %>res/book/运筹学.png" /></span>
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <h2><a href="#">运筹学</a></h2>
    <p><a href="#">收藏</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">借阅</a></p>
    </li>
    </ul>
    </div>
        <div class="pagin">
    	<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="javascript:;">1</a></li>
        <li class="paginItem current"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
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
    
    
    
    
    </div>
</body>
</html>