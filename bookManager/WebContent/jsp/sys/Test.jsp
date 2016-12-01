<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TestPage</title>
</head>
<body>
  <p align="center">请您选择需要上传的文件</p>
    <form id="form1" name="form1" method="post"
        action="<%=basePath %>book/upload.do" enctype="multipart/form-data">
        <table border="0" align="center">
            <tr>
                <td>上传人：</td>
                <td><input name="name" type="text" id="name" size="20"></td>
            </tr>
            <tr>
                <td>上传文件：</td>
                <td><input name="file" type="file" size="20"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="submit" value="提交"> <input
                    type="reset" name="reset" value="重置"></td>
            </tr>
        </table>
    </form>
    ${upload.message }
</body>
</html>