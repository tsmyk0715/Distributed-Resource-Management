<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加客户信息</title>
<script type="text/javascript" src="/tsmyk0715/main/content/js/addClient.js"></script>
<script type="text/javascript" src="/tsmyk0715/common/js/jquery.min.js"></script>

</head>
<body style="margin: 0; padding: 0">

	<form action="addClientAction" method="post" onsubmit="return checkInput();">
		<table  title="新增客户信息" 
			  style="width:900px;height:690px;margin-left: 200px;">
		    <thead>
		        <tr align="right">
		        	<th><h3>新增客户信息信息</h3></th>
		        </tr>
		    </thead>
		    <tbody>
		    	<tr>
		    		<td align="center"></td>
		    		<td><input type="hidden" name="userId" value="${user.id }"></td>
		    	</tr>
		    	<tr>
		    		<td align="center">客户编号</td>
		    		<td>
		    			<input type="text" id="number" name="number">&nbsp;&nbsp;<b style="color:red">*</b>&nbsp;&nbsp;&nbsp;&nbsp;
						<font id="numberMsg" color="red"></font>		    		
		    		</td>
		    	</tr>
		    	<tr>
		    		<td align="center">客户名称</td>
		    		<td>
		    			<input type="text" id="customerName" name="customerName">&nbsp;&nbsp;<b style="color:red">*</b>&nbsp;&nbsp;&nbsp;&nbsp;
						<font id="customerNamerMsg" color="red"></font>	
		    		</td>
		    	</tr>
		    	<tr>
		    		<td align="center">邮政编码</td>
		    		<td><input type="text" name="postCode"></td>
		    	</tr>
		    	<tr>
		    		<td align="center">地址</td>
		    		<td><input type="text" name="address"></td>
		    	</tr>
		    	<tr>
		    		<td align="center">客户电话</td>
		    		<td>
		    			<input type="text" id="telephone" name="telephone">&nbsp;&nbsp;<b style="color:red">*</b>&nbsp;&nbsp;&nbsp;&nbsp;
						<font id="telephoneMsg" color="red"></font>
		    		</td>
		    	</tr>
		    	<tr>
		    		<td align="center">联系人</td>
		    		<td><input type="text" name="connectPerson"></td>
		    	</tr>
		    	<tr>
		    		<td align="center">联系人电话</td>
		    		<td>
		    			<input type="text" id="phone" name="phone">&nbsp;&nbsp;&nbsp;&nbsp;
						<font id="phoneMsg" color="red"></font>
		    		</td>
		    	</tr>
		    	<tr>
		    		<td align="center">开户银行</td>
		    		<td><input type="text" name="bank"></td>
		    	</tr>
		    	<tr>
		    		<td align="center">银行帐号</td>
		    		<td><input type="text" name="account"></td>
		    	</tr>
		    	<tr>
		    		<td align="center">邮箱</td>
		    		<td>
		    			<input type="text" id="email" name="email">&nbsp;&nbsp;&nbsp;&nbsp;
						<font id="emailMsg" color="red"></font>
		    		</td>
		    	</tr>
		    	<tr>
		    		<td align="center">传真</td>
		    		<td><input type="text" name="fax"></td>
		    	</tr>
		    	<tr>
		    		<td align="center">备注</td>
		    		<td>
		    			<textarea rows="7" cols="60" name="description"></textarea>
		    		</td>
		    	</tr>
		    </tbody>
	    </table>
	    <br>
		<input type="submit" value="添加"  style="margin-left:280px;">
	</form>
</body>
</html>