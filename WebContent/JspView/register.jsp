<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<embed src="../source/register.mp3" hidden=true autostart="true" loop=2> -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"  type="text/css" href="../source/register.css">
<title>register</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/ServletControl" method="post">
<div >
&nbsp;&nbsp;&nbsp;&nbsp;用户名:<input type="text" name="rname" size=20><br>
&nbsp;&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码:<input type="password" name="rpassword1" size=20><br>
确认密码:<input type="password" name="rpassword2" size=20><br>
<input type="reset" value="Reset" name="reset">&nbsp;&nbsp;
<input type="submit" value="Reg" name="Reg"><br>
&nbsp;&nbsp;&nbsp;&nbsp;<font size=5 color=red><%=request.getAttribute("message") %></font>

</div>
</form>
<c:catch>
<div id="music"><!-- 音频播放 -->
<audio src="../source/audio.mp3"  autoplay="autoplay" controls="controls"> </audio>
</div> 
</c:catch>

</body>
</html>