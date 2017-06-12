<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../../../tsmyk0715/common/js/jquery.min.js"></script>

<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/main/content/css/costCount.css">
<script type="text/javascript" src="../../../tsmyk0715/main/content/js/costCount.js"></script>
<style type="text/css">
	#d{
		 font-size: 16px;
        line-height: 150%;
        display: block;
     }
     #inputText{
     	width: 62px;
     }
</style>

</head>
<body>
	<div id="d">
		返点金额计算公式： &nbsp;&nbsp;
		返点金额 = 应付账款  * 返点数 / 100 <br>
		实际付款计算公式： &nbsp;&nbsp;
		应付账款 - 返点金额
	</div>

	<table class="mytab" cellpadding="0" cellspacing="0" >
		<thead>
			<tr>
				<th>订单编号</th>
				<th>客户名称</th>
				<th>商品名称</th>
				<th>商品型号</th>
				<th>商品价格</th>
				<th>商品数量</th>
				<th>应付账款</th>
				<th>返点</th>
				<th>返点金额</th>
				<th>实际应付款</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="l">
				<tr>
					<td>${l.number }</td>
					<td>${l.customername }</td>
					<td>${l.name }</td>
					<td>${l.size }</td>
					<td>${l.price }</td>
					<td>${l.goodsNum }</td>
					<td>${l.truePay }</td>
					<td>${l.fandian }&nbsp;个点</td>
					<td>${l.fandianjine }</td>
					<td>${l.shijifukuan }</td>
				</tr>
			</c:forEach>	
		</tbody>
	</table>
	
	<h5>修改返点费用</h5>
	
	<form action="editFanDian" method="post" onsubmit=" return vaildateInput();">
		<label>输入返点：</label>
		<input type="text" id="inputText" name="inputText" style="margin-left: 32px;"><br>
		
		<label>选择订单编号：</label>
		<select name="fandian">
			<c:forEach items="${list }" var="l">
				<option value="${l.id }">${l.number}</option>
			</c:forEach>
		</select>
		<br>
		<input type="submit" value="修改返点费用">
		<font color="red" id="tipMsg"></font>
	</form>
</body>
</html>