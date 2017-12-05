<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册成功</title>
</head>
<body>
	用户名:<s:property value="user.uname"/>
	<br/>
	密码:<s:property value="user.upwd"/>
	<br/>
	学历:<s:property value="user.edu"/>
	<br/>
	性别:
		<s:if test="user.sex == 1">
			男
		</s:if>
		<s:elseif test="user.sex == 2">
			未知
		</s:elseif>
		<s:else>
			女
		</s:else>
</body>
</html>