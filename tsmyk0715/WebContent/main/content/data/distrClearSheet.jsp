<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/main/content/css/distrClearSheet.css">
<script type="text/javascript" src="../../../tsmyk0715/common/js/jquery.min.js"></script>
<script type="text/javascript" src="../../../tsmyk0715/main/content/js/distrClearSheet.js"></script>

</head>
<body>

	<table class="clearSheet" cellpadding="0" cellspacing="0" >
		<thead>
			<tr>
				<th>订单编号</th>
				<th>客户名称</th>
				<th>商品名称</th>
				<th>商品型号</th>
				<th>商品数量</th>
				<th>订单生成时间</th>
				<th>支付方式</th>
				<th>备注</th>
			</tr>
		</thead>
		<tbody>
			 <tr>
				<td class="orderClass">一月份销售订单</td>
			</tr>
			<tr>
				<td colspan="8"><hr></td>
			</tr>
			<c:forEach items="${januaryOrder }" var="january">
				<tr>
					<td>${january.number }</td>
					<td>${january.customername }</td>
					<td>${january.name }</td>
					<td>${january.size }</td>
					<td>${january.goodsNum }</td>
					<td>${january.orderTime }</td>
					<td>${january.payType }</td>
					<td>${january.description }</td>
				</tr>
			</c:forEach>	
			<tr>
				<td class="orderClass">二月份销售订单</td>
			</tr>
			<tr>
				<td colspan="8"><hr></td>
			</tr>
			<c:forEach items="${februaryOrder }" var="february">
				<tr>
					<td>${february.number }</td>
					<td>${february.customername }</td>
					<td>${february.name }</td>
					<td>${february.size }</td>
					<td>${february.goodsNum }</td>
					<td>${february.orderTime }</td>
					<td>${february.payType }</td>
					<td>${february.description }</td>
				</tr>
			</c:forEach>	
			<tr>
				<td class="orderClass">三月份销售订单</td>
			</tr>
			<tr>
				<td colspan="8"><hr></td>
			</tr>
			<c:forEach items="${marchOrder }" var="march">
				<tr>
					<td>${march.number }</td>
					<td>${march.customername }</td>
					<td>${march.name }</td>
					<td>${march.size }</td>
					<td>${march.goodsNum }</td>
					<td>${march.orderTime }</td>
					<td>${march.payType }</td>
					<td>${march.description }</td>
				</tr>
			</c:forEach>	
			<tr>
				<td class="orderClass">四月份销售订单</td>
			</tr>
			<tr>
				<td colspan="8"><hr></td>
			</tr>
			<c:forEach items="${arpilOrder }" var="arpil">
				<tr>
					<td>${arpil.number }</td>
					<td>${arpil.customername }</td>
					<td>${arpil.name }</td>
					<td>${arpil.size }</td>
					<td>${arpil.goodsNum }</td>
					<td>${arpil.orderTime }</td>
					<td>${arpil.payType }</td>
					<td>${arpil.description }</td>
				</tr>
			</c:forEach>	
			<tr>
				<td class="orderClass">五月份销售订单</td>
			</tr>
			<tr>
				<td colspan="8"><hr></td>
			</tr>
			<c:forEach items="${mayOrder }" var="may">
				<tr>
					<td>${may.number }</td>
					<td>${may.customername }</td>
					<td>${may.name }</td>
					<td>${may.size }</td>
					<td>${may.goodsNum }</td>
					<td>${may.orderTime }</td>
					<td>${may.payType }</td>
					<td>${may.description }</td>
				</tr>
			</c:forEach>	
			<tr>
				<td class="orderClass">六月份销售订单</td>
			</tr>
			<tr>
				<td colspan="8"><hr></td>
			</tr>
			<c:forEach items="${juneOrder }" var="june">
				<tr>
					<td>${june.number }</td>
					<td>${june.customername }</td>
					<td>${june.name }</td>
					<td>${june.size }</td>
					<td>${june.goodsNum }</td>
					<td>${june.orderTime }</td>
					<td>${june.payType }</td>
					<td>${june.description }</td>
				</tr>
			</c:forEach>	
			<tr>
				<td class="orderClass">七月份销售订单</td>
			</tr>
			<tr>
				<td colspan="8"><hr></td>
			</tr>
			<c:forEach items="${julyOrder }" var="july">
				<tr>
					<td>${july.number }</td>
					<td>${july.customername }</td>
					<td>${july.name }</td>
					<td>${july.size }</td>
					<td>${july.goodsNum }</td>
					<td>${july.orderTime }</td>
					<td>${july.payType }</td>
					<td>${july.description }</td>
				</tr>
			</c:forEach>	
			<tr>
				<td class="orderClass">八月份销售订单</td>
			</tr>
			<tr>
				<td colspan="8"><hr></td>
			</tr>
			<c:forEach items="${augustOrder }" var="august">
				<tr>
					<td>${august.number }</td>
					<td>${august.customername }</td>
					<td>${august.name }</td>
					<td>${august.size }</td>
					<td>${august.goodsNum }</td>
					<td>${august.orderTime }</td>
					<td>${august.payType }</td>
					<td>${august.description }</td>
				</tr>
			</c:forEach>	
			<tr>
				<td class="orderClass">九月份销售订单</td>
			</tr>
			<tr>
				<td colspan="8"><hr></td>
			</tr>
			<c:forEach items="${septemberOrder }" var="september">
				<tr>
					<td>${september.number }</td>
					<td>${september.customername }</td>
					<td>${september.name }</td>
					<td>${september.size }</td>
					<td>${september.goodsNum }</td>
					<td>${september.orderTime }</td>
					<td>${september.payType }</td>
					<td>${september.description }</td>
				</tr>
			</c:forEach>	
			<tr>
				<td class="orderClass">十月份销售订单</td>
			</tr>
			<tr>
				<td colspan="8"><hr></td>
			</tr>
			<c:forEach items="${octoberOrder }" var="october">
				<tr>
					<td>${october.number }</td>
					<td>${october.customername }</td>
					<td>${october.name }</td>
					<td>${october.size }</td>
					<td>${october.goodsNum }</td>
					<td>${october.orderTime }</td>
					<td>${october.payType }</td>
					<td>${october.description }</td>
				</tr>
			</c:forEach>	
			<tr>
				<td class="orderClass">十一月份销售订单</td>
			</tr>
			<tr>
				<td colspan="8"><hr></td>
			</tr>
			<c:forEach items="${novemberOrder }" var="november">
				<tr>
					<td>${november.number }</td>
					<td>${november.customername }</td>
					<td>${november.name }</td>
					<td>${november.size }</td>
					<td>${november.goodsNum }</td>
					<td>${november.orderTime }</td>
					<td>${november.payType }</td>
					<td>${november.description }</td>
				</tr>
			</c:forEach>	
			<tr>
				<td class="orderClass">十二月份销售订单</td>
			</tr>
			<tr>
				<td colspan="8"><hr></td>
			</tr>
			<c:forEach items="${decemberOrder }" var="december">
				<tr>
					<td>${december.number }</td>
					<td>${december.customername }</td>
					<td>${december.name }</td>
					<td>${december.size }</td>
					<td>${december.goodsNum }</td>
					<td>${december.orderTime }</td>
					<td>${december.payType }</td>
					<td>${december.description }</td>
				</tr>
			</c:forEach>	
			<tr>
				<td class="orderClass">第一季度销售订单</td>
			</tr>
			<tr>
				<td colspan="8"><hr></td>
			</tr>
			<c:forEach items="${firstQuarterOrder }" var="firstQuarter">
				<tr>
					<td>${firstQuarter.number }</td>
					<td>${firstQuarter.customername }</td>
					<td>${firstQuarter.name }</td>
					<td>${firstQuarter.size }</td>
					<td>${firstQuarter.goodsNum }</td>
					<td>${firstQuarter.orderTime }</td>
					<td>${firstQuarter.payType }</td>
					<td>${firstQuarter.description }</td>
				</tr>
			</c:forEach>	
			<tr>
				<td class="orderClass">第二季度销售订单</td>
			</tr>
			<tr>
				<td colspan="8"><hr></td>
			</tr>
			<c:forEach items="${secondQuarterOrder }" var="secondQuarter">
				<tr>
					<td>${secondQuarter.number }</td>
					<td>${secondQuarter.customername }</td>
					<td>${secondQuarter.name }</td>
					<td>${secondQuarter.size }</td>
					<td>${secondQuarter.goodsNum }</td>
					<td>${secondQuarter.orderTime }</td>
					<td>${secondQuarter.payType }</td>
					<td>${secondQuarter.description }</td>
				</tr>
			</c:forEach>	
			<tr>
				<td class="orderClass">第三季度销售订单</td>
			</tr>
			<tr>
				<td colspan="8"><hr></td>
			</tr>
			<c:forEach items="${thirdQuarterOrder }" var="thirdQuarter">
				<tr>
					<td>${thirdQuarter.number }</td>
					<td>${thirdQuarter.customername }</td>
					<td>${thirdQuarter.name }</td>
					<td>${thirdQuarter.size }</td>
					<td>${thirdQuarter.goodsNum }</td>
					<td>${thirdQuarter.orderTime }</td>
					<td>${thirdQuarter.payType }</td>
					<td>${thirdQuarter.description }</td>
				</tr>
			</c:forEach>	
			<tr>
				<td class="orderClass">第四季度销售订单</td>
			</tr>
			<tr>
				<td colspan="8"><hr></td>
			</tr>
			<c:forEach items="${fourthQuarterOrder }" var="fourthQuarter">
				<tr>
					<td>${fourthQuarter.number }</td>
					<td>${fourthQuarter.customername }</td>
					<td>${fourthQuarter.name }</td>
					<td>${fourthQuarter.size }</td>
					<td>${fourthQuarter.goodsNum }</td>
					<td>${fourthQuarter.orderTime }</td>
					<td>${fourthQuarter.payType }</td>
					<td>${fourthQuarter.description }</td>
				</tr>
			</c:forEach> 
		</tbody>
	</table>
</body>
</html>