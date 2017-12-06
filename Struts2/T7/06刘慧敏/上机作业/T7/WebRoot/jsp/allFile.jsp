<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传成功页面</title>
</head>
<body>
	上传人:${username }
	<br/>
	上传文件名:${uploadFileFileName }
	<br/>
	上传文件类型:${uploadFileContentType }
********************************************	
********************************************	
********************************************	
	<br/>
	<a href="/Struts_T07/upload/${uploadFileFileName }">${uploadFileFileName }</a>
	
</body>
</html>