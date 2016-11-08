<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=basePath %>css/Rstyle.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src="<%=basePath %>js/jquery-1.4.4.min.js"></script>
<script language='javascript' src="<%=basePath %>js/userreg.js"></script>

</head>
<body>
<div class='body_main'> 
  <!-- start main content -->
  <div class='index_box' style='margin-top:20px;'>
    <div style="position:fixed;color:red;margin:70px 0 0 450px;font-size:10px;Z-index:100;display:block;" id="hint"></div>
    <div class='box_title'>
      <div class='text_content'>
        <h1>欢迎加入图书馆</h1>
      </div>
    </div>
    <div class='box_main'>
    <div class="line">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=basePath %>img/rs/注册1.jpg"   width="50" height="50"/></div>
    <div class="line" id='line1'>欢迎注册</div>
      <div id="register" class="register">
        <form id="form" action="<%=basePath %>user/regist.do" method="post" onSubmit="return check();">
          <div id="form_submit" class="form_submit">
            <div class="fieldset">
              <div class="field-group">
                <label class="required title">手机号</label>
                <span class="control-group" id="mobile_input">
                <div class="input_add_long_background">
                  <input class="register_input" type="text" id="mobile" name="mobile" maxLength="11" value="" onblur="__changeUserName('mobile');">
                </div>
                </span>
                <label class="tips">您将使用您的手机号码登录，请输入正确的手机号码，且第一位数必须为1</label>
              </div>
              <div class="field-group">
                <label class="required title">邮箱</label>
                <span class="control-group" id="email_input">
                <div class="input_add_long_background">
                  <input class="register_input" type="text" id="email" name="email" maxLength="50" value="" onblur="__changeUserName('email');">
                </div>
                </span>
                <label class="tips">请输入您常用的邮箱,方便您找回密码</label>
              </div>
              <div class="field-group">
                <label class="required title">设置密码</label>
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
              <div class="field-group">
                <label class="required title"><s>*</s>问题一</label>
                 <span class="control-group" id="question_input"></span>
                <span class="control-group" id="email_input">
                <div>
                  <select name="question1" id="question1">
					<option selected="selected" value="0">请选择密保问题</option>
					<option value="您母亲的姓名是？">您母亲的姓名是？</option>
					<option value="您母亲的生日是？">您母亲的生日是？</option>
					<option value="您父亲的姓名是?">您父亲的姓名是?</option>
					<option value="您父亲的生日是？">您父亲的生日是？</option>
					<option value="您配偶的姓名是？">您配偶的姓名是？</option>
					<option value="您配偶的生日是？">您配偶的生日是？</option>
					<option value="您的学号（或工号）是？">您的学号（或工号）是？</option>
					<option value="您高中班主任的名字是？">您高中班主任的名字是？</option>
					<option value="您小学班主任的名字是？">您小学班主任的名字是？</option>
					<option value="您初中班主任的名字是？">您初中班主任的名字是？</option>
					<option value="您最熟悉的童年好友名字是？">您最熟悉的童年好友名字是？</option>
					<option value="您家在哪？">您家在哪？</option>
					<option value="对您影响最大的人名字是？">对您影响最大的人名字是？</option>								
				</select>
                </div>
                </span>
                <label class="tips">该密保问题是为了帮助您找回密码</label>
			</div>
			<div class="field-group">
                <label class="required title"><s>*</s>答案</label>
                <span class="control-group" id="answer_input">
                <div class="input_add_long_background">
                  <input class="register_input" type="text" id="answer" name="answer" value="" onblur="checkAnswer(this.value)">
                </div>
                </span>
              </div>
             </div>
            </div>
          
          <div id="div_submit" class="div_submit">
          <div id="Agreement">
          	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" checked="checked" name="verify"/><font size="5">我已经仔细阅读并接收<a href="#">《图书馆读书协议》</a></font> 
          <span class="control-group" id="checkbox_input">
          </div></br>
          	<div class='div_submit_button'></div>
            <div class='div_submit_button' id="button_button_1"><input id="submit" type="submit" value="注册" class='button_button_1'></div>
            <div class='div_submit_button' id='button_button_2'> <input id="submit" type="reset" value="重置" class='button_button_1'></div>
          	<div class='div_submit_button' id='button_button_3'> <input id="submit" type="button" value="返回" class='button_button_1' onclick="location.href='http://www.baidu.com'"></div>
          </div>
        </form>
         </div>
      </div>
<script type="text/javascript">
function __changeUserName(of){
  var username=$('#'+of).val();
  if(of=='email'){
	  if (username.search(/^[\w\.+-]+@[\w\.+-]+$/) == -1) {
			showTooltips('email_input','请输入正确的Email地址',2000);
			return;
	}					
  }
  else{
	  if( !isMobilePhone(username)) {
		  showTooltips('mobile_input','请输入正确的手机号码',2000);
		  return;
	  }
  }
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
function checkEmail(email) {
	if (email.search(/^.+@.+$/) == -1) {
		showTooltips('email_input','邮箱格式不正确',2000);
	}else {
		hideTooltips('email_input');
	}
}
function checkAnswer(answer) {
	if (answer=='') {
		showTooltips('answer_input','密保问题不能为空',2000);
	}else {
		hideTooltips('answer_input');
	}
}	
function checkAuthCode(authcode) {
	if (authcode == '' || authcode.length != 6) {
		showTooltips('code_input','验证码不正确',2000);
	}else {
		hideTooltips('code_input');
 }     
}

function check() {
	hideAllTooltips();
	var ckh_result = true;
	if ($('#email').val() == '') {
	showTooltips('email_input','邮箱不能为空',4000);
	ckh_result = false;
  }
  if ($('#password1').val() == '') {
	showTooltips('password1_input','密码不能为空',4000);
	ckh_result = false;
  }
  if ($('#password2').val() == '') {
		showTooltips('password1_input2','密码没有确认',4000);
		ckh_result = false;
	  }
  if($('#mobile').val()=='' || !isMobilePhone($('#mobile').val())) {            
	  showTooltips('mobile_input','手机号码不正确',4000);
	  ckh_result = false;
  }
  if (!$("input[name='verify']").is(':checked')){	  
	showTooltips('checkbox_input','对不起，您不同意图书馆的《使用协议》无法注册',4000);
	ckh_result = false;
  }
  if ($("#answer").val()=='') {  
	  showTooltips('answer_input','密保问题答案不能为空',4000);
	  ckh_result = false;
}
  if ($("#question1").val()==0) {
	  showTooltips('question_input','您还没选择密保问题',4000);
		ckh_result = false;
}
  return ckh_result;
}
function checkMobilePhone(telphone) {
	if(telphone=='' || !isMobilePhone(telphone)) {
	showTooltips('mobile_input','请输入正确的手机号码',2000);
  }else{
	hideTooltips('mobile_input');
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
    </div>
    <div class='box_bottom'></div>
    <div style="position:absolute; width:100%; height:100%; z-index:-2; left:0; top:0;">      
<img src="<%=basePath %>img/rs/body_bg.png" height="100%" width="100%" style="left:0; top:0;">      
</div>  
</body>
</html>
