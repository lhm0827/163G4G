<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="core" prefix="c" %>
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
	<link type="text/css" rel="stylesheet" href="css/style.css" />
  </head>
  
<body class="blue-style">
 	<c:if test="${param.error == 'failed' }">
 		<script type="text/javascript">
 			alert("登录失败!请检查用户名或密码是否正确");
 		</script>
	 </c:if>
<div id="login">
	<div class="icon"></div>
	<div class="login-box">
		<form method="post" action="user?cmd=userlogin">
			<dl>
				<dt>用户名：</dt>
				<dd><input type="text" name="userName" class="input-text" /></dd>
				<dt>密　码：</dt>
				<dd><input type="password" name="userPassword" class="input-text" /></dd>
			</dl>
			<div class="buttons">
				<input type="submit" name="submit" value="登录系统" class="input-button" />
				<input type="reset" name="reset" value="重　　填" class="input-button" />
			</div>
		</form>
	</div>
</div>
</body>
</html>
