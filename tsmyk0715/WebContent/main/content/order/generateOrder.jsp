<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/demo.css">
<script type="text/javascript" src="../../../tsmyk0715/common/js/jquery.min.js"></script>
<script type="text/javascript" src="../../../tsmyk0715/common/js/jquery.easyui.min.js"></script>

</head>
<body style="margin:0;padding:0;">
	
	<!-- 显示数据的表格 start -->
	<table id="goods" title="库存信息" class="easyui-datagrid" 
		style="width:1143px;height:573px;"
        url="../../../tsmyk0715/queryAllOrders?userid=${user.id }" 
        rownumbers="true" fitColumns="true" singleSelect="true" 
        data-options="autoRowHeight:false,rowStyler:function(){return 'height: 39px';}"
        striped="true"
        pagination="true"
        pageSize=10   
        method="post"
        toolbar="#searchDialog"
        iconCls="icon-search"
        loadMsg="正在加载数据...">
	    <thead>
	        <tr align="center">
	        	<th field="ck"  checkbox="true"></th>
	        	<th field="id" hidden="false">ID</th>
	            <th field="number" width="50" >订单编号</th>
	            <th field="customername" width="50">客户名称</th>
	            <th field="name" width="50">商品名称</th>
	            <th field="size" width="50">商品规格</th>
	            <th field="goodsNum" width="50">商品数量</th>
	            <th field="orderTime" width="80">订单生成时间</th>
	            <th field="sendTime" width="50">发货时间</th>
	            <th field="payType" width="50">支付方式</th>
	            <th field="description" width="120">备注</th>
	        </tr>
	    </thead>
    </table>
    <!-- 显示数据的表格 end -->
</body>
</html>