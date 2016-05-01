<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome To Login</title>
<link rel="stylesheet"  type="text/css" href="../source/background.css">
</head>
<body >
<center>
<font size=100 color=blue>欢迎来到MVC用户登录注册系统</font>
<%-- <% request.setAttribute("message", "欢迎登陆"); %> --%>
<br><br><br>
<form action="<%=request.getContextPath()%>/ServletControl" method="post">
用户名:<input type="text" name="username" size=20><br>
密&nbsp;&nbsp;&nbsp;码:<input type="password" name="password" size=20><br>
<center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Login" name="Login">&nbsp;&nbsp;&nbsp;<input type="submit" value="Register" name="Register"></center>
<center><font size=5 color=red><%=request.getAttribute("message") %></font></center>
</form>
</center>
</body>
</html>