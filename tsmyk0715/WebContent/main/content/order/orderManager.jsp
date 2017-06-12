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
<script type="text/javascript" src="../../../tsmyk0715/main/content/js/orderManager.js"></script>
<script src="../../../tsmyk0715/main/content/My97DatePicker/calendar.js"></script>
<script src="../../../tsmyk0715/main/content/My97DatePicker/WdatePicker.js"></script>

<style type="text/css">
	.localStation{
		margin-left: 40px;
	}
	#number,#goodsNum,#sendTime,#payType{
		margin-left: 20px;
	}
</style>
</head>
<body style="margin:0;padding:0;">
	
	<!-- 顶部操作按钮 start -->
	<div style="padding:0px;width:70%;">
		<a id="add" href="addOrder" class="easyui-linkbutton" iconCls="icon-add">添加订单信息</a>
		<a id="delete" href="#" class="easyui-linkbutton" iconCls="icon-cancel">删订单信息</a>
		<a id="edit" href="#" class="easyui-linkbutton" iconCls="icon-edit">修改订单信息</a>
	</div>
	
	<!-- 显示数据的表格 start -->
	<table id="orders" title="库存信息" class="easyui-datagrid" 
		style="width:1143px;height:547px;"
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
	            <th field="orderTime" width="80">订单生成时间</th>
	            <th field="sendTime" width="50">发货时间</th>
	            <th field="payType" width="50">支付方式</th>
	            <th field="description" width="120">备注</th>
	        </tr>
	    </thead>
    </table>
    <!-- 显示数据的表格 end -->
    
    <!-- 修改信息对话框 start -->
    <div id="editDiv" style="padding:5px;display:none">

        <input id="id" type="hidden" name="id">
        
        <br><br>
    	<label for="number" class="localStation">订单编号:</label>
    	<input id="number" name="number">&nbsp;&nbsp;<font color="red">*</font>
        
        <br><br>
    	<label for="goodsNum" class="localStation">商品数量:</label>
    	<input id="goodsNum" name="goodsNum">&nbsp;&nbsp;<font color="red">*</font>
       
        <br><br>
    	<label for="sendTime" class="localStation">发货时间:</label>
    	<input id="sendTime" name="sendTime" onclick="WdatePicker()">
       
        <br><br>
    	<label for="payType" class="localStation">付款方式:</label>
    	<input id="payType" name="payType">
       
    	<br><br>
    	<label for="desc" class="localStation">备注:</label><br>
    	<textarea rows="5" cols="21" id="desc" name="desc" style="margin-left: 117px;">
    	</textarea>
    	
    	<br><br>
    	<b style="margin-left: 40px;"><font color="red" id="tipMsg"></font></b>&nbsp;
        <a href="#" id="okBtn" class="easyui-linkbutton" iconCls="icon-ok">确认修改</a>
    </div>
    <!-- 修改信息对话框 end -->
</body>
</html>