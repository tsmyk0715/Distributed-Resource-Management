<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="java.util.List,pojo.Function"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>分销资源管理系统</title>
<script type="text/javascript" src="../../common/js/jquery.min.js"></script>
<style type="text/css">
a:link {
	text-decoration: none;
	color: gray;
}
a:visited {
	text-decoration: none;
	color: gree;
}

</style>
</head>

<body style="margin:0;padding:0; background-color: rgb(1,104,183);">

<div id="cc" style="width: 100%; height: 70px; background-color: rgb(1,104,183)">

    <h1 style="margin:0;padding:18px;width:250px;float:left;font-size: 30px; cursor:default;font-family:微软雅黑,黑体,宋体;color: white;">
		分销资源管理系统
    </h1>
    
 <%--    <div style="float: left; margin-top: 35px;font-family:微软雅黑,黑体,宋体;color: white;">
    	${sessionScope.currentUser.username}（${sessionScope.currentUserRole}）
    </div> --%>
    
    <div id="localtime" style="float: left; margin-top: 35px;font-family:微软雅黑,黑体,宋体;color: white;"></div>
    
    <br>
	<div style="float: right;">
	
		<a href="../content/init.jsp" target="content" >
			<img alt="" src="images/main.PNG">
		</a>

		<a href="../content/init.jsp" target="content">
			<img alt="" src="images/help.PNG" >
		</a>

		<a href="../../passwordFix" target="content">
			<img alt="" src="images/setting.PNG">
		</a>
		
		<a href="../../index.jsp"  target="_parent">
			<img alt="退出" src="images/exit.PNG">
		</a>
	</div>
	
</div>

</body>
<script type="text/javascript">
	function showLocale(objD)
	{
		var str,colorhead,colorfoot;
		var yy = objD.getYear();
		if(yy<1900) yy = yy+1900;
		var MM = objD.getMonth()+1;
		if(MM<10) MM = '0' + MM;
		var dd = objD.getDate();
		if(dd<10) dd = '0' + dd;
		var hh = objD.getHours();
		if(hh<10) hh = '0' + hh;
		var mm = objD.getMinutes();
		if(mm<10) mm = '0' + mm;
		var ss = objD.getSeconds();
		if(ss<10) ss = '0' + ss;
		var ww = objD.getDay();
		if  (ww==0)  ww="周日";
		if  (ww==1)  ww="周一";
		if  (ww==2)  ww="周二";
		if  (ww==3)  ww="周三";
		if  (ww==4)  ww="周四";
		if  (ww==5)  ww="周五";
		if  (ww==6)  ww="周六";
		str = yy + "/" + MM + "/" + dd +" "+" "+" "+ ww +" "+" "+" " + hh + ":" + mm;
		//20:08 周一 2017/03/27
		return(str);
	}
	function tick()
	{
		var today;
		today = new Date();
		$("#localtime").text(showLocale(today));
		window.setTimeout("tick()", 1000);
	}
	tick();
</script>
</html>
