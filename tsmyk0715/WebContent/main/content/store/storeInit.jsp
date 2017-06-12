<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>库存初始化</title>

<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/demo.css">
<script type="text/javascript" src="../../../tsmyk0715/common/js/jquery.min.js"></script>
<script type="text/javascript" src="../../../tsmyk0715/common/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../../tsmyk0715/main/content/js/storeInit.js"></script>
</head>
<body style="margin:0;padding:0;">
	<!-- 显示数据的表格 start -->
	<table id="goods" title="库存信息" class="easyui-datagrid" 
		style="width:1143px;height:573px;"
        url="../../../tsmyk0715/queryAllGoods?userid=${user.id }" 
        rownumbers="true" fitColumns="true" singleSelect="true" 
        data-options="autoRowHeight:false,rowStyler:function(){return 'height: 42px';}"
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
	            <th field="number" width="40">商品编号</th>
	            <th field="name" width="40">商品名称</th>
	            <th field="productPlace" width="40">产地</th>
	            <th field="size" width="50">规格</th>
	            <th field="_package" width="60">包装</th>
	            <th field="productCode" width="50">生产批号</th>
	            <th field="promitCode" width="50">批准文号</th>
	            <th field="price" width="50">价格</th>
	            <th field="goodsNum" width="50">商品数量</th>
	            <th field="available" width="50" hidden="true">状态</th>
	            <th field="description" width="50">备注</th>
	        </tr>
	    </thead>
    </table>
    <!-- 显示数据的表格 end -->
    
	   <!-- 查询对话框 start -->
    <div id="searchDialog" style="padding:1px">
    	<div style="height: 14px;"></div>
    	<label style="margin-left: 28px;">搜索：</label>&nbsp;&nbsp;
    	<label for="number" class="localStation">商品编号:&nbsp;&nbsp;</label>
    	<input id="search_number" name=search_number>
		&nbsp;&nbsp;
    	<label for="lastname" class="localStation">商品名称:&nbsp;&nbsp;</label>
    	<input id="search_name" name="search_name">
    	&nbsp;&nbsp;
    	<label for=productPlace class="localStation">产地:&nbsp;&nbsp;</label>
    	<input id="search_place"  name="search_place">
		&nbsp;&nbsp;
        <a id="search" href="#" class="easyui-linkbutton" plain="true">搜索</a>
        <a id="clear" href="#" class="easyui-linkbutton" plain="true">清空</a>
        <div style="height: 18px;"></div>
    </div>
    <!-- 查询对话框 end -->
</body>
</html>