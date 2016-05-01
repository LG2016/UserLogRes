<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!-- <embed src="../source/video.mp3" hidden=true autostart="true" loop=2> html4支持，浏览器不一定兼容 -->
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Success</title>
</head>
<body>
<a href="http://localhost:8080/UserLogRes/JspView/login.jsp"><font size=25 color=blue>Index</font></a>
<c:catch><!-- 视频播放 -->
<div id="video">
<video src="../source/video.flv" width="500" height="500" controls="controls" ></video>
</div>
</c:catch>

<c:catch var="importError"><!-- 导入网上的页面 -->
<c:import url="https://github.com/LG2016/"></c:import>
</c:catch>
<c:out value="${importError}"></c:out>



<%-- <c:catch>
<div id="music"><!-- 音频播放 -->
<audio src="../source/audio.mp3"  autoplay="autoplay" controls="controls"> </audio>
</div> 
</c:catch> --%>

</body>
</html>