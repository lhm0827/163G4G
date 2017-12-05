<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
	<s:form action="addUser"  method="post"  >
   	<s:textfield name="user.name" label="用户名" ></s:textfield><br>
    <s:password  name="user.password" label="密码"></s:password><br>
    <s:textfield name="user.birthday" label="生日"></s:textfield><br>
    <s:radio 	 name="user.sex" list="#{1:'男',2:'女',0:'保密'}" value="1" label="性别"></s:radio><br>
    <s:checkbox  name="user.isable" fieldValue="true" label="是否启用"></s:checkbox><br>
    <s:submit    value="提交"></s:submit>
    </s:form>
  </body>
</html>
