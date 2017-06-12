<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="../../../tsmyk0715/common/js/jquery.min.js"></script>

<script type="text/javascript">
	
	//是否存在中文
	function isExistChinese(str) {
	    if(!str || str == ""){
	    	return false;
	    }
	    for(var i = 0; i < str.length; i++){
	    	if(str.charCodeAt(i) > 255){
	    		return true;
	    	}
	    }
	    return false;
	}
	
	function check(){
		var $account = $("#account").val().trim();
		var $password = $("#password").val().trim();
		var $username = $("#username").val().trim();
		
		if($account == null || $account == ''){
			$("#tipMsg").text("账户不能为空！");
			return false;
		}
		if(isExistChinese($account)){
			$("#tipMsg").text("账户不能含有中文！");
			return false;
		}
		if($password == null || $password == ''){
			$("#tipMsg").text("密码不能为空！");
			return false;
		}
		if($username == null || $username == ''){
			$("#tipMsg").text("姓名不能为空！");
			return false;
		}

		return true;
	}
	
</script>

</head>
<body>
	<div style="margin-left: 50px;">
		<h3>添加用户信息</h3>
		<form action="addUserAction" method="post" onsubmit="return check();">
		<table class="form" width="500px;" height="250px;">
			<tbody>
				<tr>
					<td><label>帐号</label></td>
					<td><input type="text" id="account" name="account"></td>
				</tr>
				<tr>
					<td><label>密码</label></td>
					<td><input type="password" id="password" name="password"></td>
				</tr>
				<tr>
					<td><label>姓名</label></td>
					<td><input type="text" id="username" name="username"></td>
				</tr>
				<tr>
					<td><label>角色</label></td>
					<td>
						<select name="roleId" style="width: 174px;">
							<c:forEach items="${roles }" var="role">
								<option value="${role.roleId }">${role.roleName }</option>
							</c:forEach>
						</select>	
					</td>
				</tr>
				</tbody>
		   </table>
		   <div style="height: 15px;"></div>
		   <input type="submit" value="提交">
		   <font id="tipMsg" color="red" style="margin-left: 35px;"></font>
		</form>
	</div>
</body>
</html>