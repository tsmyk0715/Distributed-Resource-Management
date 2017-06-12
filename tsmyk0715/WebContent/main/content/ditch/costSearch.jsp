<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="../../../tsmyk0715/main/content/js/costSearch.js"></script>

<script type="text/javascript">

</script>

<style type="text/css">
	.commonCss{
		width: 70px;
	}
</style>

</head>
<body style="padding: 0; margin:0">
	<!-- 显示数据的表格 start -->
	<table id="costCount" title="分销费用查询" class="easyui-datagrid" 
		style="width:1146px;height:575px;"
        url="../../../tsmyk0715/processCostVerify?userid=${user.id }" 
        rownumbers="true" fitColumns="true" singleSelect="true" 
        data-options="autoRowHeight:false,rowStyler:function(){return 'height: 40px';}"
        striped="true"
        pagination="true"
        pageSize=10   
        method="post"
        toolbar="#searchDialog"
        iconCls="icon-search"
        sortName="id"
        loadMsg="正在加载数据...">
	    <thead>
	        <tr align="center">
	        	<th field="ck"  checkbox="true"></th>
	        	<th field="id" hidden="true">ID</th>
	            <th field="number" width="50">订单编号</th>
	            <th field="customername" width="50">客户名称</th>
	            <th field="name" width="50">商品名称</th>
	            <th field="size" width="120">商品型号</th>
	            <th field="price" width="60">商品价格</th>
	            <th field="goodsNum" width="50">商品数量</th>
	            <th field="truePay" width="100">应付账款</th>
	            <th field="fandian" width="50">返点</th>
	            <th field="fandianjine" width="80">返点金额</th>
	            <th field="shijifukuan" width="80">实际应付款</th>
	        </tr>
	    </thead>
    </table>
    <!-- 显示数据的表格 end -->
    
    <!-- 查询对话框 start -->
    <div id="searchDialog" style="padding:1px">
    	<div style="height: 12px;"></div>
    	<label style="margin-left: 28px;">查询：</label>&nbsp;&nbsp;
    	
    	<label for="yingfu" class="localStation">应付账款:&nbsp;&nbsp;</label>
    	<input id="start_yingfu" name=start_yingfu class="commonCss"> -
    	<input id="end_yingfu" name=end_yingfu class="commonCss">
    	
    	<label for="fandian" style="margin-left:40px;">返点金额:&nbsp;&nbsp;</label>
    	<input id="start_fandian"  name="start_fandian" class="commonCss"> -
    	<input id="end_fandian"  name="end_fandian" class="commonCss">

    	<label for="shiji" style="margin-left:40px;">实际付款:&nbsp;&nbsp;</label>
    	<input id="start_shiji" name="start_shiji" class="commonCss"> -
    	<input id="end_shiji" name="end_shiji" class="commonCss">
    	
        <a id="search" href="#" class="easyui-linkbutton" plain="true" style="margin-left:20px;">搜&nbsp;&nbsp;&nbsp;&nbsp;索</a>
        <a id="clear" href="#" class="easyui-linkbutton" plain="true" style="margin-left:20px;">清空查询条件</a>
        
        <div style="height: 12px;"></div>
    </div>
    <!-- 查询对话框 end -->
</body>
</html>