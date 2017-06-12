<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/demo.css">
<script type="text/javascript" src="../../../tsmyk0715/common/js/jquery.min.js"></script>
<script type="text/javascript" src="../../../tsmyk0715/common/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../../tsmyk0715/main/content/js/storeOut.js"></script>

<title>出库单</title>

<style type="text/css">
	.localStation{
		margin-left: 30px;
	}
	#id{
		margin-left:41px;
	}
	#goodsSize{
		margin-left:2px;
	}
	#goodsNum{
		margin-left:2px;
	}
	#desc{
		margin-left:33px;
	}
	#okBtn{
		margin-left:260px;
	}

</style>

</head>
<body style="margin: 0; padding: 0">
	<!-- 
		easyui中table的一些属性:
		rownumbers : 显示行号
		fitColumns : True 就会自动扩大或缩小列的尺寸以适应表格的宽度并且防止水平滚动。
		singleSelect : True 就会只允许选中一行。
		striped : True 就把行条纹化。（即奇偶行使用不同背景色）
		pagination : True 就会在 datagrid 的底部显示分页栏。
		toolbar : 指定工具栏
	 -->
	 
	<!-- 顶部操作按钮 start -->
	<div style="padding:0px;width:70%;">
		<a id="add" href="addStockOut" class="easyui-linkbutton" iconCls="icon-add">添加出库单</a>
		<a id="delete" href="#" class="easyui-linkbutton" iconCls="icon-cancel">删除出库单</a>
		<a id="edit" href="#" class="easyui-linkbutton" iconCls="icon-edit">修改出库单</a>
	</div>
	<!-- 顶部操作按钮 end -->
	 
	<!-- 显示出库单数据的表格 start-->
	<table id="stockOut" title="出库单信息" class="easyui-datagrid"
		style="width:1147px; height: 548px;"
		url="../../../tsmyk0715/queryAllStoctOut?userid=${user.id }"
		rownumbers="true" fitColumns="true" singleSelect="false"
		data-options="autoRowHeight:false,rowStyler:function(){return 'height: 39px';}"
		striped="true"
		pagination="true"
		pageSize=10   
        method="post"
        toolbar="#searchDialog"
        iconCls="icon-search"
        loadMsg="正在加载数据...">
		
		<thead>
			<tr>
				<th field="ck" checkbox="true"></th>
				<th field="id" hidden="true"></th>
				<th field="number" width="70">订单编号</th>
				<th field="clientId" hidden="true" width="100">客户ID</th>
				<th field="goodsId" hidden="true" width="100">商品ID</th>
				<th field="customername" width="100">客户名称</th>
				<th field="name" width="70">商品名称</th>
				<th field="size" width="150">商品规格</th>
				<th field="goodsNumber" width="50">商品数量</th>
				<th field="outTime" width="80">出库时间</th>
				<th field="description"width="100">备注</th>
			</tr>
		</thead>
	</table>
	<!-- 显示出库单数据的表格 end-->

 	<!-- 查询对话框 start -->
    <div id="searchDialog" style="padding:1px">
    	<div style="height: 12px;"></div>
    	<label style="margin-left: 28px;">搜索：</label>&nbsp;&nbsp;
    	<label for="number" class="localStation">订单编号:&nbsp;&nbsp;</label>
    	<input id="search_number" name=search_number>
		&nbsp;&nbsp;
    	<label for="clientName" class="localStation">客户名称:&nbsp;&nbsp;</label>
    	<input id="search_clientName" name="search_name">
    	&nbsp;&nbsp;
    	<label for="goodsName" class="localStation">商品名称:&nbsp;&nbsp;</label>
    	<input id="search_goodsName"  name="search_place">
		&nbsp;&nbsp;
        <a id="search" href="#" class="easyui-linkbutton" plain="true">搜索</a>
        <a id="clear" href="#" class="easyui-linkbutton" plain="true">清空</a>
        <div style="height: 12px;"></div>
    </div>
    <!-- 查询对话框 end -->

	<!-- 修改信息对话框 start -->
    <div id="editDiv" style="padding:5px;display:none">
        <label for="id" class="localStation">id:&nbsp;&nbsp;</label>
        <input id="id" name="id" disabled="disabled">
        <br><br>
    	<label for="goodsNum" class="localStation">商品数量:&nbsp;&nbsp;</label>
    	<input id="goodsNum" name="goodsNum">
    	<br><br>
    	<label for="desc" class="localStation">备注:</label>
    	<input id="desc"  name="desc">
    	<br><br>
    	<font color="red" id="tipMsg" style="margin-left: 30px;"></font>
        <a href="#" id="okBtn" class="easyui-linkbutton" iconCls="icon-ok">修改</a>
    </div>
    <!-- 修改信息对话框 end -->
</body>
</html>