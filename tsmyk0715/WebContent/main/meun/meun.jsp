<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, pojo.Function"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分销资源管理系统</title>
<link rel="StyleSheet" href="main/meun/dtree/dtree.css" type="text/css" />
<script type="text/javascript" src="main/meun/dtree/dtree.js"></script>
<!-- background="#e4ebeb" bgcolor="#ececec" -->
</head>
<body  style="font-size: 18px;">
	<div>
		<script type="text/javascript">
			var powerId = new dTree('powerId');
			var root = 0;
			powerId.add(0,-1,'功能管理');
		</script>
		  <%
            List<Function> funList = (List<Function>)request.getAttribute("fun");
	   		for(Function f:funList){
		 %>
		 	<script type="text/javascript">
			 	powerId.add(<%=f.getFunId()%> ,<%=f.getParentId()%>,'<%=f.getFunValue()%>','<%=f.getFunHref()%>',
			 			'请点击进行相应操作','content','',
			 			'','');
		 	</script>
		 <% 		
	   		}
	   	 %>
		<script type="text/javascript">
	    	document.write(powerId);
	    	powerId.openAll();
	    </script>
	</div>
</body>
</html>