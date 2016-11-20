<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<% 
	String Ncname=(String)request.getAttribute("Ncname");
	String Ation1=(String)request.getAttribute("Ation1");
	String Ation2=(String)request.getAttribute("Ation2");
	String Ation3=(String)request.getAttribute("Ation3");
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心</title>
<link href="<%=basePath %>moban/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>moban/js/jquery.js"></script>

<script language="javascript">
	$(function(){
    $('.neirong').css({'position':'absolute','left':($(window).width()-490)/2,'top':80});
	$(window).resize(function(){  
    $('.neirong').css({'position':'absolute','left':($(window).width()-490)/2,'top':80});
	})  
}); 
</script>
<script>
	function sub(){
		if ($("#country").val()!="请选择省份") {
			$("input[name='sheng']").val($("#country").val());
		}else{
			return false;
		}
		if ($("#province").val()!="请选择省份") {
			$("input[name='shi']").val($("#province").val());
		}else{
			return false;
		}
		if ($("#city").val()!="请选择省份") {
			$("input[name='xian']").val($("#city").val());
		}else{
			return false;
		}
		
		$("#Form").submit();
	}
</script>
<script type="text/javascript">
	window.onload=function(){
			if (<%=Ation1!=null%>&&<%=Ation2!=null%>&&<%=Ation3!=null%>) {			
				 var obj1 = document.getElementById("country");
				    for(i=0;i<obj1.length;i++){
				        if(obj1[i].value==<%=Ation1%>)
				            obj1[i].selected = true;
				    }
			}else {
	    		var aslt=document.getElementsByTagName('select')[1];
	   			var aotn=aslt.getElementsByTagName('option')[1];
	   			aslt.onchange=function(){
	      	 	 turnCity();
	   			}					
			}
	};

	function turn(){
	    var provinceList=new Array();
	    provinceList['河北']=["请选择市(区)","石家庄","秦皇岛","唐山","邯郸","张家口"];
		provinceList['山东']=["请选择市(区)","淄博","济南","青岛","烟台","枣庄"];
		provinceList['辽宁']=["请选择市(区)","大连","沈阳","鞍山","抚顺","丹东"];
		provinceList['黑龙江']=["请选择市(区)","哈尔滨","齐齐哈尔","大庆","黑河","牡丹江"];
		provinceList['吉林']=["请选择市(区)","长春","辽源","白城","松原","吉林"];
		provinceList['青海']=["请选择市(区)","海东","玉树","西宁市"];
		provinceList['河南']=["请选择市(区)","洛阳","开封","安阳","郑州"];
		provinceList['江苏']=["请选择市(区)","无锡","常州","南京","苏州","淮安"];
		provinceList['湖北']=["请选择市(区)","武汉","宜昌","襄阳","黄冈","荆州"];
		provinceList['湖南']=["请选择市(区)","长沙","怀化","株洲","湘潭","益阳"];
		provinceList['江西']=["请选择市(区)","南昌","景德镇","上饶","宜春","九江"];
		provinceList['浙江']=["请选择市(区)","杭州","温州","宁波","金华","台州"];
		provinceList['广东']=["请选择市(区)","广州","深圳","珠海","佛山","惠州"];
		provinceList['云南']=["请选择市(区)","昆明","玉溪","丽江","普洱","西双版纳"];
		provinceList['福建']=["请选择市(区)","福州","厦门","三明","泉州","南平"];
		provinceList['海南']=["请选择市(区)","海口","三亚"];
		provinceList['山西']=["请选择市(区)","太原","大同","阳泉","长治","晋城"];
		provinceList['四川']=["请选择市(区)","成都","攀枝花","绵阳","南充","内江"];
		provinceList['陕西']=["请选择市(区)","西安","宝鸡","咸阳","渭南"];
		provinceList['贵州']=["请选择市(区)","同仁","贵阳","遵义","六盘水"];
		provinceList['安徽']=["请选择市(区)","合肥","淮南","马鞍山","安庆","黄山"];
		provinceList['重庆']=["请选择市(区)","重庆市"];
		provinceList['北京']=["请选择市(区)","北京市"];
		provinceList['天津']=["请选择市(区)","天津市"];
		provinceList['上海']=["请选择市(区)","上海市"];
		    var province=document.forms[0].province;//文档中的第一个市份；
		    province.options.length=0;//把province下拉列表的选项清0
		    var index=document.forms[0].country.value; //文档中的第一个省份家；
		    province.options.length=0;
		    for(var j in provinceList[index]){
		        newOption=new Option(provinceList[index][j],provinceList[index][j]);
		        province.options.add(newOption);		
				var city=document.forms[0].city;//文档中的第一个市区；
		        city.options.length=1;//把city下拉列表的选项清0
		    }

	}
	function turnCity(){
	        var cityList=new Array();
			cityList['石家庄']=["请选择县级","市辖区","长安区","正定县","灵寿县","深泽县","平三县"];
	        cityList['秦皇岛']=["请选择县级","卢龙县","北戴河区","抚宁县","三海关区","海港区"];
	        cityList['唐山']=["请选择县级","路南区","路北区","乐亭县","迁西县","玉田县","遵化市"];
	        cityList['邯郸']=["请选择县级","肥乡县","永年县","邱县","鸡泽县","广平县","魏县"];
			cityList['张家口']=["请选择县级","万全县","怀来县","赤城县","崇礼县","宜华县","桥西区"];	
			
			cityList['淄博']=["请选择县级","张店区","博山区","高青县","桓台县","周村区"];
	        cityList['济南']=["请选择县级","平阴县","济阳县","商河县","长清区","历城区","天桥区"];
	        cityList['青岛']=["请选择县级","崂山区","李沧区","平度市","即墨市","胶州市"];
	        cityList['烟台']=["请选择县级","龙口市","莱阳市","莱州市","招远市","海阳市"];
			cityList['枣庄']=["请选择县级","薛城区","市中区","山亭区","滕州去"];	
		
			cityList['大连']=["请选择县级","金州区","长海县","庄河市","中山区","瓦房店市"];
	        cityList['沈阳']=["请选择县级","辽中县","康平县","新民市","于洪区","皇姑区","大东区"];
	        cityList['鞍山']=["请选择县级","铁西区","铁东区","立山区","千山区","台安县","海城市"];
	        cityList['抚顺']=["请选择县级","抚城区","抚顺县","望花区","新抚区","清原","新宾"];
			cityList['丹东']=["请选择县级","元宝区","振兴区","东港市","凤城市"];	
			
			cityList['哈尔滨']=["请选择县级","道里区","南岗区","依兰县","宾县","木兰县","通河县"];
	        cityList['齐齐哈尔']=["请选择县级","龙沙区","建华区","龙江县","依安县","泰来县"];
	        cityList['大庆']=["请选择县级","龙凤区","红岗区","大同区"];
	        cityList['黑河']=["请选择县级","孙吴县","北安市","五大连池市","嫩江县","爱辉区"];
			cityList['牡丹江']=["请选择县级","安定区","阳明区","东宁县","林口县","海林市"];	
			
			cityList['长春']=["请选择县级","南关区","朝阳区","农安县","榆树县","德惠市"];
	        cityList['辽源']=["请选择县级","龙山区","西安区","东丰县","东辽县"];
	        cityList['白城']=["请选择县级","通榆县","大安市","市辖区"];
	        cityList['松原']=["请选择县级","宁江区","长岭县","扶余市"];
			cityList['吉林']=["请选择县级","丰满区","永吉县","蛟河市","舒兰市"];	
			
			cityList['海东']=["请选择县级","乐都区","平安县","民和","互助"];
	        cityList['玉树']=["请选择县级","杂多县","称多县","治多县","玉树市"];
	        cityList['西宁市']=["请选择县级","城东区","城中区","城西区","大通"];
	        
	        cityList['洛阳']=["请选择县级","孟津县","新安县","洛龙区","吉利区"];
			cityList['开封']=["请选择县级","龙亭区","顺河区","鼓楼区","开封县"];	
			cityList['安阳']=["请选择县级","汤阴县","安阳县","林州市","滑县"];
	        cityList['郑州']=["请选择县级","中原区","二七区","管城区","登封市"];
	        
	        cityList['无锡']=["请选择县级","锡山区","惠山区","江阴市","宜兴市"];
	        cityList['常州']=["请选择县级","新北区","武进区","金坛市"];
			cityList['南京']=["请选择县级","玄武区","建邺区","浦口区","江宁区"];	
			cityList['苏州']=["请选择县级","吴江区","常熟市","昆山市","张家港市","太仓市"];
	        cityList['淮安']=["请选择县级","淮阴区","洪泽县","淮安区","涟水县"];
	        
	        cityList['武汉']=["请选择县级","江岸区","江汉区","汉阳区","江夏区","新洲区"];
	        cityList['宜昌']=["请选择县级","西陵区","点军区","远安县","兴三县"];
			cityList['襄阳']=["请选择县级","襄城区","襄州区","谷物城县","保康县"];	
			cityList['黄冈']=["请选择县级","黄州区","红安县","团风县","罗田县"];
	        cityList['荆州']=["请选择县级","京山县","沙洋县","东宝区"];
	        
	        cityList['长沙']=["请选择县级","芙蓉区","天心区","岳麓区","雨花区","开福区","望城区","长沙县","宁乡县"];
	        cityList['怀化']=["请选择县级","鹤城区","中方县","辰溪县","溆浦县","芷江","靖州"];
			cityList['株洲']=["请选择县级","荷塘区","芦淞区","石峰区","天元区","株洲县","炎陵县"];	
			cityList['湘潭']=["请选择县级","雨湖区","岳塘区","湘乡市","韶山市","湘潭县"];
			cityList['益阳']=["请选择县级","资阳区","赫山区","南县","桃江县","安化县","沅江县"];
			
			cityList['南昌']=["请选择县级","东湖区","西湖区","湾里区","南昌县","新建县","安义县"];
	        cityList['景德镇']=["请选择县级","昌江区","珠山区","乐平市"];
			cityList['上饶']=["请选择县级","上饶县","信州区","玉山县","广丰县"];	
			cityList['宜春']=["请选择县级","袁州区","奉新县","上高县","宜丰县"];
			cityList['九江']=["请选择县级","九江县","武宁县","修水县","永修县"];
			
			cityList['杭州']=["请选择县级","江干区","西湖区","滨江区","萧山区"];
	        cityList['温州']=["请选择县级","鹿城区","龙湾区","永嘉县","平阳县"];
	        cityList['宁波']=["请选择县级","江东区","江北区","镇海区","宁海县","慈溪市"];	
			cityList['金华']=["请选择县级","义乌市","兰溪市","东阳市","永康市","金东区"];
	        cityList['台州']=["请选择县级","黄岩区","路桥区","三门县","天台县"];
	        
	        cityList['广州']=["请选择县级","越秀区","海珠区","天河区","白云区","黄浦区"];
	        cityList['深圳']=["请选择县级","福田区","南山区","宝安区","龙岗区","盐田区"];
			cityList['珠海']=["请选择县级","香洲区","斗门区","金湾区"];	
			cityList['佛山']=["请选择县级","禅城区","南海区","顺德区","三水区","高明区"];
	        cityList['惠州']=["请选择县级","惠阳区","博罗县","惠东县","龙门县"];
	        
	        cityList['昆明']=["请选择县级","五华区","盘龙区","官渡区","西山区","东川区"];
	        cityList['玉溪']=["请选择县级","红塔区","江川县","通海县","华宁县"];
			cityList['丽江']=["请选择县级","古城区","玉龙","永胜县"];	
			cityList['普洱']=["请选择县级","思茅区","宁洱","墨江","景东","景谷"];
			cityList['西双版纳']=["请选择县级","景洪市"];
			
			cityList['福州']=["请选择县级","鼓楼区","台江区","仓山区","马尾区","连江县"];
	        cityList['厦门']=["请选择县级","思明区","海沧区","湖里区","同安区","翔安区"];
			cityList['三明']=["请选择县级","梅列区","三元区","明溪县","清流县","宁化县"];	
			cityList['泉州']=["请选择县级","丰泽区","洛江区","安溪县","惠安县"];	        
			cityList['南平']=["请选择县级","延平区","顺昌县","浦城县","光泽县"];
			
	        cityList['海口']=["请选择县级","秀英区","龙华区","琼山区","美兰区"];
	        cityList['三亚']=["请选择县级","海棠区","吉阳区","天涯去区","崖州区"];
	
	        
	        cityList['太原']=["请选择县级","小店区","迎泽区","杏花岭区","阳曲县","古交市"];	        
	        cityList['大同']=["请选择县级","城区","矿区","南郊区","天镇县","广灵县"];
			cityList['阳泉']=["请选择县级","城区","矿区","郊区","平定县"];				
			cityList['长治']=["请选择县级","城区","郊区","长治县","平顺县"];
	        cityList['晋城']=["请选择县级","城区","阳城县","泽州县","高平市"];
	        
	        cityList['成都']=["请选择县级","锦江区","青羊区","金牛区","成华区"];
	        cityList['攀枝花']=["请选择县级","东区","西区","仁和区","米易县"];
			cityList['绵阳']=["请选择县级","游仙区","三台县","安县","平武县"];	
			cityList['南充']=["请选择县级","顺庆区","高坪区","营山县","南部县"];
			cityList['内江']=["请选择县级","市中区","东兴区","资中县"];
			
	        cityList['西安']=["请选择县级","新城区","莲湖区","雁塔区","未央区"];
	        cityList['宝鸡']=["请选择县级","金台区","陈仓区","扶风县","眉县"];
			cityList['咸阳']=["请选择县级","秦都区","渭城区","三原县","永寿县"];	
			cityList['渭南']=["请选择县级","华县","潼关县","合阳县","浦城县"];
	       
	        
	       
	        cityList['同仁']=["请选择县级","碧江区","万山区","江口县","玉屏","印江县"];
			cityList['贵阳']=["请选择县级","南明区","云岩区","花溪区","乌当区","白云区"];	
			cityList['遵义']=["请选择县级","红花岗区","汇川区","遵义县","务川"];
	        cityList['六盘水']=["请选择县级","钟山区","盘县","水城县"];
	        
	        cityList['合肥']=["请选择县级","庐阳区","蜀山区","包河区","长丰县","肥东县","肥西县"];
	        cityList['淮南']=["请选择县级","大通区","谢家集区","田家庵区","八公山区","凤台县"];
			cityList['马鞍山']=["请选择县级","花山区","雨山区","博望区","和县"];	
			cityList['安庆']=["请选择县级","迎江区","大观区","宜秀区","怀宁县","太湖县"];
	        cityList['黄山']=["请选择县级","黄山区","徽州区","休宁县"];
	        
	      
			
			cityList['重庆市']=["请选择县级","江北区","安南区","九龙坡区","大渡口区"];
	       
			
			cityList['北京市']=["请选择县级","朝阳区","东城区","西城区","海淀区"];
	  
			
			cityList['天津市']=["请选择县级","和平区","河东区","河西区"];
	        
			
			
			cityList['上海市']=["请选择县级","黄埔区","徐汇区","虹口区","杨浦区"];

			var city=document.forms[0].city;//文档中的第一个市区；
	        city.options.length=0;//把city下拉列表的选项清0
	        var index=document.forms[0].province.value;
	        city.options.length=0;
	        for(var j in cityList[index]){
      	      newOption=new Option(cityList[index][j],cityList[index][j]);
	            city.options.add(newOption);
	        }

	}
