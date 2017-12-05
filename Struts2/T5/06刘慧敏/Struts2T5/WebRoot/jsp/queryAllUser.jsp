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
    
    <title>My JSP 'queryAllUser.jsp' starting page</title>
    
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
   <h2>所有用户信息</h2>
		<table border="1">
		   <tr>
		    <td>用户ID</td>
		    <td>用户名</td>
		    <td>密码</td>
		    <td>生日</td>
		    <td>性别</td>
		    <td>是否启用</td>
		    <td>操作</td>
		   </tr>
		   <s:iterator value="userlist" var="u">
		   	<tr>
			   	<td><s:property value="#u.uid"/></td>
			   	<td><s:property value="#u.name"/></td>
			   	<td><s:property value="#u.password"/></td>
			   	<td><s:property value="#u.birthday"/></td>
			   	<td><s:if test="#user.sex==1">男</s:if><s:elseif test="#user.sex==2">女</s:elseif><s:else>保密</s:else></td>
			   	<td><s:property value="#u.isable"/></td>
			   	<td>
				   	 <a href="deleteUser?user.uid=<s:property value="#u.uid"/>">删除</a>
				   	 <a href="querySingleUser?user.uid=<s:property value="#u.uid"/>">修改</a>
			   	</td>
		   	</tr>
		   </s:iterator>
		 </table>
  </body>
</html>
