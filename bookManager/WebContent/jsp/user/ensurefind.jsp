<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>确认密码</title>
<link href="<%=basePath %>css/Rstyle.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src="<%=basePath %>js/jquery-1.4.4.min.js"></script>
<script language='javascript' src="<%=basePath %>js/userreg.js"></script>

</head>
<body>	
<div class='body_main'> 
 <div class='index_box' style='margin-top:20px;'>
	<div class='box_main'>
		<div id="register" class="register">
		<form id="form" action="<%=basePath %>user/ensurefind.do" method="post" onSubmit="return check();">
		 <div id="form_submit" class="form_submit">
            <div class="fieldset">
				<div class="field-group">
                <label class="required title">新密码</label>
                <span class="control-group" id="password1_input">
                <div class="input_add_long_background">
                  <input class="register_input" type="password" id="password1" name="password1" maxLength="20" value="" onblur="checkPwd1(this.value);" onkeyup="checkPassword();"/>
                </div>
                </span>
                <label class="tips">请使用6~20个英文字母（区分大小写）、符号或数字</label>
              </div>        
        <div id="field-group" class="field-group"
            style="display: none;">
            <span class="trigger">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码强度： </span>
            <span class="status-bar" style="text-indent: 0px;">
            <span style="line-height: 5px;">  </span> 
            </span>
            <span class="status-result"></span>
        </div>      
              <div class="field-group">
                <label class="required title">确认密码</label>
                <span class="control-group" id="password1_input2">
                <div class="input_add_long_background">
                  <input class="register_input" type="password" id="password2" name="password2" maxLength="20" value="" onblur="checkPwd2(this.value);" />
                </div>
                </span>
                <label class="tips">两次输入的密码必须一样</label>
              </div>
             </div>
             <div id="div_submit" class="div_submit">
             <div class='div_submit_button' id="button_button_1"><input id="submit" type="submit" value="确认" class='button_button_1'></div>
          	<div class='div_submit_button' id='button_button_3'> <input id="submit" type="button" value="返回" class='button_button_1' onclick="location.href='<%=basePath %>jsp/user/find.jsp'"></div>
             </div>
             </form>
            </div>
           </div> 
        </div>  
       </div> 
      </div>   
 <script type="text/javascript">  
 function check() {
		hideAllTooltips();
		var ckh_result = true;
		var pwd1=$("input[name='password1']").val();
		var pwd2=$("input[name='password2']").val();
	  if ($('#password1').val() == '') {
		showTooltips('password1_input','密码不能为空',4000);
		ckh_result = false;
	  }
	  if ($('#password2').val() == '') {
			showTooltips('password1_input2','密码没有确认',4000);
			ckh_result = false;
		  }
	  if (!(pwd1==pwd2)) {
		  showTooltips('password1_input2','密码没有确认',4000);
		  ckh_result = false;
	}
	  return ckh_result;
	}
 
 function checkPwd1(pwd1) {
		if (pwd1.search(/^.{6,20}$/) == -1) {
			showTooltips('password1_input','密码为空或位数太少',2000);
		}else {
			hideTooltips('password1_input');
		}
	}	
	function checkPwd2(pwd2) {
		var pwd1=$("input[name='password1']").val();
		if (pwd2==pwd1) {
			hideTooltips('password1_input');
		}else {
			showTooltips('password1_input2','两次输入的密码不一样',2000);
		}
	}
 
  //密码强弱
function checkPassword(){
    var pwd = $("#password1").val();
    gPasswdStatus(pwd,'field-group');
    }
function gPasswdStatus(value,id){
    var status = $("#"+id);
    var result = $("#"+id).find(".status-result")[0];
    var bar = $("#"+id).find(".status-bar span");
    if (value === "") {
        status.css("display","none");
    } else {
        var score = gCheckPassword(value);
        bar.css("width",score + "%");
        var resultDesp = gGetResultDesp(score);
        result.innerHTML = resultDesp;
        status.css("display","block");
    }
}
/**
 * 检验密码强度并返回得分
 * 
 * @param {}
 *            password
 * @return {Number}
 */
function gCheckPassword(password) {
    var _score = 0;
    if (!password) {
        return 0
    }
    if (password.length <= 4) {
        _score += 5
    } else {
        if (password.length >= 5 && password.length <= 7) {
            _score += 10
        } else {
            if (password.length >= 8) {
                _score += 25
            }
        }
    }
    var _UpperCount = (password.match(/[A-Z]/g) || []).length;
    var _LowerCount = (password.match(/[a-z]/g) || []).length;
    var _LowerUpperCount = _UpperCount + _LowerCount;
    if (_UpperCount && _LowerCount) {
        _score += 20
    } else {
        if (_UpperCount || _LowerCount) {
            _score += 10
        }
    }
    var _NumberCount = (password.match(/[\d]/g, "") || []).length;
    if (_NumberCount > 0 && _NumberCount <= 2) {
        _score += 10
    } else {
        if (_NumberCount >= 3) {
            _score += 20
        }
    }
    var _CharacterCount = (password.match(/[!@#$%^&*?_\.\-~]/g) || []).length;
    if (_CharacterCount == 1) {
        _score += 10
    } else {
        if (_CharacterCount > 1) {
            _score += 25
        }
    }
    if (_NumberCount && (_UpperCount && _LowerCount)
            && _CharacterCount) {
        _score += 5
    } else {
        if (_NumberCount && _LowerUpperCount && _CharacterCount) {
            _score += 3
        } else {
            if (_NumberCount && _LowerUpperCount) {
                _score += 2
            }
        }
    }
    return _score
}
 /**
  * 根据密码强度得分返回密码强弱度中文提示
  * 
  * @param {}
  *            score
  * @return {String}
  */
 function gGetResultDesp(score) {
    if (score <= 5) {
        return "\u592a\u77ed"
    } else {
    if (score > 5 && score < 20) {
        return "\u5f31"
        } else {
        if (score >= 20 && score < 60) {
            return "\u4e2d"
        } else {
            if (score >= 60) {
                return "\u5f3a"
            } else {
                return ""
            }
            }
        }
    }
 }
 </script> 
 
     <div style="position:absolute; width:100%; height:100%; z-index:-2; left:0; top:0;">      
<img src="<%=basePath %>img/rs/body_bg.png" height="100%" width="100%" style="left:0; top:0;">      
</div> 
</body>
</html>