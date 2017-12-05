<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
	<s:form action="user/add" method="get">
		<s:textfield label="用户名" name="user.uname" required="ture"></s:textfield>
		<s:password label="密码" name="user.upwd" showPassword="false" required="ture"></s:password>
		<s:select label="学历" list="{'小学','初中','高中','大专','大学','研究生','博士','院士'}"  size="3" name="user.edu"></s:select>
		<s:radio label="性别" list="#{1:'男',0:'女',2:'未知'}" value="1" name="user.sex" required="ture"></s:radio>
		<s:submit value="注册"></s:submit>
	</s:form>
</body>
</html>