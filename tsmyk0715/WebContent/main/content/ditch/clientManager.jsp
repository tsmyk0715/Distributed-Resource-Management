<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分销商维护功能</title>

<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/demo.css">
<script type="text/javascript" src="../../../tsmyk0715/common/js/jquery.min.js"></script>
<script type="text/javascript" src="../../../tsmyk0715/common/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../../tsmyk0715/main/content/js/clientManager.js"></script>

<style type="text/css">
	.localStation{
		margin-left: 40px;
	}
	#address,#email,#fax{
		margin-left: 36px;
	}
	#telephone{
		margin-left: 13px;
	}
	#connectPerson{
		margin-left: 23px;
	}
</style>

</head>
<body style="margin:0; padding: 0">
	
	<!-- 顶部操作按钮 start -->
	<div style="padding:0px;width:70%;">
		<a id="add" href="addClient" class="easyui-linkbutton" iconCls="icon-add">添加客户信息</a>
		<a id="delete" href="#" class="easyui-linkbutton" iconCls="icon-cancel">删除客户信息</a>
		<a id="edit" href="#" class="easyui-linkbutton" iconCls="icon-edit">修改客户信息</a>
	</div>
	
	<!-- 显示数据的表格 start -->
	<table id="clients" title="分销商信息" class="easyui-datagrid" 
		style="width:1146px;height:549px;"
        url="../../../tsmyk0715/queryCustomersByUserId?userid=${user.id }" 
        rownumbers="true" fitColumns="true" singleSelect="false" 
        data-options="autoRowHeight:false,rowStyler:function(){return 'height: 37px';}"
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
	        	<th field="id" hidden="true">ID</th>
	            <th field="number" width="50">客户编号</th>
	            <th field="customername" width="50">客户名称</th>
	            <th field="postcode" width="50">邮政编码</th>
	            <th field="address" width="50">地址</th>
	            <th field="telephone" width="100">客户电话</th>
	            <th field="connectperson" width="50">联系人</th>
	            <th field="phone" width="100">发联系人电话</th>
	            <th field="bank" width="50">开户银行</th>
	            <th field="account" width="100">银行帐号</th>
	            <th field="email" width="110">客户邮箱</th>
	            <th field="fax" width="50">传真</th>
	            <th field="description" width="120">备注</th>
	        </tr>
	    </thead>
    </table>
    <!-- 显示数据的表格 end -->
    
    <!-- 查询对话框 start -->
    <div id="searchDialog" style="padding:1px">
    	<div style="height: 12px;"></div>
    	<label style="margin-left: 28px;">搜索：</label>&nbsp;&nbsp;

    	<label for="number">客户编号:&nbsp;&nbsp;</label>
    	<input id="search_number" name=search_number>

    	<label for="name" style="margin-left:30px;">客户名称:&nbsp;&nbsp;</label>
    	<input id="search_name" type="text">

    	<label for=address style="margin-left:30px;">地址:&nbsp;&nbsp;</label>
    	<input id="search_address"  type="text"><br><br>
    	
    	
    	<label for=telephone style="margin-left:76px;">客户电话:&nbsp;&nbsp;</label>
    	<input id="search_telephone"  type="text">
    	
    	<label for=connectPerson style="margin-left:30px;">联系人:&nbsp;&nbsp;</label>
    	<input id="search_connectPerson"  type="text" style="margin-left:12px;">
    	
    	<label for="email" style="margin-left:30px;">邮箱:&nbsp;&nbsp;</label>
    	<input id="search_email"  type="text">
		    	
        <a id="search" href="#" class="easyui-linkbutton" plain="true" style="margin-left:55px;">
        	搜索
       	</a>
        <a id="clear" href="#" class="easyui-linkbutton" plain="true" style="margin-left:14px;">
        	清空
       	</a>
        <div style="height: 12px;"></div>
    </div>
    <!-- 查询对话框 end -->
	
	<!-- 修改信息对话框 start -->
    <div id="editDiv" style="padding:5px;display:none">

        <input id="id" type="hidden" name="id">
        
        <br><br>
    	<label for="address" class="localStation">地址:</label>
    	<input id="address" type="text">
        
        <br><br>
    	<label for="telephone" class="localStation">客户电话:</label>
    	<input id="telephone" type="text">
       
        <br><br>
    	<label for="connectPerson" class="localStation">联系人:</label>
    	<input id="connectPerson" type="text">
       
        <br><br>
    	<label for="phone" class="localStation">联系人电话:</label>
    	<input id="phone" type="text">
       
        <br><br>
    	<label for="email" class="localStation">邮箱:</label>
    	<input id="email" type="text">
       
        <br><br>
    	<label for="fax" class="localStation">传真:</label>
    	<input id="fax" type="text">
       
    	<br><br>
    	<label for="desc" class="localStation">备注:</label><br>
    	<textarea rows="5" cols="21" id="desc" name="desc" style="margin-left: 110px;">
    	</textarea>
    	
    	<br><br>
    	<b style="margin-left: 40px;"><font color="red" id="tipMsg"></font></b>
        <a href="#" id="okBtn" class="easyui-linkbutton"
        		 iconCls="icon-ok">确认修改</a>
    </div>
    <!-- 修改信息对话框 end -->
</body>
</html>