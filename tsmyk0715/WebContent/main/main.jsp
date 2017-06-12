<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>分销资源管理系统</title>
</head>
	<frameset rows="11%,*" border="1" framespacing="0">
		<frame src="main/head/head.jsp" name="head" scrolling="no" noresize="noresize">
		
		<frameset cols="16%,*">
			<c:choose>
			   <c:when test="${currentUser.id == 1}">
					<frame src="main/meun/meun3.jsp" scrolling="no" name="meun" noresize="noresize">
			   </c:when>
			   <c:otherwise> 
					<frame src="main/meun/meun2.jsp" scrolling="no" name="meun" noresize="noresize">
			   </c:otherwise>
			</c:choose>
			<!--
				这个是使用 dTree 的树形菜单 
				<frame src="authorization" scrolling="auto" name="meun" noresize="noresize"> -->
			<frame src="main/content/init.jsp" name="content" scrolling="auto" noresize="noresize">
		</frameset>
		<!-- <frame src="main/foot/foot.jsp" name="foot" scrolling="no" noresize="noresize"/> -->
	</frameset>
</html>