</script> 
<style type="text/css">
input[type="submit"]{background:url("<%=basePath %>/img/rs/buttom.png") no-repeat;font-size:15px;font-weight:600;color:#FFFFFF;border:0;font-family:"Microsoft YaHei","SimHei","SimSun";text-shadow:0 -1px 0 #535353;margin:5px 5px 0 0;padding:0 0 3px 0;display:block;width:106px;height:35px;text-align:center;font-weight:bold;line-height:33px;text-indent:20px;}
	#da{
		font-size: 20px;
	}
	.text{
		width: 300px;
		height: 40px;
	}
</style>

</head>


<body style="background:#edf6fa;">
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="main.jsp">首页</a></li>
    <li><a href="#">个人中心</a></li>
    </ul>
    </div></br>
  <form id="Form" action="<%=basePath %>/user/userGeRen2.do" method="post">
 <div class='neirong'>
 	<div id='da'>昵    称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="nicheng" class='text' value="<%=Ncname%>"></div></br>
 	<div id='da'>地  区：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<select  id="country" name="country" onchange="turn()" style='width:100px;height: 30px;'>
<option value="请选择省份" selected="selected">请选择省份</option>
<option value="河北">河北</option>
<option value="山东">山东</option>
<option value="辽宁">辽宁</option>
<option value="黑龙江">黑龙江</option>
<option value="吉林">吉林</option>
<option value="青海">青海</option>
<option value="河南">河南</option>
<option value="江苏">江苏</option>
<option value="湖北">湖北</option>
<option value="湖南">湖南</option>
<option value="江西">江西</option>
<option value="浙江">浙江</option>
<option value="广东">广东</option>
<option value="云南">云南</option>
<option value="福建">福建</option>
<option value="海南">海南</option>
<option value="山西">山西</option>
<option value="四川">四川</option>
<option value="陕西">陕西</option>
<option value="贵州">贵州</option>
<option value="安徽">安徽</option>
<option value="重庆">重庆</option>
<option value="北京">北京</option>
<option value="天津">天津</option>
<option value="上海">上海</option>
</select>
<select  id="province" name="province" style='width:100px;height: 30px;'>
<option value="0" selected="selected">请选择市(区)</option>
</select>
<select id="city" name="city" style='width:100px;height: 30px;'>
<option value="0" selected="selected">请选择县级</option>
</select>
<input type="hidden" name="sheng" value=""/>
<input type="hidden" name="shi" value=""/>
<input type="hidden" name="xian" value=""/>
</div></br>
 	<div class='xingbie' id='da'>
 			<label id='da'>性    别</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input class="td choose" type="radio"  name="sex" value="1" >
			<label class="td label"  id='da'>男</label>&nbsp;&nbsp;
			<input class="td choose" type="radio"  name="sex" value="2" >
			<label class="td label"  id='da'>女</label>&nbsp;&nbsp;
			<input class="td choose" type="radio"  name="sex" value="0"  checked="checked">
			<label class="td label"  id='da'>保密</label>
 	</div></br>
 	<div id='da'>原始密码：&nbsp;<input type="password" name="yuanmima" class='text'></div></br>
 	<div id='da'>新密码：&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="xinmima" class='text'></div></br>
   	<div><center><input type="button" value="确认修改" onclick="sub()"></center></div>
 	</div>
   </form>


</body>
</html>
