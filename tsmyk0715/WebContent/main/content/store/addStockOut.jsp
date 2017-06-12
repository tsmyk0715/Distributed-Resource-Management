<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">   

<script src="../tsmyk0715/main/content/My97DatePicker/calendar.js"></script>
<script src="../tsmyk0715/main/content/My97DatePicker/WdatePicker.js"></script>
 
<title>新增出库单功能</title>
	<style type="text/css">
		.common{
			margin-left: 200px;
		}
	</style>
</head>
<body>
	<form action="addStockOutAction" method="post"> 
		<h3 class="common">新增出库单</h3>
		<br>
		<input type="hidden" name="userid" value="${user.id }">
		<label class="common">出库单编号</label>
		<input type="text" name="number" style="margin-left: 22px;">
		
		<br><br>
		<label class="common">选择客户</label>
		<select name="clientId" style="margin-left: 40px;">
			<c:forEach items="${customers }" var="customer">
				<option value="${customer.id }">${customer.customerName }</option>
			</c:forEach>
		</select>
		
		<br><br>
		<label class="common">选择商品</label>
		<select name="goodsId" style="margin-left: 40px;">
			<c:forEach items="${goodses }" var="goods">
				<option value="${goods.id }">${goods.name }=>${goods.size }</option>
			</c:forEach>
		</select>
		
		<br><br>
		<label class="common">商品数量</label>
		<input type="text" name="goodsNum" style="margin-left: 40px;">
		
		<br><br>
		<label class="common" >出库时间</label>
		<input type="text" name="date" onclick="WdatePicker()" style="margin-left: 40px;">
		
		<br><br>
		<label class="common">备注</label><br>
		<textarea rows="10" cols="50" name="desc" style="margin-left: 310px;"></textarea>
	
		<br><br>
		<input type="submit" value="添加" style="margin-left: 200px;">
	</form>
	
</body>
</html>