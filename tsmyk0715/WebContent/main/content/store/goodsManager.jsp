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
<script type="text/javascript" src="../tsmyk0715/main/content/js/goodsManager.js"></script>
<style type="text/css">
	.localStation{margin-left: 40px;}
	.localStation1{margin-left: 5px;}
	#id{margin-left:41px;}
	#productPlace{margin-left:23px;}
	#size{margin-left:23px;}
	#price{margin-left:24px;}
	#goodsNum{margin-left:24px;}
	#desc{margin-left:105px;}
	#okBtn{margin-left:40px; margin-top:20px;}
</style>
</head>
<body style="margin:0;padding:0;">
	<!-- 顶部操作按钮 start -->
	<div style="padding:0px;width:70%;">
		<a id="add" href="addGoods" class="easyui-linkbutton" iconCls="icon-add">添加物料信息</a>
		<!-- <a id="delete" href="#" class="easyui-linkbutton" iconCls="icon-cancel">删除物料信息</a> -->
		<a id="edit" href="#" class="easyui-linkbutton" iconCls="icon-edit">修改物料信息</a>
	</div>
	
	<!-- 显示数据的表格 start -->
	<table id="goodsManager" title="物料维护" class="easyui-datagrid" 
		style="width:1146px;height:549px;"
        url="../../../tsmyk0715/queryAllGoods?userid=${user.id }" 
        rownumbers="true" fitColumns="true" singleSelect="false" 
        data-options="autoRowHeight:false,rowStyler:function(){return 'height: 41px';}"
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
	            <th field="number" width="50">商品编号</th>
	            <th field="name" width="50">商品名称</th>
	            <th field="productPlace" width="50">产地</th>
	            <th field="size" width="70">规格</th>
	            <th field="_package" width="80" hidden="true">包装</th>
	            <th field="productCode" width="50" hidden="true">生产批号</th>
	            <th field="promitCode" width="50" hidden="true">批准文号</th>
	            <th field="price" width="50">价格</th>
	            <th field="goodsNum" width="50">商品数量</th>
	            <th field="available" width="50" hidden="true">状态</th>
	            <th field="description" width="150">备注</th>
	        </tr>
	    </thead>
    </table>
    <!-- 显示数据的表格 end -->
    
	   <!-- 查询对话框 start -->
    <div id="searchDialog" style="padding:1px">
    	<div style="height: 12px;"></div>
    	<label style="margin-left: 28px;">搜索：</label>&nbsp;&nbsp;
    	<label for="number" class="localStation1">商品编号:&nbsp;&nbsp;</label>
    	<input id="search_number" name=search_number>
		&nbsp;&nbsp;
    	<label for="lastname" class="localStation">商品名称:&nbsp;&nbsp;</label>
    	<input id="search_name" name="search_name">
    	&nbsp;&nbsp;
    	<label for=productPlace class="localStation">产地:&nbsp;&nbsp;</label>
    	<input id="search_place"  name="search_place">

        <a id="search" href="#" class="easyui-linkbutton" plain="true" style="margin-left: 25px;">搜索</a>
        <a id="clear" href="#" class="easyui-linkbutton" plain="true" style="margin-left: 10px;">清空</a>
        <div style="height: 12px;"></div>
    </div>
    <!-- 查询对话框 end -->

	<!-- 修改信息对话框 start -->
    <div id="editDiv" style="padding:5px;display:none">

        <input id="id" type="hidden" name="id">
        
        <br><br>
    	<label for="number" class="localStation">商品编号:&nbsp;&nbsp;</label>
    	<input id="number" name="number">&nbsp;&nbsp;<em style="color: red">*</em>
        
        <br><br>
    	<label for="goodsName" class="localStation">商品名称:&nbsp;&nbsp;</label>
    	<input id="goodsName" name="goodsName">&nbsp;&nbsp;<em style="color: red">*</em>
       
        <br><br>
    	<label for="productPlace" class="localStation">产地:&nbsp;&nbsp;</label>
    	<input id="productPlace" name="productPlace">&nbsp;&nbsp;<em style="color: red">*</em>
       
        <br><br>
    	<label for="size" class="localStation">规格:&nbsp;&nbsp;</label>
    	<input id="size" name="size">
       
        <br><br>
    	<label for="price" class="localStation">价格:&nbsp;&nbsp;</label>
    	<input id="price" name="price">
	
		<br><br>
    	<label for="goodsNum" class="localStation">数量:&nbsp;&nbsp;</label>
    	<input id="goodsNum" name="goodsNum">

    	<br><br>
    	<label for="desc" class="localStation">备注:</label><br>
    	<textarea rows="5" cols="21" id="desc" name="desc"></textarea>
    	
    	<br>
        <a href="#" id="okBtn" class="easyui-linkbutton" iconCls="icon-ok">确认修改</a>
    	<b style="margin-left: 40px;"><font color="red" id="tipMsg"></font></b>
    </div>
    <!-- 修改信息对话框 end -->
</body>
</html>