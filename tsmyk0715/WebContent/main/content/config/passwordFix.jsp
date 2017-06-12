<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="../../../tsmyk0715/common/js/jquery.min.js"></script>

<script type="text/javascript">
	function check(){
		var $username = $("#username").val().trim();
		var $password = $("#password").val().trim();
		if($username == null || $username == ''){
			$("#tipMsg").text("姓名不能为空！");
			return false;
		}
		if($password == null || $password == ''){
			$("#tipMsg").text("密码不能为空！");
			return false;
		}
		return true;
	}
	
</script>	
</head>
<body>
	
	<div style="margin-left: 50px;">
		<h4>个人信息修改</h4>
		<form action="fixPasswordAction" method="post" onsubmit="return check();">
			<table width="500px;" height="250px;">
				<tr>
					<td></td>
					<td><input type="hidden" name="id" value="${user.id }"></td>
				</tr>
				<tr>
					<td>帐号</td>
					<td><input type="text" name="account" value="${user.account }" disabled="disabled"></td>
				</tr>
				<tr>
					<td>角色</td>
					<td><input type="text" name="roleName" value="${currentUserRole}" disabled="disabled"></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" id="username" name="username" value="${user.username }" ></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="text" id="password" name="password" value="${user.password }"></td>
				</tr>
			</table> 
			
			<div style="height: 15px;"></div>
			<input type="submit" value="确认修改">
			<font id="tipMsg" color="red" style="margin-left: 35px;"></font>
		</form>
		
	</div>
	
</body>
</html>