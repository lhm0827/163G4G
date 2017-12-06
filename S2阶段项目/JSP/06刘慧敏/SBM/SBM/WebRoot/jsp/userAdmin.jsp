<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'userAdmin.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript">
	function doit(flag, id) {
		if (flag == "del") {
			if (confirm("确认删除吗？") != true)
				return;
		}
	}
</script>
</head>
<body>




	<div class="menu">
		<table>
			<tbody>
				<tr>
					<td>
					<form method="post" action="user?cmd=selectUser">
							<input name="flag" value="search" class="input-text"type="hidden"> 用户名称：
							<input name="userName" class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp;
							<input value="查 询" type="submit">
						</form></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">

		<div class="optitle clearfix">
			<em><input value="添加数据" class="input-button"
				onclick="window.location='jsp/userAdd.jsp'" type="button"></em>
			<div class="title">用户管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
						<td width="80"><div class="STYLE1" align="center">用户名称</div></td>
						<td width="100"><div class="STYLE1" align="center">性别</div></td>
						<td width="100"><div class="STYLE1" align="center">年龄</div></td>

						<td width="150"><div class="STYLE1" align="center">电话</div></td>
						<td width="150"><div class="STYLE1" align="center">地址</div></td>
						<td width="150"><div class="STYLE1" align="center">权限</div></td>
					</tr>

					<tr>
						<td height="23">
							<span class="STYLE1">${user.userId }</span>
						</td>
						<td>
							<span class="STYLE1">${user.userName }</span>
						</td>
						<td>
							<span class="STYLE1">${user.userSex } </span>
						</td>
						<td>
							<span class="STYLE1">${user.userAge }</span>
						</td>
						<td>
							<span class="STYLE1">${user.telephone }</span>
						</td>
						<td>
							<span class="STYLE1">${user.address }</span>
						</td>
						<td>
							<span class="STYLE1">${user.type }</span>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>