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
<title>新增订单信息</title>
</head>
<body>
	<form action="addOrderAction" method="post">
		<table id="addGoods" title="新增订单" 
			style="width:900px;height:690px;margin-left: 200px;">
		    <thead>
		        <tr align="right">
		        	<th><h3>新增订单信息</h3></th>
		        </tr>
		    </thead>
		    <tbody>
		    	<tr>
		    		<td align="center"></td>
		    		<td><input type="hidden" name="userId" value="${user.id }"></td>
		    	</tr>
		    	<tr>
		    		<td align="center">订单编号</td>
		    		<td><input type="text" name="number"></td>
		    	</tr>
		    	<tr>
		    		<td align="center">客户名称</td>
		    		<td>
			    		<select name="clientId" style="width: 172px;">
							<c:forEach items="${customers }" var="customer">
								<option value="${customer.id }">${customer.customerName }</option>
							</c:forEach>
						</select>
		    		</td>
		    	</tr>
		    	<tr>
		    		<td align="center">商品名称</td>
		    		<td>
		    			<select name="goodsId" style="width: 172px;">
							<c:forEach items="${goodses }" var="goods">
								<option value="${goods.id }">${goods.name }=>${goods.size }</option>
							</c:forEach>
						</select>	
		    		</td>
		    	</tr>
		    	<tr>
		    		<td align="center">商品数量</td>
		    		<td><input type="text" name="goodsNum"></td>
		    	</tr>
		    	<tr>
		    		<td align="center">生产订单时间</td>
		    		<td><input type="text" name="orderTime" onclick="WdatePicker()"></td>
		    	</tr>
		    	<tr>
		    		<td align="center">发货时间</td>
		    		<td><input type="text" name="sendTime" onclick="WdatePicker()"></td>
		    	</tr>
		    	<tr>
		    		<td align="center">支付方式</td>
		    		<td><input type="text" name="payType"></td>
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
		<input type="submit" value="添加" style="margin-left:280px;">
	</form>
</body>
</html>