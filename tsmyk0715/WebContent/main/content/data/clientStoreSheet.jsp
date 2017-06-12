<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/main/content/css/clientStoreSheet.css">

<script type="text/javascript" src="../../../tsmyk0715/common/js/jquery.min.js"></script>
<script type="text/javascript" src="../../../tsmyk0715/main/content/js/clientStoreSheet.js"></script>

</head>
<body>
	<table class="storeChectSheet" cellpadding="0" cellspacing="0" width="100%" >
		<thead>
			<tr>
				<th>商品编号</th>
				<th>名称</th>
				<th>产地</th>
				<th>型号</th>
				<th>价格（元）</th>
				<th>原始库存</th>
				<th>订购数量</th>
				<th>剩余库存</th>
				<th>期初余额（元）</th>
				<th>期末余额（元）</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${storeChectSheet }" var="store">
				<tr style="height: 40px;">
					<td>${store.number }</td>
					<td>${store.name }</td>
					<td>${store.productplace }</td>
					<td>${store.size }</td>
					<td>${store.price }</td>
					<td>${store.originalStore }</td>
					<td>${store.goodsOrderNumber }</td>
					<td>${store.surplusStore }</td>
					<td>${store.originalMoney }</td>
					<td>${store.surplsMoney }</td>
				</tr>
				
			</c:forEach>	
		</tbody>
	</table>
</body>
</html>