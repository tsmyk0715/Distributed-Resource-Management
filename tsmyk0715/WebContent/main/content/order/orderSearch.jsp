<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单查询功能</title>

<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/demo.css">
<script type="text/javascript" src="../../../tsmyk0715/common/js/jquery.min.js"></script>
<script type="text/javascript" src="../../../tsmyk0715/common/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../../tsmyk0715/main/content/js/orderSearch.js"></script>

</head>
<body style="margin:0;padding:0;">
<!-- 显示数据的表格 start -->
	<table id="orders" title="订单管理功能" class="easyui-datagrid" 
		style="width:1146px;height:575px;"
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
	            <th field="number" width="50">订单编号</th>
	            <th field="customername" width="50">客户名称</th>
	            <th field="name" width="50">商品名称</th>
	            <th field="size" width="50">商品规格</th>
	            <th field="goodsNum" width="50">商品数量</th>
	            <th field="orderTime" width="80">生成订单时间</th>
	            <th field="sendTime" width="50">发货时间</th>
	            <th field="payType" width="50">支付方式</th>
	            <th field="description" width="120">备注</th>
	        </tr>
	    </thead>
    </table>
    <!-- 显示数据的表格 end -->
    
    <!-- 查询对话框 start -->
    <div id="searchDialog" style="padding:1px">
    	<div style="height: 12px;"></div>
    	<label style="margin-left: 28px;">搜索：</label>&nbsp;&nbsp;
    	
    	<label for="number" class="localStation">订单编号:&nbsp;&nbsp;</label>
    	<input id="search_number" name=search_number>
    	
    	<label for=search_client style="margin-left:60px;">客户名称:&nbsp;&nbsp;</label>
    	<input id="search_client"  name="search_client">

    	<label for="search_name" style="margin-left:60px;">商品名称:&nbsp;&nbsp;</label>
    	<input id="search_name" name="search_name">
    	
    	<br><br>
    	<label for=search_orderTime style="margin-left: 78px;">生成时间:&nbsp;&nbsp;</label>
    	<input id="search_orderTime"  name="search_orderTime">
		
		<label for=search_sendTime style="margin-left:60px;">发货时间:&nbsp;&nbsp;</label>
    	<input id="search_sendTime"  name="search_sendTime">
		
		<label for=search_payType style="margin-left:60px;">支付方式:&nbsp;&nbsp;</label>
    	<input id="search_payType"  name="search_payType">
		
        <a id="search" href="#" class="easyui-linkbutton" plain="true" style="margin-left:60px;">搜索</a>
        <a id="clear" href="#" class="easyui-linkbutton" plain="true" style="margin-left:10px;">清空</a>
       
        <div style="height: 12px;"></div>
    </div>
    <!-- 查询对话框 end -->
</body>
</html>