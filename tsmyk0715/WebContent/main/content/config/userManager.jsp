<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../../../tsmyk0715/common/themes/demo.css">
<script type="text/javascript" src="../../../tsmyk0715/common/js/jquery.min.js"></script>
<script type="text/javascript" src="../../../tsmyk0715/common/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../../tsmyk0715/main/content/js/userManager.js"> </script>

<style type="text/css">
	.localStation,#okBtn{
		margin-left: 35px;
	}
</style>
</head>
<body style="margin: 0; padding: 0">
	
	<!-- 顶部操作按钮 start -->
	<div style="padding:0px;width:90%;">
		<a id="add" href="addUser" class="easyui-linkbutton" iconCls="icon-add">添加用户</a>
		<a id="delete" href="#" class="easyui-linkbutton" iconCls="icon-cancel">删除用户</a>
		<a id="edit" href="#" class="easyui-linkbutton" iconCls="icon-edit">修改用户信息</a>
	</div>
	<!-- 顶部操作按钮 end -->
	
	<!-- 显示数据的表格 start -->
	<table id="users" title="用户信息" class="easyui-datagrid" 
		style="width:1145px;height:546px;"
        url="../../../tsmyk0715/regist"
        rownumbers="true" fitColumns="true" singleSelect="false" 
        data-options="autoRowHeight:false,rowStyler:function(){return 'height: 40px';}"
        striped="true"
        pagination="true"
        pageSize=10   
        method="post"
        toolbar="#searchDialog"
        iconCls="icon-search">
	    <thead>
	        <tr align="center">
	        	<th field="ck"  checkbox="true"></th>
	        	<th field="id" hidden="true"></th>
	            <th field="account" width="50">帐号</th>
	            <th field="username" width="50">姓名</th>
	            <th field="password" width="50">密码</th>
	            <th field="roleName" width="50">角色</th>
	        </tr>
	    </thead>
    </table>
    <!-- 显示数据的表格 end -->
    
    <!-- 修改信息对话框 start -->
    <div id="editDialog" style="padding:5px;display:none">
        
        <input id="id" type="hidden">
    	<br>
    	
    	<label for="username" class="localStation">姓名</label>
    	<input id="username" type="text" >
    	<br><br>
    	
    	<label for="lastname" class="localStation">密码</label>
    	<input id="password" type="password">
    	 <br><br>
        <a href="#" id="editOkBtn" class="easyui-linkbutton" iconCls="icon-ok">修改</a>
    	<font id="tipMsg" color="red" style="margin-left: 15px;"></font>
    </div>
    <!-- 修改信息对话框 end -->
    
    <!-- 查询对话框 start -->
    <div id="searchDialog" style="padding:1px">
    	<div style="height:10px;"></div>
    	
    	<label for="" style="margin-left:33px;">查询</label>

    	<label for="account" style="margin-left:35px;">帐号：</label>
    	<input id="search_account" name="search_account">
    	
    	<label for="name" style="margin-left:35px;">姓名：</label>
    	<input id="search_name"  name="search_name">
    	
        <a id="search" href="#" class="easyui-linkbutton" plain="true" style="margin-left:35px;">搜索</a>
        <a id="clear" href="#" class="easyui-linkbutton" plain="true" style="margin-left:15px;">清空</a>
   	
   		<div style="height:10px;"></div>
    </div>
    <!-- 查询对话框 end -->
</body>
</html>